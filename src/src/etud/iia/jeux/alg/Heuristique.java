package src.etud.iia.jeux.alg;

import src.etud.iia.jeux.modele.PlateauJeu;
import src.etud.iia.jeux.modele.joueur.Joueur;

public interface Heuristique {

    public float[] evalMultiPlayer(PlateauJeu p, Joueur j);

}
