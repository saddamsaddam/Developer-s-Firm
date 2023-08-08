package Registration;
import com.itextpdf.text.Font;
import com.toedter.calendar.JDateChooser;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
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
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;import javax.swing.JButton;import javax.swing.JComboBox;
import javax.swing.JFileChooser;import javax.swing.JFormattedTextField;
import javax.swing.JFrame;import javax.swing.JLabel;import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;import javax.swing.JPanel;import javax.swing.JScrollPane;import javax.swing.JTable;
import javax.swing.JTextField;import javax.swing.table.DefaultTableModel;
import org.jdatepicker.JDatePicker;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.SqlDateModel;
import org.json.JSONArray;
import org.json.JSONException;import org.json.JSONObject;

/**
 *
 * @author saddamnvn
 */
public class Delete extends JFrame {
    
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
       
       HashSet<String> result=new HashSet();
          int fok;
          
    JTextField[] incomefielde;
    JPanel allleft7 ;
    JPanel alltop7 ;
    JPanel allmidle7 ;
    JPanel allright7 ;
    JPanel downloadleft1 ;
    JPanel downloadtop1 ;
    JPanel downloadmidle1 ;
    JPanel downloadright1 ;
     String[] usernamef;
     String[] passwordf;
     String[] rolingf;
     JButton[] deletef;
         JButton cr;
 JButton regis,restore;
    int breaker=0,selectcount=0;
    String sharenamesend;
                                 JSONArray array = new JSONArray();
                                  JSONArray username = new JSONArray();
                                   JSONArray password = new JSONArray();
                                    JSONArray roling = new JSONArray();
                                  JSONArray arraymoney = new JSONArray();
                                   JSONArray type = new JSONArray();
                                  JSONArray arrayincomesource = new JSONArray();
                                   JPanel panel=new JPanel();
    String money1,money2,date1,date2,incomesource1,incomesource2;
     JSONObject json=null ;
          HashSet<String> resultflat=new HashSet();
         HashSet<JMenuItem> jmenuitem=new HashSet();
        JMenu projectname,capital,timeperiod,deleteproject,extraincome,extradebitmenu,editshare,editflat,deleteshare,deleteflat,utilityincome,utilitybill,editsetutility,editincomeutility;
        JMenuItem extradebit;
         JMenu xy,bge;
                               Font aa2vF = new Font(Font.FontFamily.HELVETICA,12f, Font.BOLD );
     Font tat = new Font(Font.FontFamily.HELVETICA, 10 );
    //HomeForm.SimpleBottomLine simpleBottomLine=new HomeForm.SimpleBottomLine();
    validatiocheck vlength = new validatiocheck();
     int lentgthnull, oth=0,othd,count=0,jk=0;
     double ar,br,crk;
     //gap calculate
     double[] regu=new double[4];
     double [] incom=new double[4];
     JMenuItem[] assessmemtyear = new JMenuItem[20];
     JMenuItem[] assessmemtyear1 = new JMenuItem[20];
     JMenuItem[] assessmemtyear2 = new JMenuItem[20];
     JMenuItem[] assessmemtyear3 = new JMenuItem[20];
     JMenuItem[] assessmemtyear4 = new JMenuItem[20];
     JMenuItem[] assessmemtyear5 = new JMenuItem[20];
     JMenuItem[] assessmemtyear6 = new JMenuItem[20];
     
