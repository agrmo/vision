package sicht;

import java.awt.Graphics;

// Im Allgemeinen ist die menschliche Sicht ein Verfahren zum
// Anschauen von etwas.
//
// Eine Sicht in Code durchgeführt nimmt eine Welt ein, und stellt
// ihre Dingen dar. Zum Beispiel, eine Sicht für zweidimensionale
// Punkte nimmt eine Liste von einfach zweidimensionalen Vektoren, und
// stellt sie dar.
//
// Die Sicht stellt Körper einer Welt dar, sodaß wir uns den Körpern
// auf einem Bildschirm anschauen können.
//
// Die Sicht kennt nicht, wie sie mit einem Mensch mit der Mouse oder
// der Tastatur behandeln kann.
//
// Die Sicht bildet die ursprünglichen Daten nicht auf. Am besten
// umwandelt sie die ursprüngliche Daten nicht.  Eine Sicht soll so
// wenig Berechnungen wie möglich machen, sodaß sie die Welt
// darstellen kann.
//
// Warum benutzen wir das JComponent nicht? Es gibt eine genaue
// Antwort: Java kann nicht eine Reihe von JComponenten
// zusammenketten, die nach- noch aufeinander liegen. Deshalb müssen
// wir ein einzelnes JComponent erzeugen, und eine Reihe von "Sichten"
// benutzen.
public abstract class Sicht {
    public abstract void darstellen(Graphics g);
}
