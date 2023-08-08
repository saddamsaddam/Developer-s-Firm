import javax.swing.*;
import com.toedter.calendar.JDateChooser;

public class EndingDateApp {
    public static void main(String[] args) {
        JDateChooser endDateChooser = new JDateChooser();

        int option = JOptionPane.showOptionDialog(null, endDateChooser, "Ending Date",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);

        if (option == JOptionPane.OK_OPTION) {
            java.util.Date endDate = endDateChooser.getDate();

            JOptionPane.showMessageDialog(null, "End Date: " + endDate);
        }
    }
}
