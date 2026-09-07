package verleger.punkt;

import reel.matrix.RDreimatrix;
import reel.vektor.RDreivektor;
import ganz.vektor.GDreivektor;
import ganz.vektor.GZweivektor;
import ganz.vektor.GDreivektor;

// Ein Punktverleger verlegt einen dreidimensionalen Punkt von einer
// zweidimensionalen Punkt mit Hilfe der Ein-Punkt-Perspektive.
//
// Schritte der Ein-Punkt-Perspektive:
// 1. Berechne die nötige Drehung.
// 2. Drehe den Punkt.
// 3. Entfernen die Kamera vom Ursprung.
// 4. Projizieren alle Vektoren zu einer zweidimensionalen Fläche.
// 5. Verschieben alle Vektoren zum Zentrum des Bildchirms.
public class Punktverleger {
    
    // ein: Dreivektor
    // aus: Zweivektor
    //
    // Verlege den gegeben dreidimensionalen Vektor.
    public static GZweivektor verlege(GDreivektor va,
				      GDreivektor entfernung, double brennweite,
				      double breite, double hoehe,
				      RDreimatrix drehung) {
		
	// Drehe die Basis des Vektors um.
	RDreivektor vb = new RDreivektor(va.eins, va.zwei, va.drei);
	RDreivektor vc = drehung.punkt(vb);

	// Jetzt ist die Stelle gedreht.
	// Entferne die Augen entlang der z-Achse.
	vc.eins -= entfernung.eins;
	vc.zwei -= entfernung.zwei;
	vc.drei -= entfernung.drei;
	
	// Letzendlich verlegen die Stellen von drei bis zwei Dimensionen.
	int zweidimensionalex = (int) ((0.5 * breite)
				       + (vc.eins/vc.drei) * brennweite);
	
	int zweidimensionaley = (int) ((0.5 * hoehe)
				       + (vc.zwei/vc.drei) * brennweite);

	GZweivektor aus = new GZweivektor(zweidimensionalex, zweidimensionaley);
	
	return aus;
    }
}
