package sicht.strecke.zwei;

import javax.swing.JComponent;
import java.awt.Graphics;
import welt.strecke.zwei.Zweistreckewelt;
import strecke.Zweistrecke;
import sicht.Sicht;

// Eine Zweistreckesicht kann Strecken darstellen.
public class Zweistreckesicht extends Sicht {

    // Wir müssen die Welt in die Sicht einsetzen, weil Java sie
    // irgendwann anrufen wird, die Welt darzustellen. 
    public Zweistreckewelt zsw;
    
    public Zweistreckesicht(Zweistreckewelt zsw) {
	this.zsw = zsw;
    }

    // Stelle eine Strecke dar.
    void darstellestrecke(Graphics g, Zweistrecke k) {
	g.drawLine((int) k.von.eins, (int) k.von.zwei,
		   (int) k.bis.eins, (int) k.bis.zwei);
    }

    public void darstellen(Graphics g) {
	// Stelle jede Strecke dieser Welt dar.
	for (int i = 0; i < this.zsw.strecken.length; i++) {
	    this.darstellestrecke(g, this.zsw.strecken[i]);
	}
    }
}

