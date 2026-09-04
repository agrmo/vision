package sicht.vektor.zwei;

import dreher.zweivektor.Zweivektordreher;
import java.awt.Graphics;
import sicht.Sicht;
import vektor.Zweivektor;
import vektor.fort.zwei.Zweifortvektor;
import verdoppler.vektor.Vektorverdoppler;
import welt.vektor.Zweivektorwelt;
import welt.strecke.zwei.Zweistreckewelt;
import sicht.strecke.zwei.Zweistreckesicht;
import strecke.Zweistrecke;

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
	Zweistrecke[] zsl = new Zweistrecke[streckeanzahl];

	for (int i = 0; i < this.zweivektorwelt.orte.length; i++) {

	    // Stelle die Spitze des Vektors dar.
	    // Die Spitze hat zwei Teile: ein nach "links" und ein nach "rechts."
	    // d.i.
	    //          \  <-- Größe der Spitze
	    // ----------
	    //          /  <-- Größe der Spitze

	    // Baue die zwei Spitzen.

	    Zweivektor a = Zweifortvektor.mache(this.zweivektorwelt.vektoren[i], this.spitze);
	    Zweivektor b = Zweivektordreher.drehen(a, 135.0 * (Math.PI / 180.0));
	    Zweivektor c = Zweifortvektor.mache(this.zweivektorwelt.vektoren[i], this.spitze);
	    Zweivektor d = Zweivektordreher.drehen(c, -135.0 * (Math.PI / 180.0));

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

	    Zweivektor schwanzvon = Vektorverdoppler.verdoppele(this.zweivektorwelt.orte[i]);
	    Zweivektor schwanzbis = Vektorverdoppler.verdoppele(this.zweivektorwelt.orte[i]);
	    schwanzbis.addiere(this.zweivektorwelt.vektoren[i]);

	    Zweivektor spitzeeinsvon = Vektorverdoppler.verdoppele(schwanzbis);
	    Zweivektor spitzeeinsbis = Vektorverdoppler.verdoppele(schwanzbis);
	    spitzeeinsbis.addiere(b);

	    Zweivektor spitzezweivon = Vektorverdoppler.verdoppele(schwanzbis);
	    Zweivektor spitzezweibis = Vektorverdoppler.verdoppele(schwanzbis);
	    spitzezweibis.addiere(d);

	    zsl[i * 3] = new Zweistrecke(schwanzvon, schwanzbis);
	    zsl[(i * 3) + 1] = new Zweistrecke(spitzeeinsvon, spitzeeinsbis);
	    zsl[(i * 3) + 2] = new Zweistrecke(spitzezweivon, spitzezweibis);
	}

	// Nun stelle alle Strecken dar. Wir benutzen eine
	// Zweistreckewelt und eine Zweistreckesicht.

	Zweistreckewelt zsw = new Zweistreckewelt(zsl);
	Zweistreckesicht zss = new Zweistreckesicht(zsw);
	zss.darstellen(g);
    }
}


