package sicht.zwei.graph;

import ganz.strecke.GZweistrecke;
import ganz.vektor.GZweivektor;
import java.awt.Graphics;
import sicht.Sicht;
import sicht.zwei.punkt.Zweipunktsicht;
import sicht.zwei.strecke.Zweistreckesicht;
import welt.zwei.graph.Zweigraphwelt;
import welt.zwei.punkt.Zweipunktwelt;
import welt.zwei.strecke.Zweistreckewelt;

// Eine Sicht der zweidimensionalen Graphwelt.
public class Zweigraphsicht extends Sicht {

    Zweigraphwelt zgw;
    int durchmesser;

    public Zweigraphsicht(Zweigraphwelt zgw,
			  int d) {
	this.zgw = zgw;
	this.durchmesser = d;
    }

    /*
      Das Zentrum von drawCircle() von Java ist nicht genau auf dem
      gegebenen Ort dargestellt. Zum Beispiel
      
      Knoten (0,0) Durchmesser 3
      Kante (0,0) bis (10,10)
      
      Gewünscht:
      
      |---|
      | \ |
      |--\|
          \
           \
            ...

      Aber Java wird die beiden wieso darstellen,

      \
      |---|
      |\  |
      |-\-|
         \
          \
           ...
	     
      weil das Zentrum des Kreises nicht auf (0,0) steht. Wir sollen
      die Stellen des Knoten verbessern. In diesem Beispiel
      verschieben wir die Stellen des Kreises -3 in die x- und
      y-Richtung.

      Warum 4?
    */
    void verbessereknoten(GZweivektor zp) {
	GZweivektor unterschied = new GZweivektor(this.durchmesser / 4,
						  this.durchmesser / 4);
	zp.subtrahiere(unterschied);
    }

    public void darstellen(Graphics g) {
	// Ein Graph dargestellt ist nur eine Menge von Kreisen und
	// Strecken.

	// Nehme die Kanten.
	GZweistrecke[] kanten = this.zgw.nehmekanten();

	// Nehme die Knoten.
	Zweistreckewelt zsw = new Zweistreckewelt(kanten);
	GZweivektor[] knoten = zgw.nehmeknoten();

	for (int i = 0; i < knoten.length; i++) {
	    this.verbessereknoten(knoten[i]);
	}

	// Mache die unterliegende Sichten.
	Zweistreckesicht ss = new Zweistreckesicht(zsw);
	Zweipunktwelt pw = new Zweipunktwelt(knoten);
	Zweipunktsicht ps = new Zweipunktsicht(pw, this.durchmesser);

	ss.darstellen(g);
	ps.darstellen(g);
    }
}
