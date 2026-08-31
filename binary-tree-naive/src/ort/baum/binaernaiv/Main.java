package ort.baum.binaernaiv;

import java.util.ArrayList;
import baum.binaer.Binaerbaum;
import paar.Paar;
import druck.paar.Paardrucker;

// java -cp classes ort.baum.binaernaiv.Main

public class Main {
    static void beispieleins() {
	// Naive Lösung.

	//            3
	//           / \
	//          /   \
	//         /     \
	//        5       2
	//       / \     / \
	//      1   9   6   8

	Binaerbaum b = new Binaerbaum(3,
				      new Binaerbaum(5,
						     new Binaerbaum(1),
						     new Binaerbaum(9)),
				      new Binaerbaum(2,
						     new Binaerbaum(6),
						     new Binaerbaum(8)));

	ArrayList<Paar> orte = Binaerbaumortnaiv.nehmeorte(b, 0, 0, 1, 1);
	
	for (int i = 0; i < orte.size(); i++) {
	    System.out.println(Paardrucker.drucke(orte.get(i)));
	}

	// [0,0]
	// [-1,1]
	// [-2,2]
	// [0,2]
	// [1,1]
	// [0,2]
	// [2,2]
	// 
	// Problem: 9 und 6 liegen aufeinander an der Stelle [0,2].
	// Wir brauchen eine bessere Lösung.
    }
    
    public static void main(String[] args) {
	beispieleins();
    }
}
