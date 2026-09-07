package verleger.strecke;

import reel.matrix.RDreimatrix;
import ganz.strecke.GDreistrecke;
import ganz.strecke.GZweistrecke;
import ganz.vektor.GDreivektor;
import ganz.vektor.GZweivektor;
import verleger.punkt.Punktverleger;

// Ein Streckeverleger verlegt eine dreidimensionale Welt von
// Vielflächen zu einer zweidimensionalen Welt von Vektoren und
// Strecken.
//
// Schritte:
// 1. Berechne die nötige Drehung.
// 2. Drehe den Punkt.
// 3. Entfernee die Kamera vom Ursprung.
// 4. Projiziere alle Vektoren zu einer zweidimensionalen Fläche.
// 5. Verschiebe alle Vektoren zum Zentrum des Bildchirms.
public class Streckeverleger {
    
    // ein: Dreistrecke, ...
    // aus: Zweistrecke
    //
    // Verlege die gegebene dreidimensionale Strecke.
    public static GZweistrecke verlege(GDreistrecke ds,
				       GDreivektor entfernung, double brennweite,
				       double breite, double hoehe,
				       RDreimatrix drehung) {
	
	GZweivektor verlegtervektorvon = Punktverleger.verlege(ds.von,
							       entfernung, brennweite,
							       breite, hoehe,
							       drehung);
	
	GZweivektor verlegtervektorbis = Punktverleger.verlege(ds.bis,
							       entfernung, brennweite,
							       breite, hoehe,
							       drehung);
	
	// Die neue Strecke, die nur in zwei Dimensionen liegt.
	GZweistrecke zs = new GZweistrecke(verlegtervektorvon, verlegtervektorbis);
	
	return zs;
    }
}