      JMenuItem[] assessmemtyearu = new JMenuItem[20];
     JMenuItem[] assessmemtyear1u = new JMenuItem[20];
     JMenuItem[] assessmemtyear2u = new JMenuItem[20];
     JMenuItem[] assessmemtyear3u = new JMenuItem[20];
     JMenuItem[] assessmemtyear4u = new JMenuItem[20];
     JMenuItem[] assessmemtyear5u = new JMenuItem[20];
     JMenuItem[] assessmemtyear6u = new JMenuItem[20];
     int[] ayear = new int[20];
 JMenu menu;
JButton EXIT;
LocalDateTime cyear = LocalDateTime.now();
int currentyear = (cyear.getYear());
long TIN;
int vis3 = 0;
int[] totalasset = new int[11];
JMenuBar bar = new JMenuBar();

JMenuBar bar4 = new JMenuBar();
JMenu menu4 = new JMenu();

ArrayList<Integer> TaxPayment = new ArrayList<Integer>();
String[] salary1 = new String[17];
String[] houseproperty = new String[17];
String[] taxdibate = new String[17];
String[] familyexpense = new String[17];
String[] registrationreturn = new String[21];
String[] assetliabilityreturn = new String[21];
String[] taxcount = new String[21];
int sumsalary = 0, taxfreeincome = 0, housepropertysum = 0, taxsum = 0, taxpaymentsum = 0;
double taxpayable = 0;
double sum1_9 = 0;
ArrayList<Integer> taxpayment = new ArrayList();
double[] leftpart = new double[9];
double[] rightpart = new double[10];

validatiocheck ch = new validatiocheck();
long text;
JTable table = new JTable();
    public Delete(String role) throws ParseException
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
    
   
     public void  addflatinformation()
    {
        flatinfo=connection.getsharemateprojectflatinfo(prn);
        
        
        fltname=new JTextField[Integer.parseInt( flatjtf.getText())];
        fltdebit=new JTextField[Integer.parseInt( flatjtf.getText())];
        
        flatlabelname=new JLabel[Integer.parseInt( flatjtf.getText())];
        flatlabeldebit=new JLabel[Integer.parseInt( flatjtf.getText())];
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
                Logger.getLogger(Delete.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Delete.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(Delete.class.getName()).log(Level.SEVERE, null, ex);
            }
          });
        
    }
     
     public void checkflatinformation() throws JSONException, ClassNotFoundException, SQLException
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
                 flatinfo=connection.getsharemateprojectflatinfo(prn);
                 for(int i=0;i<Integer.parseInt( flatjtf.getText());i++)
                {

                    fltname[i].setVisible(false);
                    fltdebit[i].setVisible(false);
                    flatlabeldebit[i].setVisible(false);
                    flatlabelname[i].setVisible(false);
                    flatinfo.put(fltname[i].getText(),  fltdebit[i].getText());

                }
                 
                 System.out.println(flatinfo);
                 addflat.setVisible(false);
                 connection.updateflatinfo(prn,flatinfo);
                 HomeForm hh = new HomeForm(role);
                 hh.setVisible(true);
                 dispose();
             }
            
            
             
        }
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
    deletebody();

    }
    public void deletebody()
{
     menu = new JMenu("Delete             ");
        menu.setPreferredSize(new Dimension(200, 30)); // Set preferred size
        menu.setMaximumSize(new Dimension(300, 30)); // Set maximum size

    bar = new JMenuBar();
    
    projectname=new JMenu("Delete Income From Flat:");
    capital=new JMenu("Delete Project Description");
    deleteproject=new JMenu("Delete Project");
    editsetutility=new JMenu("Delete set Utility & Others");
    editincomeutility=new JMenu("Delete Income Utility & Others");
     result=connection.getsharemateprojectname();
     result.forEach(e->{
          deleteproject.add(new JMenuItem(e));
         json=connection.getsharemateprojectflatinfo(e);
         JMenu flatname=new JMenu(e);
         JMenu flatname1=new JMenu(e);
           JMenu flatname2=new JMenu(e);
         Iterator<String> keys = json.keys();
         String line;
             while(keys.hasNext())
             {
                 String txt=keys.next();
                 JMenu flt=new JMenu(txt);
                  JMenu flt1=new JMenu(txt);
                   JMenu flt2=new JMenu(txt);
                  resultflat=connection.getsharemateprojectflatdate(e,txt);
                  if(resultflat.size()>0)
                  {
                     resultflat.forEach(ff->{ 
                         flt.add( new JMenuItem(ff));
                     });
                     
                  }

                  flatname.add(flt);
                  
                   resultflat=connection.getsetutilitydate(e,txt);
                  if(resultflat.size()>0)
                  {
                     resultflat.forEach(ff->{ 
                         flt1.add( new JMenuItem(ff));
                     });
                     
                  }
                   flatname1.add(flt1);
                   resultflat=connection.getincomeutilitydate(e,txt);
                  if(resultflat.size()>0)
                  {
                     resultflat.forEach(ff->{ 
                         flt2.add( new JMenuItem(ff));
                     });
                     
                  }
                    flatname2.add(flt2);
             }
         
          projectname.add(flatname);
          editsetutility.add( flatname1);
          editincomeutility.add( flatname2);
          JMenu projectinfo=new JMenu(e);
          resultflat=connection.getsharemateprojectcapital(e);
          JMenu projectcapital=new JMenu("Capital");
          if(resultflat.size()>0)
                  {
                     resultflat.forEach(ff->{ 
                         projectcapital.add( new JMenuItem(ff));
                     });
                     
                  }
          
           projectinfo.add((projectcapital));
           // projectinfo=new JMenu(e);
          resultflat=connection.getsharemateprojectwithdraw(e);
         JMenu  projectwithdraw=new JMenu("Widthraw");
          if(resultflat.size()>0)
                  {
                     resultflat.forEach(ff->{ 
                         projectwithdraw.add( new JMenuItem(ff));
                     });
                     
                  }
          
           projectinfo.add( projectwithdraw);
           
           resultflat=connection.getsharemateprojectdebit(e);
          JMenu  projectdebit=new JMenu("Debit");
          if(resultflat.size()>0)
                  {
                     resultflat.forEach(ff->{ 
                        projectdebit.add( new JMenuItem(ff));
                     });
                     
                  }
                     projectinfo.add(projectdebit);
                     
           resultflat=connection.getothersincomedate(e);
           JMenu  others=new JMenu("Others Income");
          if(resultflat.size()>0)
                  {
                     resultflat.forEach(ff->{ 
                        others.add( new JMenuItem(ff));
                     });
                     
                  }
          
           
           projectinfo.add(others);
          capital.add(projectinfo);
     });
    //add project income and capital
           resultflat=connection.extradebitdate();
           JMenu  others=new JMenu("Others Debit");
          if(resultflat.size()>0)
                  {
                     resultflat.forEach(ff->{ 
                        others.add( new JMenuItem(ff));
                     });
                     
                  }
    menu.add(projectname);
    menu.add(capital);
    menu.add( deleteproject);
    menu.add(others);
    menu.add(editsetutility);
    menu.add(editincomeutility);
   
    bar4 = new JMenuBar();
    bar4.add(menu);
    setJMenuBar(bar4);
 
    //centreleft_6_top.add(bar4);

    intercentralpanel.add(bar4);
   // allright6.add(alljl4);
    
    xy= (JMenu) menu.getItem(0);//change
     count=xy.getItemCount();
     for(int i=0;i<count;i++)
     {
                JMenu xyz=(JMenu) xy.getItem(i);//prn name
                String prn=xy.getItem(i).getText();
                  int cc=xyz.getItemCount();
                  for(int j=0;j<cc;j++)
                    {
                         JMenu xyzd=(JMenu) xyz.getItem(j);// flatname
                          String flt=xyz.getItem(j).getText();
                         int ccc=xyzd.getItemCount();
                         bge=xyzd;
                         for(int k=0;k<ccc;k++)
                         {
                                   int gg=k;
                                   bge.getItem(k).addActionListener(e->{
                                   array = new JSONArray();
                                   jsondata = new JSONObject();
                                   arraymoney = new JSONArray();
                                   arrayincomesource = new JSONArray();
                                   
                                  try {
                                     // JSONObject json = new JSONObject();
                                      json=connection.getsharemateprojecteditinfo(prn,flt,e.getActionCommand());
                                     // System.out.println(json);
                                             array=new JSONArray(json.getString("data"));
                                     // System.out.println(array.length());
                                      panel = new JPanel(new GridLayout(2, 1, 0, 0));
                                      JPanel panelone = new JPanel(new GridLayout(array.length(), 11, 5, 5));
                                      JPanel paneltwo = new JPanel(new GridLayout(1, 1, 0, 0));// 0 rows, 4 columns
                                     JTextField[] incomefield=new   JTextField[array.length()]; 
                                      JTextField[] incomemoneyfield=new JTextField[array.length()]; 
                                       JDateChooser[] endDateChooser = new JDateChooser[array.length()];
                                       String[] moneyc=new String [array.length()];
                                       String[] source=new String [array.length()];
                                       String[] date=new String [array.length()];
                                        JButton[] Edit=new JButton[array.length()];
                                        
                                        for(int ii=0;ii<array.length();ii++)
                                  {
                                      
                                          jsondata=new JSONObject(array.getString(ii));
                                          arraymoney=new JSONArray(jsondata.getString("money"));
                                          arrayincomesource=new JSONArray(jsondata.getString("incomesource"));
                                          moneyc[ii]=arraymoney.getString(0);
                                            source[ii]= arrayincomesource.getString(0);
                                            date[ii]=e.getActionCommand();
                                JLabel incomeprojectname=new JLabel("Project Name: ");
                                JTextField incomeprojecnamee= new JTextField(prn);
                                incomeprojecnamee.setEnabled(false);
                                panelone.add(incomeprojectname);
                                panelone.add(incomeprojecnamee);

                                JLabel flatname=new JLabel("Flat Name: ");
                                JTextField flatnamee= new JTextField(flt);
                                flatnamee.setEnabled(false);
                                panelone.add(flatname);
                                panelone.add(flatnamee);

                                JLabel incomesorce=new JLabel("Income Source: ");
                                incomefield[ii]= new JTextField(arrayincomesource.getString(0));
                                panelone.add(incomesorce);
                                panelone.add(incomefield[ii]);

                                JLabel incomemoney=new JLabel("    Money: ");
                                incomemoneyfield[ii]= new JTextField(arraymoney.getString(0));
                                panelone.add(incomemoney);
                                panelone.add(incomemoneyfield[ii]);

                                 JLabel incomedate=new JLabel("    Date: ");


                                  endDateChooser[ii] = new JDateChooser();
                                  endDateChooser[ii].setPreferredSize(new java.awt.Dimension(110,0));
                                  endDateChooser[ii].setDateFormatString("yyyy-MM-dd");
                                    try {
                                        endDateChooser[ii].setDate(new SimpleDateFormat("yyyy-MM-dd").parse(e.getActionCommand()));
                                    } catch (ParseException ex) {
                                        Logger.getLogger(HomeForm.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                java.awt.Font font =  endDateChooser[ii].getFont();
                                float newSize = font.getSize() + 4; // Increase the font size by 4
                                endDateChooser[ii].setFont(font.deriveFont(newSize));
                                 panelone.add(incomedate);
                                 panelone.add(endDateChooser[ii]);

                                 Edit[ii]=new JButton("Delete  ");
                                 panelone.add(Edit[ii]);
                               
                                 
                                // Password label and text field
                                JLabel passwordLabel = new JLabel();
                                paneltwo.add(passwordLabel);
                                 panel.add(panelone);
                                 panel.add(paneltwo);
                                 
                                       
                                  }
                                    for(int n=0;n<array.length();n++)
                                    {
                                        int jk=n;
                                         Edit[n].addActionListener(u->{ 
                                      //String olddate,String newdate
                                      System.out.println(new SimpleDateFormat("yyyy-MM-dd").format( endDateChooser[jk].getDate()));
                                              try {
                                                  connection.deleteUpdate(prn,flt,moneyc[jk],incomemoneyfield[jk].getText(), source[jk],incomefield[jk].getText(),date[jk],new SimpleDateFormat("yyyy-MM-dd").format( endDateChooser[jk].getDate()).toString());
                                               
                                                  Edit[jk].setEnabled(false);
                                                  intercentralpanel.removeAll();
                                                  intercentralpanel.revalidate();
                                                  intercentralpanel.repaint();
                                                    deletebody();
                                                   
                                                   // panel.revalidate();
                                                    
                                                   // panel.p

                                              } catch (ClassNotFoundException ex) {
                                                  Logger.getLogger(HomeForm.class.getName()).log(Level.SEVERE, null, ex);
                                              } catch (SQLException ex) {
                                                  Logger.getLogger(HomeForm.class.getName()).log(Level.SEVERE, null, ex);
                                              }
                                  });

                                    }
                                        
                                JScrollPane scrollPane = new JScrollPane(panel);
                                  scrollPane.setPreferredSize(panel.getPreferredSize());
                                  int option = JOptionPane.showOptionDialog(null, scrollPane, "Single day information",
                                           JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, null, null);

                                   if (option == JOptionPane.OK_OPTION) {
                                   scrollPane.removeAll(); // Remove all components from the panel
                                    scrollPane.revalidate(); // Revalidate the panel to reflect the changes
                                  scrollPane.repaint();
                                   }                               
                              
                              
                                           
                                     
                                  } catch (JSONException ex) {
                                      Logger.getLogger(HomeForm.class.getName()).log(Level.SEVERE, null, ex);
                                  }
                                
                               
                              
                            
                            });
                             
                         }
                        
                    
                    }
     }
    
     
       xy= (JMenu) menu.getItem(1);//change
     count=xy.getItemCount();
     for(int i=0;i<count;i++)
     {
                JMenu xyz=(JMenu) xy.getItem(i);//prn name
                String prn=xy.getItem(i).getText();
                  int cc=xyz.getItemCount();
                  for(int j=0;j<cc;j++)
                    {
                         JMenu xyzd=(JMenu) xyz.getItem(j);// flatname
                          String flt=xyz.getItem(j).getText();
                         int ccc=xyzd.getItemCount();
                         bge=xyzd;
                         for(int k=0;k<ccc;k++)
                         {
                              int gg=k;
                              bge.getItem(k).addActionListener(e->{
                              System.out.println(xyzd.getItem(gg).getText());
                                array = new JSONArray();
                                   jsondata = new JSONObject();
                                   arraymoney = new JSONArray();
                                   arrayincomesource = new JSONArray();
                                   
                                  try {
                                      JSONObject json = new JSONObject();
                                      json=connection.getsharemateprojecteditinfocapital(prn,flt,e.getActionCommand());
                                     // System.out.println(json);
                                     array=new JSONArray(json.getString("data"));
                                     // System.out.println(array.length());
                                      panel = new JPanel(new GridLayout(2, 1, 0, 0));
                                      JPanel panelone = new JPanel(new GridLayout(array.length(), 11, 5, 5));
                                      JPanel paneltwo = new JPanel(new GridLayout(1, 1, 0, 0));// 0 rows, 4 columns
                                     JTextField[] incomefield=new   JTextField[array.length()]; 
                                      JTextField[] incomemoneyfield=new JTextField[array.length()]; 
                                       JDateChooser[] endDateChooser = new JDateChooser[array.length()];
                                       String[] moneyc=new String [array.length()];
                                       String[] source=new String [array.length()];
                                       String[] date=new String [array.length()];
                                        JButton[] Edit=new JButton[array.length()];
                                        
                                        for(int ii=0;ii<array.length();ii++)
                                  {
                                      
                                          jsondata=new JSONObject(array.getString(ii));
                                          arraymoney=new JSONArray(jsondata.getString("money"));
                                          arrayincomesource=new JSONArray(jsondata.getString("incomesource"));
                                          moneyc[ii]=arraymoney.getString(0);
                                            source[ii]= arrayincomesource.getString(0);
                                            date[ii]=e.getActionCommand();
                                JLabel incomeprojectname=new JLabel("Project Name: ");
                                JTextField incomeprojecnamee= new JTextField(prn);
                                incomeprojecnamee.setEnabled(false);
                                panelone.add(incomeprojectname);
                                panelone.add(incomeprojecnamee);

                                JLabel flatname=new JLabel("Type : ");
                                JTextField flatnamee= new JTextField(flt);
                                flatnamee.setEnabled(false);
                                panelone.add(flatname);
                                panelone.add(flatnamee);
                                 selectcount=0;
                                JLabel incomesorce=new JLabel("Source: ");
                                incomefield[ii]= new JTextField(arrayincomesource.getString(0));
                                panelone.add(incomesorce);
                                panelone.add(incomefield[ii]);

                                JLabel incomemoney=new JLabel("    Money: ");
                                incomemoneyfield[ii]= new JTextField(arraymoney.getString(0));
                                panelone.add(incomemoney);
                                panelone.add(incomemoneyfield[ii]);

                                 JLabel incomedate=new JLabel("    Date: ");


                                  endDateChooser[ii] = new JDateChooser();
                                  endDateChooser[ii].setPreferredSize(new java.awt.Dimension(120,0));
                                  endDateChooser[ii].setDateFormatString("yyyy-MM-dd");
                                    try {
                                        endDateChooser[ii].setDate(new SimpleDateFormat("yyyy-MM-dd").parse(e.getActionCommand()));
                                    } catch (ParseException ex) {
                                        Logger.getLogger(HomeForm.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                java.awt.Font font =  endDateChooser[ii].getFont();
                                float newSize = font.getSize() + 4; // Increase the font size by 4
                                endDateChooser[ii].setFont(font.deriveFont(newSize));
                                 panelone.add(incomedate);
                                 panelone.add(endDateChooser[ii]);

                                 Edit[ii]=new JButton("Delete  ");
                                 panelone.add(Edit[ii]);
                               
                                 
                                // Password label and text field
                                JLabel passwordLabel = new JLabel();
                                paneltwo.add(passwordLabel);
                                 panel.add(panelone);
                                 panel.add(paneltwo);
                                 
                                       
                                  }
                                    for(int n=0;n<array.length();n++)
                                    {
                                        int jk=n;
                                         Edit[n].addActionListener(u->{ 
                                      //String olddate,String newdate
                                      System.out.println(new SimpleDateFormat("yyyy-MM-dd").format( endDateChooser[jk].getDate()));
                                              try {
                                                  connection.deletecapitalUpdate(prn,flt,moneyc[jk],incomemoneyfield[jk].getText(), source[jk],incomefield[jk].getText(),date[jk],new SimpleDateFormat("yyyy-MM-dd").format( endDateChooser[jk].getDate()).toString());
                                                  Edit[jk].setEnabled(false);
                                                    intercentralpanel.removeAll();
                                                  intercentralpanel.revalidate();
                                                  intercentralpanel.repaint();
                                                    deletebody();
                                                    
                                              } catch (ClassNotFoundException ex) {
                                                  Logger.getLogger(HomeForm.class.getName()).log(Level.SEVERE, null, ex);
                                              } catch (SQLException ex) {
                                                  Logger.getLogger(HomeForm.class.getName()).log(Level.SEVERE, null, ex);
                                              }
                                  });

                                    }
                                        
                                JScrollPane scrollPane = new JScrollPane(panel);
                                  scrollPane.setPreferredSize(panel.getPreferredSize());
                                  int option = JOptionPane.showOptionDialog(null, scrollPane, "Single day information",
                                           JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, null, null);

                                   if (option == JOptionPane.OK_OPTION) {
                                   scrollPane.removeAll(); // Remove all components from the panel
                                    scrollPane.revalidate(); // Revalidate the panel to reflect the changes
                                  scrollPane.repaint();
                                   }                               
                              
                              
                                           
                                     
                                  } catch (JSONException ex) {
                                      Logger.getLogger(HomeForm.class.getName()).log(Level.SEVERE, null, ex);
                                  }
                                
                               
                              
                            
                            
                              
                            
                            });
                             
                         }
                        
                    
                    }
                  
     }
      xy= (JMenu) menu.getItem(2);//change
     count=xy.getItemCount();
     for(int i=0;i<count;i++)
     {
        xy.getItem(i).addActionListener(e->{
                  System.out.println(e.getActionCommand());
            try {
                connection.projectdelete(e.getActionCommand());
                
                deletebody();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(HomeForm.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(HomeForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
     
     }
       xy= (JMenu) menu.getItem(3);//change
     count=xy.getItemCount();
     for(int i=0;i<count;i++)
     {
                xy.getItem(i).addActionListener(e->{
                                    array = new JSONArray();
                                   jsondata = new JSONObject();
                                   arraymoney = new JSONArray();
                                   arrayincomesource = new JSONArray();
                                   
                                  try {
                                      JSONObject json = new JSONObject();
                                      json=connection.extradebit(e.getActionCommand());
                                     // System.out.println(json);
                                       array=new JSONArray(json.getString("data"));
                                     // System.out.println(array.length());
                                      panel = new JPanel(new GridLayout(2, 1, 0, 0));
                                      JPanel panelone = new JPanel(new GridLayout(array.length(), 11, 5, 5));
                                      JPanel paneltwo = new JPanel(new GridLayout(1, 1, 0, 0));// 0 rows, 4 columns
                                     JTextField[] incomefield=new   JTextField[array.length()]; 
                                      JTextField[] incomemoneyfield=new JTextField[array.length()]; 
                                       JDateChooser[] endDateChooser = new JDateChooser[array.length()];
                                       String[] moneyc=new String [array.length()];
                                       String[] source=new String [array.length()];
                                       String[] date=new String [array.length()];
                                        JButton[] Edit=new JButton[array.length()];
                                        
                                        for(int ii=0;ii<array.length();ii++)
                                  {
                                      
                                          jsondata=new JSONObject(array.getString(ii));
                                          arraymoney=new JSONArray(jsondata.getString("money"));
                                          arrayincomesource=new JSONArray(jsondata.getString("incomesource"));
                                          moneyc[ii]=arraymoney.getString(0);
                                            source[ii]= arrayincomesource.getString(0);
                                            date[ii]=e.getActionCommand();
                                JLabel incomeprojectname=new JLabel("Name: ");
                                JTextField incomeprojecnamee= new JTextField("All Project");
                                incomeprojecnamee.setEnabled(false);
                                panelone.add(incomeprojectname);
                                panelone.add(incomeprojecnamee);

                                JLabel flatname=new JLabel("Type : ");
                                JTextField flatnamee= new JTextField("extra");
                                flatnamee.setEnabled(false);
                                panelone.add(flatname);
                                panelone.add(flatnamee);

                                JLabel incomesorce=new JLabel("Source: ");
                                incomefield[ii]= new JTextField(arrayincomesource.getString(0));
                                panelone.add(incomesorce);
                                panelone.add(incomefield[ii]);

                                JLabel incomemoney=new JLabel("    Money: ");
                                incomemoneyfield[ii]= new JTextField(arraymoney.getString(0));
                                panelone.add(incomemoney);
                                panelone.add(incomemoneyfield[ii]);

                                 JLabel incomedate=new JLabel("    Date: ");


                                  endDateChooser[ii] = new JDateChooser();
                                  endDateChooser[ii].setPreferredSize(new java.awt.Dimension(110,0));
                                  endDateChooser[ii].setDateFormatString("yyyy-MM-dd");
                                    try {
                                        endDateChooser[ii].setDate(new SimpleDateFormat("yyyy-MM-dd").parse(e.getActionCommand()));
                                    } catch (ParseException ex) {
                                        Logger.getLogger(HomeForm.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                java.awt.Font font =  endDateChooser[ii].getFont();
                                float newSize = font.getSize() + 4; // Increase the font size by 4
                                endDateChooser[ii].setFont(font.deriveFont(newSize));
                                 panelone.add(incomedate);
                                 panelone.add(endDateChooser[ii]);

                                 Edit[ii]=new JButton("Delete");
                                 panelone.add(Edit[ii]);
                               
                                 
                                // Password label and text field
                                JLabel passwordLabel = new JLabel();
                                paneltwo.add(passwordLabel);
                                 panel.add(panelone);
                                 panel.add(paneltwo);
                                 
                                       
                                  }
                                    for(int n=0;n<array.length();n++)
                                    {
                                        int jk=n;
                                         Edit[n].addActionListener(u->{ 
                                                if(incomemoneyfield[jk].getText().isBlank()||incomefield[jk].getText().isBlank())
                                                {
                                                              JOptionPane.showMessageDialog(null, "Please Fill Up all The Record ");   

                                                }
                                                else
                                                {
                                                  try{
                                                   Integer.parseInt(incomemoneyfield[jk].getText());
                                                   connection.deletecapitalUpdate(" ","Extradebit",moneyc[jk],incomemoneyfield[jk].getText(), source[jk],incomefield[jk].getText(),date[jk],new SimpleDateFormat("yyyy-MM-dd").format( endDateChooser[jk].getDate()).toString());
                                                   Edit[jk].setEnabled(false);
                                                    intercentralpanel.removeAll();
                                                  intercentralpanel.revalidate();
                                                  intercentralpanel.repaint();
                                                    deletebody();
                                                    }catch(NumberFormatException ee)
                                                    {
                                                     JOptionPane.showMessageDialog(null, "Please Enter Number of Amount(money).");

                                                    } catch (ClassNotFoundException ex) {
                                              Logger.getLogger(HomeForm.class.getName()).log(Level.SEVERE, null, ex);
                                          } catch (SQLException ex) {
                                              Logger.getLogger(HomeForm.class.getName()).log(Level.SEVERE, null, ex);
                                          }
                                                }
                                             
                                    });

                                    }
                                        
                                JScrollPane scrollPane = new JScrollPane(panel);
                                  scrollPane.setPreferredSize(panel.getPreferredSize());
                                  int option = JOptionPane.showOptionDialog(null, scrollPane, "Single day information",
                                           JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, null, null);

                                   if (option == JOptionPane.OK_OPTION) {
                                   scrollPane.removeAll(); // Remove all components from the panel
                                    scrollPane.revalidate(); // Revalidate the panel to reflect the changes
                                  scrollPane.repaint();
                                   }                               
                              
                              
                                           
                                     
                                  } catch (JSONException ex) {
                                      Logger.getLogger(HomeForm.class.getName()).log(Level.SEVERE, null, ex);
                                  }
                                
                               
     });
    }
    
     xy= (JMenu) menu.getItem(4);//change
     count=xy.getItemCount();
     for(int i=0;i<count;i++)
     {
                JMenu xyz=(JMenu) xy.getItem(i);//prn name
                String prn=xy.getItem(i).getText();
                  int cc=xyz.getItemCount();
                  for(int j=0;j<cc;j++)
                    {
                         JMenu xyzd=(JMenu) xyz.getItem(j);// flatname
                          String flt=xyz.getItem(j).getText();
                         int ccc=xyzd.getItemCount();
                         bge=xyzd;
                         for(int k=0;k<ccc;k++)
                         {
                                   int gg=k;
                                   bge.getItem(k).addActionListener(e->{
                                   array = new JSONArray();
                                   jsondata = new JSONObject();
                                   arraymoney = new JSONArray();
                                   arrayincomesource = new JSONArray();
                                   
                                  try {
                                      JSONObject json = new JSONObject();
                                      json=connection.setutilityeditinfo(prn,flt,e.getActionCommand());
                                     // System.out.println(json);
                                             array=new JSONArray(json.getString("data"));
                                     // System.out.println(array.length());
                                      panel = new JPanel(new GridLayout(2, 1, 0, 0));
                                      panel.setPreferredSize(new Dimension(1200, 200));
                                      JPanel panelone = new JPanel(new GridLayout(array.length(), 11, 5, 5));
                                      JPanel paneltwo = new JPanel(new GridLayout(1, 1, 0, 0));// 0 rows, 4 columns
                                     JTextField[] incomefield=new   JTextField[array.length()];
                                      JTextField[] typefield=new   JTextField[array.length()];
                                      JTextField[] incomemoneyfield=new JTextField[array.length()]; 
                                       JDateChooser[] endDateChooser = new JDateChooser[array.length()];
                                       String[] moneyc=new String [array.length()];
                                        String[] typedata=new String [array.length()];
                                       String[] source=new String [array.length()];
                                       String[] date=new String [array.length()];
                                        JButton[] Edit=new JButton[array.length()];
                                        
                                        for(int ii=0;ii<array.length();ii++)
                                  {
                                      
                                          jsondata=new JSONObject(array.getString(ii));
                                          arraymoney=new JSONArray(jsondata.getString("money"));
                                           type=new JSONArray(jsondata.getString("type"));
                                          arrayincomesource=new JSONArray(jsondata.getString("incomesource"));
                                          moneyc[ii]=arraymoney.getString(0);
                                           typedata[ii]=type.getString(0);
                                            source[ii]= arrayincomesource.getString(0);
                                            date[ii]=e.getActionCommand();
                                                                            
                                

                                JLabel flatname=new JLabel("Flat Name: ");
                                JTextField flatnamee= new JTextField(flt);
                                flatnamee.setEnabled(false);
                                panelone.add(flatname);
                                panelone.add(flatnamee);
                                
                                JLabel incomeprojectname=new JLabel("Type: ");
                                 typefield[ii]= new JTextField( typedata[ii]);
                                
                                 JComboBox<String> comboBox = new JComboBox<>();
                                Dimension preferredSize = new Dimension(90, 0);
                                comboBox.setMaximumSize(preferredSize);
                                comboBox.setPreferredSize(preferredSize);
                                comboBox.addItem("Utility");
                                comboBox.addItem("Other");
                                
                                panelone.add(incomeprojectname);
                                panelone.add(comboBox); 
                                comboBox.setSelectedItem( typedata[ii]);
                                   comboBox.addActionListener(new ActionListener() {
                                      int lp=fok; 
                                    public void actionPerformed(ActionEvent e) {
                                        JComboBox<String> source = (JComboBox<String>) e.getSource();
                                        sharenamesend = (String) source.getSelectedItem();
                                         typefield[lp].setText( sharenamesend);
                                    }
                                });
                               // incomefielde[ii].setVisible(false);


                                JLabel incomesorce=new JLabel("Income Source: ");
                                incomefield[ii]= new JTextField(arrayincomesource.getString(0));
                                panelone.add(incomesorce);
                                panelone.add(incomefield[ii]);

                                JLabel incomemoney=new JLabel("    Money: ");
                                incomemoneyfield[ii]= new JTextField(arraymoney.getString(0));
                                panelone.add(incomemoney);
                                panelone.add(incomemoneyfield[ii]);

                                 JLabel incomedate=new JLabel("    Date: ");


                                  endDateChooser[ii] = new JDateChooser();
                                  endDateChooser[ii].setPreferredSize(new java.awt.Dimension(130,0));
                                  endDateChooser[ii].setDateFormatString("yyyy-MM-dd");
                                    try {
                                        endDateChooser[ii].setDate(new SimpleDateFormat("yyyy-MM-dd").parse(e.getActionCommand()));
                                    } catch (ParseException ex) {
                                        Logger.getLogger(HomeForm.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                java.awt.Font font =  endDateChooser[ii].getFont();
                                float newSize = font.getSize() + 4; // Increase the font size by 4
                                endDateChooser[ii].setFont(font.deriveFont(newSize));
                                 panelone.add(incomedate);
                                 panelone.add(endDateChooser[ii]);

                                 Edit[ii]=new JButton("Delete  ");
                                 panelone.add(Edit[ii]);
                               
                                 
                                // Password label and text field
                                JLabel passwordLabel = new JLabel();
                                paneltwo.add(passwordLabel);
                                 panel.add(panelone);
                                 panel.add(paneltwo);
                                 
                                       
                                  }
                                    for(int n=0;n<array.length();n++)
                                    {
                                        int jk=n;
                                         Edit[n].addActionListener(u->{ 
                                             
                                              if(incomemoneyfield[jk].getText().isBlank()||incomefield[jk].getText().isBlank())
                                                {
                                                              JOptionPane.showMessageDialog(null, "Please Fill Up all The Record ");   

                                                }
                                                else
                                                {
                                                  try{
                                                   Integer.parseInt(incomemoneyfield[jk].getText());
                                                   connection.setutilitydelete(prn,flt,moneyc[jk],incomemoneyfield[jk].getText(), source[jk],incomefield[jk].getText(),date[jk],new SimpleDateFormat("yyyy-MM-dd").format( endDateChooser[jk].getDate()).toString(), typedata[jk], typefield[jk].getText());
                                                   Edit[jk].setEnabled(false);
                                                    
                                                  intercentralpanel.removeAll();
                                                  intercentralpanel.revalidate();
                                                  intercentralpanel.repaint();
                                                    deletebody();
                                                    }catch(NumberFormatException ee)
                                                    {
                                                     JOptionPane.showMessageDialog(null, "Please Enter Number of Amount(money).");

                                                    } catch (ClassNotFoundException ex) {
                                              Logger.getLogger(HomeForm.class.getName()).log(Level.SEVERE, null, ex);
                                          } catch (SQLException ex) {
                                              Logger.getLogger(HomeForm.class.getName()).log(Level.SEVERE, null, ex);
                                          }
                                                }
                                             
                                             
                                  });

                                    }
                                        
                                JScrollPane scrollPane = new JScrollPane(panel);
                                  scrollPane.setPreferredSize(panel.getPreferredSize());
                                  int option = JOptionPane.showOptionDialog(null, scrollPane, "Project Name -> "+prn,
                                           JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, null, null);

                                   if (option == JOptionPane.OK_OPTION) {
                                   scrollPane.removeAll(); // Remove all components from the panel
                                    scrollPane.revalidate(); // Revalidate the panel to reflect the changes
                                  scrollPane.repaint();
                                   }                               
                              
                              
                                           
                                     
                                  } catch (JSONException ex) {
                                      Logger.getLogger(HomeForm.class.getName()).log(Level.SEVERE, null, ex);
                                  }
                                
                               
                              
                            
                            });
                             
                         }
                        
                    
                    }
     }
        xy= (JMenu) menu.getItem(5);//change
     count=xy.getItemCount();
     for(int i=0;i<count;i++)
     {
                JMenu xyz=(JMenu) xy.getItem(i);//prn name
                String prn=xy.getItem(i).getText();
                  int cc=xyz.getItemCount();
                  for(int j=0;j<cc;j++)
                    {
                         JMenu xyzd=(JMenu) xyz.getItem(j);// flatname
                          String flt=xyz.getItem(j).getText();
                         int ccc=xyzd.getItemCount();
                         bge=xyzd;
                         for(int k=0;k<ccc;k++)
                         {
                                   int gg=k;
                                   bge.getItem(k).addActionListener(e->{
                                   array = new JSONArray();
                                   jsondata = new JSONObject();
                                   arraymoney = new JSONArray();
                                   arrayincomesource = new JSONArray();
                                   
                                  try {
                                      JSONObject json = new JSONObject();
                                      json=connection.incomeutilityeditinfo(prn,flt,e.getActionCommand());
                                     // System.out.println(json);
                                             array=new JSONArray(json.getString("data"));
                                     // System.out.println(array.length());
                                      panel = new JPanel(new GridLayout(2, 1, 0, 0));
                                      panel.setPreferredSize(new Dimension(1200, 200));
                                      JPanel panelone = new JPanel(new GridLayout(array.length(), 11, 5, 5));
                                      JPanel paneltwo = new JPanel(new GridLayout(1, 1, 0, 0));// 0 rows, 4 columns
                                     JTextField[] incomefield=new   JTextField[array.length()];
                                      JTextField[] typefield=new   JTextField[array.length()];
                                      JTextField[] incomemoneyfield=new JTextField[array.length()]; 
                                       JDateChooser[] endDateChooser = new JDateChooser[array.length()];
                                       String[] moneyc=new String [array.length()];
                                        String[] typedata=new String [array.length()];
                                       String[] source=new String [array.length()];
                                       String[] date=new String [array.length()];
                                        JButton[] Edit=new JButton[array.length()];
                                        
                                        for(int ii=0;ii<array.length();ii++)
                                  {
                                      
                                          jsondata=new JSONObject(array.getString(ii));
                                          arraymoney=new JSONArray(jsondata.getString("money"));
                                           type=new JSONArray(jsondata.getString("type"));
                                          arrayincomesource=new JSONArray(jsondata.getString("incomesource"));
                                          moneyc[ii]=arraymoney.getString(0);
                                           typedata[ii]=type.getString(0);
                                            source[ii]= arrayincomesource.getString(0);
                                            date[ii]=e.getActionCommand();
                                                                            
                                

                                JLabel flatname=new JLabel("Flat Name: ");
                                JTextField flatnamee= new JTextField(flt);
                                flatnamee.setEnabled(false);
                                panelone.add(flatname);
                                panelone.add(flatnamee);
                                
                                JLabel incomeprojectname=new JLabel("Type: ");
                                 typefield[ii]= new JTextField( typedata[ii]);
                                
                                 JComboBox<String> comboBox = new JComboBox<>();
                                Dimension preferredSize = new Dimension(90, 0);
                                comboBox.setMaximumSize(preferredSize);
                                comboBox.setPreferredSize(preferredSize);
                                 comboBox.addItem("Utility");
                                  comboBox.addItem("Other");
                                
                                panelone.add(incomeprojectname);
                                panelone.add(comboBox); 
                                comboBox.setSelectedItem( typedata[ii]);
                                   comboBox.addActionListener(new ActionListener() {
                                      int lp=fok; 
                                    public void actionPerformed(ActionEvent e) {
                                        JComboBox<String> source = (JComboBox<String>) e.getSource();
                                        sharenamesend = (String) source.getSelectedItem();
                                         typefield[lp].setText( sharenamesend);
                                    }
                                });
                               // incomefielde[ii].setVisible(false);


                                JLabel incomesorce=new JLabel("Income Source: ");
                                incomefield[ii]= new JTextField(arrayincomesource.getString(0));
                                panelone.add(incomesorce);
                                panelone.add(incomefield[ii]);

                                JLabel incomemoney=new JLabel("    Money: ");
                                incomemoneyfield[ii]= new JTextField(arraymoney.getString(0));
                                panelone.add(incomemoney);
                                panelone.add(incomemoneyfield[ii]);

                                 JLabel incomedate=new JLabel("    Date: ");


                                  endDateChooser[ii] = new JDateChooser();
                                  endDateChooser[ii].setPreferredSize(new java.awt.Dimension(130,0));
                                  endDateChooser[ii].setDateFormatString("yyyy-MM-dd");
                                    try {
                                        endDateChooser[ii].setDate(new SimpleDateFormat("yyyy-MM-dd").parse(e.getActionCommand()));
                                    } catch (ParseException ex) {
                                        Logger.getLogger(HomeForm.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                java.awt.Font font =  endDateChooser[ii].getFont();
                                float newSize = font.getSize() + 4; // Increase the font size by 4
                                endDateChooser[ii].setFont(font.deriveFont(newSize));
                                 panelone.add(incomedate);
                                 panelone.add(endDateChooser[ii]);

                                 Edit[ii]=new JButton("Delete  ");
                                 panelone.add(Edit[ii]);
                               
                                 
                                // Password label and text field
                                JLabel passwordLabel = new JLabel();
                                paneltwo.add(passwordLabel);
                                 panel.add(panelone);
                                 panel.add(paneltwo);
                                 
                                       
                                  }
                                    for(int n=0;n<array.length();n++)
                                    {
                                        int jk=n;
                                         Edit[n].addActionListener(u->{ 
                                             
                                              if(incomemoneyfield[jk].getText().isBlank()||incomefield[jk].getText().isBlank())
                                                {
                                                              JOptionPane.showMessageDialog(null, "Please Fill Up all The Record ");   

                                                }
                                                else
                                                {
                                                  try{
                                                   Integer.parseInt(incomemoneyfield[jk].getText());
                                                   connection.incomeutilitydelete(prn,flt,moneyc[jk],incomemoneyfield[jk].getText(), source[jk],incomefield[jk].getText(),date[jk],new SimpleDateFormat("yyyy-MM-dd").format( endDateChooser[jk].getDate()).toString(), typedata[jk], typefield[jk].getText());
                                                   Edit[jk].setEnabled(false);
                                                   
                                                   intercentralpanel.removeAll();
                                                  intercentralpanel.revalidate();
                                                  intercentralpanel.repaint();
                                                    deletebody();
                                                    }catch(NumberFormatException ee)
                                                    {
                                                     JOptionPane.showMessageDialog(null, "Please Enter Number of Amount(money).");

                                                    } catch (ClassNotFoundException ex) {
                                              Logger.getLogger(HomeForm.class.getName()).log(Level.SEVERE, null, ex);
                                          } catch (SQLException ex) {
                                              Logger.getLogger(HomeForm.class.getName()).log(Level.SEVERE, null, ex);
                                          }
                                                }
                                             
                                             
                                  });

                                    }
                                        
                                JScrollPane scrollPane = new JScrollPane(panel);
                                  scrollPane.setPreferredSize(panel.getPreferredSize());
                                  int option = JOptionPane.showOptionDialog(null, scrollPane, "Project Name -> "+prn,
                                           JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, null, null);

                                   if (option == JOptionPane.OK_OPTION) {
                                   scrollPane.removeAll(); // Remove all components from the panel
                                    scrollPane.revalidate(); // Revalidate the panel to reflect the changes
                                  scrollPane.repaint();
                                   }                               
                              
                              
                                           
                                     
                                  } catch (JSONException ex) {
                                      Logger.getLogger(HomeForm.class.getName()).log(Level.SEVERE, null, ex);
                                  }
                                
                               
                              
                            
                            });
                             
                         }
                        
                    
                    }
     }
    
   
}
   
      public static void main(String[] args) throws ParseException {
     Delete window = new  Delete("");
     window.setVisible(true);

}


}
