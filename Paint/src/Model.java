import javax.swing.*;
import java.awt.*;

public class Model extends JComponent {


    public void paint (Graphics g, Point pointStart, Point pointEnd) {
        if (pointStart != null) {
            g.setColor(Color.black);
            g.drawLine(pointStart.x, pointStart.y, pointEnd.x, pointEnd.y);
        }
    }
    public void openFile (JPanel jPanel ) {

    }
}
