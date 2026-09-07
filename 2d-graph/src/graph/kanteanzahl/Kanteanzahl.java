package graph.kanteanzahl;

import graph.Graph;
    
// Berechne die Anzahl von Kanten des ganzen Graphen. Am besten ist
// die Antwort mit einem nicht verdoppelten Graphen berechnet.
public class Kanteanzahl {
    
    public static int kanteanzahl(Graph g) {
	int kanteanzahl = 0;
	
	for (int i = 0; i < g.nachbar.size(); i++) {
	    kanteanzahl += g.nachbar.get(i).size();
	}

	return kanteanzahl;
    }
}
