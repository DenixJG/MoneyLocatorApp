import com.formdev.flatlaf.FlatDarkLaf;
import com.mongodb.client.MongoClient;
import controllers.MongoController;
import views.MainWindow;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;

/**
 * Ejecución de la App
 *
 * @author RafaelIonutPopescu
 */
public class Main {
    /**
     * Run
     *
     * @param args - none
     */
    public static void main(String[] args) {
        // Establecer nuevo LookAndFeel
        FlatDarkLaf.setup();
        try {
            UIManager.setLookAndFeel(new FlatDarkLaf());
        } catch (UnsupportedLookAndFeelException e) {
            System.err.println("[ERR]: Error on set new LookAndFeel");
            e.printStackTrace();
        }

        // Ejecutar APP
        MainWindow mainWindow = new MainWindow();
    }
}
