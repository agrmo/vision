package sicht.baum.binaer;

import java.awt.Color;
import paar.Paar;
import baum.binaer.Binaerbaum;
import java.util.ArrayList;
import javax.swing.JFrame;
import welt.baum.binaer.Binaerbaumwelt;
import sicht.Sicht;
import maler.Maler;

// java -cp classes sicht.baum.binaer.Main

public class Main {
    static void beispieleins() {
	//
	//      3
	//     / \
	//    5   2
	//
	Binaerbaum baum = new Binaerbaum(3,
					 new Binaerbaum(5),
					 new Binaerbaum(2));

	int dx = 50;
	int dy = 80;
	double d = 30;
	int ux = 100;
	int uy = 100;
	Binaerbaumwelt bw = new Binaerbaumwelt(baum,
					       ux, uy,
					       dx, dy);
	Binaerbaumsicht s = new Binaerbaumsicht(bw, d);

	Maler m = new Maler(new Sicht[] {s});
	JFrame frame = new JFrame();
	frame.getContentPane().setBackground(Color.BLACK);
        frame.getContentPane().setForeground(Color.WHITE);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setSize(1200, 600);
	frame.add(m);
	frame.setVisible(true);
    }
    
    static void beispielzwei() {
	//
	//            3
	//           / \
	//          /   \
	//         /     \
	//        5       2
	//       / \     / \
	//      1   9   0   8
	
	Binaerbaum baum = new Binaerbaum(3,
					 new Binaerbaum(5,
							new Binaerbaum(1),
							new Binaerbaum(9)),
					 new Binaerbaum(2,
							new Binaerbaum(0),
							new Binaerbaum(8)));

	int dx = 50;
	int dy = 80;
	double d = 30;
	int ux = 200;
	int uy = 100;
	Binaerbaumwelt bw = new Binaerbaumwelt(baum,
					       ux, uy,
					       dx, dy);
	Binaerbaumsicht s = new Binaerbaumsicht(bw, d);

	Maler m = new Maler(new Sicht[] {s});
	JFrame frame = new JFrame();
	frame.getContentPane().setBackground(Color.BLACK);
        frame.getContentPane().setForeground(Color.WHITE);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setSize(1200, 600);
	frame.add(m);
	frame.setVisible(true);
    }

    public static void main(String[] args) {
	beispielzwei();
    }
}
