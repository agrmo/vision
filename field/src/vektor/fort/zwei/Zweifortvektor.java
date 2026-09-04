package vektor.fort.zwei;

import vektor.Zweivektor;
import dreher.zweivektor.Zweivektordreher;

// Baue einen neuen Vektor in der gleichen Richtung als der gegebene
// Vektor. Das heißt ein "fortbewegender Vektor" oder "Fortvektor."
public class Zweifortvektor {

    // va: Der gegebene Vektor
    // betrag: Betrag des ausgehenden Vektors
    public static Zweivektor mache(Zweivektor va, double betrag) {

	double theta = Math.atan2(va.zwei, va.eins);
	Zweivektor vb = new Zweivektor(betrag, 0);
	Zweivektor vc = Zweivektordreher.drehen(vb, theta);

	return vc;
    }
}
