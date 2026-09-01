package verdoppler.vektor;

import vektor.Dreivektor;
import vektor.Zweivektor;

public class Vektorverdoppler {

    public static Zweivektor verdoppele(Zweivektor p) {
	return new Zweivektor(p.eins, p.zwei);
    }

    public static Dreivektor verdoppele(Dreivektor p) {
	return new Dreivektor(p.eins, p.zwei, p.drei);
    }

    public static Zweivektor[] verdoppele(Zweivektor[] pla) {
	Zweivektor[] plb = new Zweivektor[pla.length];
	for (int i = 0; i < pla.length; i++) {
	    plb[i] = new Zweivektor(pla[i].eins,
				    pla[i].zwei);
	}

	return plb;
    }
}
