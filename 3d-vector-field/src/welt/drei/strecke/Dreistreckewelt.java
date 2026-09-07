package welt.drei.strecke;
    
import ganz.strecke.GDreistrecke;

// Eine Dreistreckewelt ist eine Liste von dreidimensionalen Strecken.
public class Dreistreckewelt {
    public GDreistrecke[] strecken;

    public Dreistreckewelt(GDreistrecke[] dsl) {
	this.strecken = dsl;
    }
}
