package verleger.graph;

import auge.Auge;
import dreher.euler.Eulerdreher;
import ganz.vektor.GDreivektor;
import reel.matrix.RDreimatrix;
import reel.vektor.RDreivektor;
import ganz.vektor.GZweivektor;
import verleger.punkt.Punktverleger;
import welt.drei.graph.Dreigraphwelt;
import welt.zwei.graph.Zweigraphwelt;

public class Graphverleger {
    
    // ein: Dreigraphwelt, ...
    // aus: Zweigraphwelt
    //
    // Verlege die dreidimensionale Dreigraphwelt zu einer
    // zweidimensionale Zweigraphwelt.
    public static Zweigraphwelt verlege(Dreigraphwelt dgw, Auge auge) {

	GDreivektor[] dreiorten = dgw.nehmeknoten();
	GZweivektor[] zweiorten = new GZweivektor[dreiorten.length];

	// Für jeden Knoten, verlegen den Knoten.
	RDreimatrix drehung = Eulerdreher.nehmedrehung(auge.winkeleins,
						       auge.winkelzwei,
						       auge.winkeldrei);

	// Verlege jeden Vektor. 
	for (int i = 0; i < zweiorten.length; i++) {
	    zweiorten[i] = Punktverleger.verlege(dreiorten[i],
						 auge.entfernung, auge.brennweite,
						 auge.breite, auge.hoehe,
						 drehung);
	}

	Zweigraphwelt zw = new Zweigraphwelt(dgw.graph, zweiorten);
	
	return zw;
    }
}
