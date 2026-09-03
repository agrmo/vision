package welt.baum.binaer.horizontal;

import baum.binaer.Binaerbaum;
import java.util.ArrayList;
import vektor.Zweivektor;
import welt.baum.binaer.Binaerbaumstrecke;
import druck.strecke.Streckedrucker;
import strecke.Zweistrecke;
import druck.vektor.Vektordrucker;
import java.util.HashMap;

// Mache eine Welt für einen zweidimensionalen binärschen Baum.
public class Binaerbaumwelthorizontal {

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
    public Zweivektor[] orte;
    public Zweistrecke[] strecken;

    public Binaerbaumwelthorizontal(Binaerbaum b,
				    int ux, int uy,
				    int dx, int dy) {
	this.baum = b;
	this.ursprungx = ux;
	this.ursprungy = uy;
	this.deltax = dx;
	this.deltay = dy;

	// Berechne die unterliegende Orten.
	Binaerbaumorthorizontal bo = new Binaerbaumorthorizontal(b);

	// Nehme die Abbildung
	HashMap<Integer,Zweivektor> wer = bo.nehmewer();

	// Straffe und verschiebe die Orte
	straffeverschiebe(wer);

	// Berechne die Orte nach Verstraffung und Verschiebung.
	this.orte = this.nehmeorte(wer);
	this.strecken = this.nehmestrecken(wer);
    }

    void straffeverschiebe(HashMap<Integer,Zweivektor> wer) {
	for (int k : wer.keySet()) {
	    Zweivektor zv = wer.get(k);
	    zv.eins = zv.eins * this.deltax + this.ursprungx;
	    zv.zwei = zv.zwei * this.deltax + this.ursprungy;
	}
    }

    // Nehme eine Liste von allen Knoten dieses Baumes.
    Zweivektor[] nehmeorte(HashMap<Integer,Zweivektor> wer) {
	
	// Die berechnete Orte, nicht übereinanderliegende,
	// unverschoben und unverstafft.
	Zweivektor[] orte = new Zweivektor[wer.size()];

	int i = 0;
	for (int k : wer.keySet()) {
	    orte[i] = wer.get(k);
	    i += 1;
	}

	return orte;
    }

    // Nehme eine Liste von allen Kanten dieses Baumes.
    Zweistrecke[] nehmestrecken(HashMap<Integer,Zweivektor> wer) {

	Zweistrecke[] zsl = Binaerbaumstrecke.strecken(this.baum, wer);
	
	return zsl;
    }
} 
