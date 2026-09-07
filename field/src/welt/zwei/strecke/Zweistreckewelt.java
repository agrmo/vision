package welt.zwei.strecke;
    
import ganz.strecke.GZweistrecke;

//  Eine Zweistreckewelt ist eine Liste von zweidimensionalen Strecken.
//
//  Die Strecken können Teile einer Figur, eines Körpers oder eines
//  Graphen sein.
//
//  Die Welt konnte von einer dreidimensionalen Welt gebildet sein. Ein
//  auf einer zweidimensionale Ebene verlegter Kubus stellt keine schöne
//  Figur dar, weil er wahrscheinlich verschiedene Strecken innerhalb
//  der Figur enthält.
public class Zweistreckewelt {
    public GZweistrecke[] strecken;

    public Zweistreckewelt(GZweistrecke[] zsl) {
	this.strecken = zsl;
    }
}
