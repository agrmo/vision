package reel.matrix;

import reel.vektor.RZweivektor;

// Eine 2x2 Matrix.
public class RZweimatrix {
    
    public double a;
    public double b;
    public double c;	
    public double d;

    public RZweimatrix(double a, double b, double c, double d) {
	this.a = a;
	this.b = b;
	this.c = c;	
	this.d = d;
    }

    public RZweivektor[] zeilen() {
	return new RZweivektor[] {
	    new RZweivektor(this.a, this.b),
	    new RZweivektor(this.c, this.d)
	};
    }
    

    public RZweivektor[] kolonnen() {
	return new RZweivektor[] {
	    new RZweivektor(this.a, this.c),
	    new RZweivektor(this.b, this.d)
	};
    }

    public void addiere(RZweimatrix m) {
	this.a += m.a;
	this.b += m.b;
	this.c += m.c;	
	this.d += m.d;
    }

    public void subtrahiere(RZweimatrix m) {
	this.a -= m.a;
	this.b -= m.b;
	this.c -= m.c;	
	this.d -= m.d;
    }

    /*
      Multipliziere diese 2x2 Matrix mit dem 2x1 Vektor v.

      |ab| * |e|  = ein zweidimensionaler Vektor   
      |cd|   |f|  

    */
    public RZweivektor punkt(RZweivektor v) {
	
	return new RZweivektor(this.a * v.eins + this.b * v.zwei,
			       this.c * v.eins + this.d * v.zwei);
    }

    /* Multipliziere diese 2x2 Matrix mit dem 2x2 Matrix m.

       |ab| * |ef| = eine 2x2 Matrix
       |cd|   |gh| 
       
    */
    public RZweimatrix punkt(RZweimatrix m) {

	return new RZweimatrix(this.a * m.a + this.b * m.c, this.a * m.b + this.b * m.d,
			       this.c * m.a + this.d * m.c, this.c * m.b + this.d * m.d);
    }
}
