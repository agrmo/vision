package ganz.vektor;

// Ein ganzer Zweivektor.
public class GZweivektor {
    public int eins;
    public int zwei;

    public GZweivektor(int e, int z) {
	this.eins = e;
	this.zwei = z;
    }

    public void addiere(GZweivektor v) {
	this.eins += v.eins;
	this.zwei += v.zwei;
    }

    public void subtrahiere(GZweivektor v) {
	this.eins -= v.eins;
	this.zwei -= v.zwei;
    }
}
