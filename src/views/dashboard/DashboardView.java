package views.dashboard;

import controllers.UserController;

import javax.swing.*;

public class DashboardView extends JFrame {
    private JLabel lblWindowTitle;
    private JPanel mainContentPanel;
    private JPanel titlePanel;

    // Controllers
    UserController userController;

    public DashboardView() {
        initComponents();
    }

    /**
     * Iniciamos los componentes de la ventana principal
     */
    private void initComponents() {
        setDefaultLookAndFeelDecorated(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 550);
        setContentPane(mainContentPanel);
        setLocationRelativeTo(null); // Centrar ventana en la pantalla
        setResizable(false); // No se puede redimensionar
        setUndecorated(false); // Mostrar barra de titulo
        // lblCloseWindowIcon.setVisible(false); // Ocultar botón de cierre
        setIconImage(new ImageIcon("resources/icons/App-Icon.png").getImage()); // Icono de la APP
        setVisible(true); // Mostrar ventana
        setName("DashboardView");
    }

    public UserController getUserController() {
        return userController;
    }

    public void setUserController(UserController userController) {
        this.userController = userController;
    }


}
