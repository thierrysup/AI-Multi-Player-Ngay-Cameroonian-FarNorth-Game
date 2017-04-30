package src.etud.iia.jeux.modele.joueur;


public class Joueur  
{

    private String id;
    
    private int nombreTrou;
    
    private boolean simple;
    
    private boolean veuve;
    
    private boolean grandeMere;
    
    private boolean dead;

    public Joueur(String s,int trou)
    {
        id = s;
        nombreTrou=trou;
        simple = true;
        veuve = false;
        grandeMere = false;
        dead = false;
    }

    public boolean isSimple() {
        return simple;
    }

    public void setSimple(boolean simple) {
        this.simple = simple;
    }

    public boolean isVeuve() {
        return veuve;
    }

    public void setVeuve(boolean veuve) {
        this.veuve = veuve;
    }

    public boolean isGrandeMere() {
        return grandeMere;
    }

    public void setGrandeMere(boolean grandeMere) {
        this.grandeMere = grandeMere;
    }

    public boolean isDead() {
        return dead;
    }

    public void setDead(boolean dead) {
        this.dead = dead;
    }
    
    public String getId()    // A
    {
        return id;
    }

    public void setId(String s)   //A(String)
    {
        id = s;
    }

    public int getNombreTrou() {
        return nombreTrou;
    }

    public void setNombreTrou(int nombreTrou) {
        this.nombreTrou = nombreTrou;
    }
    

    @Override
    public String toString()
    {
        return id;
    }

}
