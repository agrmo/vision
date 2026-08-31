package sicht.baum.binaer;

import welt.punkt.Zweipunktwelt;
import sicht.punkt.Zweipunktsicht;
import vektor.Zweivektor;
import baum.binaer.Binaerbaum;
import java.util.ArrayList;
import sicht.Sicht;
import java.awt.Graphics;
import welt.baum.binaer.Binaerbaumwelt;
import ort.baum.binaer.Binaerbaumort;

// Ein Binärbaumsicht stellt einen Baum dar.
public class Binaerbaumsicht extends Sicht {

    Binaerbaumwelt welt;
    double durchmesser;

    public Binaerbaumsicht(Binaerbaumwelt bw, double d) {
	this.welt = bw;
	this.durchmesser = d;
    }

    public void darstellen(Graphics g) {
	
	// Nehme die Orte der Knoten.
	Zweivektor[] punktliste = this.welt.nehmeorte();
	Zweipunktwelt zpw = new Zweipunktwelt(punktliste);
	Zweipunktsicht zps = new Zweipunktsicht(zpw, this.durchmesser);
	zps.darstellen(g);
    }
}
