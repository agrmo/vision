package druck.strecke;

import strecke.Zweistrecke;
import strecke.Dreistrecke;
import druck.vektor.Vektordrucker;

public class Streckedrucker {
    public static String drucke(Zweistrecke k) {
	StringBuilder sb = new StringBuilder();
	sb.append("Von ");
	sb.append(Vektordrucker.drucke(k.von));
	sb.append(" bis ");
	sb.append(Vektordrucker.drucke(k.bis));

	return sb.toString();
    }

    public static String drucke(Dreistrecke k) {
	StringBuilder sb = new StringBuilder();
	sb.append("Von ");
	sb.append(Vektordrucker.drucke(k.von));
	sb.append(" bis ");
	sb.append(Vektordrucker.drucke(k.bis));

	return sb.toString();
    }

    public static String drucke(Zweistrecke[] zl) {
	StringBuilder sb = new StringBuilder();
	sb.append("[");
	for (int i = 0; i < zl.length; i++) {
	    if (i != 0) {
		sb.append(",");
	    }
	    
	    sb.append(Streckedrucker.drucke(zl[i]));
	}
	sb.append("]");

	return sb.toString();
    }
}
