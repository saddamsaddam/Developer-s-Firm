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
public class CreateProject extends JFrame {
         JScrollPane scrollPane;
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
    public CreateProject(String role) throws ParseException
    {
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
    
   
    
        
    public void addbutton() throws JSONException, ClassNotFoundException, SQLException
    {
        //jtf,sharematename,sharemateamount
         if(jtf.getText().isBlank()|| sharematename.getText().isBlank()||sharemateamount.getText().isBlank()||flatjtf.getText().isBlank())
        {
       JOptionPane.showMessageDialog(null, "Please Fill Up all The Record");
        }
        else
        {
            try {
             percentagecount=percentagecount+Integer.parseInt(sharemateamount.getText());
              if(percentagecount>100)
            {
               JOptionPane.showMessageDialog(null, " Added percentage is  "+(percentagecount-Integer.parseInt(sharemateamount.getText()))+" And Total Percantage will 100");
               percentagecount=percentagecount-Integer.parseInt(sharemateamount.getText());
   
            }
            else
            {
                if(percentagecount==100)
                {
                   boolean a = connection.projectsharemate(jtf.getText(),flatjtf.getText(),sharematename.getText(),sharemateamount.getText(),flatinfo,values15);
                   if (a == true) {
                 JOptionPane.showMessageDialog(null, "successfully Project Created ");
                  HomeForm hh = new HomeForm(role);
                   hh.setVisible(true);
                   dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Not Inserted");
                }
                }
                else
                {
                   //data send to database
               boolean a = connection.projectsharemate(jtf.getText(),flatjtf.getText(),sharematename.getText(),sharemateamount.getText(),flatinfo,values15);
                if (a == true) {
                 JOptionPane.showMessageDialog(null, "successfully saved ");
                 percentagetest.put(sharematename.getText(),Integer.parseInt(sharemateamount.getText()));
                 //JLabel ff=new JLabel(sharematename.getText()+"                "+sharemateamount.getText());
                 //shareparshow.add(ff);
                 //shareparshow.revalidate();
                } else {
                    JOptionPane.showMessageDialog(null, "Not Inserted");
                }
           addsharemate.setVisible(true);
           intercentralpanel.remove(sharename);
           intercentralpanel.remove(scrollPane);
           intercentralpanel.remove(sharematename);
           intercentralpanel.remove(shareamount);
           intercentralpanel.remove(sharemateamount);
           
           intercentralpanel.remove(addbutton);
           
             jtf.setEnabled(false);
             flatjtf.setEnabled(false);
             
              
               
             intercentralpanel.revalidate();
             intercentralpanel.repaint();  
                }
               
            }
          
             
             } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Please Enter Number of Amount(money).");
            //System.out.println("String cannot be converted to an integer.");
             }
            
            
        }
    
    }
    
    
   
     public void  addflatinformation()
    {
        fltname=new JTextField[Integer.parseInt( flatjtf.getText())];
        fltdebit=new JTextField[Integer.parseInt( flatjtf.getText())];
        
        flatlabelname=new JLabel[Integer.parseInt( flatjtf.getText())];
        flatlabeldebit=new JLabel[Integer.parseInt( flatjtf.getText())];
              System.out.print(fltname.length);
          textFieldSize = new Dimension(400, 30);
        for(int i=0;i<Integer.parseInt( flatjtf.getText());i++)
        {
            flatlabelname[i] = new JLabel("Enter the name of Flat"+(i+1));
            intercentralpanel.add(flatlabelname[i]);
             fltname[i]=new JTextField();
             fltname[i].setMaximumSize(textFieldSize);
             fltname[i].setPreferredSize(textFieldSize);
           intercentralpanel.add( fltname[i]); 
            
            
            flatlabeldebit[i] = new JLabel("Enter The Flat Cost"+(i+1));
            intercentralpanel.add(flatlabeldebit[i]);
             fltdebit[i]=new JTextField();
             fltdebit[i].setMaximumSize(textFieldSize);
             fltdebit[i].setPreferredSize(textFieldSize);
             intercentralpanel.add( fltdebit[i]); 
        }
          addflat=new JButton("Add");
          intercentralpanel.add(addflat);
          
          addflat.addActionListener(e->{
            try {
                
                checkflatinformation();
            } catch (JSONException ex) {
                Logger.getLogger(CreateProject.class.getName()).log(Level.SEVERE, null, ex);
            }
          });
        
    }
     
