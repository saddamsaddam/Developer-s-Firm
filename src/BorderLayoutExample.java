import javax.swing.*;
import java.awt.*;

public class BorderLayoutExample {
    public static void main(String[] args) {
        // Create the main frame
        JFrame frame = new JFrame("BorderLayout Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        // Create the main panel with BorderLayout
        JPanel mainPanel = new JPanel(new BorderLayout());

        // Create the content panel for the left side
        JPanel contentPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel contentLabel = new JLabel("Left-side content");
        contentPanel.add(contentLabel);

        // Create the south panel
        JPanel southPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton button = new JButton("Button");
        southPanel.add(button);

        // Add the content panel to the main panel
        mainPanel.add(contentPanel, BorderLayout.WEST);

        // Add the south panel to the main panel
        mainPanel.add(southPanel, BorderLayout.SOUTH);

        // Add the main panel to the frame's content pane
        frame.getContentPane().add(mainPanel);

        // Display the frame
        frame.setVisible(true);
    }
}
