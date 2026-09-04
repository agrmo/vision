package sicht.feld.einseins;

import java.awt.Graphics;
import sicht.Sicht;
import feld.einseins.Einseinsfeld;
import welt.vektor.Zweivektorwelt;
import sicht.vektor.zwei.Zweivektorsicht;
import vektor.Zweivektor;

// Sicht für ein 1-1-Feld.
// Die Stellen sind eine Reihe von Zahlen.
// Die Werte sind eine Reihe von Zahlen.
//
// Um dieses Feld darzustellen, bauen wir eine Zweivektorwelt, wobei
// jeder Vektor senkrecht in the +y Richtung zeigt.
public class Einseinsfeldsicht extends Sicht {

    public Einseinsfeld eef;
    public double abstand;

    // Bildschirm
    public double breite;
    public double hoehe;

    public Einseinsfeldsicht(Einseinsfeld eef, double abstand,
			     double breite, double hoehe) {
	this.eef = eef;
	this.abstand = abstand;
	this.breite = breite;
	this.hoehe = hoehe;
    }

    public void darstellen(Graphics g) {

	Zweivektor[] orte = new Zweivektor[this.eef.orte.length];
	Zweivektor[] vektoren = new Zweivektor[this.eef.orte.length];
	
	for (int i = 0; i < this.eef.orte.length; i++) {
	    orte[i] = new Zweivektor((0.5 * this.breite) + i * this.abstand,
				     (0.5 * this.hoehe));
	    
	    vektoren[i] = new Zweivektor(0, this.eef.werte[i]);
	}

	Zweivektorwelt zvw = new Zweivektorwelt(orte, vektoren);
	Zweivektorsicht zvs = new Zweivektorsicht(zvw);
	zvs.darstellen(g);
    }
}
