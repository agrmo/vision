package ort.baum.binaernaiv;

import paar.Paar;
import baum.binaer.Binaerbaum;
import java.util.ArrayList;

public class Binaerbaumortnaiv {

    // Wir brauchen eine Liste von Orten von einem binärischen Baum
    // nehmen. Lassen wir eine rekursive Funktion machen, die durch
    // einem Baum geht und seine Stelle in eine Liste von Orten
    // hinfügen.
    //
    // Die Reihenfolge der Liste wird von einer Suchfunktion
    // gebaut. Lassen wir Tiefensuche benutzen.
    //
    // Rekursive Tiefensuche.
    static void fuegeorte(Binaerbaum b,
			  int x, int y,
			  int deltax, int deltay,
			  ArrayList<Paar> orte) {

	// Grundfall
	if (b == null) {
	    return;
	}

	// Ein Knoten gibt drei Punkte aus:
	// - Sich selbst; seinen Wert.
	// - Seine zwei Zweigen.

	// Also die Reihenfolge ist:
	// [sich, links, rechts]

	// Der Ort dieses Knotens wurde schon berechnet.
	orte.add(new Paar(x, y));

	int linksx = x - deltax;
	int linksy = y + deltay;

	Binaerbaumortnaiv.fuegeorte(b.links,
				    linksx, linksy,
				    deltax, deltay,
				    orte);

	int rechtsx = x + deltax;
	int rechtsy = linksy;
	
	Binaerbaumortnaiv.fuegeorte(b.rechts,
				    rechtsx, rechtsy,
				    deltax, deltay,
				    orte);

	return;
    }

    public static ArrayList<Paar> nehmeorte(Binaerbaum b,
					    int x, int y,
					    int deltax, int deltay) {

	ArrayList<Paar> orte = new ArrayList<Paar>();
	Binaerbaumortnaiv.fuegeorte(b, x, y, deltax, deltay, orte);

	return orte;
    }
}
