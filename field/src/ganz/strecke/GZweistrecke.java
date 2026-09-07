package ganz.strecke;

import ganz.vektor.GZweivektor;

// Eine Zweistrecke ist ein Paar von zwei Zweivektoren.
//
// Eine Zweistrecke ist eine zweidimensionale Strecke.
//
// Die Idee ist, daß wir eine Zweistrecke eines Körpers beschreiben
// wollen. Obwohl die Daten dahin ganz einfach sind, ist es schwierig,
// die Datenstrukuren über einen Körper zu zeigen. Wir müssen ganz
// klar sein, daß ein Paar von Orten Teil eines Körpers ist.
//
// Die Strecken können vielleicht Kanten verkörpern. Vielleicht die
// Kanten einer Dreiecke oder eines Quadrats.
public class GZweistrecke {
    public GZweivektor von;
    public GZweivektor bis;
    
    public GZweistrecke(GZweivektor v, GZweivektor b) {
	this.von = v;
	this.bis = b;
    }

    public void addiere(GZweivektor v) {
	this.von.addiere(v);
	this.bis.addiere(v);
    }
}
