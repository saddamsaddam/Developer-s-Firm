package Registration;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.PopupMenu;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;import javax.swing.JButton;import javax.swing.JComboBox;
import javax.swing.JFileChooser;import javax.swing.JFormattedTextField;
import javax.swing.JFrame;import javax.swing.JLabel;import javax.swing.JList;
import javax.swing.JOptionPane;import javax.swing.JPanel;import javax.swing.JPasswordField;
import javax.swing.JScrollPane;import javax.swing.JTextField;import javax.swing.ListCellRenderer;
import javax.swing.border.EmptyBorder;
import org.jdatepicker.DateModel;
import org.jdatepicker.JDatePicker;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.SqlDateModel;
import org.json.JSONException;import org.json.JSONObject;

/**
 *
 * @author saddamnvn
 */
public class Extradebit extends JFrame {
     int count=0;
        private JComboBox<Object> comboBox;
            HashSet<String> result=new HashSet();
            String selectedString;
    String role;
    JDatePicker datePicker ;
    String calendaroutput = null,values15;
    int labelcount=0;
    int percentagecount=0;
    String projectname,flatname;
    Database connection = new  Database();
     int lng=1;
     JSONObject jsondata=new JSONObject();
     JSONObject jsonoption=new JSONObject();
    
    JTextField jtf,sharematename,sharemateamount,flatjtf,sharematemoney;
    JButton addsharemate,uploadimg,addbutton,addend,addendfront,homer;
    byte[] immAsBytes = null;
    JScrollPane js;
    JPanel mainbody,intercentralpanel, centerpanel;
    JPanel test;
    JPanel[] jpanelcolor=new JPanel[5];
     Component retrievedComponent;
      JLabel label,imgshow ,sharename,shareamount,flatlabel,sharemoney,labelspace;
       Dimension textFieldSize;
       public void setprnflt( String projectnam,String flatnam)
       {
           projectname=projectnam;
           flatname=flatnam;
           center(projectname,flatname);
       }
    public Extradebit(String role)
    {
        System.out.println(role);
       this.role=role;
    this.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
    this.setSize(screen.width - 20, screen.height - 70);
    setTitle("MultiPanel Test");

     mainbody = new JPanel();
     for(int i=0;i<5;i++)
    {
           jpanelcolor[i]=new JPanel();
           jpanelcolor[i].setBackground(Color.gray);
 
    }
    setupjpanel(mainbody,jpanelcolor);
    //adding scroll bar
    //js = new JScrollPane(mainbody);
    //js.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    this.add(mainbody);
     //center(null,null);
    // top();
    // bottom();
    }
    public void setupjpanel(JPanel xyz,JPanel[] jpanelcolor)
    {
    xyz.setLayout(new BorderLayout());
    for(int i=0;i<5;i++)
    {
         if(i==0){
            if(labelcount==0)
            {
                labelspace=new JLabel("                                                                                                                                                                             ");
                jpanelcolor[0].add(labelspace);
                
                labelcount++;
            }
            xyz.add(jpanelcolor[0], BorderLayout.WEST);
        }
        if(i==1){
            if(labelcount==1)
            {
               labelspace=new JLabel("                                                                      ");
                homer =new JButton("Home Page");
                jpanelcolor[1].add(labelspace);
                jpanelcolor[1].add(  homer);
                homer.addActionListener(e->{
                    HomeForm hh;
                try {
                    hh = new HomeForm(role);
                     hh.setVisible(true);
                dispose();

                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(loginForm.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(loginForm.class.getName()).log(Level.SEVERE, null, ex);
                } catch (JSONException ex) {
                    Logger.getLogger(loginForm.class.getName()).log(Level.SEVERE, null, ex);
                }
                });
                labelcount++;
            }
         xyz.add(jpanelcolor[1], BorderLayout.EAST);
        }
        if(i==2){
         xyz.add(jpanelcolor[2], BorderLayout.NORTH);
        }
        if(i==3){
         xyz.add(jpanelcolor[3], BorderLayout.SOUTH);
        }
        if(i==4){
         xyz.add(jpanelcolor[4], BorderLayout.CENTER);
        }

    }
  }
   
    public void addbutton() throws JSONException, ClassNotFoundException, SQLException, ParseException
    {
        //jtf,sharematename,sharemateamount
       
        if( sharematemoney.getText().isBlank())
        {
          JOptionPane.showMessageDialog(null, "Please Fill Up all The Record ");   
         }
        else
        {
            try{
                Integer.parseInt(sharematemoney.getText());
                //data send to database
               boolean a = connection.projectextradebit(jtf.getText(),selectedString,sharematemoney.getText());
                if (a == true) {
                   HomeForm hh = new HomeForm(role);
                   hh.setVisible(true);
                   dispose();
                 //JOptionPane.showMessageDialog(null, "successfully saved ");
                } else {
                    JOptionPane.showMessageDialog(null, "Not Inserted");
                }
           addsharemate.setVisible(true);
           intercentralpanel.remove(sharename);
           intercentralpanel.remove(comboBox);
           
           intercentralpanel.remove( sharemoney);
           intercentralpanel.remove(sharematemoney);
           intercentralpanel.remove(addbutton);
             lng++;
           //intercentralpanel.remove( addend);
             jtf.setEnabled(false);
             intercentralpanel.revalidate();
             intercentralpanel.repaint();
            }catch(NumberFormatException e)
            {
                          JOptionPane.showMessageDialog(null, "Please Enter Number of Amount(money).");
  
            }
              
        }
       
    }
    
    public void addsharematefun()
    {
        textFieldSize = new Dimension(400, 30);
        addsharemate.setVisible(false);
        
        sharename=new JLabel("Enter The Name");
        intercentralpanel.add(sharename);
        
         comboBox = new JComboBox<>();
             result=connection.itemnamereturn("projectextradebit");

        comboBox.setRenderer(new ButtonRenderer());
        comboBox.addItem(new JButton("Add New Item"));
        comboBox.setMaximumSize(textFieldSize);
        comboBox.setPreferredSize(textFieldSize);
        count=0;
        result.forEach(e->{
            if(count==0)
            {
                selectedString=e;
               count++;
            }
        comboBox.addItem(e);
        });

        // Add an action listener to handle the selection
        comboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Object selectedItem = comboBox.getSelectedItem();
                    
                    if (selectedItem instanceof JButton) {
                    showRegistrationDialog();
                }
                    else{
                      selectedString = (String) selectedItem; 
                      
                       System.out.println(selectedString);
                    }
                
                
            }
        });

        // Add the combo box to the content pane
        intercentralpanel.add(comboBox);
        
         sharemoney=new JLabel("Enter The Total Money");
        intercentralpanel.add(sharemoney);
        
        sharematemoney=new JTextField();
        sharematemoney.setMaximumSize(textFieldSize);
        sharematemoney.setPreferredSize(textFieldSize);
        intercentralpanel.add(sharematemoney);
        
      
        addbutton=new JButton("Save");
        intercentralpanel.add(addbutton);
        

        addbutton.addActionListener(e->{
            try {
                try {
                    addbutton();
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Extradebit.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(Extradebit.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ParseException ex) {
                    Logger.getLogger(Extradebit.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (JSONException ex) {
                Logger.getLogger(Extradebit.class.getName()).log(Level.SEVERE, null, ex);
            }
         });
        
         
    }
    public void center(String projectname,String flatname)
    {
    retrievedComponent = mainbody.getComponent(4);
    centerpanel = (JPanel) retrievedComponent;
    for(int i=0;i<5;i++)
    {
           jpanelcolor[i]=new JPanel();
           jpanelcolor[i].setBackground(Color.white);
 
    }
    setupjpanel(centerpanel, jpanelcolor);
    retrievedComponent = centerpanel.getComponent(4);
    intercentralpanel = (JPanel) retrievedComponent;
    BoxLayout BoxLayouty = new BoxLayout(intercentralpanel, BoxLayout.Y_AXIS);
    intercentralpanel.setLayout(BoxLayouty);
    label = new JLabel("Debit Type");
    intercentralpanel.add(label);
    
    jtf=new JTextField();
    textFieldSize = new Dimension(400, 30);
    jtf.setMaximumSize(textFieldSize);
    jtf.setPreferredSize(textFieldSize);
    intercentralpanel.add(jtf);
    jtf.setText("extra");
    jtf.setEnabled(false);
    

    addsharemate=new JButton("Debit");
    intercentralpanel.add(addsharemate);
    
    
     addsharemate.addActionListener(e->{
         addsharematefun();
     });
    }
      public static void main(String[] args) {
      Extradebit window = new  Extradebit("");
     window.setVisible(true);

}
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
            connection.itemadd("projectextradebit","projectextradebit", username);
            intercentralpanel.remove(sharename);
            intercentralpanel.remove(comboBox);
            intercentralpanel.remove(sharemoney);
            intercentralpanel.remove(sharematemoney);
            intercentralpanel.remove(addbutton);

             addsharematefun();
            // Process registration data
            JOptionPane.showMessageDialog(null, "Successfully Data Added");

        }
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
