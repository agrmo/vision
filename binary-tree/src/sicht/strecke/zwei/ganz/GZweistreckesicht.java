package sicht.strecke.zwei.ganz;

import javax.swing.JComponent;
import java.awt.Graphics;
import welt.strecke.zwei.ganz.GZweistreckewelt;
import strecke.ganz.GZweistrecke;
import sicht.Sicht;

// Eine Zweistreckesicht kann Strecken darstellen.
public class GZweistreckesicht extends Sicht {

    // Wir müssen die Welt in die Sicht einsetzen, weil Java sie
    // irgendwann anrufen wird, die Welt darzustellen. 
    public GZweistreckewelt zsw;
    
    public GZweistreckesicht(GZweistreckewelt zsw) {
	this.zsw = zsw;
    }

    public void darstellen(Graphics g) {
	// Stelle jede Strecke dieser Welt dar.
	for (int i = 0; i < this.zsw.strecken.length; i++) {

	    GZweistrecke k = this.zsw.strecken[i];
	    g.drawLine(k.von.eins, k.von.zwei,
		       k.bis.eins, k.bis.zwei);
	}
    }
}

