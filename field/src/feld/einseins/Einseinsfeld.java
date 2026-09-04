package feld.einseins;

// Ein eindimensionale Skalafeld.  Der Eintrag is eindimensional, und
// die Ausgabe ist eindimensional.  Eine Stelle ist eine
// eindimensionale Zahl.  Ein Wert ist ein eindimensionale Zahl.
public class Einseinsfeld {

    public double[] orte;
    public double[] werte;

    public Einseinsfeld(double[] orte, double[] werte) {
	this.orte = orte;
	this.werte = werte;
    }
}
