package zahl.reihe;

public class Zahlenreihe {

    // Nehme eine Anzahl von Zahlen zwischen von und bis. Der
    // regelmäßige Abstand zwischen zwei Zahlen ist deshalb
    // ((von-bis)/anzahl).
    public static double[] reihe(double von, double bis, int anzahl) {

	double abstand = (von-bis)/anzahl;
	double[] reihe = new double[anzahl];

	for (int i = 0; i < anzahl; i++) {
	    reihe[i] = i * abstand;
	}

	return reihe;
    }
}
