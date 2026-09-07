package dreher.reel.matrix.drei;

import reel.matrix.RDreimatrix;

public class RDreimatrixdreher {

    // Baue eine Matrix, die um die x-Achse (in der yz-Fläche) dreht.
    // Oder der Nickwinkel.
    // 
    // |1 0    0   |
    // |0 cos  -sin|
    // |0 sin  cos |
    //
    public static RDreimatrix nehmedreherx(double theta) {
	return new RDreimatrix(1, 0, 0,
			      0, Math.cos(theta), -Math.sin(theta),
			      0, Math.sin(theta), Math.cos(theta));
    }

    // Problem: theta soll -> -1 * theta?
    // Baue eine Matrix, die um die y-Achse (in der zx-Fläche) dreht.
    // Oder der Rollwinkel.
    // 
    // |cos 0  -sin|
    // |0   1  0   |
    // |sin 0  cos |
    //
    public static RDreimatrix nehmedrehery(double theta) {
	return new RDreimatrix(Math.cos(theta), 0, -Math.sin(theta),
			      0, 1, 0,
			      Math.sin(theta), 0, Math.cos(theta));
    }

    // Baue eine Matrix, die um die z-Achse (in der xy-Fläche) dreht.
    // Oder der Gierwinkel.
    // 
    // |cos  -sin 0|
    // |sin  cos 0|
    // |0    0   1|
    //
    public static RDreimatrix nehmedreherz(double theta) {
	return new RDreimatrix(Math.cos(theta), -Math.sin(theta), 0,
			      Math.sin(theta), Math.cos(theta), 0,
			      0, 0, 1);
    }
}

