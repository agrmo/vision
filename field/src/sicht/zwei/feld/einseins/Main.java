package sicht.zwei.feld.einseins;

import maler.Maler;
import sicht.Sicht;
import zahl.reihe.Zahlenreihe;
import feld.einseins.Einseinsfeld;
import bildschirm.Bildschirm;

// java -cp classes sicht.zwei.feld.einseins.Main

public class Main {

    // x: Eintrag
    static double funktiona(double x) {
	return 50 * Math.cos(x);
    }
	
    static void beispieleins() {

	// Mache das Feld.
	// d/dx y = sin(x), y(0)=1
	// y = cos(x)

	double[] eintrag = Zahlenreihe.reihe(0, 4, 20);
	double[] werte = new double[eintrag.length];

	for (int i = 0; i < eintrag.length; i++) {
	    werte[i] = funktiona(eintrag[i]);
	}

	// Ich konnte das einfacher machen. Ich nenne es der Rechner?
	// Und sie ist die Funktion? Ein Rechner nimmt eine Funktion
	// und Eintrag hinein, und gibt eine Ausgabe aus.

	Einseinsfeld esf = new Einseinsfeld(eintrag, werte);

	// Mache die Sicht.
	Einseinsfeldsicht s = new Einseinsfeldsicht(esf, 20, 1200, 600);
	
	// Mache den Maler.
	Maler m = new Maler(new Sicht[] {s});

	// Stelle die Daten dar.
	Bildschirm.schwarz(m);
    }
    
    public static void main(String[] args) {
	beispieleins();
    }
}
