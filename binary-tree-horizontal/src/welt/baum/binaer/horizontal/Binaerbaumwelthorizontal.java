package welt.baum.binaer.horizontal;

import baum.binaer.Binaerbaum;
import java.util.ArrayList;
import vektor.Zweivektor;
import baum.binaer.Binaerbaumgroesse;
import welt.baum.binaer.Binaerbaumstrecke;
import druck.strecke.Streckedrucker;
import strecke.Zweistrecke;
import druck.vektor.Vektordrucker;

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

	// Berechne die Orte nach Verstraffung und Verschiebung.
	this.orte = this.nehmeorte(bo);
	this.strecken = this.nehmestrecken(bo);
    }

    // Nehme eine Liste von allen Knoten dieses Baumes.
    Zweivektor[] nehmeorte(Binaerbaumorthorizontal bo) {
	
	// Die berechnete Orte, nicht übereinanderliegende,
	// unverschoben und unverstafft.
	Zweivektor[] orte = bo.nehmeorte();

	// Zweivektor[] ortez = new Zweivektor[orte.length];
	
	for (int i = 0; i < orte.length; i++) {
	    // orte[i] = new Zweivektor(orte[i].eins * this.deltax + this.ursprungx,
	    // 			     orte[i].zwei * this.deltay + this.ursprungy);
	    orte[i].eins = orte[i].eins * this.deltax + this.ursprungx;
	    orte[i].zwei = orte[i].zwei * this.deltax + this.ursprungx;
	}

	return orte;
    }

    // Nehme eine Liste von allen Kanten dieses Baumes.
    Zweistrecke[] nehmestrecken(Binaerbaumorthorizontal bo) {
	Zweistrecke[] zsl = Binaerbaumstrecke.strecken(this.baum, bo.wer);
	return zsl;
    }
} 
