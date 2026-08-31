package paar;

import druck.paar.Paardrucker;

/*
  java -cp classes paar.Main
*/

public class Main {
    static void beispieleins() {
	Paar p = new Paar(3,4);
	System.out.println(Paardrucker.drucke(p));
    }

    public static void main(String[] args) {
	beispieleins();
    }
}
