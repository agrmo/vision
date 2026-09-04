package sicht.baum.binaer;

import welt.baum.binaer.Binaerbaumwelt;
import bildschirm.Bildschirm;
import baum.binaer.Binaerbaum;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JFrame;
import maler.Maler;
import sicht.Sicht;
import vektor.Zweivektor;
import baum.binaer.zufall.Zufallsbinaerbaum;

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
	int d = 30;
	int ux = 100;
	int uy = 100;
	Binaerbaumwelt bw = new Binaerbaumwelt(baum,
					       ux, uy,
					       dx, dy);
	Binaerbaumsicht s = new Binaerbaumsicht(bw, d);

	Maler m = new Maler(new Sicht[] {s});

	Bildschirm.schwarz(m);
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
	int d = 30;
	int ux = 200;
	int uy = 100;
	Binaerbaumwelt bw = new Binaerbaumwelt(baum,
								   ux, uy,
								   dx, dy);
	
	Binaerbaumsicht s = new Binaerbaumsicht(bw, d);

	Maler m = new Maler(new Sicht[] {s});

	Bildschirm.schwarz(m);
    }

    static void beispieldrei() {

	// Mache n knoten mit Wahrscheinlichkeit p, um jeweilige linke
	// Kante irgendo zu machen.
	Binaerbaum b = Zufallsbinaerbaum.baue(300, 0.2);
	
	int dx = 20;
	int dy = 40;
	int d = 15;
	int ux = 500;
	int uy = 50;
	Binaerbaumwelt bw = new Binaerbaumwelt(b,
					       ux, uy,
					       dx, dy);
	
	Binaerbaumsicht s = new Binaerbaumsicht(bw, d);

	Maler m = new Maler(new Sicht[] {s});
	
	Bildschirm.schwarz(m);
    }

    public static void main(String[] args) {
	beispieldrei();
    }
}
