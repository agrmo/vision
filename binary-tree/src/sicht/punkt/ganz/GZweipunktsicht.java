package sicht.punkt.ganz;

import java.awt.Graphics;
import sicht.Sicht;
import vektor.ganz.GZweivektor;
import welt.punkt.ganz.GZweipunktwelt;

public class GZweipunktsicht extends Sicht {

    // Die Stellen jedes Punkts.
    public GZweipunktwelt pw;

    // Der Durchmesser jedes Vektors.
    int durchmesser;
    
    public GZweipunktsicht(GZweipunktwelt pw, int d) {
	this.pw = pw;
	this.durchmesser = d;
    }

    // Stelle jeden Vektor dar.
    public void darstellen(Graphics g) {
	for (int i = 0; i < this.pw.punktliste.length; i++) {
	    GZweivektor k = this.pw.punktliste[i];
	    g.drawOval(k.eins, k.zwei,
		       this.durchmesser / 2, this.durchmesser / 2);
	}
    }
}

