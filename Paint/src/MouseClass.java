/*
This class includes all the functions related to the Mouse. The class is further utilized in the ModelClass
 */


import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MouseClass implements MouseListener, MouseMotionListener {

    Controller MyController = new Controller();

    public void mouseClicked(MouseEvent e) {
        MyController.MyView.statusBar.setText(String.format("Mouse Clicked at %d, %d", e.getX(), e.getY()));

    }

    @Override
    public void mousePressed(MouseEvent e) {
        MyController.MyView.statusBar.setText(String.format("Mouse Pressed"));

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        MyController.MyView.statusBar.setText(String.format("Mouse Released"));
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        MyController.MyView.statusBar.setText(String.format("Mouse Entered Canvas Area"));

    }

    @Override
    public void mouseExited(MouseEvent e) {
        MyController.MyView.statusBar.setText(String.format("Mouse Exited Canvas Area"));

    }

    // Mouse Motion Listener
    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
