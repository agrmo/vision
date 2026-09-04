package sicht.baum.binaer;

import verdoppler.vektor.Vektorverdoppler;
import baum.binaer.Binaerbaum;
import java.awt.Graphics;
import java.util.ArrayList;
import sicht.Sicht;
import sicht.punkt.ganz.GZweipunktsicht;
import sicht.strecke.zwei.ganz.GZweistreckesicht;
import strecke.ganz.GZweistrecke;
import vektor.ganz.GZweivektor;
import welt.baum.binaer.Binaerbaumstrecke;
import welt.baum.binaer.Binaerbaumwelt;
import welt.punkt.ganz.GZweipunktwelt;
import welt.strecke.zwei.ganz.GZweistreckewelt;

// Ein Binärbaumsicht stellt einen Baum dar.
public class Binaerbaumsicht extends Sicht {

    Binaerbaumwelt welt;
    int durchmesser;

    public Binaerbaumsicht(Binaerbaumwelt bw, int d) {
	this.welt = bw;
	this.durchmesser = d;
    }

    GZweivektor[] verbesserepunkte() {

	GZweivektor[] punktliste = Vektorverdoppler.verdoppele(this.welt.orte);

	GZweivektor unterschied = new GZweivektor(this.durchmesser / 4,
						  this.durchmesser / 4);
	
	for (int i = 0; i < punktliste.length; i++) {
	    punktliste[i].subtrahiere(unterschied);
	}
	
	return punktliste;
    }
    
    public void darstellen(Graphics g) {
	// Nehme die Kante des Baumes.
	GZweistrecke[] zsl = this.welt.strecken;
	GZweistreckewelt zsw = new GZweistreckewelt(zsl);
	GZweistreckesicht zss = new GZweistreckesicht(zsw);
	zss.darstellen(g);

	// Nehme die Orte der Knoten.
	GZweivektor[] verbessertepunktliste = verbesserepunkte();
	GZweipunktwelt zpw = new GZweipunktwelt(verbessertepunktliste);
	GZweipunktsicht zps = new GZweipunktsicht(zpw, this.durchmesser);
	zps.darstellen(g);
    }
}
