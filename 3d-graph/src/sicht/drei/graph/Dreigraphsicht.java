package sicht.drei.graph;

import auge.Auge;
import java.awt.Graphics;
import sicht.Sicht;
import sicht.zwei.graph.Zweigraphsicht;
import verleger.graph.Graphverleger;
import welt.drei.graph.Dreigraphwelt;
import welt.zwei.graph.Zweigraphwelt;

// Eine Sicht, die eine dreidimensionale Graphwelt darstellt.
public class Dreigraphsicht extends Sicht {

    // Die Welt.
    public Dreigraphwelt dgw;

    // Jeder Knoten ist als einen Kreis dargestellt.
    int durchmesser;

    // Das Auge.
    Auge auge;
    
    public Dreigraphsicht(Dreigraphwelt dgw, int durchmesser, Auge auge) {
	this.dgw = dgw;
	this.durchmesser = durchmesser;
	this.auge = auge;
    }
    
    public void darstellen(Graphics g) {

	// Wandle eine Dreigraphsicht zu einer Zweigraphsicht um.  Wir
	// müssen nur die dreidimensionalen Stellen zu
	// zweidimensionalen verlegen. Die Verbindungen der Knoten
	// werden nicht verändert.
	Zweigraphwelt zgw = Graphverleger.verlege(this.dgw, this.auge);

	// Die Zweigraphsicht wird die Knoten richtig verschieben,
	// sodaß jeweilige Kante in das Zentrum des Knoten gesetzt
	// wird. Interessant, daß das in nur zwei Dimensionen gilt.
	Zweigraphsicht zs = new Zweigraphsicht(zgw, this.durchmesser);
	zs.darstellen(g);
    }
}
