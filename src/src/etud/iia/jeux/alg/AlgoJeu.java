package src.etud.iia.jeux.alg;

import src.etud.iia.jeux.modele.joueur.Joueur;
import src.etud.iia.jeux.ngay.CoupNgay;
import src.etud.iia.jeux.ngay.PlateauNgay;

public interface AlgoJeu {
 /** Renvoie le meilleur
     * @param p
     * @return
     */
	public CoupNgay meilleurCoup(PlateauNgay p);
        public CoupNgay meilleurCoupMultiPlayer(PlateauNgay p,Joueur j);
        public int getNbnoeuds();


}
 