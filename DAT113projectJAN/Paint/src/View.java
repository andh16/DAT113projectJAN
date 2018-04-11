import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import java.awt.*;

public class View extends JFrame {

    // Globale Variabler
    private static final int CANVAS_WIDTH = 800;
    private static final int CANVAS_HEIGT = 700;
    private static final int STATUSBAR_HEIGHT = 20;
    private DrawCanvas canvas = new DrawCanvas();

    // Meny
    JMenuBar menuBar = new JMenuBar();
    JMenu menu = new JMenu("Fil");

    // Panel where the straight line is drawn, and button to activate it
    JPanel mousePanel = new JPanel();
    JButton drawLine = new JButton("Rett linje");

    // Knapper tilhørende
    JMenuItem aapne = new JMenuItem("Åpne");
    JMenuItem lagre = new JMenuItem("Lagre");
    JMenuItem lagreSom = new JMenuItem("Lagre som...");

    // Knapper tilhørednde menybaren.
    JButton tegne = new JButton("Tegn");

    // Statuspanel (nederst)
    JPanel statusPanel = new JPanel();
    JLabel statusBar = new JLabel("Status");


    public View (Controller controller) {

        super("Tittel");
        this.setLayout(new BorderLayout());
        this.setPreferredSize(new Dimension(CANVAS_WIDTH, CANVAS_HEIGT));

        //Container cp = getContentPane();

        //this.add(canvas, BorderLayout.CENTER);
        this.add(mousePanel, BorderLayout.CENTER);
        pack(); //??????

        // statusBar
        statusPanel.setBorder((new BevelBorder(BevelBorder.LOWERED)));
        this.add(statusPanel, BorderLayout.SOUTH);
        statusPanel.setPreferredSize(new Dimension(this.getWidth(), STATUSBAR_HEIGHT));
        statusPanel.setLayout(new BoxLayout(statusPanel, BoxLayout.X_AXIS));
        statusBar.setHorizontalAlignment(SwingConstants.LEFT);
        statusPanel.add(statusBar);

        // Add buttons to menubar
        menu.add(aapne);
        menu.add(lagre);
        menu.add(lagreSom);
        menuBar.add(menu);
        menuBar.add(tegne);
        menuBar.add(drawLine);
        this.setJMenuBar(menuBar);

        // Add action to buttons
        aapne.addActionListener(controller);
        lagre.addActionListener(controller);
        lagreSom.addActionListener(controller);
        drawLine.addActionListener(controller);

        canvas.addMouseListener(controller);
        canvas.addMouseMotionListener(controller);

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }


    // Panelet som alle tegningene gjøres opp på.
    private class DrawCanvas extends JPanel {

        DrawCanvas() {
            this.setBackground(Color.white);
        }


        @Override
        public void paintComponent (Graphics g) {
            super.paintComponent(g);
            g.setColor(Color.WHITE);

        }
    }



}
