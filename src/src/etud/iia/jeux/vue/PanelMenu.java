/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.etud.iia.jeux.vue;

//import awale.controler.MenuControler;
import java.applet.Applet;
import java.applet.AudioClip;
import src.etud.iia.jeux.vue.custom.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.font.TextAttribute;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JLabel;
import src.etud.iia.jeux.vue.custom.Panel;
import src.etud.iia.jeux.vue.custom.Sound;

/**
 *
 * @author Thierry TCHINDA && Mercedes KADJE
 */
public class PanelMenu extends Panel {

    WindowNgay parent;
    public Thread thread;
    public static URL url1, url2, url3;
    public static AudioClip ac1, ac2;
    private final JLabel title = new JLabel("<HTML><U>Menu Of Ngay Game</U></HTML>");
    private final Button btnNewPart = new Button("New Party");
    private final Button btnScores = new Button(" Scores ");
    private final Button btnRules = new Button(" Documentation ");
    private final Button btnAbout = new Button(" About ");
    private final Button btnExit = new Button(" Quit ");
    private final JLabel footer = new JLabel("The best still to come ...");

    private final Box boxBtn = Box.createVerticalBox();

    //   private final MenuControler menuControl;
    public PanelMenu(JFrame frame) {
       
        //      menuControl = new MenuControler(frame);
        this.parent = (WindowNgay) frame;
        initComposant();

    }

    public final void initComposant() {

        title.setHorizontalAlignment(JLabel.CENTER);
        title.setForeground(Color.BLACK);
        title.setFont(new Font("Ubuntu", Font.ITALIC, 18));

        footer.setHorizontalAlignment(JLabel.CENTER);
        footer.setForeground(Color.WHITE);
        footer.setFont(new Font("Ubuntu", Font.ITALIC, 18));
        btnNewPart.addActionListener(e -> {
         
            this.parent.setContentPane(new PanelPartie(this.parent));
            this.parent.setVisible(true);
        });
        btnScores.addActionListener(e -> {
          
            System.out.println("Pas encore disponibles ...Scores");;
        });
        btnRules.addActionListener(e -> {
           
            System.out.println("Pas encore disponibles ...Documentation");;
        });
        btnAbout.addActionListener(e -> {
   
            System.out.println("Pas encore disponibles ...About");;
        });
        btnExit.addActionListener(e -> {
     
            System.exit(0);
        });

        boxBtn.add(Box.createVerticalStrut(40));
        boxBtn.add(title);
        boxBtn.add(Box.createVerticalStrut(30));
        boxBtn.add(btnNewPart);
        boxBtn.add(Box.createVerticalStrut(30));
        boxBtn.add(btnScores);
        boxBtn.add(Box.createVerticalStrut(30));
        boxBtn.add(btnRules);
        boxBtn.add(Box.createVerticalStrut(30));
        boxBtn.add(btnAbout);
        boxBtn.add(Box.createVerticalStrut(30));
        boxBtn.add(btnExit);
        boxBtn.add(Box.createVerticalStrut(20));
        boxBtn.add(footer);

        this.add(boxBtn);
    }
}
