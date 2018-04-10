import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.ImageObserver;
import java.text.AttributedCharacterIterator;

public class Controller implements WindowListener, ActionListener, MouseMotionListener, MouseListener {

    Model MyModel;
    View MyView;
    Graphics g;

    Point pointStart = null;
    Point pointEnd   = null;

    public Controller() {
        MyView = new View (this);
        MyModel = new Model();
        MyView.addWindowListener(this);
    }

    // WindowListener
    @Override
    public void windowOpened(WindowEvent e) {

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

    // ActionListener
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(MyView.tegne)) {
            MyView.repaint(pointStart.x, pointStart.y, pointEnd.x, pointEnd.y);
        }

    }

    // MouseListener
    @Override
    public void mouseClicked(MouseEvent e) {
       MyView.statusBar.setText("Mouse Clicked at X: " + e.getX() + ", Y :" + e.getY());
    }

    @Override
    public void mousePressed(MouseEvent e) {
        MyView.statusBar.setText("Mouse Pressed");
        pointStart =  e.getPoint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
      MyView.statusBar.setText("Mouse Released");

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        MyView.statusBar.setText("Mouse Entered Canvas Area");

    }

    @Override
    public void mouseExited(MouseEvent e) {
        MyView.statusBar.setText("Mouse Exited Canvas Area");

    }

    // MouseMotionListener
    @Override
    public void mouseDragged(MouseEvent e) {
        pointEnd = e.getPoint();
        MyModel.paint(g, pointStart, pointEnd);
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    /*

    //MouseMotionListener
    @Override
    public void mouseDragged(MouseEvent e) {
        pointEnd = e.getPoint();
       // g.drawLine(pointStart.x, pointStart.y, pointEnd.x, pointEnd.y);
        myModel.paint(g, pointStart, pointEnd);
        myView.repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        pointEnd = e.getPoint();
    }
    */
}
