package sicht.punkt;

import java.awt.Graphics;
import vektor.Zweivektor;
import sicht.Sicht;
import welt.punkt.Zweipunktwelt;

// Eine Punktsicht kann Vektore darstellen.  Die Punkte stehen schon
// auf einer Ebene. Ein Punkt sieht anders als ein Vektor aus, aber
// die beiden enthalten die gleiche Datenstruktur! Man muss vorsichtig
// sein.
public class Zweipunktsicht extends Sicht {

    // Die Stellen jedes Punkts.
    public Zweipunktwelt pw;

    // Der Durchmesser jedes Vektors.
    double durchmesser;

    public Zweipunktsicht(Zweipunktwelt pw, double d) {
	this.pw = pw;
	this.durchmesser = d;
    }

    void darstellenPunkt(Graphics g, Zweivektor k) {
	g.drawOval((int) k.eins, (int) k.zwei,
		   (int) (this.durchmesser / 2.0), (int) (this.durchmesser / 2.0));
    }

    // Stelle jeden Vektor dar.
    public void darstellen(Graphics g) {
	for (int i = 0; i < this.pw.punktliste.length; i++) {
	    this.darstellenPunkt(g, this.pw.punktliste[i]);
	}
    }
}

