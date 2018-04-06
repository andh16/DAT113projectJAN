import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;       // Using AWT's Graphics and Color
import java.awt.event.*; // Using AWT event classes and listener interfaces
import javax.swing.*;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class View extends JFrame {

    private static final int CANVAS_WIDTH = 800;
    private static final int CANVAS_HEIGT = 700;

    JPanel mainPanel = new JPanel();
    JMenuBar menuBar = new JMenuBar();
    JMenu menu = new JMenu("Fil");
    JPanel statusPanel = new JPanel();
    JLabel statusLabel = new JLabel("Status");
    JMenuItem aapne = new JMenuItem("Åpne");
    JMenuItem lagre = new JMenuItem("Lagre");
    JMenuItem lagreSom = new JMenuItem("Lagre som...");

    public View (Controller controller) {

        this.add(mainPanel);
        menu.add(aapne);
        menu.add(lagre);
        menu.add(lagreSom);
        menuBar.add(menu);
        this.add(menuBar);

        aapne.addActionListener(controller);
        lagre.addActionListener(controller);
        lagreSom.addActionListener(controller);

        this.setJMenuBar(menuBar);
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(CANVAS_WIDTH,CANVAS_HEIGT);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        class Canvas extends JPanel {

        }

    }



}
