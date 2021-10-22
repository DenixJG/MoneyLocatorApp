package views.login;

import controllers.UserController;
import models.User;
import views.MainWindow;

import javax.swing.*;
import java.awt.event.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoginView extends JFrame {
    private JPanel contentPane;
    private JButton btnLogin;
    private JTextField txtUsername;
    private JPasswordField pwdPassword;
    private JLabel lblUsernameIcon;
    private JLabel lblPasswordIcon;
    private JLabel lblCloseWindowIcon;
    private JButton buttonCancel;

    private MainWindow mainWindow; // Ventana Padre
    private UserController userController; // Controlador

    public LoginView() {
        setSize(400, 300);
        setUndecorated(true); // Quitar frame de la ventana
        setLocationRelativeTo(null); // Centrar ventana en la pantalla
        setResizable(false); // No se puede redimensionar
        setContentPane(contentPane);
        // setModal(true);
        getRootPane().setDefaultButton(btnLogin);

        btnLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        // Cerrar al hacer clic en el botón X y efecto hover
        // TODO: 20/10/2021 Extraer los eventos en metodos o en otra clase
        lblCloseWindowIcon.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                onCancel();
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


        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onOK() {
        // add your code here
        User user = getUserToLogin();
        if (user != null) {
            userController = new UserController(this, user);
            if (userController.validateUser()) {
                System.out.println("[INFO](LoginView): User -> " + user.getUsername());
                // TODO: 22/10/2021 Mandar mensaje a la ventana principal de que el usuario es correcto
                // Cerramos la ventana
                getMainWindow().setVisible(true); // Mostrar ventana
                dispose();
            } else {
                System.err.println("[INFO](LoginView): User -> " + user.getUsername() + ", not exists!");
            }
        }  // TODO: 21/10/2021 Mensaje de error o validación
    }

    private void onCancel() {
        // add your code here if necessary
        getMainWindow().setVisible(true); // Al cerrar se vuelve a mostrar la ventana Padre
        dispose();
    }

    /**
     * Devuelve el usuario que intenta iniciar sesión.
     *
     * @return {@linkplain User}
     */
    private User getUserToLogin() {
        if (!txtUsername.getText().equals("") && pwdPassword.getPassword().length > 0) {
            return new User(txtUsername.getText(), pwdPassword.getText());
        } else {
            return null;
        }
    }

    // Getter y Setter

    public MainWindow getMainWindow() {
        return mainWindow;
    }

    public void setMainWindow(MainWindow mainWindow) {
        this.mainWindow = mainWindow;
    }
}
