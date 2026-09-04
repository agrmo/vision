package sicht.feld.einseins;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
import maler.Maler;
import sicht.Sicht;
import zahl.reihe.Zahlenreihe;
import feld.einseins.Einseinsfeld;

// java -cp classes sicht.feld.einseins.Main

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
	Dimension bildschirm = Toolkit.getDefaultToolkit().getScreenSize();
	double breite = bildschirm.getWidth();
	double hoehe = bildschirm.getHeight();
	Einseinsfeldsicht s = new Einseinsfeldsicht(esf, 20,
						    breite, hoehe);
	
	// Mache den Maler.
	Maler m = new Maler(new Sicht[] {s});

	// Stelle die Daten dar.
	JFrame frame = new JFrame();
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.getContentPane().setBackground(Color.BLACK);
        frame.getContentPane().setForeground(Color.WHITE);
	frame.setSize((int) breite, (int) hoehe);
	frame.add(m);
	frame.setVisible(true);
    }
    
    public static void main(String[] args) {
	beispieleins();
    }
}
