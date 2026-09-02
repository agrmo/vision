package sicht.baum.binaer.horizontal;

import verdoppler.vektor.Vektorverdoppler;
import baum.binaer.Binaerbaum;
import java.awt.Graphics;
import java.util.ArrayList;
import sicht.Sicht;
import sicht.punkt.Zweipunktsicht;
import sicht.strecke.zwei.Zweistreckesicht;
import strecke.Zweistrecke;
import vektor.Zweivektor;
import welt.baum.binaer.Binaerbaumstrecke;
import welt.baum.binaer.horizontal.Binaerbaumwelthorizontal;
import welt.punkt.Zweipunktwelt;
import welt.strecke.zwei.Zweistreckewelt;

// Ein Binärbaumsicht stellt einen Baum dar.
public class Binaerbaumsichthorizontal extends Sicht {

    Binaerbaumwelthorizontal welt;
    double durchmesser;

    public Binaerbaumsichthorizontal(Binaerbaumwelthorizontal bw, double d) {
	this.welt = bw;
	this.durchmesser = d;
    }

    Zweivektor[] verbesserepunkte() {

	Zweivektor[] punktliste = Vektorverdoppler.verdoppele(this.welt.orte);

	Zweivektor unterschied = new Zweivektor((this.durchmesser / 4.0),
						(this.durchmesser / 4.0));
	
	for (int i = 0; i < punktliste.length; i++) {
	    punktliste[i].subtrahiere(unterschied);
	}

	return punktliste;
    }
    
    public void darstellen(Graphics g) {
	// Nehme die Kante des Baumes.
	Zweistrecke[] zsl = this.welt.strecken;
	Zweistreckewelt zsw = new Zweistreckewelt(zsl);
	Zweistreckesicht zss = new Zweistreckesicht(zsw);
	zss.darstellen(g);

	// Nehme die Orte der Knoten.
	Zweivektor[] verbessertepunktliste = verbesserepunkte();
	Zweipunktwelt zpw = new Zweipunktwelt(verbessertepunktliste);
	Zweipunktsicht zps = new Zweipunktsicht(zpw, this.durchmesser);
	zps.darstellen(g);
    }
}
