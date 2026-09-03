package druck.menge;

import java.util.Set;

public class Mengedrucker {
    public static String drucke(Set<Integer> menge) {

	StringBuilder sb = new StringBuilder();

	Integer[] zahl = new Integer[menge.size()];
	zahl = menge.toArray(zahl);
	
	sb.append("{");
	
	for (int i = 0; i < zahl.length; i++) {
	    if (i != 0) {
		sb.append(", ");
	    }

	    sb.append(zahl[i]);
	}

	sb.append("}");

	return sb.toString();
    }
}
