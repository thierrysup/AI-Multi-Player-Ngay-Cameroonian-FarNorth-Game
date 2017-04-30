/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.etud.iia.jeux.vue.custom;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import src.etud.iia.jeux.ngay.PlateauNgay;
import static src.etud.iia.jeux.ngay.PlateauNgay.joueurDisqualifier;
import static src.etud.iia.jeux.ngay.PlateauNgay.partieNumber;

/**
 *
 * @author Thierry TCHINDA && Mercedes KADJE
 */
public class PanelHeader extends JPanel {

    JPanel panelScore;
    PanelLog panelLogo;
    JPanel panelPartieJDis;
    PlateauNgay plateauCourant;

    //label du panneau des score et trous ...
    private final JLabel vide = new JLabel("  ");
    private final JLabel j1Lab = new JLabel("<HTML><U><I>Player 1</I></U></HTML>");
    private final JLabel j2Lab = new JLabel("<HTML><U><I>Player 2</I></U></HTML>");
    private final JLabel j3Lab = new JLabel("<HTML><U><I>Player 3</I></U></HTML>");
    private final JLabel scoreLab = new JLabel("<HTML><U><I>Scores</I></U></HTML>");
    private final JLabel trousLab = new JLabel("<HTML><U><I>Boxes</I></U></HTML>");
    private JLabel scoreJ1Lab;
    private JLabel scoreJ2Lab;
    private JLabel scoreJ3Lab;
    private JLabel trousJ1Lab;
    private JLabel trousJ2Lab;
    private JLabel trousJ3Lab;

    //Image logo UMA ...
    ImageIcon imgUma = new ImageIcon("src/ressources/images/logo.jpg");

    //Table des Joueurs Disqualifier et du numerode la Partie
    private final JLabel disqualLab = new JLabel("<HTML><U><I>Disqualify</I></U></HTML>");
    private final JLabel partLab = new JLabel("<HTML><U><I>Party</I></U></HTML>");
    public JLabel joueurDisLab = new JLabel("player " + PlateauNgay.joueurDisqualifier);
    public JLabel partNumLab = new JLabel("party " + PlateauNgay.partieNumber);

    public PanelHeader(PlateauNgay plateauCourant) {
        this.plateauCourant = plateauCourant;
        scoreJ1Lab = new JLabel("" + plateauCourant.getScore(plateauCourant.getJoueur1()));
        scoreJ2Lab = new JLabel("" + plateauCourant.getScore(plateauCourant.getJoueur2()));
        scoreJ3Lab = new JLabel("" + plateauCourant.getScore(plateauCourant.getJoueur3()));
        trousJ1Lab = new JLabel("" + PlateauNgay.getJoueur1().getNombreTrou());
        trousJ2Lab = new JLabel("" + PlateauNgay.getJoueur2().getNombreTrou());
        trousJ3Lab = new JLabel("" + PlateauNgay.getJoueur3().getNombreTrou());

        setLayout(new GridLayout(1, 3, 0, 0));
        setSize(800, 150);
        setOpaque(false);
        panelScore = new JPanel(new GridLayout(4, 3, 10, 10));

        panelScore.add(vide);

        scoreLab.setFont(new Font("Ubuntu", Font.BOLD, 18));
        scoreLab.setHorizontalAlignment(SwingConstants.CENTER);

        panelScore.add(scoreLab);

        trousLab.setFont(
                new Font("Ubuntu", Font.BOLD, 18));
        trousLab.setHorizontalAlignment(SwingConstants.CENTER);

        panelScore.add(trousLab);

        j1Lab.setFont(
                new Font("Ubuntu", Font.BOLD, 18));
        j1Lab.setHorizontalAlignment(SwingConstants.CENTER);

        panelScore.add(j1Lab);

        scoreJ1Lab.setFont(new Font("Ubuntu", Font.ITALIC, 16));
        scoreJ1Lab.setHorizontalAlignment(SwingConstants.CENTER);

        panelScore.add(scoreJ1Lab);

        trousJ1Lab.setFont(new Font("Ubuntu", Font.ITALIC, 16));
        trousJ1Lab.setHorizontalAlignment(SwingConstants.CENTER);

        panelScore.add(trousJ1Lab);

        j2Lab.setFont(new Font("Ubuntu", Font.BOLD, 18));
        j2Lab.setHorizontalAlignment(SwingConstants.CENTER);

        panelScore.add(j2Lab);

        scoreJ2Lab.setFont(new Font("Ubuntu", Font.ITALIC, 16));
        scoreJ2Lab.setHorizontalAlignment(SwingConstants.CENTER);

        panelScore.add(scoreJ2Lab);

        trousJ2Lab.setFont(new Font("Ubuntu", Font.ITALIC, 16));
        trousJ2Lab.setHorizontalAlignment(SwingConstants.CENTER);

        panelScore.add(trousJ2Lab);

        j3Lab.setFont(new Font("Ubuntu", Font.BOLD, 18));
        j3Lab.setHorizontalAlignment(SwingConstants.CENTER);

        panelScore.add(j3Lab);

        scoreJ3Lab.setFont(new Font("Ubuntu", Font.ITALIC, 16));
        scoreJ3Lab.setHorizontalAlignment(SwingConstants.CENTER);

        panelScore.add(scoreJ3Lab);

        trousJ3Lab.setFont(new Font("Ubuntu", Font.ITALIC, 16));
        trousJ3Lab.setHorizontalAlignment(SwingConstants.CENTER);

        panelScore.add(trousJ3Lab);

        panelScore.setOpaque(false);
        add(panelScore, BorderLayout.WEST);

        panelLogo = new PanelLog();

        panelLogo.setBackground(imgUma);

        panelLogo.setOpaque(false);
        add(panelLogo);

        panelPartieJDis = new JPanel(new GridLayout(2, 2, 5, 10));

        disqualLab.setFont(new Font("Ubuntu", Font.BOLD, 18));
        disqualLab.setHorizontalAlignment(SwingConstants.CENTER);

        panelPartieJDis.add(disqualLab);

        partLab.setFont(
                new Font("Ubuntu", Font.BOLD, 18));
        partLab.setHorizontalAlignment(SwingConstants.CENTER);

        panelPartieJDis.add(partLab);

        joueurDisLab.setFont(new Font("Ubuntu", Font.ITALIC, 16));
        joueurDisLab.setHorizontalAlignment(SwingConstants.CENTER);

        panelPartieJDis.add(joueurDisLab);

        partNumLab.setFont(new Font("Ubuntu", Font.ITALIC, 16));
        partNumLab.setHorizontalAlignment(SwingConstants.CENTER);

        panelPartieJDis.add(partNumLab);

        panelPartieJDis.setOpaque(false);
        add(panelPartieJDis, BorderLayout.EAST);

    }
    public void updateInfoHeader(PlateauNgay plateauCourrant){
        scoreJ1Lab.setText("" + plateauCourant.getScore(plateauCourant.getJoueur1()));
        scoreJ2Lab.setText("" + plateauCourant.getScore(plateauCourant.getJoueur2()));
        scoreJ3Lab.setText("" + plateauCourant.getScore(plateauCourant.getJoueur3()));
        trousJ1Lab.setText("" + PlateauNgay.getJoueur1().getNombreTrou());
        trousJ2Lab.setText("" + PlateauNgay.getJoueur2().getNombreTrou());
        trousJ3Lab.setText("" + PlateauNgay.getJoueur3().getNombreTrou());
        joueurDisLab.setText("player " + PlateauNgay.joueurDisqualifier);
        partNumLab.setText("party " + PlateauNgay.partieNumber);
    }
}
