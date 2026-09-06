package dreher.reel.vektor.zwei;

import reel.matrix.RZweimatrix;
import reel.vektor.RZweivektor;

// Ein RZweivektordreher dreht einen zweidimensionalen Vektor um einen
// Drehpunkt.
//
// x' = cos(theta) x - sin(theta) y
// y' = sin(theta) x + cos(theta) y
//
public class RZweivektordreher {

    // Dreh den zweidimensionalen Vektor um den Ursprung gegen den
    // Uhrzeigersinn. Theta hat die Einheit Radiant.
    public static RZweivektor drehen(RZweivektor zp, double theta) {
	double xneu = Math.cos(theta)*zp.eins - Math.sin(theta)*zp.zwei;
	double yneu = Math.sin(theta)*zp.eins + Math.cos(theta)*zp.zwei;

	return new RZweivektor(xneu, yneu);
    }

    // Ähnlich wie der Achsedreher stellen wir eine klare bestimmte Frage
    // und benennen dem Problem einen schlechten Namen.
    //
    // Frage: Wie drehen wir einen Vektor um einen Punkt herum?
    //
    // Antwort:
    // 1. Nenne den Vektor zu drehen va
    // 2. Nenne den Drehpunkt drehpunkt
    // 3. Subtrahiere teilweise drehpunkt von va. d.h. vb = va - drehpunkt
    // 4. Drehe vb mit der gegebenen Drehmatrix -> vc
    // 5. Addiere teilweise drehpunkt zu vc. d.h. vd = vc + drehpunkt
    // 6. Gebe vd aus
    public static RZweivektor drehe(RZweivektor va,
				    RZweivektor drehpunkt,
				    RZweimatrix drehung) {
	va.subtrahiere(drehpunkt);
	RZweivektor vb = drehung.punkt(va);
	vb.addiere(drehpunkt);
	
	return vb;
    }
}

