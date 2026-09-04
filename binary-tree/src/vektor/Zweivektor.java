package vektor;

// Ein Zweivektor ist eine Liste von zwei Zahlen.
// 
// Vielleicht steht dieser Vektor im Euklidraum, aber
// im Allgemeinen haben wir kein Koordinatensystem.
public class Zweivektor {
    public double eins;
    public double zwei;

    public Zweivektor(double x, double y) {
	this.eins = x;
	this.zwei = y;
    }

    // Addiere den gegebenen Zweivektor zu diesem.  
    public void addiere(Zweivektor v) {
	this.eins += v.eins;
	this.zwei += v.zwei;
    }
    
    // Subtrahiere den gegebenen Zweivektor zu diesem.  
    public void subtrahiere(Zweivektor v) {
	this.eins -= v.eins;
	this.zwei -= v.zwei;
    }

    // Dividiere den gegebenen Zweivektor zu diesem.  
    public void dividiere(Zweivektor v) {
	this.eins = this.eins / v.eins;
	this.zwei = this.zwei / v.zwei;
    }
    
    // Multipliziere teilweise den gegebenen Zweivektor zu diesem.  
    public void punkt(Zweivektor v) {
	this.eins = this.eins * v.eins;
	this.zwei = this.zwei * v.zwei;
    }
}
