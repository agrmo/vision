package welt.baum.binaer;

import baum.binaer.Binaerbaum;
import java.util.ArrayList;
import ort.baum.binaer.Binaerbaumort;
import paar.Paar;
import vektor.Zweivektor;
import baum.binaer.Binaerbaumgroesse;

// Mache eine Welt für einen zweidimensionalen binärschen Baum.
public class Binaerbaumwelt {

    // Der Baum.
    public Binaerbaum baum;

    // Der Ursprung des Baumes.
    int ursprungx;
    int ursprungy;

    // Verschiebe nach der Multiplizierung mit deltax und delta y.
    // Nicht vor.

    // Wie weit zwei Knoten voneinander stehen soll.
    int deltax;
    int deltay;
    
    public Binaerbaumwelt(Binaerbaum b,
			  int ux, int uy,
			  int dx, int dy) {
	this.baum = b;
	this.ursprungx = ux;
	this.ursprungy = uy;
	this.deltax = dx;
	this.deltay = dy;
    }

    public Zweivektor[] nehmeorte() {

	// Die berechnete Orte, nicht übereinanderliegende,
	// unverschoben und unverstafft.
	Binaerbaumort bo = new Binaerbaumort(this.baum);
	Paar[] orte = bo.nehmeorte();

	// Es ist zusätzlich, in double zu übersetzen. Java braucht
	// int. Wir sollen diese Funktion verbessern.
	Zweivektor[] ortez = new Zweivektor[orte.length];

	for (int i = 0; i < orte.length; i++) {
	    ortez[i] = new Zweivektor(orte[i].eins * this.deltax + this.ursprungx,
				      orte[i].zwei * this.deltay + this.ursprungy);
	}

	return ortez;
    }
}    
