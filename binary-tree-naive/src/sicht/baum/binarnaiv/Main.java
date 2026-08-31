package sicht.baum.binaernaiv;

import java.awt.Color;
import druck.vektor.Vektordrucker;
import vektor.Zweivektor;
import baum.binaer.Binaerbaum;
import java.util.ArrayList;
import javax.swing.JFrame;
import welt.baum.binaernaiv.Binaerbaumweltnaiv;
import sicht.Sicht;
import maler.Maler;

// java -cp classes sicht.baum.binaernaiv.Main

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
	Zweivektor w = new Zweivektor(100,100);
	Binaerbaumweltnaiv bw = new Binaerbaumweltnaiv(baum, w, dx, dy);
	Binaerbaumsichtnaiv s = new Binaerbaumsichtnaiv(bw, d);

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
	Zweivektor w = new Zweivektor(200,100);
	Binaerbaumweltnaiv bw = new Binaerbaumweltnaiv(baum, w, dx, dy);
	Binaerbaumsichtnaiv s = new Binaerbaumsichtnaiv(bw, d);

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
