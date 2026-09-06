package sicht.strecke.zwei;

import javax.swing.JComponent;
import java.awt.Graphics;
import welt.strecke.zwei.Zweistreckewelt;
import ganz.strecke.GZweistrecke;
import sicht.Sicht;

// Eine GZweistreckesicht kann Strecken darstellen.
public class Zweistreckesicht extends Sicht {

    // Wir müssen die Welt in die Sicht einsetzen, weil Java sie
    // irgendwann anrufen wird, die Welt darzustellen. 
    public Zweistreckewelt zsw;
    
    public Zweistreckesicht(Zweistreckewelt zsw) {
	this.zsw = zsw;
    }

    // Stelle eine Strecke dar.
    void darstellestrecke(Graphics g, GZweistrecke k) {
	g.drawLine(k.von.eins, k.von.zwei,
		   k.bis.eins, k.bis.zwei);
    }

    public void darstellen(Graphics g) {
	// Stelle jede Strecke dieser Welt dar.
	for (int i = 0; i < this.zsw.strecken.length; i++) {
	    this.darstellestrecke(g, this.zsw.strecken[i]);
	}
    }
}

