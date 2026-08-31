package sicht.baum.binaernaiv;

import welt.punkt.Zweipunktwelt;
import sicht.punkt.Zweipunktsicht;
import vektor.Zweivektor;
import baum.binaer.Binaerbaum;
import java.util.ArrayList;
import sicht.Sicht;
import java.awt.Graphics;
import ort.baum.binaernaiv.Binaerbaumortnaiv;
import welt.baum.binaernaiv.Binaerbaumweltnaiv;

//                o
//               /
//              o
//             /
//            o
//           /
//          o

//                o
//                 \
//                  o
//                   \
//                    o
//                     \
//                      o

//                o
//                 \
//                  o
//                   \
//                    o
//                     \
//                      o
//                     /
//                    o
//                   /
//                  o
//                 /
//                o

//                o
//                 \
//                  o
//                 / \
//                o   o
//               / \   \
//              o   o   o
//             /     \
//            o       o
//           /       
//          o       

// Ein Binärbaumsicht stellt einen Baum dar.
public class Binaerbaumsichtnaiv extends Sicht {

    Binaerbaumweltnaiv welt;
    double durchmesser;

    public Binaerbaumsichtnaiv(Binaerbaumweltnaiv bw,
			       double d) {
	this.welt = bw;
	this.durchmesser = d;
    }

    public void darstellen(Graphics g) {

	// Nehme die Orte der Knoten.
	Zweivektor[] punktliste = this.welt.nehmeorte();
	Zweipunktwelt zpw = new Zweipunktwelt(punktliste);
	Zweipunktsicht zps = new Zweipunktsicht(zpw, this.durchmesser);
	zps.darstellen(g);
    }
}
