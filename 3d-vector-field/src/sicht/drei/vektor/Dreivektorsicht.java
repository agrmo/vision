package sicht.drei.vektor;

import rund.Abrunder;
import auge.Auge;
import dreher.euler.Eulerdreher;
import fort.Fortvektor;
import ganz.strecke.GDreistrecke;
import ganz.vektor.GDreivektor;
import reel.vektor.RDreivektor;
import java.awt.Graphics;
import reel.matrix.RDreimatrix;
import sicht.Sicht;
import sicht.drei.strecke.Dreistreckesicht;
import verdoppler.vektor.Vektorverdoppler;
import welt.drei.strecke.Dreistreckewelt;
import welt.drei.vektor.Dreivektorwelt;

// Stelle eine Reihe von dreidimensionalen Vektoren dar.
public class Dreivektorsicht extends Sicht {

    // Die Welt.
    Dreivektorwelt welt;
    
    // Die Größe der Spitze des Vektors. 
    int spitze = 10;

    // Das Auge.
    Auge auge;
    
    public Dreivektorsicht(Dreivektorwelt w, Auge a) {
	this.welt = w;
	this.auge = a;
    }
    
    public void darstellen(Graphics g) {

	// Stelle jeden Vektor dieser Welt dar.  Jeder Vektor ergibt 3
	// neue: die Spitzen des Vektors.  Also 4 insgesamt.  Also
	// multipliziere 4 mit der Anzahl der Vektoren.  Die ist die
	// Anzahl der Strecken der Dreistreckewelt.  Lass wir eine
	// Streckewelt bauen. Jeder Vektor ergibt 4 Strecken.

	// Baue alle Strecken dieser Dreivektorwelt.
	
	int streckeanzahl = 4 * this.welt.vektoren.length;
	GDreistrecke[] dsl = new GDreistrecke[streckeanzahl];
	
	for (int i = 0; i < this.welt.vektoren.length; i++) {

	    // Stelle die Spitze des Vektors dar.  Die Spitze hat drei
	    // Teile. Jede Spitze geht ein bißchen in der
	    // Gegenrichtung (135 Grad) und sind gleichmäßig
	    // voneinander entfernt (120 Grad).
	    
	    // d.i.
	    //          \  <-- Größe der Spitze, 135 Grad "zurück"
	    // ----------
	    //          /  <-- Größe der Spitze, 135 Grad "zurück"
	    //
	    // und von Spitzenaussicht
	    //
	    //             |
	    //             |
	    //  120 Grad   .   120 Grad           
	    //            / \
	    //           /   \
	    //
	    //          120 Grad
	    //
	    // wobei jede Strecke ist 120 Grad voneinander entfernt.
	    // Und 120+120+120 = 360.

	    // Baue die drei Spitzen.
	    
	    RDreivektor a = Fortvektor.mache(this.welt.vektoren[i], this.spitze);
	    RDreivektor b = Fortvektor.mache(this.welt.vektoren[i], this.spitze);
	    RDreivektor c = Fortvektor.mache(this.welt.vektoren[i], this.spitze);

	    RDreimatrix adrehung = Eulerdreher.nehmedrehung(0,
							   -135 * (Math.PI / 180.0),
							   0);

	    RDreimatrix bdrehung = Eulerdreher.nehmedrehung(0,
							   -135 * (Math.PI / 180.0),
							   -120 * (Math.PI / 180.0));

	    RDreimatrix cdrehung = Eulerdreher.nehmedrehung(0,
							   -135 * (Math.PI / 180.0),
							   120 * (Math.PI / 180.0));

	    
	    GDreivektor d = Abrunder.abrunde(adrehung.punkt(a));
	    GDreivektor e = Abrunder.abrunde(bdrehung.punkt(b));
	    GDreivektor f = Abrunder.abrunde(cdrehung.punkt(c));

	    // Es gibt bis jetzt 4 Vektoren: der Schwanz und die drei
	    // Spitzen.  Der Schwanz ist this.welt.vektoren[i] und die
	    // drei Spitzen sind d, e und f. Sie zeigen sich in die
	    // richtige Richtungen aber stehen nicht an den richtigen
	    // Orten. Dargestellt:

	    /*
	       
             \  
	      -----
	     /

	    */
	    
	    // Nun verschiebe alle vier Vektoren zum richtigen Ort.

	    GDreivektor schwanzvon = this.welt.orte[i];
	    GDreivektor schwanzbis = Vektorverdoppler.verdoppele(this.welt.orte[i]);
 	    schwanzbis.addiere(this.welt.vektoren[i]);

	    GDreivektor spitzeeinsvon = Vektorverdoppler.verdoppele(schwanzbis);
	    GDreivektor spitzeeinsbis = Vektorverdoppler.verdoppele(schwanzbis);
	    spitzeeinsbis.addiere(d);

	    GDreivektor spitzezweivon = Vektorverdoppler.verdoppele(schwanzbis);
	    GDreivektor spitzezweibis = Vektorverdoppler.verdoppele(schwanzbis);
	    spitzezweibis.addiere(e);

	    GDreivektor spitzedreivon = Vektorverdoppler.verdoppele(schwanzbis);
	    GDreivektor spitzedreibis = Vektorverdoppler.verdoppele(schwanzbis);
	    spitzedreibis.addiere(f);

	    dsl[i * 4] = new GDreistrecke(schwanzvon, schwanzbis);
	    dsl[(i * 4) + 1] = new GDreistrecke(spitzeeinsvon, spitzeeinsbis);
	    dsl[(i * 4) + 2] = new GDreistrecke(spitzezweivon, spitzezweibis);
	    dsl[(i * 4) + 3] = new GDreistrecke(spitzedreivon, spitzedreibis);
	}

	// Nun stelle alle Strecken dar. Wir benutzen eine
	// Dreistreckewelt und eine Dreistreckesicht.

	Dreistreckewelt dsw = new Dreistreckewelt(dsl);

	Dreistreckesicht dss = new Dreistreckesicht(dsw, this.auge);

	dss.darstellen(g);
    }
}


