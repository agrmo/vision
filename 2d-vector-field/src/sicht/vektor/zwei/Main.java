package sicht.vektor.zwei;

import bildschirm.Bildschirm;
import ganz.vektor.GZweivektor;
import maler.Maler;
import sicht.Sicht;
import welt.vektor.zwei.Zweivektorwelt;

// java -cp classes sicht.vektor.zwei.Main

public class Main {

    static void beispieleins() {
	// Mache die Welt.
	GZweivektor[] vektore = new GZweivektor[] {
	    new GZweivektor(30,50),
	    new GZweivektor(10,50)
	};
	GZweivektor[] orte = new GZweivektor[] {
	    new GZweivektor(100, 100),
	    new GZweivektor(200, 100)
	};
	Zweivektorwelt ow = new Zweivektorwelt(vektore, orte);

	// Mache die Sicht.
	Zweivektorsicht s = new Zweivektorsicht(ow);
	Maler m = new Maler(new Sicht[] {s});
	
	// Stelle die Daten dar.
	Bildschirm.schwarz(m);
    }

    public static void main(String[] args){
	beispieleins();
    }
}
