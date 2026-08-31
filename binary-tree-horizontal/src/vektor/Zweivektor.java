package vektor;

/*
  Ein Zweivektor ist eine Liste von zwei Zahlen.
  
  Ein Zweivektor im Euklidraum.

  Was sind ähnlich mit dem Vektor und dem Vektor?

  Sie besitzen die gleiche Basisvektoren.

  Was ist der Unterschied zweischen der Zweivektor und der Zweivektor?

  Der zweidimensionale Vektor und der zweidimensionale Vektor besitzen
  verschiedenen Ursprung.

  Zum Beispiel die Ecke enthält Dreivektoren, um ihre Strecke zu zeigen.
 */
public class Zweivektor {
    public double eins;
    public double zwei;

    // ein: ganze Zahl, ganze Zahl
    public Zweivektor(double x, double y) {
	this.eins = x;
	this.zwei = y;
    }

    // ein:
    // v: Zweivektor
    // Addiere den gegebenen Zweivektor zu diesem.  
    public void addiere(Zweivektor v) {
	this.eins += v.eins;
	this.zwei += v.zwei;
    }

    // ein: Zweivektor
    // Subtrahiere den gegebenen Zweivektor zu diesem.  
    public void subtrahiere(Zweivektor v) {
	this.eins -= v.eins;
	this.zwei -= v.zwei;
    }

    // ein: Zweivektor
    // Dividiere den gegebenen Zweivektor zu diesem.  
    public void dividiere(Zweivektor v) {
	this.eins = this.eins / v.eins;
	this.zwei = this.zwei / v.zwei;
    }
    
    // ein: Zweivektor
    // Multipliziere teilweise den gegebenen Zweivektor zu diesem.  
    public void punkt(Zweivektor v) {
	this.eins = this.eins * v.eins;
	this.zwei = this.zwei * v.zwei;
    }
}
