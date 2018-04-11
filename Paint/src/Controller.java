import javax.swing.*;
import java.awt.*;
import java.awt.Graphics;
import java.awt.event.*;
import java.io.IOException;

public class Controller implements WindowListener, ActionListener, MouseListener {

    BaseGraphics myGraphics;
    Model myModel;
    View myView;
    int endPointX;
    int endPointY;
   int startPointX;
    int startPointY;
    boolean shape = false;
    int i = 0;

    public Controller() {
        myView = new View (this);
        myModel = new Model();
        myView.addWindowListener(this);
        myView.mousePanel.addMouseListener(this);
        myGraphics = new BaseGraphics();
    }

    @Override
    public void windowOpened(WindowEvent e) {
        JOptionPane.showMessageDialog(null, "Velkommen til JavaOptionPaint!");

    }

    @Override
    public void windowClosing(WindowEvent e) {


    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        //If open button is pressed

        if(e.getSource().equals(myView.aapne)) {
            try {
                myView.mousePanel.add(myModel.openFile());
                myView.validate();
            } catch (IOException e1) {
                System.out.println("Feil i controller");
            }
        }

        //If drawLine button is pressed, int shape = 1
        else if(e.getSource().equals(myView.drawLine)){
            this.shape = !this.shape;
        }

        //If save button is pressed

        else if(e.getSource().equals(myView.lagre)){
            myModel.saveFile(myView.mainPanel);
        }

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

        //If shape is false, draw regular
        if(this.shape == false){
            Graphics g = myView.mousePanel.getGraphics();
            g.setColor(Color.black);
            g.fillOval(e.getX(), e.getY(), 10, 10);

        }
       startPointX = e.getX();
       startPointY = e.getY();

    }

    @Override
    public void mouseReleased(MouseEvent e) {

        //Draw straight line
        if(this.shape == true) {
            endPointX = e.getX();
            endPointY = e.getY();
            Graphics g = myView.mousePanel.getGraphics();
            Graphics2D g2 = (Graphics2D) g;
            g2.setStroke(new BasicStroke(3));
            g.drawLine(startPointX, startPointY, endPointX, endPointY
            );
            System.out.println(endPointX + "\n" + endPointY + "\n" + startPointX + "\n" + startPointY);
        }

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }
    @Override
    public void mouseExited(MouseEvent e) {

    }
}
