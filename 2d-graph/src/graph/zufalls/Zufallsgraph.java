package graph.zufalls;

import graph.Graph;
import java.util.ArrayList;
import java.util.List;
import liste.Liste;

// Ein Zufallsgraph ist eine Art Graph mit n Knoten, bei dem jede
// Kante ganz zufällig erzeugt ist. Gegeben die Anzahl von Knoten und
// die Wahrscheinlichkeit p, jedes Paar von Knoten eine Kante zu
// tragen.
public class Zufallsgraph {
    
    // n: Anzahl von Knoten
    // Nehme alle Paare von Knoten.  Ein ungerichteter Graph besitzt
    // am höchstens (1/2)n(n-1)-mal Kante, die zwei Knoten verbinden
    // werden. Komplexität: (1/2)*n*(n-1).
    // z.B.
    // Die Zahl n ergibt die liste von Paaren:
    // [[0,1],[0,2],[1,2]]
    private static ArrayList<int[]> nehmePaare(int n, double p) {

	// Wir kennen schon die Größe eines Paars: 2.  Aber wir kennen
	// nicht schon die Anzahl der Paare, also wir brauchen ein
	// ArrayList der Paare.
	ArrayList<int[]> paare = new ArrayList<int[]>(n);
	
	for (int i = 0; i < n; i++) {
	    for (int j = i; j < n; j++) {
		if (i != j) {
		    double r = Math.random();

		    // Würfe eine "Münze," die Wahrscheinlichkeit p hat.
		    // Falls "ja," setze eine neue Kante [i,j] ein.
		    // Falls "nein," tue nichts.
		    if (r < p) {
			paare.add(new int[] {i,j});
		    }    
		}
	    }
	}
	
	return paare;
    }

    // n: ganze Zahl
    // p: double
    // n ist die Anzahl von Knoten.    
    // p ist die Wahrscheinlichkeit, daß je ein Paar von Knoten eine
    // Kante trägt. Sobald das Object erzeugt wird, bauen den Graph
    // auf.
    public static Graph mache(int n, double p) {
	ArrayList<int[]> paare = nehmePaare(n, p);

	int[][] paareArray = Liste.nehmeArrayListArrayInteger(paare);

	return new Graph(paareArray, n);
    }
}
