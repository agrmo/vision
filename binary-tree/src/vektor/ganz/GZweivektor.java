package vektor.ganz;

// Ein Zweivektor mit ganzen Zahlen.
public class GZweivektor {
    public int eins;
    public int zwei;

    public GZweivektor(int e, int z) {
	this.eins = e;
	this.zwei = z;
    }

    // Subtrahiere den gegebenen Zweivektor zu diesem.  
    public void subtrahiere(GZweivektor v) {
	this.eins -= v.eins;
	this.zwei -= v.zwei;
    }
}
