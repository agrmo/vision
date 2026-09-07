package verdoppler.vektor;

import ganz.vektor.GDreivektor;
import ganz.vektor.GZweivektor;
import reel.vektor.RDreivektor;
import reel.vektor.RZweivektor;

public class Vektorverdoppler {

    public static GZweivektor verdoppele(GZweivektor p) {
	return new GZweivektor(p.eins, p.zwei);
    }

    public static RZweivektor verdoppele(RZweivektor p) {
	return new RZweivektor(p.eins, p.zwei);
    }

    public static GDreivektor verdoppele(GDreivektor p) {
	return new GDreivektor(p.eins, p.zwei, p.drei);
    }

    public static RDreivektor verdoppele(RDreivektor p) {
	return new RDreivektor(p.eins, p.zwei, p.drei);
    }

    public static GZweivektor[] verdoppele(GZweivektor[] pla) {
	GZweivektor[] plb = new GZweivektor[pla.length];
	for (int i = 0; i < pla.length; i++) {
	    plb[i] = new GZweivektor(pla[i].eins, pla[i].zwei);
	}

	return plb;
    }

    public static RZweivektor[] verdoppele(RZweivektor[] pla) {
	RZweivektor[] plb = new RZweivektor[pla.length];
	for (int i = 0; i < pla.length; i++) {
	    plb[i] = new RZweivektor(pla[i].eins, pla[i].zwei);
	}

	return plb;
    }
}
