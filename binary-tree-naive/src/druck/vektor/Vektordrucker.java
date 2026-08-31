package druck.vektor;

import vektor.Zweivektor;
import java.util.ArrayList;

public class Vektordrucker {
    public static String drucke(Zweivektor v) {
	StringBuilder sb = new StringBuilder();
	sb.append("[");
	sb.append(v.eins);
	sb.append(",");
	sb.append(v.zwei);
	sb.append("]");
	return sb.toString();
    }
    
    // Drucke eine Liste von Zweivektoren.
    public static String drucke(Zweivektor[] vl) {
	StringBuilder sb = new StringBuilder();
	sb.append("[");
	for (int i = 0; i < vl.length; i++) {
	    if (i != 0) {
		sb.append(",");
	    }
	    
	    sb.append(Vektordrucker.drucke(vl[i]));
	}
	sb.append("]");

	return sb.toString();
    }

    // Drucke eine Liste von Zweivektoren.
    public static String drucke(ArrayList<Zweivektor> liste) {
	StringBuilder sb = new StringBuilder();
	sb.append("[");
	for (int i = 0; i < liste.size(); i++) {
	    if (i != 0) {
		sb.append(",");
	    }
	    
	    sb.append(Vektordrucker.drucke(liste.get(i)));
	}
	sb.append("]");

	return sb.toString();
    }
}
