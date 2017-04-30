/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.etud.iia.jeux.vue.custom;

/**
 *
 * @author thierry
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class PanelInitGame extends JDialog {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    ImageIcon imgMaoua = new ImageIcon("src/ressources/images/back5.jpg");
    private Panel panneauD = new Panel();
    private JPanel panneauMsg = new JPanel();
    private final Box boxHPan = Box.createHorizontalBox();
    private final Box boxVPan = Box.createVerticalBox();
    private JPanel panneauBoutton = new JPanel();
    private JLabel labelPlayer = new JLabel("<HTML><<I>Player who beginning </I></HTML>");

    private final JLabel j1Lab = new JLabel("<HTML><U><I>Player 1</I></U></HTML>");
    private final JLabel j2Lab = new JLabel("<HTML><U><I>Player 2</I></U></HTML>");
    private final JLabel j3Lab = new JLabel("<HTML><U><I>Player 3</I></U></HTML>");

    private int[] trousN = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    public static JComboBox j1labTr = new JComboBox();
    public static JComboBox j2labTr = new JComboBox();
    public static JComboBox j3labTr = new JComboBox();

    public static JComboBox playerCBX = new JComboBox();
    private Button bouttonOk = new Button(" OK ");

    public PanelInitGame(JFrame parent, String title, Boolean modal) {

        super(parent, title, modal);
        panneauD.setBackground(imgMaoua);
        
        
        labelPlayer.setFont(new Font("Ubuntu", Font.BOLD, 18));
        labelPlayer.setHorizontalAlignment(SwingConstants.CENTER);
        
        //entete ...
        playerCBX.addItem(new String("player1"));
        playerCBX.addItem(new String("player2"));
        playerCBX.addItem(new String("player3"));

        //boxHPan.add(Box.createVerticalStrut(10));
        boxHPan.add(Box.createHorizontalStrut(15));
        boxHPan.add(labelPlayer);
        boxHPan.add(Box.createHorizontalStrut(10));
        boxHPan.add(playerCBX);
        

        panneauMsg.setLayout(new GridLayout(4, 2,20,5));

        for (int i = 0; i <= 10; i++) {
            j1labTr.addItem(trousN[i]);
            j2labTr.addItem(trousN[i]);
            j3labTr.addItem(trousN[i]);
        }

        panneauMsg.add(new JLabel(" "));
        panneauMsg.add(new JLabel(" Graps "));

        j1Lab.setFont(new Font("Ubuntu", Font.BOLD, 18));
        j1Lab.setHorizontalAlignment(SwingConstants.CENTER);
        j1Lab.setForeground(Color.WHITE);
        panneauMsg.add(j1Lab);
        j1labTr.setFont(new Font("Ubuntu", Font.BOLD, 16));
        panneauMsg.add(j1labTr);
        j2Lab.setFont(new Font("Ubuntu", Font.BOLD, 18));
        j2Lab.setHorizontalAlignment(SwingConstants.CENTER);
        j2Lab.setForeground(Color.WHITE);
        panneauMsg.add(j2Lab);
        j2labTr.setFont(new Font("Ubuntu", Font.BOLD, 16));
        panneauMsg.add(j2labTr);
        j3Lab.setFont(new Font("Ubuntu", Font.BOLD, 18));
        j3Lab.setHorizontalAlignment(SwingConstants.CENTER);
        j3Lab.setForeground(Color.WHITE);
        panneauMsg.add(j3Lab);
        j3labTr.setFont(new Font("Ubuntu", Font.BOLD, 16));
        panneauMsg.add(j3labTr);
        panneauMsg.setOpaque(false);
        
        
        panneauBoutton.add(bouttonOk);
        panneauBoutton.setOpaque(false);
        boxVPan.add(Box.createVerticalStrut(10));
        boxVPan.add(boxHPan);
        boxVPan.add(Box.createVerticalStrut(10));
        boxVPan.add(panneauMsg);
        boxVPan.add(Box.createVerticalStrut(15));
        boxVPan.add(panneauBoutton);

        this.setMinimumSize(new Dimension(500, 300));
        
        this.setLocationRelativeTo(null);
        this.setResizable(false);
       // this.setUndecorated(true);

        bouttonOk.addActionListener(e -> {
           // updateView();
            this.setVisible(false);
        });
    }

    public void AfficheMessage() {
        panneauD.add(boxVPan); 
        this.setContentPane(panneauD);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    
    public void updateView(){
        this.playerCBX.removeAllItems();
        this.j1labTr.removeAllItems();
        this.j2labTr.removeAllItems();
        this.j3labTr.removeAllItems();
    }
}
