package strecke;

import vektor.Dreivektor;

// Eine Dreistrecke ist ein Paar von zwei Dreivektoren.
//
// Eine Dreistrecke ist eine dreidimensionale Strecke.
//
// Eine Strecke hat verschiedene Anwendungen.
//
// Häufig benutzt ist eine Strecke als Strecke eines Körpers.
public class Dreistrecke {
    public Dreivektor von;
    public Dreivektor bis;
    
    public Dreistrecke(Dreivektor v, Dreivektor b) {
	this.von = v;
	this.bis = b;
    }

    public void addiere(Dreivektor p) {
	this.von.addiere(p);
	this.bis.addiere(p);
    }
}
