package baum.binaer;

import java.util.ArrayList;
import java.util.HashMap;
import baum.binaer.Binaerbaum;

public class Binaerbaumabbildung {

    // Mache eine Abbildung von Zahl bis Baum.
    public static HashMap<Integer,Binaerbaum> werbaum(Binaerbaum b) {

	// Abbildung von Knoten bis Knoten.
	HashMap<Integer,Binaerbaum> werbaum = new HashMap<Integer,Binaerbaum>();

	// Liste von Knoten, durch denen zu laufen.
	ArrayList<Binaerbaum> zulaufen = new ArrayList<Binaerbaum>();

	// Grundfall
	// Der Ursprung hat kein Elter.
	zulaufen.add(b);

	while (zulaufen.size() > 0) {

	    // Tiefensuche
	    // oder Breitensuche mit remove(0).
	    Binaerbaum naechste = zulaufen.remove(zulaufen.size() - 1);

	    // Füge ihn in die Abbildung.
	    werbaum.put(naechste.wert, naechste);
	    
	    if (naechste.links != null) {
		zulaufen.add(naechste.links);
	    }

	    if (naechste.rechts != null) {
		zulaufen.add(naechste.rechts);
	    }
	}
	
	return werbaum;
    }
}
