package maler;

import javax.swing.JComponent;
import java.awt.Graphics;
import sicht.Sicht;

// Der Maler. Es gibt immer nur ein Maler. Er mält eine Liste von
// Kunstwerken auf der Tafel. Er kennt die Eigenschaften eines
// Augenpaars, sodaß er verschiedene Dinge auf unserem Bildschirm
// darstellen kann.
public class Maler extends JComponent {

    public Sicht[] sichte;

    public Maler(Sicht[] s) {
	this.sichte = s;
    }

    public void paintComponent(Graphics g) {
	for (int i = 0; i < this.sichte.length; i++) {
	    this.sichte[i].darstellen(g);
	}
    }
}
