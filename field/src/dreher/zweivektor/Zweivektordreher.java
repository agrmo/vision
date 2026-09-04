package dreher.zweivektor;

import vektor.Zweivektor;

// Ein Zweivektordreher dreht einen zweidimensionalen Vektor um einen
// Drehpunkt.
//
// x' = cos(theta) x - sin(theta) y
// y' = sin(theta) x + cos(theta) y
//
public class Zweivektordreher {

    // Dreh den zweidimensionalen Vektor um den Ursprung gegen den
    // Uhrzeigersinn. Theta hat die Einheit Radiant.
    public static Zweivektor drehen(Zweivektor zp, double theta) {
	double xneu = Math.cos(theta)*zp.eins - Math.sin(theta)*zp.zwei;
	double yneu = Math.sin(theta)*zp.eins + Math.cos(theta)*zp.zwei;

	return new Zweivektor(xneu, yneu);
    }
}

