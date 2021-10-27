package views.currency.selector;

import javax.swing.*;

public class CurrencySelectorView extends JFrame {
    private JButton btnSelectCurrency;
    private JList currencyList;
    private JPanel mainContentPanel;
    private JPanel titlePanel;
    private JLabel lblWindowTitle;

    public CurrencySelectorView() {
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
        setIconImage(new ImageIcon("resources/icons/App-Icon.png").getImage()); // Icono de la APP
        setVisible(true); // Mostrar ventana
        setName("CurrencySelectorView");
    }
}
