package ganz.strecke;

import ganz.vektor.GDreivektor;

// Eine Dreistrecke ist ein Paar von zwei Dreivektoren.
//
// Eine Dreistrecke ist eine dreidimensionale Strecke.
//
// Eine Strecke hat verschiedene Anwendungen.
//
// Häufig benutzt ist eine Strecke als Strecke eines Körpers.
public class GDreistrecke {
    public GDreivektor von;
    public GDreivektor bis;
    
    public GDreistrecke(GDreivektor v, GDreivektor b) {
	this.von = v;
	this.bis = b;
    }

    public void addiere(GDreivektor p) {
	this.von.addiere(p);
	this.bis.addiere(p);
    }
}
