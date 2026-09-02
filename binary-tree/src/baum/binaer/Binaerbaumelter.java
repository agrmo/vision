package baum.binaer;

import java.util.ArrayList;
import java.util.HashMap;
import baum.binaer.Binaerbaum;

public class Binaerbaumelter {

    // Mache eine Abbildung von Knoten bis Knoten. Die Abbildung zeigt
    // das Elter jedes Knotens. 
    public static HashMap<Integer,Integer> elter(Binaerbaum b) {

	// Abbildung von Knoten bis Knoten.
	HashMap<Integer,Integer> elter = new HashMap<Integer,Integer>();

	// Liste von Knoten, durch denen zu laufen.
	ArrayList<Binaerbaum> zulaufen = new ArrayList<Binaerbaum>();

	// Grundfall
	// Der Ursprung hat kein Elter.
	zulaufen.add(b);

	while (zulaufen.size() > 0) {
	    
	    Binaerbaum naechste = zulaufen.remove(0);
	    
	    if (naechste.links != null) {
		elter.put(naechste.links.wert, naechste.wert);
		zulaufen.add(naechste.links);
	    }

	    if (naechste.rechts != null) {
		elter.put(naechste.rechts.wert, naechste.wert);
		zulaufen.add(naechste.rechts);
	    }
	}
	
	return elter;
    }
}
