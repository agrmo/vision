package strecke.ganz;

import vektor.ganz.GZweivektor;

// Eine zweidimensionale Strecke mit ganzen Zahlen.
public class GZweistrecke {
    public GZweivektor von;
    public GZweivektor bis;
    
    public GZweistrecke(GZweivektor v, GZweivektor b) {
	this.von = v;
	this.bis = b;
    }
}
