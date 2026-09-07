package ganz.vektor;

// Ein ganzer Dreivektor.
public class GDreivektor {
    public int eins;
    public int zwei;
    public int drei;

    public GDreivektor(int e, int z, int d) {
	this.eins = e;
	this.zwei = z;
	this.drei = d;
    }

    public void addiere(GDreivektor v) {
	this.eins += v.eins;
	this.zwei += v.zwei;
	this.drei += v.drei;
    }

    public void subtrahiere(GDreivektor v) {
	this.eins -= v.eins;
	this.zwei -= v.zwei;
	this.drei -= v.drei;
    }
}
