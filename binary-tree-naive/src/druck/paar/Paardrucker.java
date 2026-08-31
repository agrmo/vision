package druck.paar;

import paar.Paar;

public class Paardrucker {
    public static String drucke(Paar p) {
	StringBuilder sb = new StringBuilder();
	sb.append("[");
	sb.append(p.eins);
	sb.append(",");
	sb.append(p.zwei);
	sb.append("]");
	return sb.toString();
    }
}
