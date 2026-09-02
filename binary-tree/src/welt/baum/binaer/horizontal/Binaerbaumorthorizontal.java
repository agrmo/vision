package welt.baum.binaer.horizontal;

import baum.binaer.Binaerbaum;
import baum.binaer.Binaerbaumelter;
import baum.binaer.Binaerbaumgroesse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import vektor.Zweivektor;
import java.util.HashMap;
import java.util.Set;

// Berechene alle Orte dieses Baumes.  Ein Rechner, der durch einem
// Baum geht, und berechnet die Stelle jedes Knotens.
//
// Idee
//
// Der Ort eines Knotens ist vielleicht
//                              
//                              o (x,y)
//
// Was sind die Orte seiner Kinder?
//
//                              o
//                             / \
// links = (x - dx, y + dy)   /   \  rechts = (x + dx, y + dy)
//                           /     \
//                          o       o
// Problem
//                  o
//                 / \
//                o   o
//                 \ /
//                  o <- Zwei Knoten
//                 / \
//                o   o
// Idee
//
// Wir müssen die Breite eines Baumes zuerst berechnen, bevor
// wir die Stelle links und rechts berechnen. Insbesondere,
// - Wenn wir rechts berechnen wollen, müssen wir die größte linke
//   Stelle berechnen und verschieben den Knoten rechts.
// - Wenn wir links berechnen wollen, müssen wir die größte rechte
//   Stelle berechnen und verschieben den Knoten links.
// 
// Problem
//         o                          o        
//        / \       	             / \       
//       o   o      	            o   o      
//        \   \   ->                 \   \     
//         o   o    	              o   o    
//          \   \   	               \ / \   
//           o   o  zwei Knoten hier -> o   o  
//            \   \ 	                 \   \ 
//	       o   o	                  o   o
//
// Idee
//
// 1. Baue eine Abbildung für jede Stelle des Knotens.
// 2. Geh durch den Baum mit Breitensuche. Nicht Tiefensuche.
// 
//    Speichere jede Stelle des Knotens, aber:
// 
// 3. Wenn eine Stelle schon besitzt ist, verschiebe das Elter einen
//    Schritt in der anderen Richtung. Verschiebe den Knoten selbst
//    nicht. Verschiebe das Elter.
//
// Beispiel
//
//                o
//               / \__
//              o     o   ->
//             / \   / \
//            o   o A   o
//           / \   \ 
//          o   o   o
//
// In diesem Fall will Knoten A seine Kinder machen. Aber er muss
// nicht sich, sonern sein Elter zuerst nach rechts verschieben.
//
// Aber es gibt noch ein anderes Problem. Ein anderer Baum kann noch
// dort nach rechts stehen.
//
//                    o
//                   / \
//                  o   o
//                 / \   \
//                C   o   D
//               / \     / \
//              H   B   C   E
//             / \   \  
//            J   G   A
//           / \   \ 
//          K   I   F
// 
// A will ein Kind nach links machen, aber es gibt dort einen Knoten.
// Es gibt verschiedene Lösungen:
//
// 1. Verschiebe A nach rechts.
// 2. Verschiebe C nach links, seine Kinder, B steht bleiben, A steht bleiben.
// 3. Verschiebe C nach rechts, E nach rechts, B nach rechts.
// 4. Verschiebe D nach rechts, seine Kinder, B nach rechts.
//
// Eine Lösung:
// 1. A fragt F, verschieben Sie nach links bitte.
// 2. F sagt nein, es gibt I dort.
// 3. F fragt I, verschieben Sie nach links bitte.
// 4. I sagt nein, es gibt K dort.
// 5. I fragt K, verschieben Sie nach links bitte.
// 6. K sagt OK. Ich habe mich verschoben.
// 7. I verschiebt sich nach links.
// 8. F verschiebt sich nach links.
// 9. A macht sein Kind.
//
// Also wir brauchen eine rekursive Funktion, die durch einem Baum in
// irgendeine Richtung bewegen kann, um Knoten und seine Kinder in
// einer bestimmten Richtung verschieben sollte.
//
// - verschiebelinks(Knoten k)
// - verschieberechts(Knoten k)
//
// Diese zwei Funktionen brauchen zwei Datenstrukturen:
// - elter: Eine Abbildung von Knoten bis Knoten
// - ort: Eine Abbildung von Knoten bis Ort.
//
// Problem
//
// Zwei Knoten stehen dicht nebeneinander. Ein wollt das Kind A nach
// rechts machen, aber ein Knoten steht nicht nur dort, sodern auch
// direkt darunter.
// 
//                        o o
//                       / / \
//                      o B A o
//
// Idee
//
// Verschiebe B in der Richtung, die wir das neues Kind machen. In
// diesem Fall nach rechts.
//
// Problem
//                         A B
//                          /
//                         C
//
// A will ein Kind nach links machen. C steht darunter. Hätte A C in
// der Richtung des neuen Kindes verschoben, dann wird es noch eine
// Überschneidung geben.
//
// Idee
//
// Mache die Funktion istueberschneidetrechts(Knoten A, Knoten C).
//
// Hat der Knoten C eine mögliche Überschneidung mit Knoten A nach rechts?
// boolean istueberschneidetrechts(Knoten A, Knoten C)
//
// Hat der Knoten C eine mögliche Überschneidung mit Knoten A nach linkss?
// boolean istueberschneidetlinkss(Knoten A, Knoten C)
//
// if (Es gibt ein Knoten darunter und derselbe Knoten ist eine
// mögliche Überschneidung nach rechts) { verschiebe ihn rechts }
//
// if (Es gibt ein Knoten darunter und derselbe Knoten ist eine
// mögliche Überschneidung nach links) { verschiebe ihn links }
//
// Also mit dieser Funktion wird A nicht C nach links verschieben. Gut.
//
// Problem
//
// Es gebt mehr Knoten als A und C, die übereinander überschneiden können.
//

