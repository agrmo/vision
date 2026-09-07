package druck.reel.vektor;

import reel.vektor.RDreivektor;
import reel.vektor.RZweivektor;
import java.util.ArrayList;

public class RVektordrucker {
    public static String drucke(RZweivektor v) {
	StringBuilder sb = new StringBuilder();
	sb.append("[");
	sb.append(v.eins);
	sb.append(",");
	sb.append(v.zwei);
	sb.append("]");
	return sb.toString();
    }

    public static String drucke(RDreivektor v) {
	StringBuilder sb = new StringBuilder();
	sb.append("[");
	sb.append(v.eins);
	sb.append(",");
	sb.append(v.zwei);
	sb.append(",");
	sb.append(v.drei);
	sb.append("]");
	return sb.toString();
    }

    // Drucke eine Liste von RZweivektoren.
    public static String drucke(RZweivektor[] vl) {
	StringBuilder sb = new StringBuilder();
	sb.append("[");
	for (int i = 0; i < vl.length; i++) {
	    if (i != 0) {
		sb.append(",");
	    }
	    
	    sb.append(RVektordrucker.drucke(vl[i]));
	}
	sb.append("]");

	return sb.toString();
    }

    // Drucke eine Liste von RZweivektoren.
    public static String drucke(ArrayList<RZweivektor> liste) {
	StringBuilder sb = new StringBuilder();
	sb.append("[");
	for (int i = 0; i < liste.size(); i++) {
	    if (i != 0) {
		sb.append(",");
	    }
	    
	    sb.append(RVektordrucker.drucke(liste.get(i)));
	}
	sb.append("]");

	return sb.toString();
    }
}
