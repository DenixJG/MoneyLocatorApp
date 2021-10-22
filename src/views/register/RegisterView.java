package views.register;

import views.MainWindow;

import javax.swing.*;
import java.awt.event.*;

public class RegisterView extends JFrame {
    private JPanel contentPane;
    private JButton buttonOK;
    private JTextField txtUsername;
    private JPasswordField pwdRepPassword;
    private JPasswordField pwdPassword;
    private JTextField txtEmail;
    private JLabel lblUsername;
    private JLabel lblEmail;
    private JLabel lblPasswd;
    private JLabel lblRepPasswd;
    private JLabel lblCloseWindowIcon;

    private MainWindow mainWindow;

    public RegisterView() {
        setSize(400, 300);
        setUndecorated(true); // Quitar frame de la ventana
        setLocationRelativeTo(null); // Centrar ventana en la pantalla
        setResizable(false); // No se puede redimensionar
        setContentPane(contentPane);
        // setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener() {
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
        getMainWindow().setVisible(true);
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        getMainWindow().setVisible(true);
        dispose();
    }


    // Getter y Setter

    public MainWindow getMainWindow() {
        return mainWindow;
    }

    public void setMainWindow(MainWindow mainWindow) {
        this.mainWindow = mainWindow;
    }
}
