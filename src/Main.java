import com.formdev.flatlaf.FlatDarkLaf;
import views.InitialWindow;
import javax.swing.*;

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
        InitialWindow initialWindow = new InitialWindow();
    }
}
