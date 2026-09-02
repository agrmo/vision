package sicht.baum.binaer.horizontal;

import welt.baum.binaer.horizontal.Binaerbaumwelthorizontal;
import baum.binaer.Binaerbaum;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JFrame;
import maler.Maler;
import sicht.Sicht;
import vektor.Zweivektor;
import baum.binaer.zufall.Zufallsbinaerbaum;

// java -cp classes sicht.baum.binaer.horizontal.Main

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
	Binaerbaumwelthorizontal bw = new Binaerbaumwelthorizontal(baum,
								   ux, uy,
								   dx, dy);
	Binaerbaumsichthorizontal s = new Binaerbaumsichthorizontal(bw, d);

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
	Binaerbaumwelthorizontal bw = new Binaerbaumwelthorizontal(baum,
								   ux, uy,
								   dx, dy);
	
	Binaerbaumsichthorizontal s = new Binaerbaumsichthorizontal(bw, d);

	Maler m = new Maler(new Sicht[] {s});
	JFrame frame = new JFrame();
	frame.getContentPane().setBackground(Color.BLACK);
        frame.getContentPane().setForeground(Color.WHITE);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setSize(1200, 600);
	frame.add(m);
	frame.setVisible(true);
    }

    static void beispieldrei() {

	// Mache n knoten mit Wahrscheinlichkeit p, um jeweilige linke
	// Kante irgendo zu machen.
	Binaerbaum b = Zufallsbinaerbaum.baue(30, 0.5);
	
	int dx = 30;
	int dy = 50;
	double d = 20;
	int ux = 500;
	int uy = 50;
	Binaerbaumwelthorizontal bw = new Binaerbaumwelthorizontal(b,
								   ux, uy,
								   dx, dy);
	
	Binaerbaumsichthorizontal s = new Binaerbaumsichthorizontal(bw, d);

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
	beispieldrei();
    }
}
