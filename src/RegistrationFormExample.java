import javax.swing.*;

public class RegistrationFormExample {
    public static void main(String[] args) {
        String[] roles = {"Admin", "CoAdmin", "User"};

        // Create the components
        JTextField usernameField = new JTextField();
        JPasswordField passwordField = new JPasswordField();
        JComboBox<String> roleDropdown = new JComboBox<>(roles);

        // Create the panel and add the components
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(new JLabel("Username:"));
        panel.add(usernameField);
        panel.add(new JLabel("Password:"));
        panel.add(passwordField);
        panel.add(new JLabel("Role:"));
        panel.add(roleDropdown);

        // Display the option pane dialog with the panel
        int result = JOptionPane.showConfirmDialog(null, panel, "Registration Form",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        // Check the user's response
        if (result == JOptionPane.OK_OPTION) {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());
            String selectedRole = (String) roleDropdown.getSelectedItem();

            // Perform further processing with the entered data
            System.out.println("Username: " + username);
            System.out.println("Password: " + password);
            System.out.println("Role: " + selectedRole);
        } else {
            System.out.println("Registration canceled.");
        }
    }
}
