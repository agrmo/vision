package graph;

import java.util.ArrayList;

// Ein ungerichteter ungewichteter Graph. 
//
// Der Graph besitzt n Knoten und am höchstens (1/2)N(N-1) Kanten.
//
// Eigenschaften:
// - Ein Knoten ist eine ganze Zahl.
// - Es gibt Größe-mal Knoten im Graphen.
// - Die Kennzeichen (Index) der Knoten sind 0 bis (Größe - 1).
// - Deshalb jede Liste von Nachbarn ist immer eine Liste von
//   ganzen Zahlen von 0 bis Größe - 1.
//
// Die Durchführung dieses Graphen ist eine Nachbarschaftsliste.
//
// Ein Knoten ist eine ganze Zahl.
// Eine Kantenliste ist eine Liste von Knoten.
// Ein Graph ist eine Liste von Kantenliste.
public class Graph {

    /*
      "nachbar" ist eine Nachbarschaftsliste. 

      Beispiel:
      paare: [[1,2],[0,2],[0,1]]

      Bildet die Nachbarschaftsliste:
      0: [1]
      1: [2]
      2: [0]

      in Form von

      [[1],[2],[0]]

      d.h., der Index der Liste zeigt den Namen des Knoten.
    */
    public ArrayList<ArrayList<Integer>> nachbar;

    // "groesse" ist die Anzahl der Knoten dieses Graphen.
    public int groesse;

    /*
      paare: Liste von Liste von Integer
      
      Liste von Paaren, die die Knoten einer Kante zeigen. Die Knoten
      sind genau die Kennzeichen der Listen.  z.B. [[1,2],[0,1],[2,0]]
      ist eine Schleife.
      
      Nehmen wir an, daß jede Kante is nur einmal in Paare gegeben,
      z.B. nur [1,2] und nicht beide [1,2] und [2,1].
      
      paare konnte trotzdem Verdopplungen besitzen. Daß wäre ein
      Fehler des Benutzers. Lassen wir auch prüfen, daß eine Kante
      nur einmal in der Struktur addiert wird. d.i.

      if (Kante noch nicht im n ist) {
        addiere die Kante in n
      }
      
      groesse: ganze Zahl

      Die Anzahl der Knoten in diesem Graph. Wir müssen den Groesse
      bestimmt einnehmen, weil es Knoten ohne Kanten geben konnte.
    */
    
    public Graph() {
	// Nur benutzt, um Kinder zu machen.
    }
    
    public Graph(int[][] paare, int groesse) {
	this.groesse = groesse;
	
	// Am Anfang gibt es keine Kante.  Erzeugen die
	// Nachbarschaftsliste mit Größe "groesse" und erzeugen eine
	// leere Liste dahin.
	this.nachbar = new ArrayList<ArrayList<Integer>>();

	// Für jeden Knoten, mach eine leere Liste für die Kanten.
	for (int i = 0; i < groesse; i++) {
	    this.nachbar.add(new ArrayList<Integer>());
	}

	// Setze alle Kanten ein.
	for (int i = 0; i < paare.length; i++) {

	    // Ein Paar ist eine Kante.
	    int[] paar = paare[i];

	    // Aber die Kante kann auch schon in der
	    // Nachbarschaftsliste stehen.

	    // Nur wenn die Kante noch nicht in der
	    // Nachbarschaftsliste steht, addieren wir die Kante.

	    // Falls die Kante noch nicht in der Struktur ist, füge die Kante.
	    if (!this.nachbar.get(paar[0]).contains(paar[1]) &&
		!this.nachbar.get(paar[1]).contains(paar[0])) {
		
		this.nachbar.get(paar[0]).add(paar[1]);
		
	    } else {
		System.out.println("Die Kante " + paar[0] + ", " + paar[1]
				   + " schon existiert.");
	    }
	}
    }
}
