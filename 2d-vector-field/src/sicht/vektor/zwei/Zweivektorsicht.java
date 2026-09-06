package sicht.vektor.zwei;

import dreher.reel.vektor.zwei.RZweivektordreher;
import fort.Fortvektor;
import ganz.strecke.GZweistrecke;
import ganz.vektor.GZweivektor;
import java.awt.Graphics;
import reel.vektor.RZweivektor;
import sicht.Sicht;
import sicht.strecke.zwei.Zweistreckesicht;
import verdoppler.vektor.Vektorverdoppler;
import welt.strecke.zwei.Zweistreckewelt;
import welt.vektor.zwei.Zweivektorwelt;

// Stellen eine Reihe von Vektoren dar. Ein Vektor wird wie ein Pfeil
// dargestellt.
public class Zweivektorsicht extends Sicht {
    
    Zweivektorwelt zweivektorwelt;

    // Die Größe der Spitze des Vektors. 
    int spitze = 20;
    
    public Zweivektorsicht(Zweivektorwelt zvw) {
	this.zweivektorwelt = zvw;
    }
    
    public void darstellen(Graphics g) {

	// Stelle jeden Vektor dieser Welt dar.  Jeder Vektor ergibt 2
	// neue: die Spitzen des Vektors.  Also 3 insgesamt.  Also
	// multipliziere 3 mit der Anzahl der Vektoren.  Die ist die
	// Anzahl der Strecken der Zweistreckewelt.  Lass wir eine
	// Streckewelt bauen. Jeder Vektor ergibt 3 Strecken.

	// Baue alle Strecken dieser Zweivektorwelt.
	
	int streckeanzahl = 3 * this.zweivektorwelt.vektoren.length;
	GZweistrecke[] zsl = new GZweistrecke[streckeanzahl];

	for (int i = 0; i < this.zweivektorwelt.orte.length; i++) {

	    // Stelle die Spitze des Vektors dar.
	    // Die Spitze hat zwei Teile: ein nach "links" und ein nach "rechts."
	    // d.i.
	    //          \  <-- Größe der Spitze
	    // ----------
	    //          /  <-- Größe der Spitze

	    // Baue die zwei Spitzen.

	    RZweivektor a = Fortvektor.mache(this.zweivektorwelt.vektoren[i], this.spitze);
	    RZweivektor b = RZweivektordreher.drehen(a, 135.0 * (Math.PI / 180.0));
	    RZweivektor c = Fortvektor.mache(this.zweivektorwelt.vektoren[i], this.spitze);
	    RZweivektor d = RZweivektordreher.drehen(c, -135.0 * (Math.PI / 180.0));

	    // Wir brauchen ganze Zahlen im Bildschirm.
	    GZweivektor gb = new GZweivektor((int) b.eins, (int) b.zwei);
	    GZweivektor gd = new GZweivektor((int) d.eins, (int) d.zwei);

	    // Es gibt bis jetzt 3 Vektoren: der Schwanz und die zwei
	    // Spitzen.  Der Schwanz ist this.zweivektorwelt.vektoren[i] und die
	    // zwei Spitzen sind b, d.

	    // Die zeigen in die richtige Richtungen aber stehen nicht
	    // an den richtigen Orten. D.i.

	    /*
	       
             \  
	      -----
	     /

	    */
	    
	    // Nun verschiebe alle drei Vektoren zum richtigen Ort.
	    
	    GZweivektor schwanzvon = Vektorverdoppler.verdoppele(this.zweivektorwelt.orte[i]);
	    GZweivektor schwanzbis = Vektorverdoppler.verdoppele(this.zweivektorwelt.orte[i]);
	    schwanzbis.addiere(this.zweivektorwelt.vektoren[i]);

	    GZweivektor spitzeeinsvon = Vektorverdoppler.verdoppele(schwanzbis);
	    GZweivektor spitzeeinsbis = Vektorverdoppler.verdoppele(schwanzbis);
	    spitzeeinsbis.addiere(gb);

	    GZweivektor spitzezweivon = Vektorverdoppler.verdoppele(schwanzbis);
	    GZweivektor spitzezweibis = Vektorverdoppler.verdoppele(schwanzbis);
	    spitzezweibis.addiere(gd);

	    zsl[i * 3] = new GZweistrecke(schwanzvon, schwanzbis);
	    zsl[(i * 3) + 1] = new GZweistrecke(spitzeeinsvon, spitzeeinsbis);
	    zsl[(i * 3) + 2] = new GZweistrecke(spitzezweivon, spitzezweibis);
	}

	// Nun stelle alle Strecken dar. Wir benutzen eine
	// Zweistreckewelt und eine Zweistreckesicht.

	Zweistreckewelt zsw = new Zweistreckewelt(zsl);
	Zweistreckesicht zss = new Zweistreckesicht(zsw);
	zss.darstellen(g);
    }
}


