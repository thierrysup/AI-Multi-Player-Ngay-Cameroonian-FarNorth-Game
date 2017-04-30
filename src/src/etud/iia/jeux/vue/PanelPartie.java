/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.etud.iia.jeux.vue;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import javax.swing.ImageIcon;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import src.etud.iia.jeux.alg.AlgoJeu;
import src.etud.iia.jeux.alg.MaxN;
import src.etud.iia.jeux.modele.joueur.Joueur;
import src.etud.iia.jeux.ngay.CoupNgay;
import src.etud.iia.jeux.ngay.HeuristiquesNgay;
import src.etud.iia.jeux.ngay.PlateauNgay;
import src.etud.iia.jeux.vue.custom.Button;
import src.etud.iia.jeux.vue.custom.Panel;
import src.etud.iia.jeux.vue.custom.PanelHeader;
import src.etud.iia.jeux.vue.custom.PanelInitGame;

/**
 *
 * @author Thierry TCHINDA && Mercedes KADJE
 */
public class PanelPartie extends Panel implements MouseListener {

    private final ImageIcon imgPlateau = new ImageIcon("src/ressources/images/ouisss.jpg");
    private ImageIcon imgGrain, imgGrain2, imgGrain3, imgCase;

    private final int platX = 174;
    private final int platY = 247;

    private final int sautCaseX = 63;
    private final int sautCaseY = 56;

    private final int grenierAiX = 18 + platX;
    private final int grenierAiY = 27 + platY;

    private final int grenierAJ2X = 148 + platX;
    private final int grenierAJ2Y = 142 + platY;

    private final int grenierAJ3X = 400 + platX;
    private final int grenierAJ3Y = 29 + platY;

    private final int[] casesX;
    private final int[] casesY;

    //La fenetre principale
    WindowNgay frame;
    PanelHeader pan;
    JPanel panLab;
    Button btnBack;
    JLabel labNext;
    JLabel labCPlayer;
    private final Box boxPan = Box.createVerticalBox();
    private final Box boxHPan = Box.createHorizontalBox();

    private PanelInitGame dialogPan;

    Joueur j1, j2, j3;

    boolean jeufini = false;
    int joueurTour = 0;

    int profondeurMax = 1;

    AlgoJeu AlgoJoueur[] = new AlgoJeu[3];

    public PlateauNgay plateauCourant; // On commence par le Joueur Blanc (arbitraire)

    private int[] grains;
    private int posCase;
    int nbrGrainsCase = 0;
    public int rand;
    private int[] scores;

