package vektor;

// Ein Dreivektor ist eine Liste von drei ganzen Zahlen.
public class Dreivektor {
    public double eins;
    public double zwei;
    public double drei;

    // ein: ganze Zahl, ganze Zahl, ganze Zahl
    public Dreivektor(double x, double y, double z) {
	this.eins = x;
	this.zwei = y;
	this.drei = z;
    }

    // ein: Dreivektor
    // Addiere den gegebenen Dreivektor zu diesem.  
    public void addiere(Dreivektor v) {
	this.eins += v.eins;
	this.zwei += v.zwei;
	this.drei += v.drei;
    }

    // ein: Dreivektor
    // Subtrahiere den gegebenen Dreivektor zu diesem.  
    public void subtrahiere(Dreivektor v) {
	this.eins -= v.eins;
	this.zwei -= v.zwei;
	this.drei -= v.drei;
    }

    // ein: Dreivektor
    // Dividiere den gegebenen Dreivektor zu diesem.  
    public void dividiere(Dreivektor v) {
	this.eins = this.eins / v.eins;
	this.zwei = this.zwei / v.zwei;
	this.drei = this.drei / v.drei;
    }
    
    // ein: Dreivektor
    // Multipliziere den gegebenen Dreivektor mit a.
    public void multipliziere(double a) {
	this.eins = this.eins * a;
	this.zwei = this.zwei * a;
	this.drei = this.drei * a;
    }
    
    // ein: Dreivektor
    // Multipliziere teilweise den gegebenen Dreivektor zu diesem.  
    public void punkt(Dreivektor v) {
	this.eins = this.eins * v.eins;
	this.zwei = this.zwei * v.zwei;
	this.drei = this.drei * v.drei;
    }

    // Der Betrag dieses Vektors.
    public double betrag() {
	return Math.sqrt(this.eins * this.eins
			 + this.zwei * this.zwei
			 + this.drei * this.drei);
    }
}
