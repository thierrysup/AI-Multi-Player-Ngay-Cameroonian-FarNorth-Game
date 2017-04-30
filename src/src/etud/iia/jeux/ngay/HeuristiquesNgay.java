/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.etud.iia.jeux.ngay;

import src.etud.iia.jeux.alg.Heuristique;
import src.etud.iia.jeux.modele.PlateauJeu;
import src.etud.iia.jeux.modele.joueur.Joueur;

/**
 *
 * @authors thierry && mercedes
 */
public class HeuristiquesNgay {
    
    public static Heuristique h1 = new Heuristique() {
		

        public float[] evalMultiPlayer(PlateauJeu p, Joueur j) {
            PlateauNgay pNgay = (PlateauNgay) p;
             return pNgay.evaluation(pNgay, j);
        }
	};

	public static Heuristique h2 = new Heuristique() {
		

        public float[] evalMultiPlayer(PlateauJeu p, Joueur j) {
            PlateauNgay pNgay = (PlateauNgay) p;
             return pNgay.evaluation(pNgay, j);
        }
	};
        public static Heuristique h3 = new Heuristique() {
		
        public float[] evalMultiPlayer(PlateauJeu p, Joueur j) {
            PlateauNgay pNgay = (PlateauNgay) p;
             return pNgay.evaluation(pNgay, j);
        }
	};

}
