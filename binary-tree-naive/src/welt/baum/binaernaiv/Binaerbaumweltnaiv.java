package welt.baum.binaernaiv;

import baum.binaer.Binaerbaum;
import vektor.Zweivektor;
import paar.Paar;
import ort.baum.binaernaiv.Binaerbaumortnaiv;
import java.util.ArrayList;

// Mache eine Welt für einen zweidimensionalen binärschen Baum.
public class Binaerbaumweltnaiv {

    // Der Baum.
    public Binaerbaum baum;

    // Der Wurzel des Baumes.
    public Zweivektor wurzel;

    // Wie weit zwei Knoten voneinander stehen soll.
    int deltax;
    int deltay;

    public Binaerbaumweltnaiv(Binaerbaum b, Zweivektor w,
			      int dx, int dy) {
	this.baum = b;
	this.wurzel = w;
	this.deltax = dx;
	this.deltay = dy;
    }

    public Zweivektor[] nehmeorte() {
	
	ArrayList<Paar> orte = Binaerbaumortnaiv.nehmeorte(this.baum,
							   (int) this.wurzel.eins, (int) this.wurzel.zwei,
							   this.deltax, this.deltay);
	    
	Zweivektor punktliste[] = new Zweivektor[orte.size()];
	for (int i = 0; i < orte.size(); i++) {
	    Paar ort = orte.get(i);
	    punktliste[i] = new Zweivektor(ort.eins, ort.zwei);
	}

	return punktliste;
    }
}
