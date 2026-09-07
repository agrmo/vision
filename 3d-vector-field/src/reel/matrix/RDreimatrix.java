package reel.matrix;

import reel.vektor.RDreivektor;

// Die Matrix.
public class RDreimatrix {
    
    public double a;
    public double b;
    public double c;	
    public double d;
    public double e;
    public double f;	
    public double g;
    public double h;
    public double i;

    public RDreimatrix(double a, double b, double c,
		       double d, double e, double f,
		       double g, double h, double i) {
	this.a = a;
	this.b = b;
	this.c = c;	
	this.d = d;
	this.e = e;
	this.f = f;	
	this.g = g;
	this.h = h;
	this.i = i;	
    }

    public RDreivektor[] zeilen() {
	return new RDreivektor[] {
	    new RDreivektor(this.a, this.b, this.c),
	    new RDreivektor(this.d, this.e, this.f),
	    new RDreivektor(this.g, this.h, this.i),
	};
    }
    

    public RDreivektor[] kolonnen() {
	return new RDreivektor[] {
	    new RDreivektor(this.a, this.d, this.g),
	    new RDreivektor(this.b, this.e, this.h),
	    new RDreivektor(this.c, this.f, this.i),
	};
    }

    public void addiere(RDreimatrix m) {
	this.a += m.a;
	this.b += m.b;
	this.c += m.c;	
	this.d += m.d;
	this.e += m.e;
	this.f += m.f;	
	this.g += m.g;
	this.h += m.h;
	this.i += m.i;
    }

    public void subtrahiere(RDreimatrix m) {
	this.a -= m.a;
	this.b -= m.b;
	this.c -= m.c;	
	this.d -= m.d;
	this.e -= m.e;
	this.f -= m.f;	
	this.g -= m.g;
	this.h -= m.h;
	this.i -= m.i;
    }

    /* Multipliziere diese Matrix mit dem Vektor.

       |abc|   |j|     
       |def| * |k|  = ein Dreivektor
       |ghi|   |l|     
    
    */
    public RDreivektor punkt(RDreivektor v) {

	return new RDreivektor(this.a * v.eins + this.b * v.zwei + this.c * v.drei,
			       this.d * v.eins + this.e * v.zwei + this.f * v.drei,
			       this.g * v.eins + this.h * v.zwei + this.i * v.drei);
    }

    /* Multipliziere diese 3x3 Matrix mit dem 3x3 Matrix m.

       |abc|   |abc|    
       |def| * |def| = eine Matrix
       |ghi|   |ghi|    
       
    */
    public RDreimatrix punkt(RDreimatrix m) {
	
	return new RDreimatrix(this.a * m.a + this.b * m.d + this.c * m.g,
			       this.a * m.b + this.b * m.e + this.c * m.h,
			       this.a * m.c + this.b * m.f + this.c * m.i,
			       this.d * m.a + this.e * m.d + this.f * m.g,
			       this.d * m.b + this.e * m.e + this.f * m.h,
			       this.d * m.c + this.e * m.f + this.f * m.i,
			       this.g * m.a + this.h * m.d + this.i * m.g,
			       this.g * m.b + this.h * m.e + this.i * m.h,
			       this.g * m.c + this.h * m.f + this.i * m.i);
    }
}
