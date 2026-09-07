package sicht.drei.strecke;

import auge.Auge;
import dreher.euler.Eulerdreher;
import ganz.strecke.GDreistrecke;
import ganz.strecke.GZweistrecke;
import java.awt.Graphics;
import reel.matrix.RDreimatrix;
import sicht.Sicht;
import sicht.zwei.strecke.Zweistreckesicht;
import verleger.strecke.Streckeverleger;
import welt.drei.strecke.Dreistreckewelt;
import welt.zwei.strecke.Zweistreckewelt;

// Eine Dreistreckesicht kann dreidimensionalen Strecken darstellen.
// Wir benutzen die Verlegung der Ein-Punkt-Perspektive.
public class Dreistreckesicht extends Sicht {

    // Die Welt.
    public Dreistreckewelt dsw;

    // Das Auge.
    Auge auge;
    
    public Dreistreckesicht(Dreistreckewelt dsw, Auge auge) {
	this.dsw = dsw;
	this.auge = auge;
    }

    public void darstellen(Graphics g) {

	GZweistrecke[] zsl = new GZweistrecke[dsw.strecken.length];
	RDreimatrix drehung = Eulerdreher.nehmedrehung(this.auge.winkeleins,
						       this.auge.winkelzwei,
						       this.auge.winkeldrei);
	
	// Stelle jede Strecke dieser Welt dar.
	for (int i = 0; i < this.dsw.strecken.length; i++) {
	    zsl[i] = Streckeverleger.verlege(this.dsw.strecken[i],
					     this.auge.entfernung, this.auge.brennweite,
					     this.auge.breite, this.auge.hoehe,
					     drehung);
	}

	Zweistreckewelt zsw = new Zweistreckewelt(zsl);
	Zweistreckesicht zss = new Zweistreckesicht(zsw);
	zss.darstellen(g);
    }
}