     public void checkflatinformation() throws JSONException
     {
         int cc=0;
        for(int i=0;i<Integer.parseInt( flatjtf.getText());i++)
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
             for(int i=0;i<Integer.parseInt( flatjtf.getText());i++)
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
                 for(int i=0;i<Integer.parseInt( flatjtf.getText());i++)
                {

                    fltname[i].setVisible(false);
                    fltdebit[i].setVisible(false);
                    flatlabeldebit[i].setVisible(false);
                    flatlabelname[i].setVisible(false);
                    flatinfo.put(fltname[i].getText(),  fltdebit[i].getText());

                }
             addflat.setVisible(false);
             intercentralpanel.add(addsharemate);
             }
            
            
             
        }
     }
    public void addsharematefun()
    {
        sum=0;
        textFieldSize = new Dimension(400, 30);
        addsharemate.setVisible(false);
        
        sharename=new JLabel("Enter The Name");
        intercentralpanel.add(sharename);
        
        sharematename=new JTextField();
         sharematename.setMaximumSize(textFieldSize);
         sharematename.setPreferredSize(textFieldSize);
        intercentralpanel.add(sharematename);
        
        shareamount=new JLabel("Enter The Share(%)");
        intercentralpanel.add(shareamount);
        
        sharemateamount=new JTextField();
        sharemateamount.setMaximumSize(textFieldSize);
        sharemateamount.setPreferredSize(textFieldSize);
        intercentralpanel.add(sharemateamount);

       
        
        
        
        addbutton=new JButton("Add");
        intercentralpanel.add(addbutton);
         intercentralpanel.add(Box.createVerticalStrut(30));
              shareparshow=new JPanel();
              shareparshow.setLayout(new BoxLayout(shareparshow, BoxLayout.Y_AXIS));
               String[] columnNames = {"Name", "Sum(%)"};
               // Create the table model with no data initially
                 DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
              for (Map.Entry<String, Integer> entry : percentagetest.entrySet()) {
                  // Add data to the table model
                   tableModel.addRow(new Object[]{entry.getKey(),entry.getValue()});
                   sum=sum+entry.getValue();
                }
               tableModel.addRow(new Object[]{"Total",sum});
               JTable table = new JTable(tableModel);
                scrollPane = new JScrollPane(table);
                intercentralpanel.add(scrollPane);
                 intercentralpanel.revalidate();
              
         
        
        addbutton.addActionListener(e->{
            try {
                addbutton();
            } catch (JSONException ex) {
                Logger.getLogger(CreateProject.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(CreateProject.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(CreateProject.class.getName()).log(Level.SEVERE, null, ex);
            }
         });
        
         
    }
    public void center() throws ParseException
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
    
    jtf=new JTextField();
    textFieldSize = new Dimension(400, 30);
    jtf.setMaximumSize(textFieldSize);
    jtf.setPreferredSize(textFieldSize);
    intercentralpanel.add(jtf);
    
    
    
    flatlabel = new JLabel("Enter the number of Flat");
    intercentralpanel.add( flatlabel);
     flatjtf=new JTextField("0");
    textFieldSize = new Dimension(400, 30);
     flatjtf.setMaximumSize(textFieldSize);
     flatjtf.setPreferredSize(textFieldSize);
    intercentralpanel.add( flatjtf);
    
    createflat=new JButton("Add Flat Information");
    intercentralpanel.add( createflat);
    
    createflat.addActionListener(e->{
         try {
            int num = Integer.parseInt(flatjtf.getText());
              if(num>0)
            {
             createflat.setVisible(false);
             flatjtf.setEnabled(false);
              addflatinformation();   
            }
            else
            {
             JOptionPane.showMessageDialog(null, "Please Enter The Flat Number(n>0)"); 
            }
        } catch (NumberFormatException ee) {
             JOptionPane.showMessageDialog(null, "Please Enter The Valid Flat Number (Ex:1234)"); 
        }
       
        
          
    });
    
    
    addsharemate=new JButton("Add ShareMate");
     addsharemate.addActionListener(e->{
         addsharematefun();
     });
    }
   
      public static void main(String[] args) throws ParseException {
     CreateProject window = new  CreateProject("");
     window.setVisible(true);

}


}
