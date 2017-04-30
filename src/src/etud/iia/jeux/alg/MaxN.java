/**
 *
 */
package src.etud.iia.jeux.alg;

import java.util.ArrayList;

import src.etud.iia.jeux.modele.joueur.Joueur;

import src.etud.iia.jeux.ngay.CoupNgay;
import src.etud.iia.jeux.ngay.PlateauNgay;

public class MaxN implements AlgoJeu {


    /**
     * La profondeur de recherche par défaut
     */
    private final static int PROFMAXDEFAUT = 4;
    /**
     * La profondeur de recherche utilisée pour l'algorithme
     */
    private int profMax;
    /**
     * L'heuristique utilisée par l'algorithme
     */
    private Heuristique h;

    /**
     * Le nombre de noeuds développé par l'algorithme (facultatif... mais peut
     * être intéressant pour se faire une idée du nombre de noeuds développés)
     */
    private int nbnoeuds;
    /**
     * Le nombre de feuilles évaluées par l'algorithme (facultatif)
     */
    private int nbfeuilles;
    //-----POUR NOTRE ALGORITHME MULTIPLAYER-----
    private Joueur joueur1;

    private Joueur joueur2;

    private Joueur joueur3;

    private CoupNgay meilleurCoup;

    // -------------------------------------------
    // Constructeurs
    // -------------------------------------------
    public MaxN(Heuristique h, Joueur joueur1, Joueur joueur2, Joueur joueur3) {
        this(h, joueur1, joueur2, joueur3, PROFMAXDEFAUT);
    }

    public MaxN(Heuristique h, Joueur joueur1, Joueur joueur2, Joueur joueur3, int profMaxi) {
        this.h = h;
        this.joueur1 = joueur1;
        this.joueur2 = joueur2;
        this.joueur3 = joueur3;
        profMax = profMaxi;
        nbnoeuds = 0;
//		System.out.println("Initialisation d'un MiniMax de profondeur " + profMax);
    }

    //-------------------------------------------
    // Méthodes de l'interface AlgoJeu--Ngay
    //-------------------------------------------
    public CoupNgay meilleurCoupMultiPlayer(PlateauNgay p, Joueur player) {
        meilleurCoup = null;
        nbnoeuds = 0;
        ArrayList<CoupNgay> coupsPossibles = p.coupsPossibles(player);

        float[] meilleur = new float[3];
        meilleur[0] = Float.NEGATIVE_INFINITY;
        meilleur[1] = Float.NEGATIVE_INFINITY;
        meilleur[2] = Float.NEGATIVE_INFINITY;

        for (CoupNgay c : coupsPossibles) {
            nbnoeuds++;
            PlateauNgay s = jouerBeurre(p, player, c);
            float[] maxN = n_playerMaxN(s, profMax - 1, PlateauNgay.next_Player(player));
            if (meilleur[PlateauNgay.joueurToInt(player)] < maxN[PlateauNgay.joueurToInt(player)]) {
                meilleur = maxN;//(meilleur[PlateauNgay.joueurToInt(player)] < Math.max(meilleur[PlateauNgay.joueurToInt(PlateauNgay.getJoueurAdverse(player))], meilleur[PlateauNgay.joueurToInt(PlateauNgay.getJoueurAdverse(PlateauNgay.getJoueurAdverse(player)))]))
                meilleurCoup = c;
            }
        }
        return meilleurCoup;
    }

    public int getNbnoeuds() {
        return nbnoeuds;
    }

    // -------------------------------------------
    // Méthodes publiques
    // -------------------------------------------
    @Override
    public String toString() {
        return "MiniMax(ProfMax=" + profMax + ")";
    }

    // -------------------------------------------
    // Méthodes internes
    // -------------------------------------------
    //A vous de jouer pour implanter Max n(n=3)
    private float[] n_playerMaxN(PlateauNgay state, int profondeur, Joueur player) {

        ArrayList<CoupNgay> coupsPossibles = state.coupsPossibles(player);

        float[] v = new float[3];

        if (profondeur <= 0 || coupsPossibles.isEmpty()) {
            return h.evalMultiPlayer(state, player);
        }

        v[0] = Float.NEGATIVE_INFINITY;
        v[1] = Float.NEGATIVE_INFINITY;
        v[2] = Float.NEGATIVE_INFINITY;
        for (CoupNgay c : coupsPossibles) {
            nbnoeuds++;
            PlateauNgay s = jouerBeurre(state, player, c);
            v = PlateauNgay.vector_Max(v, n_playerMaxN(s, profondeur - 1, PlateauNgay.next_Player(player)), player);
        }
        return v;
    }

    private PlateauNgay jouerBeurre(PlateauNgay p, Joueur j, CoupNgay c) {
        PlateauNgay s = p.copy();
        s.joue(j, c);
        return s;
    }

    public CoupNgay meilleurCoup(PlateauNgay p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
