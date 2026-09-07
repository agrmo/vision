package welt.zwei.graph;

import graph.Graph;
import ganz.vektor.GZweivektor;
import graph.kanteanzahl.Kanteanzahl;
import verdoppler.vektor.Vektorverdoppler;
import ganz.strecke.GZweistrecke;

// Eine Zweigraphwelt ist ein Paar von:
// - Graph
// - Liste von Orten
//  
// Am Anfang ist ein Graph nicht darstellbar. Er besitzt viele
// Strecken und Knoten, die aber keinen bestimmten Ort besetzen.
//
// Eine Graphwelt verbindet einen Graph mit Orten der Knoten, sodaß
// wir ihn vorstellen können. Das tut man ohne Berechnungen, aber ein
// Computer ist kein Mensch.
//
// Wie stellte man die Orten eines Graphen? Die Knoten überschneiden
// sich nicht. Die Strecken sind geradlinige. Die Strecken überliegen
// so wenig andere Strecken wie möglich. Und so weiter. Diese
// Grundlagen muss man rechnerich beitragen.
//
// Eine Graphwelt ist eine Welt des Graphen.
//
public class Zweigraphwelt {

    // Der Graph.
    public Graph graph;

    // Die Orten jedes Knoten.
    public GZweivektor[] orten;

    public Zweigraphwelt(Graph g, GZweivektor[] o) {
	this.graph = g;
	this.orten = o;
    }

    // ein: ganze Zahl
    // Sie gibt neue Vektore aus.
    // Diese Welt kennt wie groß ein Knoten ist.
    public GZweivektor[] nehmeknoten() {

	GZweivektor[] ausvektoren = new GZweivektor[this.orten.length];
	
	for (int i = 0; i < this.orten.length; i++) {
	    ausvektoren[i] = Vektorverdoppler.verdoppele(this.orten[i]);
	}
	
	return ausvektoren;
    }

    // Rechne alle Kanten dieses Graphen aus.
    public GZweistrecke[] nehmekanten() {

	// Zuerst berechne wie viele Kanten es gibt.
	int ka = Kanteanzahl.kanteanzahl(this.graph);

	// Wir kennen wir viele Kanten dieser Graph gibt.
	GZweistrecke[] kanten = new GZweistrecke[ka];

	// Es gibt ka-mal Kanten dieses Graphen.
	// Die Summe aller i und j ist gleich ka.
	// Also laufe über jede Kante durch, und addiere die Kante.

	int kantenzeichen = 0;
	for (int i = 0; i < this.graph.groesse; i++) {
	    // Wo dieser Knoten ist.
	    int vonx = (int) this.orten[i].eins;
	    int vony = (int) this.orten[i].zwei;

	    for (int j = 0; j < this.graph.nachbar.get(i).size(); j++) {

		// Wer der Knoten ist, dem dieser Knoten verbunden ist.
		int bisknoten = this.graph.nachbar.get(i).get(j);
		    
		int bisx = (int) this.orten[bisknoten].eins;
		int bisy = (int) this.orten[bisknoten].zwei;

		kanten[kantenzeichen] = new GZweistrecke(new GZweivektor(vonx, vony),
							 new GZweivektor(bisx, bisy));
		kantenzeichen += 1;
	    }
	}

	return kanten;
    }
}
