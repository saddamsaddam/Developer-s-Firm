package Registration;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LinkableDropDownMenu extends JFrame {
    private JComboBox<Object> comboBox;

    public LinkableDropDownMenu() {
        setTitle("Linkable Drop-Down Menu");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);

        // Create the combo box and add items
        comboBox = new JComboBox<>();
        comboBox.setRenderer(new ButtonRenderer());
        comboBox.addItem("Google");
        comboBox.addItem("Yahoo");
        comboBox.addItem("Bing");
        comboBox.addItem(new JButton("Add Item"));

        // Add an action listener to handle the selection
        comboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Object selectedItem = comboBox.getSelectedItem();
                    
                    if (selectedItem instanceof JButton) {
                    showRegistrationDialog();
                }
                    else{
                       String selectedString = (String) selectedItem;  
                       System.out.println(selectedString);
                    }
                
                
            }
        });

        // Add the combo box to the content pane
        getContentPane().add(comboBox);
    }

    // Method to open a URL in the default web browser
    private void openURL(String url) {
        try {
            Desktop.getDesktop().browse(java.net.URI.create(url));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // Method to show the registration dialog
    private void showRegistrationDialog() {
        JTextField usernameField = new JTextField();
        JPasswordField passwordField = new JPasswordField();

        JPanel panel = new JPanel(new GridLayout(2, 2, 5, 5));
        panel.setBorder(new EmptyBorder(10, 10, 10, 10));
        panel.add(new JLabel("Item Name:"));
        panel.add(usernameField);

        int result = JOptionPane.showConfirmDialog(this, panel, "Registration", JOptionPane.OK_CANCEL_OPTION);

        if (result == JOptionPane.OK_OPTION) {
            String username = usernameField.getText();

            // Process registration data
            System.out.println("Item Name: " + username);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new LinkableDropDownMenu().setVisible(true);
            }
        });
    }

    // Custom renderer to display buttons as items in the combo box
    class ButtonRenderer extends JButton implements ListCellRenderer<Object> {
        public ButtonRenderer() {
            setOpaque(true);
        }

        public Component getListCellRendererComponent(JList<?> list, Object value, int index,
                                                      boolean isSelected, boolean cellHasFocus) {
            if (value instanceof JButton) {
                JButton button = (JButton) value;
                setText(button.getText());
            } else {
                setText((String) value);
            }

            setBackground(isSelected ? list.getSelectionBackground() : list.getBackground());
            setForeground(isSelected ? list.getSelectionForeground() : list.getForeground());

            return this;
        }
    }
}
