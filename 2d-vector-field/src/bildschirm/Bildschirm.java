package bildschirm;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
import maler.Maler;

public class Bildschirm {

    public static void schwarz(Maler m) {

	Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
	double breite = dimension.getWidth();
	double hoehe = dimension.getHeight();
	
	JFrame frame = new JFrame();
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.getContentPane().setBackground(Color.BLACK);
        frame.getContentPane().setForeground(Color.WHITE);
	frame.setSize((int) breite, (int) hoehe);
	frame.add(m);
	frame.setVisible(true);
    }
}
