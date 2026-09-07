package sicht.drei.vektor;

import bildschirm.Bildschirm;
import auge.Auge;
import java.awt.Dimension;
import java.awt.Toolkit;
import maler.Maler;
import sicht.Sicht;
import ganz.vektor.GDreivektor;
import welt.drei.vektor.Dreivektorwelt;

// java -cp classes sicht.drei.vektor.Main

public class Main {

    static void beispieleins() {
	// Mache die Welt.
	GDreivektor[] v = new GDreivektor[] {
	    new GDreivektor(30,50,20),
	    new GDreivektor(50,0,0)
	};
	GDreivektor[] o = new GDreivektor[] {
	    new GDreivektor(20,20,20),
	    new GDreivektor(10,10,10)
	};
	Dreivektorwelt dvw = new Dreivektorwelt(v, o);

	// Mache die Sicht.
	GDreivektor entfernung = new GDreivektor(0,0,200);
	double brennweite = 500;
	Dimension bildschirm = Toolkit.getDefaultToolkit().getScreenSize();
	double breite = bildschirm.getWidth();
	double hoehe = bildschirm.getHeight();
	double winkeleins = 0;
	double winkelzwei = 0;
	double winkeldrei = 0;
	Auge auge = new Auge(entfernung, brennweite,
			     breite, hoehe,
			     winkeleins,
			     winkelzwei,
			     winkeldrei);
	Dreivektorsicht s = new Dreivektorsicht(dvw, auge);
	Maler m = new Maler(new Sicht[] {s});
	
	// Mache den Bildschirm.
	Bildschirm.schwarz(m);
    }

    public static void main(String[] args){
	beispieleins();
    }
}
