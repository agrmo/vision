package sicht.zwei.punkt;

import ganz.vektor.GZweivektor;
import java.awt.Graphics;
import sicht.Sicht;
import welt.zwei.punkt.Zweipunktwelt;

// Eine Punktsicht kann Vektore darstellen.  Die Punkte stehen schon
// auf einer Ebene. Ein Punkt sieht anders als ein Vektor aus, aber
// die beiden enthalten die gleiche Datenstruktur. Man muss vorsichtig
// sein.
public class Zweipunktsicht extends Sicht {

    // Die Stellen jedes Punkts.
    public Zweipunktwelt pw;

    // Der Durchmesser jedes Vektors.
    int durchmesser;

    public Zweipunktsicht(Zweipunktwelt pw, int d) {
	this.pw = pw;
	this.durchmesser = d;
    }

    void darstellepunkt(Graphics g, GZweivektor k) {
	g.drawOval(k.eins, k.zwei,
		   (this.durchmesser / 2), (this.durchmesser / 2));
    }

    // Stelle jeden Vektor dar.
    public void darstellen(Graphics g) {
	for (int i = 0; i < this.pw.punktliste.length; i++) {
	    this.darstellepunkt(g, this.pw.punktliste[i]);
	}
    }
}

