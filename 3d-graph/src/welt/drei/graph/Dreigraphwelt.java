package welt.drei.graph;

import graph.Graph;
import ganz.vektor.GDreivektor;
import ganz.strecke.GDreistrecke;
import graph.kanteanzahl.Kanteanzahl;
import verdoppler.vektor.Vektorverdoppler;

// Eine Dreigraphwelt ist ein Paar von:
// - Graph
// - Liste von Orten
//  
// Am Anfang ist ein Graph nicht darstellbar. Er besitzt viele
// Strecken und Knoten, aber mit keinen Orten verbunden.
//
// Eine Graphwelt verbindet einen Graph mit Orten der Knoten, sodaß
// wir ihn anschauen können. Das tut man ohne Berechnungen, aber ein
// Computer ist kein Mensch.
//
// Eine Graphwelt ist eine Welt des Graphen. Es könne verschiedene
// Welte eines Graphen geben.
//
// Wie stellt man die Orten eines Graphen dar? Die Knoten überliegen
// sich nicht. Die Strecken sind geradlinige. Die Strecken überliegen
// so wenig andere Strecken wie möglich. Und so weiter. Diese
// Grundlagen muss man rechnerich beitragen.
public class Dreigraphwelt {

    // Der Graph.
    public Graph graph;

    // Die Orten jedes Knoten.
    public GDreivektor[] orten;

    public Dreigraphwelt(Graph n, GDreivektor[] o) {
	this.graph = n;
	this.orten = o;
    }

    // ein: ganze Zahl
    // Sie gibt neue Vektore aus.
    public GDreivektor[] nehmeknoten() {
	
	GDreivektor[] ausvektoren = new GDreivektor[this.orten.length];
	
	for (int i = 0; i < this.orten.length; i++) {
	    ausvektoren[i] = Vektorverdoppler.verdoppele(this.orten[i]);
	}
	
	return ausvektoren;
    }

    // Nehme die Kanten dieses Graphen.
    public GDreistrecke[] nehmekanten() {

	// Zuerst berechne wie viele Kanten es gibt.
	int laenge = Kanteanzahl.kanteanzahl(this.graph);

	// Wir kennen wir viele Kanten dieser Graph gibt.
	GDreistrecke[] kanten = new GDreistrecke[laenge];

	// Es gibt laenge-mal Kanten dieses Graphen.
	// Die Summe aller i und j ist gleich laenge.
	// Also laufe über jede Kante durch, und addiere die Kanten.
	int kantenzeichen = 0;

	// Für jeden Knoten,
	for (int i = 0; i < this.graph.groesse; i++) {
	    // Nehme den Streckeanfang.
	    int vonx = this.orten[i].eins;
	    int vony = this.orten[i].zwei;
	    int vonz = this.orten[i].drei;

	    for (int j = 0; j < this.graph.nachbar.get(i).size(); j++) {

		// Nehme das Streckeende.
		int bisknoten = this.graph.nachbar.get(i).get(j);
		    
		int bisx = this.orten[bisknoten].eins;
		int bisy = this.orten[bisknoten].zwei;
		int bisz = this.orten[bisknoten].drei;

		kanten[kantenzeichen] = new GDreistrecke(new GDreivektor(vonx, vony, vonz),
							 new GDreivektor(bisx, bisy, bisz));
		kantenzeichen += 1;
	    }
	}

	return kanten;
    }
}
