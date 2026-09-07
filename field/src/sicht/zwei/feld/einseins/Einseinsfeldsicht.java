package sicht.zwei.feld.einseins;

import feld.einseins.Einseinsfeld;
import ganz.vektor.GZweivektor;
import java.awt.Graphics;
import sicht.Sicht;
import sicht.zwei.vektor.Zweivektorsicht;
import welt.zwei.vektor.Zweivektorwelt;

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

	GZweivektor[] orte = new GZweivektor[this.eef.orte.length];
	GZweivektor[] vektoren = new GZweivektor[this.eef.orte.length];
	
	for (int i = 0; i < this.eef.orte.length; i++) {
	    orte[i] = new GZweivektor((int) ((0.5 * this.breite) + i * this.abstand),
				      (int) (0.5 * this.hoehe));
	    
	    vektoren[i] = new GZweivektor(0, (int) this.eef.werte[i]);
	}

	Zweivektorwelt zvw = new Zweivektorwelt(orte, vektoren);
	Zweivektorsicht zvs = new Zweivektorsicht(zvw);
	zvs.darstellen(g);
    }
}
