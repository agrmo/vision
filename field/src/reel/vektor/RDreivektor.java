package reel.vektor;

import ganz.vektor.GDreivektor;

// Ein reeler Dreivektor.
public class RDreivektor {
    public double eins;
    public double zwei;
    public double drei;

    public RDreivektor(double x, double y, double z) {
	this.eins = x;
	this.zwei = y;
	this.drei = z;
    }

    public void addiere(RDreivektor v) {
	this.eins += v.eins;
	this.zwei += v.zwei;
	this.drei += v.drei;
    }

    public void addiere(GDreivektor v) {
	this.eins += v.eins;
	this.zwei += v.zwei;
	this.drei += v.drei;
    }

    public void subtrahiere(RDreivektor v) {
	this.eins -= v.eins;
	this.zwei -= v.zwei;
	this.drei -= v.drei;
    }

    public void dividiere(RDreivektor v) {
	this.eins = this.eins / v.eins;
	this.zwei = this.zwei / v.zwei;
	this.drei = this.drei / v.drei;
    }
    
    public void multipliziere(double a) {
	this.eins = this.eins * a;
	this.zwei = this.zwei * a;
	this.drei = this.drei * a;
    }
    
    public void punkt(RDreivektor v) {
	this.eins = this.eins * v.eins;
	this.zwei = this.zwei * v.zwei;
	this.drei = this.drei * v.drei;
    }

    public double betrag() {
	return Math.sqrt(this.eins * this.eins
			 + this.zwei * this.zwei
			 + this.drei * this.drei);
    }
}
