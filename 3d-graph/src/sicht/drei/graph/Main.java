package sicht.drei.graph;

import auge.Auge;
import bildschirm.Bildschirm;
import ganz.vektor.GDreivektor;
import graph.Graph;
import maler.Maler;
import sicht.Sicht;
import sicht.zwei.graph.Zweigraphsicht;
import welt.drei.graph.Dreigraphwelt;

// java -cp classes sicht.drei.graph.Main

public class Main {

    static void beispieleins() {
	// Der Graph.
	int[][] paare = {{1,2},{2,0}};
        int groesse = 3;
        Graph g = new Graph(paare, groesse);

	// Die Orten.
        GDreivektor[] orten = {
	    new GDreivektor(10,10,100),
	    new GDreivektor(50,50,120),
	    new GDreivektor(100,40,150)
	};

	// Mache die Welt.
	Dreigraphwelt dgw = new Dreigraphwelt(g, orten);

	// Mache die Sicht.
	double breite = 1200;
	double hoehe = 600;
	double brennweite = 500;
	int durchmesser = 20;
	GDreivektor entfernung = new GDreivektor(0,0,0);
	double winkeleins = 0;
	double winkelzwei = 0;
	double winkeldrei = 0;
	Auge auge = new Auge(entfernung, brennweite,
			     breite, hoehe,
			     winkeleins,
			     winkelzwei,
			     winkeldrei);
	
	Dreigraphsicht s = new Dreigraphsicht(dgw, durchmesser, auge);
	Maler m = new Maler(new Sicht[] {s});
  
        // Stelle die Daten dar.
	Bildschirm.schwarz(m);
    }

    public static void main(String[] args){
	beispieleins();
    }
}
