package auge;

import ganz.vektor.GDreivektor;

// Das Auge. Man sieht die Welt mithilfe seiner Augen.
public class Auge {

    public GDreivektor entfernung;
    public double brennweite;
    
    // Bildschirm.
    public double breite;
    public double hoehe;

    // ZXZ Euler Winkel.
    public double winkeleins;
    public double winkelzwei;
    public double winkeldrei;

    public Auge(GDreivektor entfernung, double brennweite,
		double breite, double hoehe,
		double winkeleins,
		double winkelzwei,
		double winkeldrei) {
	
	this.breite = breite;
	this.hoehe = hoehe;
	this.entfernung = entfernung;
	this.brennweite = brennweite;
	this.winkeleins = winkeleins;
	this.winkelzwei = winkelzwei;
	this.winkeldrei = winkeldrei;
    }
}
