package dreher.euler;

import reel.matrix.RDreimatrix;
import dreher.reel.matrix.drei.RDreimatrixdreher;

public class Eulerdreher {

    // Gegeben drei Zahlen, berechne die Matrix zur Drehung der
    // Basisvektoren. Die Zahlen bestimmen drei Eulerwinkel ZXZ.
    // 
    // 1. Drehung um z1-Achse. Ergibt neue Basis (x2,y2,z2)
    // 2. Drehung um x2-Achse. Ergibt neue Basis (x3,y3,z3)
    // 3. Drehung um z3-Achse. Ergibt neue Basis (x4,y4,z4)
    public static RDreimatrix nehmedrehung(double winkeleins,
					   double winkelzwei,
					   double winkeldrei) {

	RDreimatrix matrixeins = RDreimatrixdreher.nehmedreherx(winkeleins);
	RDreimatrix matrixzwei = RDreimatrixdreher.nehmedreherz(winkelzwei);
	RDreimatrix matrixdrei = RDreimatrixdreher.nehmedreherx(winkeldrei);

	return matrixeins.punkt(matrixzwei.punkt(matrixdrei));
    }
}

