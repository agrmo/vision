package ort.baum.binaer;

import paar.Paar;
import baum.binaer.Binaerbaum;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import druck.paar.Paardrucker;
import baum.binaer.Binaerbaumgroesse;

// Berechene alle Orte dieses Baumes.  Ein Rechner, der durch einem
// Baum geht, und berechnet die Stelle jedes Knotens.
//
// Der Ort eines Knotens ist vielleicht
//                              
//                              o (x,y)
//
// Was sind die Orte seiner Kinder?
//
// Idee
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

public class Binaerbaumort {

    Binaerbaum baumursprung;

    // Ort -> Wert
    public HashMap<Integer,HashMap<Integer,Integer>> ort;
    
    // Wert -> Ort
    public HashMap<Integer,Paar> wer;

    public Binaerbaumort(Binaerbaum bu) {

	// Fangen wir mit dem ursprünglichen Baum und dem
	// ursprünglichem Ort an.
	this.baumursprung = bu;

	// Am Anfang kennen wir nun den Ort des Ursprungs.
	this.ort = new HashMap<Integer,HashMap<Integer,Integer>>();
	this.wer = new HashMap<Integer,Paar>();
	
	this.fuege(0, 0, bu.wert);

	// Fangen unmittelbar mit dem Bau an.
	this.baue(this.baumursprung, 0, 0);

	// Schon haben wir alle Orten gefunden.
	// Die Orte stehen schon im wer und ort.
    }

    // Fuege einen Knoten am Ort.
    void fuege(int x, int y, int w) {
	if (!this.ort.containsKey(x)) {
	    this.ort.put(x, new HashMap<Integer,Integer>());
	}

	this.ort.get(x).put(y, w);
	this.wer.put(w, new Paar(x,y));
    }

    // Ist der Ort [x,y] besetzt?
    boolean besetzt(int x, int y) {
	return this.ort.containsKey(x)
	    && this.ort.get(x).containsKey(y);
    }

    // Wer steht am Ort [x,y]?
    int werwert(int x, int y) {
	return this.ort.get(x).get(y);
    }

    // Lösche den Knoten an der Stelle [x,y]
    void loesche(int x, int y) {
	int wert = this.ort.get(x).get(y);
	this.wer.remove(wert);
	this.ort.get(x).remove(y);

	if (this.ort.get(x).size() == 0) {
	    this.ort.remove(x);
	}
    }
    
    // Verschiebe den Knoten, der an [x,y] besetzt, nach links.
    //
    // Wer steht an der Stelle [x, y]?
    // Nehme den Knoten A.
    // Ist [x-1,y] besetzt?
    // Ja:
    //   Wer steht an der Stelle [x-1,y]?
    //   Nehme den Knoten B.
    //   Verschiebe B links.
    // Nein:
    //   Verschiebe A nach links.
    // Fertig.
    void verschiebelinks(int x, int y) {
	
	// Wert des Knotens, der [x,y] besetzt.
	int k = this.werwert(x,y);

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

    // Verschiebe den Knoten, der an [x,y] besetzt, nach rechts.
    void verschieberechts(int x, int y) {
	
	// Wert des Knotens, der [x,y] besetzt.
	int k = this.werwert(x,y);

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

    void baue(Binaerbaum b, int x, int y) {

	if (b == null) {
	    return;
	}
	
	// Baum b ist schon gefügt. Füge seine Kinder.

	if (b.links != null) {
	    int linksx = x - 1;
	    int linksy = y + 1;

	    if (this.besetzt(linksx, linksy)) {
		// Verschiebe den jeweiligen Knoten, der die stelle Stelle
		// [linksx,linksy] besetzt hat.
		verschiebelinks(linksx, linksy);
	    }

	    this.fuege(linksx, linksy, b.links.wert);
	    this.baue(b.links, linksx, linksy);
	}

	if (b.rechts != null) {
	    int rechtsx = x + 1;
	    int rechtsy = y + 1;

	    if (this.besetzt(rechtsx, rechtsy)) {
		// Verschiebe den jeweiligen Knoten, der die stelle Stelle
		// [rechtsx,rechtsy] besetzt hat.
		verschieberechts(rechtsx, rechtsy);
	    }
	    
	    this.fuege(rechtsx, rechtsy, b.rechts.wert);
	    this.baue(b.rechts, rechtsx, rechtsy);
	}
    }

    // Nehme eine Liste von allen Orten, die berechnet wurden.
    public Paar[] nehmeorte() {
	
	int groesse = Binaerbaumgroesse.groesse(this.baumursprung);
	Paar[] orte = new Paar[groesse];

	int i = 0;
	for (int wert : this.wer.keySet()) {
	    Paar ort = this.wer.get(wert);
	    orte[i] = ort;
	    i += 1;
	}

    	return orte;
    }
}
