package baum.binaer;

// Es gibt zwei Wege, eine Datenstruktur zu bauen:
// 1. Mit einer rekursiven Klassenstruktur
//    - Baum
//      - Baum links
//      - Baum rechts

// 2. Mit einem Graphen
//    - Ein Binärbaum ist einfach ein gerichteter Graph, der nicht
//     verdoppelt ist, womit dessen Knotten am höchtens zwei Knoten
//     besitzt, wobei die erste Kante in der Nachbarschaftsliste
//     die Kante am links ist.

// Nehme 1.

public class Binaerbaum {

    public int wert;
    public Binaerbaum links;
    public Binaerbaum rechts;

    public Binaerbaum(int w) {
	this.wert = w;
	this.links = null;
	this.rechts = null;
    }

    public Binaerbaum(int w, Binaerbaum l, Binaerbaum r) {
	this.wert = w;
	this.links = l;
	this.rechts = r;
    }
}
