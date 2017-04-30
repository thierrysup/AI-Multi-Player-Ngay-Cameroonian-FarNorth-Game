package src.etud.iia.jeux.modele;

import src.etud.iia.jeux.modele.joueur.Joueur;

import java.util.ArrayList;
import src.etud.iia.jeux.ngay.CoupNgay;

public interface PlateauJeu {

    /** renvoie la liste des coups possibles
     *
     * @param j	le joueur dont c'est au tour de jouer
     * @return liste des coups possibles pour le joueur j
     */
    public abstract ArrayList<CoupNgay> coupsPossibles(Joueur j);

    /** joue un coup sur le plateau
     *
     * @param j	Le joueur qui joue
     * @param c Le coup joué par le joueur
     */
    public abstract void joue(Joueur j, CoupNgay c);

    //   public abstract CoupJeu parseCoup(String s);
    /** duplique le plateau courant
     * 
     */
    public abstract PlateauJeu copy();

    /** indique si un coup est possible pour un joueur sur le plateau courant
     *
     * @param j	Le joueur qui pourrait jouer ce coup
     * @param c Le coup envisagé par le joueur
     */
    public abstract boolean coupValide(Joueur j, CoupNgay c);

   
}
