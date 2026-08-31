package baum.binaer;

import java.util.ArrayList;

// Berechne die Größe eines Baumes.
// Berechne, wie viele Knoten im Baum steht.
public class Binaerbaumgroesse {

    public static int groesse(Binaerbaum b) {
	if (b == null) {
	    return 0;
	}

	return 1 + Binaerbaumgroesse.groesse(b.links)
	    + Binaerbaumgroesse.groesse(b.rechts);
    }
}
