package welt.baum.binaer;

import baum.binaer.Binaerbaum;
import baum.binaer.Binaerbaumgroesse;
import java.util.LinkedList;
import java.util.HashMap;
import vektor.Zweivektor;
import strecke.Zweistrecke;

// Berechene alle Kanten dieses Baumes.
public class Binaerbaumstrecke {

    // Geh durch dem Baum, und mache jede Kante dieses Baumes.
    public static Zweistrecke[] strecken(Binaerbaum b,
					 HashMap<Integer,Zweivektor> wer) {
	
	int kanteanzahl = Binaerbaumgroesse.groesse(b) - 1;
	
	Zweistrecke[] strecken = new Zweistrecke[kanteanzahl];

	// Index der Liste
	int i = 0;

	// Grundfall
	LinkedList<Binaerbaum> zulaufen = new LinkedList<Binaerbaum>();
	zulaufen.add(b);

	// Geh durch dem Baum, nehme alle Kanten.
	//
	// Die Schleife kann entweder
	// while (i < kanteanzahl) {}
	// oder
	// while (zulaufen.size() > 0)
	// sein.
	// Die zweite ist wahrscheinlich mehr sicher.
	//
	// Aber wir glauben ganz genau, daß die Anzahl von Kanten
	// gleich die Knotenanzahl minus Eins ist.
	while (zulaufen.size() > 0) {

	    // remove() == remove(0) O(1)
	    // n.b. ArrayList remove(0) O(n)
	    Binaerbaum naechste = zulaufen.remove();
	    Zweivektor von = wer.get(naechste.wert);

	    if (naechste.links != null) {

		// Mache eine Strecke.
		Zweivektor bis = wer.get(naechste.links.wert);
		Zweistrecke zs = new Zweistrecke(von, bis);

		strecken[i] = zs;
		i += 1;
		zulaufen.add(naechste.links);
	    }

	    if (naechste.rechts != null) {

		// Mache eine Strecke.
		Zweivektor bis = wer.get(naechste.rechts.wert);
		Zweistrecke zs = new Zweistrecke(von, bis);
		
		strecken[i] = zs;
		i += 1;
		zulaufen.add(naechste.rechts);
	    }
	}

	if (i != kanteanzahl) {
	    System.out.println("Problem " + i + " " + kanteanzahl);
	}

    	return strecken;
    }
}
