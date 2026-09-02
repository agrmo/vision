package baum.binaer.zufall;

import baum.binaer.Binaerbaum;
import java.util.Random;
import liste.Liste;
import java.util.ArrayList;
import java.util.HashMap;

// God this is so much fun.

// Ein binärischer Baum, erzeugt von einem ganz zufälligen Algorithmus.
// Wir brauchen nur, eine bestimmte Anzahl von knoten zu erzeugen. Wir
// fangen an mit dem Bau mit dem Wert 0. Also der Kopfbaum hat Wert 0.
// Der letzte gefügte Knoten hat Wert n - 1.
public class Zufallsbinaerbaum {

    // Mache einen neuen Baum nach links mit dem Wert i
    // Füge den Knoten auch in der Abbildung.
    // Warum k?
    // k < i < n
    // Wir wollen einen Baum mit Größe n bauen.
    // Wir haben so weit 0, 1, ..., i-1 Knoten gemacht.
    // Wir wollen den i-ten Knoten bauen.
    // Wir machen jetzt den i-ten Knoten als Kind des Knotens k.
    //
    // Baue links: Nehme den Knoten 1 zufälligerweise. k = 1.
    //             Baue den knoten i = 5 als das linke Kind des k.
    //
    //                      0
    //                     / \
    //                    1   3
    //                   / \
    //                  5   4
    //                       \
    //                        2
    //
    static void bauelinks(int k, int i, HashMap<Integer,Binaerbaum> wer) {
	Binaerbaum knotenk = wer.get(k);
	knotenk.links = new Binaerbaum(i);
	wer.put(i, knotenk.links);
    }

    // Mache einen neuen Baum nach rechts mit dem Wert i
    // Füge den Knoten auch in der Abbildung.
    static void bauerechts(int k, int i, HashMap<Integer,Binaerbaum> wer) {
	Binaerbaum knotenk = wer.get(k);
	knotenk.rechts = new Binaerbaum(i);
	wer.put(i, knotenk.rechts);
    }

    // Geh durch dem Baum mit Größe i, und berechne, wer hat seine
    // linke Stelle frei. Warum i? Der Baum ist nicht vollig gebaut.
    static int[] werhatlinksfrei(HashMap<Integer,Binaerbaum> wer, int i) {

	ArrayList<Integer> knoten = new ArrayList<Integer>();

	for (int j = 0; j < i; j++) {
	    if (wer.get(j).links == null) {
		knoten.add(j);
	    }
	}

	return Liste.nehmeArrayInt(knoten);
    }

    // Geh durch dem Baum mit Größe i, und berechne, wer hat seine
    // rechte Stelle frei. Warum i? Der Baum ist nicht vollig gebaut.
    static int[] werhatrechtsfrei(HashMap<Integer,Binaerbaum> wer, int i) {

	ArrayList<Integer> knoten = new ArrayList<Integer>();
	
	for (int j = 0; j < i; j++) {
	    if (wer.get(j).rechts == null) {
		knoten.add(j);
	    }
	}

	return Liste.nehmeArrayInt(knoten);
    }

    // Nehme einen zufälligen Baum, dessen linkse Stelle frei hat.
    // Warum i? Der Baum ist nicht vollig gebaut.
    static int nehmeknotenlinks(HashMap<Integer,Binaerbaum> wer, int i, Random r) {
	
	// Alle Knoten, deren rechte Stelle frei ist.
	int[] linksfrei = Zufallsbinaerbaum.werhatlinksfrei(wer, i);

	int zufall = r.nextInt(linksfrei.length);

	return linksfrei[zufall];
    }

    // Nehme einen zufälligen Baum, dessen rechte Stelle frei ist.
    // Warum i? Der Baum ist nicht vollig gebaut.
    static int nehmeknotenrechts(HashMap<Integer,Binaerbaum> wer, int i, Random r) {

	// Alle Knoten, deren rechte Stelle frei ist.
	int[] rechtsfrei = Zufallsbinaerbaum.werhatrechtsfrei(wer, i);

	int zufall = r.nextInt(rechtsfrei.length);

	return rechtsfrei[zufall];
    }

    // Baue einen Baum mit n Knoten.
    // p: Wahrscheinlichkeit, die linke Kante zu machen
    // 1-p: Wahrscheinlichkeit, die rechte Kante zu machen
    public static Binaerbaum baue(int n, double p) {

	// Zufallsquelle
	Random r = new Random();

	// Abbildung von Wert bis Baum.
	// Sodaß wir kennen können, wo jeder Baum steht.
	// Wir benutzen keine Suchfunktion.
	// Sondern wir nehmen unmittelbar den jeweiligen Knoten.
	HashMap<Integer,Binaerbaum> wer = new HashMap<Integer,Binaerbaum>();

	// Grundfall
	Binaerbaum kopf = new Binaerbaum(0);
	wer.put(0, kopf);

	// Fangen an mit 1. 0 gibt es schon.
	for (int i = 1; i < n; i++) {
	    
	    // Wir bauen jetzt den i-ten Knoten.
	    // Es gibt schon i-1 Knoten.
	    // Also nehmir wir zufälligerweise den Knoten 0...i-1,
	    // dessen linke oder rechte Seite frei ist.
	    
	    double probe = r.nextDouble();
	    
	    if (probe < p) {
		// Baue links
		int knotenlinks = Zufallsbinaerbaum.nehmeknotenlinks(wer, i, r);
		Zufallsbinaerbaum.bauelinks(knotenlinks, i, wer);
		
	    } else {
		// Baue rechts
		int knotenrechts = Zufallsbinaerbaum.nehmeknotenrechts(wer, i, r);
		Zufallsbinaerbaum.bauerechts(knotenrechts, i, wer);
	    }
	}

	return kopf;
    }
}
