package reel.vektor;

// Ein reeler Zweivektor.
public class RZweivektor {
    public double eins;
    public double zwei;

    public RZweivektor(double x, double y) {
	this.eins = x;
	this.zwei = y;
    }

    public void addiere(RZweivektor v) {
	this.eins += v.eins;
	this.zwei += v.zwei;
    }
    
    public void subtrahiere(RZweivektor v) {
	this.eins -= v.eins;
	this.zwei -= v.zwei;
    }

    public void dividiere(RZweivektor v) {
	this.eins = this.eins / v.eins;
	this.zwei = this.zwei / v.zwei;
    }
    
    public void punkt(RZweivektor v) {
	this.eins = this.eins * v.eins;
	this.zwei = this.zwei * v.zwei;
    }
}
