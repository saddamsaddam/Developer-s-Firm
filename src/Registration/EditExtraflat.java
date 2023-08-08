package Registration;
import com.toedter.calendar.JDateChooser;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;import javax.swing.JButton;import javax.swing.JFileChooser;import javax.swing.JFormattedTextField;
import javax.swing.JFrame;import javax.swing.JLabel;import javax.swing.JOptionPane;import javax.swing.JPanel;import javax.swing.JScrollPane;import javax.swing.JTable;
import javax.swing.JTextField;import javax.swing.table.DefaultTableModel;
import org.jdatepicker.JDatePicker;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.SqlDateModel;
import org.json.JSONException;import org.json.JSONObject;

/**
 *
 * @author saddamnvn
 */
public class EditExtraflat extends JFrame {
    int leng=0;
         JScrollPane scrollPane;
         String prn;
       Map<String, Integer> percentagetest = new HashMap<>();
       int sum=0;
       LinkedList<String> linklist = new LinkedList<>();
    String role;
            JDatePicker datePicker ;
    String calendaroutput = null,values15;
    int labelcount=0;
    int percentagecount=0;
    Database connection = new  Database();
     int lng=1;
     JSONObject jsondata=new JSONObject();
     JSONObject jsonoption=new JSONObject();
     JTextField[]fltname;
     JTextField[]fltdebit;
     JLabel total,share;
     JLabel[] flatlabelname;
     JLabel[] flatlabeldebit;
    // Map<String, String> flatinfo = new HashMap<String, String>();
      JSONObject flatinfo = new JSONObject();
    JTextField jtf,sharematename,sharemateamount,flatjtf;
    JButton addsharemate,addbutton,addend,createflat,addflat,homer;
    byte[] immAsBytes = null;
    JScrollPane js;
    JPanel mainbody,intercentralpanel, centerpanel,shareparshow;
    JPanel test;
    JPanel[] jpanelcolor=new JPanel[5];
     Component retrievedComponent;
      JLabel label,imgshow ,sharename,shareamount,flatlabel,labelspace,labelspacer;
       Dimension textFieldSize;
    public EditExtraflat(String role,String prn) throws ParseException, JSONException
    {
        this.role=role;
        this.prn=prn;
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
    js = new JScrollPane(mainbody);
    js.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    this.add(js);
     center();
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
    
   
     public void  addflatinformation() throws JSONException
    {
        int i=0;
         flatinfo=connection.getsharemateprojectflatinfo(prn);
         leng=    flatinfo.length();    
         fltname=new JTextField[flatinfo.length()];
         fltdebit=new JTextField[flatinfo.length()];
        
         flatlabelname=new JLabel[flatinfo.length()];
         flatlabeldebit=new JLabel[flatinfo.length()];
         textFieldSize = new Dimension(400, 30);
         Iterator<String> keys = flatinfo.keys();
                // Iterate over keys and get values
                while (keys.hasNext()) {
                    String key = keys.next();
                    String value = flatinfo.getString(key);
                    System.out.println("Key: " + key + ", Value: " + value);
                     flatlabelname[i] = new JLabel("Enter the name of Flat"+(i+1));
                    intercentralpanel.add(flatlabelname[i]);
                     fltname[i]=new JTextField(key);
                     fltname[i].setMaximumSize(textFieldSize);
                     fltname[i].setPreferredSize(textFieldSize);
                   intercentralpanel.add( fltname[i]); 


                    flatlabeldebit[i] = new JLabel("Enter The Flat Cost"+(i+1));
                    intercentralpanel.add(flatlabeldebit[i]);
                     fltdebit[i]=new JTextField(value);
                     fltdebit[i].setMaximumSize(textFieldSize);
                     fltdebit[i].setPreferredSize(textFieldSize);
                     intercentralpanel.add( fltdebit[i]); 
                     i++;
                }
       
          addflat=new JButton("Add");
          intercentralpanel.add(addflat);
          
          addflat.addActionListener(e->{
            try {
                
                checkflatinformation();
            } catch (JSONException ex) {
                Logger.getLogger(EditExtraflat.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(EditExtraflat.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(EditExtraflat.class.getName()).log(Level.SEVERE, null, ex);
            }
          });
        
    }
     
     public void checkflatinformation() throws JSONException, ClassNotFoundException, SQLException
     {
         int cc=0;
        for(int i=0;i<leng;i++)
        {
            if(fltname[i].getText().isBlank()|| fltdebit[i].getText().isBlank())
            {
                cc=1;
                break;
            }

        }
        
        if(cc==1)
        {
           JOptionPane.showMessageDialog(null, "Please Fill All Field");
        }
        else
        {
            linklist = new LinkedList<>();
             for(int i=0;i<leng;i++)
            {
                 linklist.add( fltdebit[i].getText()); 
            
            }
             JPanel rr=connection.Stringcheckup(linklist);
             if(rr.getComponentCount()>0)
             {
                 JOptionPane.showOptionDialog(null, rr, "Error",
                                           JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, null, null);
             }
             else
             {
                
                         for(int i=0;i<leng;i++)
                {

                    fltname[i].setVisible(false);
                    fltdebit[i].setVisible(false);
                    flatlabeldebit[i].setVisible(false);
                    flatlabelname[i].setVisible(false);
                    flatinfo.put(fltname[i].getText(),  fltdebit[i].getText());

                }
                 
                 System.out.println(flatinfo);
                 addflat.setVisible(false);
                 connection.Editflatinfo(prn,flatinfo);
                 HomeForm hh = new HomeForm(role);
                 hh.setVisible(true);
                 dispose();
                
             }
            
            
             
        }
     }
   
    public void center() throws ParseException, JSONException
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
    label = new JLabel("Enter Your Project Name");
    intercentralpanel.add(label);
    
    jtf=new JTextField(prn);
    jtf.setEnabled(false);
    textFieldSize = new Dimension(400, 30);
    jtf.setMaximumSize(textFieldSize);
    jtf.setPreferredSize(textFieldSize);
    intercentralpanel.add(jtf);
    
    addflatinformation();
    
   
    }
   
      public static void main(String[] args) throws ParseException, JSONException {
     EditExtraflat window = new  EditExtraflat("","");
     window.setVisible(true);

}


}
