package fort;

import dreher.reel.vektor.zwei.RZweivektordreher;
import druck.reel.vektor.RVektordrucker;
import ganz.vektor.GDreivektor;
import ganz.vektor.GZweivektor;
import reel.vektor.RDreivektor;
import reel.vektor.RZweivektor;
import verdoppler.vektor.Vektorverdoppler;

// Baue einen neuen Vektor in der gleichen Richtung als der gegebene
// Vektor. Das heißt ein "fortbewegender Vektor" oder "Fortvektor."
//
// Die Vorgehensweise ist anders als in Dreifortvektor.
// 1. Nehme den Betrag des gegebenen Vektors = b1
// 2. Multipliziere den Vektor mit (b/b1).
// 3. Fertig
public class Fortvektor {

    // va: Der gegebene Vektor
    // betrag: Betrag des ausgehenden Vektors
    public static RDreivektor mache(RDreivektor va, double betrag) {

	double betraga = va.betrag();
	RDreivektor vb = Vektorverdoppler.verdoppele(va);
	vb.multipliziere(betrag / betraga);
	
	return vb;
    }

    public static RDreivektor mache(GDreivektor va, double betrag) {
	return Fortvektor.mache(new RDreivektor(va.eins,
						va.zwei,
						va.drei),
				betrag);
    }

    // Baue einen neuen Vektor in der gleichen Richtung als der gegebene
    // Vektor. Das heißt ein "fortbewegender Vektor" oder "Fortvektor."
    //
    // va: Der gegebene Vektor
    // betrag: Betrag des ausgehenden Vektors
    public static RZweivektor mache(RZweivektor va, double betrag) {

	double theta = Math.atan2(va.zwei, va.eins);
	RZweivektor vb = new RZweivektor(betrag, 0);
	RZweivektor vc = RZweivektordreher.drehen(vb, theta);

	return vc;
    }

    public static RZweivektor mache(GZweivektor va, double betrag) {
	return Fortvektor.mache(new RZweivektor(va.eins,
						va.zwei),
				betrag);
    }
}
