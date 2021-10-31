package views.currency.selector;

import controllers.UserController;
import views.dashboard.DashboardView;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CurrencySelectorView extends JFrame {
    private JButton btnSelectCurrency;
    private JList currencyList;
    private JPanel mainContentPanel;
    private JPanel titlePanel;
    private JLabel lblWindowTitle;

    // Controller
    UserController userController;

    // Properties
    String selectedCurrency;

    // Option
    JOptionPane jOptionPane;

    public CurrencySelectorView() {
        initComponents();

        btnSelectCurrency.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (getSelectedCurrency() != null) {
                    selectedCurrency = getSelectedCurrency();
                    if (showConfirmation() == JOptionPane.OK_OPTION) {
                        openDashboardView();
                    }
                }
            }
        });
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
        setIconImage(new ImageIcon("resources/icons/App-Icon.png").getImage()); // Icono de la APP
        setVisible(true); // Mostrar ventana
        setName("CurrencySelectorView");
    }

    private String getSelectedCurrency() {
        return (String) this.currencyList.getSelectedValue();
    }

    private void openDashboardView() {
        DashboardView dashboardView = new DashboardView();
        this.dispose();
    }

    private int showConfirmation() {
        return JOptionPane.showConfirmDialog(this, "Divisa: " + selectedCurrency);
    }

    public UserController getUserController() {
        return userController;
    }

    public void setUserController(UserController userController) {
        this.userController = userController;
    }

    public static void main(String[] args) {
        new CurrencySelectorView();
    }

}
