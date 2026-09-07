package reel.strecke;

import reel.vektor.RDreivektor;

// Eine Dreistrecke ist ein Paar von zwei Dreivektoren.
//
// Eine Dreistrecke ist eine dreidimensionale Strecke.
//
// Eine Strecke hat verschiedene Anwendungen.
//
// Häufig benutzt ist eine Strecke als Strecke eines Körpers.
public class RDreistrecke {
    public RDreivektor von;
    public RDreivektor bis;
    
    public RDreistrecke(RDreivektor v, RDreivektor b) {
	this.von = v;
	this.bis = b;
    }

    public void addiere(RDreivektor p) {
	this.von.addiere(p);
	this.bis.addiere(p);
    }
}
