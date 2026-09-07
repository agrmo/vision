package rund;

import reel.vektor.RDreivektor;
import ganz.vektor.GDreivektor;
import reel.strecke.RDreistrecke;
import ganz.strecke.GDreistrecke;

// 1. Manchmal brauchen wir ganze Zahlen:
// - Orte einiger Bäume, die in Abbildung bestimmt werden müssen
// - Orte eines Kubus
// - Orte eines Graphen, die in Listen stehen
//
// 2. Manchmal müssen wir diese Zahlen als reelen Zahlen benutzen:
// - Drehung der Orte eines Kubus
// - Drehung der Orte eines dreidimensionalen Graphen
//
// 3. Wir müssen wesentlich diese Zahlen zurück in ganzen Zahlen
//    umwandeln, um sie im Bildschirm darzustellen.
// - Stellung eines gedrehten dreidimensionalen Kubus
// - Stellung eines gedrehten dreidimensionalen Graphen
//
// Darum brauchen wir einen "Abrunder."
public class Abrunder {

    public static GDreivektor abrunde(RDreivektor rv) {
	return new GDreivektor((int) rv.eins,
			       (int) rv.zwei,
			       (int) rv.drei);
    }

    public static GDreistrecke abrunde(RDreistrecke rs) {
	return new GDreistrecke(Abrunder.abrunde(rs.von),
				Abrunder.abrunde(rs.bis));
    }
}
