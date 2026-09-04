package welt.baum.binaer;

import baum.binaer.Binaerbaum;
import java.util.ArrayList;
import welt.baum.binaer.Binaerbaumstrecke;
import vektor.ganz.GZweivektor;
import strecke.ganz.GZweistrecke;
import java.util.HashMap;

// Mache eine Welt für einen zweidimensionalen binärschen Baum.
public class Binaerbaumwelt {

    // Der Baum.
    Binaerbaum baum;

    // Der Ursprung des Baumes.
    int ursprungx;
    int ursprungy;

    // Verschiebe nach der Multiplizierung mit deltax und delta y.
    // Nicht vor.

    // Wie weit zwei Knoten voneinander stehen soll.
    int deltax;
    int deltay;

    // Die wichtige Daten: Orte und Strecken.
    public GZweivektor[] orte;
    public GZweistrecke[] strecken;

    public Binaerbaumwelt(Binaerbaum b,
			  int ux, int uy,
			  int dx, int dy) {
	this.baum = b;
	this.ursprungx = ux;
	this.ursprungy = uy;
	this.deltax = dx;
	this.deltay = dy;

	// Berechne die unterliegende Orten.
	Binaerbaumort bo = new Binaerbaumort(b);

	// Nehme die Abbildung
	HashMap<Integer,GZweivektor> wer = bo.wer;

	// Straffe und verschiebe die Orte
	straffeverschiebe(wer);

	// Berechne die Orte nach Verstraffung und Verschiebung.
	this.orte = bo.nehmeorte();

	// Nehme eine Liste von allen Kanten dieses Baumes.
	this.strecken = Binaerbaumstrecke.nehmestrecken(b, wer);
    }

    void straffeverschiebe(HashMap<Integer,GZweivektor> wer) {
	for (int k : wer.keySet()) {
	    GZweivektor zv = wer.get(k);
	    zv.eins = zv.eins * this.deltax + this.ursprungx;
	    zv.zwei = zv.zwei * this.deltax + this.ursprungy;
	}
    }
} 