    public PanelPartie(JFrame frame) {
        // setLayout(null);
        dialogPan = new PanelInitGame(this.frame, "Game Configuration Frame", true);
        dialogPan.AfficheMessage();

        j1 = new Joueur("1", dialogPan.j1labTr.getSelectedIndex());
        j2 = new Joueur("2", dialogPan.j2labTr.getSelectedIndex());
        j3 = new Joueur("3", dialogPan.j3labTr.getSelectedIndex());
        System.out.println("les trous sont j1 " + j1.getNombreTrou() + "j2" + j2.getNombreTrou() + "j3" + j3.getNombreTrou());

        PlateauNgay.setJoueurs(j1, j2, j3); // Pour savoir qui joue "1" et qui joue "2" et qui joue "3" 

        if (dialogPan.playerCBX.getSelectedItem().equals(new String("player1"))) {
            System.out.println("j1" + j1.toString());
            plateauCourant = new PlateauNgay(j1);
        } else {
            if (dialogPan.playerCBX.getSelectedItem().equals(new String("player2"))) {
                System.out.println("id j2 " + j2.getId() + " trous " + j2.getNombreTrou());
                plateauCourant = new PlateauNgay(j2);

            } else {
                plateauCourant = new PlateauNgay(j3);
            }
        }

        AlgoJoueur[0] = new MaxN(HeuristiquesNgay.h1, j1, j2, j3,4);
        AlgoJoueur[1] = new MaxN(HeuristiquesNgay.h2, j2, j3, j1, profondeurMax);
        AlgoJoueur[2] = new MaxN(HeuristiquesNgay.h3, j3, j1, j2, profondeurMax);

        pan = new PanelHeader(plateauCourant);
        panLab = new JPanel(new GridLayout(1, 4, 0, 0));
        panLab.setOpaque(false);
        btnBack = new Button(" Home ");
        btnBack.setSize(50, 30);
        labNext = new JLabel("<HTML><H2><U><B><I>CURRENT PLAYER </I></B></U></H2></HTML>");
        labNext.setForeground(Color.white);
        //labNext.setIcon(new ImageIcon("src/ressources/images/img.jpg")) ;
        //labNext.setLocation(232,202);

        labCPlayer = new JLabel("player " + (plateauCourant.currentPlayer.getId()));
        //labCPlayer.setText("<HTML><H2><I> player </H2></I></HTML>");
        labCPlayer.setFont(new Font("Ubuntu", Font.BOLD, 18));
        // labCPlayer.setLocation(265,202);

        this.frame = (WindowNgay) frame;
        panLab.add(new JLabel(" "));
        panLab.add(labNext);
        panLab.add(labCPlayer);
        panLab.add(new JLabel(" "));

        boxPan.add(Box.createVerticalStrut(20));
        boxPan.add(pan);
        //boxPan.add(Box.createVerticalStrut(10));
        // boxPan.add(btnBack);
        boxPan.add(Box.createVerticalStrut(20));
        boxPan.add(panLab);
        // add(btnBack);
        boxPan.add(Box.createVerticalStrut(300));
        boxHPan.add(btnBack);
        boxPan.add(boxHPan);
        add(boxPan);
        //add(btnBack);

        this.casesX = new int[10];
        this.casesY = new int[10];
        this.scores = new int[3];
        this.grains = new int[10];

        initPosition();
        this.addMouseListener(this);
        btnBack.addActionListener((e) -> {
            // reinitialize();
            dialogPan.updateView();
            PlateauNgay.joueurDisqualifier = 0;
            PlateauNgay.partieNumber = 1;
            this.removeAll();
            PanelPartie.this.frame.setContentPane(new PanelMenu(frame));
            PanelPartie.this.frame.setVisible(true);
        });

        if (plateauCourant.currentPlayer.equals(PlateauNgay.getJoueur1())) {
            plateauCourant.jouerAI(PlateauNgay.getJoueur1(), AlgoJoueur);
            labCPlayer.setText(plateauCourant.currentPlayer.getId());
            this.pan.updateInfoHeader(plateauCourant);
            this.repaint();
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(imgPlateau.getImage(), platX, platY, null);

            this.drawGrains(g);
       
    }

    private void initPosition() {

        for (int i = 0; i < 5; i++) {
            casesX[i] = platX + (sautCaseX * i) + 82;
            casesY[i] = platY + 28;
        }

        for (int i = 5; i < 10; i++) {
            casesX[i] = 82 + (sautCaseX * (i % 5)) + platX;
            casesY[i] = 85 + platY;
        }
    }

    public void drawGrains(Graphics g){

        //for(int j = 0; j < this.scores[0]; j++){
        imgGrain = new ImageIcon("src/ressources/pionsCase/grenierV" + plateauCourant.getScore()[0] + ".png");
        g.drawImage(imgGrain.getImage(), this.grenierAiX - 3, this.grenierAiY + 20, 55, 120, null);
        //}

        // for(int j = 0; j < this.scores[1]; j++){
        imgGrain2 = new ImageIcon("src/ressources/pionsCase/grenierH" + plateauCourant.getScore()[1] + ".png");
        g.drawImage(imgGrain2.getImage(), this.grenierAJ2X + 20, this.grenierAJ2Y, 120, 55, null);

        imgGrain3 = new ImageIcon("src/ressources/pionsCase/grenierV" + plateauCourant.getScore()[2] + ".png");
        g.drawImage(imgGrain3.getImage(), this.grenierAJ3X - 3, this.grenierAJ3Y + 20, 55, 120, null);
        // }

        for (int i = 4; i >= 0; i--) {
            int c = 4 - i;
            //for(int j = 0; j < grains[i]; j++){
            //Thread.sleep(300);
            imgCase = new ImageIcon("src/ressources/pionsCase/trou" + plateauCourant.getNbGraines(i) + ".png");
            g.drawImage(imgCase.getImage(), this.casesX[c] - 2, this.casesY[c] - 5, 55, 55, null);
            //this.repaint();
             
            //}
        }

        for (int i = 5; i < 10; i++) {
            // for(int j = 0; j < grains[i]; j++){
            //Thread.sleep(300);
            imgCase = new ImageIcon("src/ressources/pionsCase/trou" + plateauCourant.getNbGraines(i) + ".png");
            g.drawImage(imgCase.getImage(), this.casesX[i] - 2, this.casesY[i] - 5, 55, 55, null);
           // this.repaint();
              
           
            // }
        }

    }

    @Override
    public void mouseClicked(MouseEvent me) {
        for (int i = 0; i < 10; i++) {
            int maxX = casesX[i] + sautCaseX;
            int maxY = casesY[i] + sautCaseY;
            if (me.getX() > casesX[i] && maxX > me.getX()) {
                if (me.getY() > casesY[i] && maxY > me.getY()) {
                    this.posCase = i;
                    //labCPlayer.setText("player"+posCase);
                    if (i < 5) {
                        CoupNgay coup = new CoupNgay(4 - this.posCase);
                        plateauCourant.jouerPlayer(plateauCourant.currentPlayer, AlgoJoueur, coup);
                        labCPlayer.setText(plateauCourant.currentPlayer.getId());
                    } else {
                        CoupNgay coup = new CoupNgay(this.posCase);
                        plateauCourant.jouerPlayer(plateauCourant.currentPlayer, AlgoJoueur, coup);
                        labCPlayer.setText(plateauCourant.currentPlayer.getId());
                    }
                    this.pan.updateInfoHeader(plateauCourant);
                    this.repaint();
                    System.out.println("bouton clicker est :" + (i + 1));
                }
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent me) {
        //System.out.println("les coordonnees sont " + me.paramString());
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent me) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
