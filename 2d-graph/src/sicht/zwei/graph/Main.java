package sicht.zwei.graph;

import bildschirm.Bildschirm;
import ganz.vektor.GZweivektor;
import graph.Graph;
import graph.zufalls.Zufallsgraph;
import maler.Maler;
import sicht.Sicht;
import welt.zwei.graph.Zweigraphwelt;

// java -cp classes sicht.zwei.graph.Main

public class Main {

    static void beispieleins() {
	// Mache die Welt.
	int[][] paare = {{1,2},{2,0}};
        int groesse = 3;
        Graph g = new Graph(paare, groesse);
	
        GZweivektor[] orte = {
	    new GZweivektor(10,10),
	    new GZweivektor(50,50),
	    new GZweivektor(100,40)
	};
	Zweigraphwelt zgw = new Zweigraphwelt(g, orte);

	// Mache die Sicht.
	int durchmesser = 20;
	Zweigraphsicht zgs = new Zweigraphsicht(zgw, durchmesser);
	Maler m = new Maler(new Sicht[] {zgs});
  
        // Stelle die Daten dar.
	Bildschirm.schwarz(m);
    }

    public static void main(String[] args){
	beispieleins();
    }
}
