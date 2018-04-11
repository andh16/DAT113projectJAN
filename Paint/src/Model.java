import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.*;

public class Model {
    View myView;
    JFileChooser fileChooser = new JFileChooser();

    //Open image stream

    public JLabel openFile () throws IOException {
        fileChooser.showOpenDialog(myView);
        FileInputStream fileStream = new FileInputStream(fileChooser.getSelectedFile().getAbsolutePath());
        BufferedInputStream bufferedStream = new BufferedInputStream(fileStream);
        Image img = ImageIO.read(bufferedStream);
        ImageIcon imgIcon = new ImageIcon(img);
        JLabel label = new JLabel(imgIcon);
        bufferedStream.close();
        fileStream.close();
        return label;
    }

    public void saveFile(JPanel jpanel){
        fileChooser.showSaveDialog(myView);

    }
    public void straightLine(){

    }
}