public class Binaerbaumorthorizontal {

    // Baum:
    // - wert
    // - links
    // - rechts
    Binaerbaum baumursprung;

    // Wert -> Wert
    HashMap<Integer,Integer> elter;

    // Ort -> Wert
    // .get(x).get(y)
    // oder
    // .get(y).get(x)?
    // Ein gutes Antwort:
    // Der Baum wird in der +y Richtung gebaut.
    // Fangen mit der Zeile y=0 an.
    // Also .get(y).get(x) ist besser.
    // Auch wir brauchen die Liste von allen Knoten
    // auf einer bestimmten Zeile y.
    public HashMap<Integer,HashMap<Integer,Integer>> ort;
    
    // Wert -> Ort
    public HashMap<Integer,Zweivektor> wer;

    public Binaerbaumorthorizontal(Binaerbaum bu) {

	// Fangen wir mit dem ursprünglichen Baum und dem
	// ursprünglichem Ort an.
	this.baumursprung = bu;

	// Der ganze Baum ist gebaut, und wir brauchen (leider) eine
	// Abbildung für die Eltern.
	this.elter = Binaerbaumelter.elter(bu);

	// Am Anfang kennen wir nun den Ort des Ursprungs.
	this.ort = new HashMap<Integer,HashMap<Integer,Integer>>();
	this.wer = new HashMap<Integer,Zweivektor>();
	
	this.fuege(0, 0, bu.wert);

	// Fangen unmittelbar mit dem Bau an.
	this.baue(this.baumursprung, 0, 0);

	// Schon haben wir alle Orten gefunden.
	// Die Orte stehen schon im wer und ort.
    }

    // Fuege einen Knoten am Ort.
    void fuege(int x, int y, int w) {
	if (!this.ort.containsKey(y)) {
	    this.ort.put(y, new HashMap<Integer,Integer>());
	}

	this.ort.get(y).put(x, w);
	this.wer.put(w, new Zweivektor(x,y));
    }

    // Lösche den Knoten an der Stelle [x,y]
    void loesche(int x, int y) {
	int wert = this.ort.get(y).get(x);
	this.wer.remove(wert);
	this.ort.get(y).remove(x);

	if (this.ort.get(y).size() == 0) {
	    this.ort.remove(y);
	}
    }

    // Ist der Ort [x,y] besetzt?
    boolean besetzt(int x, int y) {
	return this.ort.containsKey(y)
	    && this.ort.get(y).containsKey(x);
    }

    // Verschiebe den Knoten, der [x,y] besetzt, nach links.
    //
    // Wer steht an der Stelle [x, y]?
    // Nehme den Knoten A.
    // Ist [x-1,y] besetzt?
    // Ja:
    //   Wer steht an der Stelle [x-1,y]?
    //   Nehme den Knoten B.
    //   Verschiebe B links.
    // 
    // Verschiebe A nach links.
    // Fertig.
    void verschiebelinks(int x, int y) {
	
	// Wert des Knotens, der [x,y] besetzt.
	int k = this.ort.get(y).get(x);

	if (this.besetzt(x-1,y)) {
	    this.verschiebelinks(x-1,y);
	}

	// k steht an [x,y] nicht mehr.
	// Er steht an der Stelle [x-1,y].
	this.loesche(x,y);
	this.fuege(x-1,y,k);
	
	// Gut, alles verschoben.
	return;
    }

