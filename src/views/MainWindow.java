package views;

import views.login.LoginView;
import views.register.RegisterView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Clase de la ventana principal
 *
 */
public class MainWindow extends JFrame {
    // FIXME: 20/10/2021 Hacer que salga en la barra de tareas la ventana, con extender de JFrame funcionaría.
    private JPanel mainContentPanel;
    private JPanel titlePanel;
    private JPanel contentPanel;
    private JButton btnLogin;
    private JButton btnRegister;
    private JLabel lblAppTitle;
    private JPanel menuBarPanel;
    private JLabel lblCloseWindowIcon;

    /**
     * Constructor
     */
    public MainWindow() {
        initWindow();
        // Login
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openLoginDialog();
            }
        });
        // Register
        btnRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openRegisterDialog();
            }
        });

        // Cerrar al hacer clic en el botón X y efecto hover
        // TODO: 20/10/2021 Extraer los eventos en metodos o en otra clase
        lblCloseWindowIcon.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dispose();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                lblCloseWindowIcon.setEnabled(true);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                lblCloseWindowIcon.setEnabled(false);
            }
        });

    }

    /**
     * Iniciamos los componentes de la ventana principal
     */
    private void initWindow() {
        setDefaultLookAndFeelDecorated(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 550);
        setContentPane(mainContentPanel);
        setLocationRelativeTo(null); // Centrar ventana en la pantalla
        setResizable(false); // No se puede redimensionar
        setUndecorated(false); // Mostrar barra de titulo
        lblCloseWindowIcon.setVisible(false); // Ocultar botón de cierre
        setIconImage(new ImageIcon("resources/icons/App-Icon.png").getImage()); // Icono de la APP
        setVisible(true); // Mostrar ventana
        setName("MainWindow");
    }

    /**
     * Instancia un nuevo {@link LoginView} para después asignarle una ventana padre
     * ocultando la padre y mostrando {@code JDialog}.
     */
    private void openLoginDialog() {
        LoginView loginView = new LoginView();
        loginView.setMainWindow(this);
        loginView.getMainWindow().setVisible(false);
        loginView.setVisible(true);
    }

    /**
     * Instancia un nuevo {@link RegisterView} para después asignarle una ventana padre
     * ocultando la padre y mostrando {@code JDialog}.
     */
    private void openRegisterDialog() {
        RegisterView registerView = new RegisterView();
        registerView.setMainWindow(this);
        registerView.getMainWindow().setVisible(false);
        registerView.setVisible(true);
    }

}