    // Verschiebe den Knoten, der [x,y] besetzt, nach rechts.
    void verschieberechts(int x, int y) {
	
	// Wert des Knotens, der [x,y] besetzt.
	int k = this.ort.get(y).get(x);

	if (this.besetzt(x+1,y)) {
	    this.verschieberechts(x+1,y);
	}

	// k steht an [x,y] nicht mehr.
	// Er steht an der Stelle [x+1,y].
	this.loesche(x,y);
	this.fuege(x+1,y,k);
	
	// Gut, alles verschoben.
	return;
    }

    // Wir wollen ein linkes Kind auf der Stelle (x-1,y+1) machen.
    //
    //                    o (x,y)
    //                   /
    //                  o (x-1,y+1)
    //
    // Aber es gibt eine Menge von möglichen Überschneidungen.
    //
    // Nehme alle möglichen Überschneidungen von (x-n,y)
    //
    //         o o ... o o (x,y)
    //
    // Finde alle ihre Kinder, die die Kante ((x,y),(x-1,y+1))
    // überschneiden.
    //
    // Verschiebe alle die überschneidenden Kinder züruck zu ihren
    // Eltern, nach links.
    // void entwirrenlinks(int x, int y) {

    // 	// Nehme alle Eltern, die auf der Zeile x steht.
    // 	ArrayList<Integer> xknoten = new ArrayList<Integer>();
    // 	Set<Integer> = this.ort.get(x).keySet();
    // 	ArrayList<Integer> xknoteninks = new ArrayList<Integer>();

    // 	// Nehme nur die Eltern, die nach links von (x,y) steht.
    // 	for (int xk : xknoten) {
    // 	    if (this.wer.get(xk).eins < );
    // 	}
    // }

    // Baue ein Kind von b nach links.
    void bauelinks(Binaerbaum b, int x, int y) {
	int linksx = x - 1;
	int linksy = y + 1;

	if (this.besetzt(linksx, linksy)) {
	    // Verschiebe den jeweiligen Knoten, der die stelle Stelle
	    // [linksx,linksy] besetzt hat.
	    this.verschiebelinks(linksx, linksy);
	}

	this.fuege(linksx, linksy, b.links.wert);
	this.baue(b.links, linksx, linksy);
    }

    // Baue ein Kind von b nach rechts.
    void bauerechts(Binaerbaum b, int x, int y) {
	int rechtsx = x + 1;
	int rechtsy = y + 1;

	if (this.besetzt(rechtsx, rechtsy)) {
	    // Verschiebe den jeweiligen Knoten, der die stelle Stelle
	    // [rechtsx,rechtsy] besetzt hat.
	    this.verschieberechts(rechtsx, rechtsy);
	}
	
	this.fuege(rechtsx, rechtsy, b.rechts.wert);
	this.baue(b.rechts, rechtsx, rechtsy);
    }

    void baue(Binaerbaum b, int x, int y) {

	if (b == null) {
	    return;
	}
	
	// Der Ort des Baumes b ist schon berechnet.
	// Finde die Orte seiner Kinder.

	if (b.links != null) {
	    bauelinks(b, x, y);
	}

	if (b.rechts != null) {
	    bauerechts(b, x, y);
	}
    }

    // Nehme eine Liste von allen Orten, die berechnet wurden.
    public Zweivektor[] nehmeorte() {
	
	int groesse = Binaerbaumgroesse.groesse(this.baumursprung);
	Zweivektor[] orte = new Zweivektor[groesse];

	int i = 0;
	for (int wert : this.wer.keySet()) {
	    Zweivektor ort = this.wer.get(wert);
	    orte[i] = ort;
	    i += 1;
	}

    	return orte;
    }

    // Nehme ein String dieser Datenstruktur.
    // Soll in druck/ sein...
    public String drucke() {
	StringBuilder sb = new StringBuilder();

	for (int key : this.wer.keySet()) {
	    Zweivektor ort = this.wer.get(key);
	    sb.append(key + ": [" + ort.eins + ", " + ort.zwei + "]");
	    sb.append("\n");
	}

	return sb.toString();
    }
}
