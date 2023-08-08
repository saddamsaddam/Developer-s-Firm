/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package Registration;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;

import com.itextpdf.text.Font;

import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;

import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.ColumnText;

import com.itextpdf.text.pdf.PdfContentByte;

import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPCellEvent;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
//import java.awt.Font;
import java.awt.Toolkit;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import com.itextpdf.text.Element;
import com.toedter.calendar.JDateChooser;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
*
* @author 01957
*/
public class HomeForm extends JFrame {
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
    int breaker=0,selectcount=0;String role,sharenamesend;
                                 JSONArray array = new JSONArray();
                                  JSONArray username = new JSONArray();
                                   JSONArray password = new JSONArray();
                                    JSONArray roling = new JSONArray();
                                  JSONObject jsondata = new JSONObject();
                                  JSONArray arraymoney = new JSONArray();
                                   JSONArray type = new JSONArray();
                                  JSONArray arrayincomesource = new JSONArray();
                                   JPanel panel=new JPanel();
    String money1,money2,date1,date2,incomesource1,incomesource2;
     JSONObject json=null ;
        Database connection = new  Database();
          HashSet<String> resultflat=new HashSet();
         HashSet<JMenuItem> jmenuitem=new HashSet();
        JMenu projectname,capital,timeperiod,deleteproject,extraincome,extradebitmenu,editshare,editflat,deleteshare,deleteflat,utilityincome,utilitybill,editsetutility,editincomeutility;
        JMenuItem extradebit;
         JMenu xy,bge;
                               Font aa2vF = new Font(Font.FontFamily.HELVETICA,12f, Font.BOLD );
     Font tat = new Font(Font.FontFamily.HELVETICA, 10 );
    SimpleBottomLine simpleBottomLine=new SimpleBottomLine();
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

JPanel mainbody, left, right, bottom, top, centre, centreleft, centreright, centrecentre, bottom_left, bottom_right, bottom_bottom, bottom_centre, bottom_top,
        centreleft_1_top, centreleft_1_bottom, centreleft_1_centre, centreleft_2_top, centreleft_2_bottom, centreleft_2_centre, centreleft_3_top, centreleft_3_bottom, centreleft_3_centre, centreleft_4_top, centreleft_4_bottom, centreleft_4_centre, centreleft_5_top, centreleft_5_bottom, centreleft_5_centre, centreleft_6_top, centreleft_6_bottom, centreleft_6_centre, centreleft_7_top, centreleft_7_bottom, centreleft_7_centre, centreleft_8_top, centreleft_8_bottom, centreleft_8_centre, centreleft_9_top, centreleft_9_bottom, centreleft_9_centre,
        centreleft_1_top_upper, centreleft_2_top_upper, centreleft_3_top_upper, centreleft_4_top_upper, centreleft_5_top_upper, centreleft_6_top_upper, centreleft_7_top_upper, centreleft_8_top_upper, centreleft_9_top_upper,
        centreleft_1_top_middle, centreleft_2_top_middle, centreleft_3_top_middle, centreleft_4_top_middle, centreleft_5_top_middle, centreleft_6_top_middle, centreleft_7_top_middle, centreleft_8_top_middle, centreleft_9_top_middle,
        centrecentre_1_top, centrecentre_1_bottom, centrecentre_1_centre, centrecentre_2_top, centrecentre_2_bottom, centrecentre_2_centre, centrecentre_3_top, centrecentre_3_bottom, centrecentre_3_centre, centrecentre_4_top, centrecentre_4_bottom, centrecentre_4_centre, centrecentre_5_top, centrecentre_5_bottom, centrecentre_5_centre, centrecentre_6_top, centrecentre_6_bottom, centrecentre_6_centre, centrecentre_7_top, centrecentre_7_bottom, centrecentre_7_centre,
        centrecentre_1_top_upper, centrecentre_2_top_upper, centrecentre_3_top_upper, centrecentre_4_top_upper, centrecentre_5_top_upper, centrecentre_6_top_upper, centrecentre_7_top_upper,
        centrecentre_1_top_middle, centrecentre_2_top_middle, centrecentre_3_top_middle, centrecentre_4_top_middle, centrecentre_5_top_middle, centrecentre_6_top_middle, centrecentre_7_top_middle,
        centreright_1_top, centreright_1_bottom, centreright_1_centre, centreright_2_top, centreright_2_bottom, centreright_2_centre, centreright_3_top, centreright_3_bottom, centreright_3_centre, centreright_4_top, centreright_4_bottom, centreright_4_centre, centreright_5_top, centreright_5_bottom, centreright_5_centre, centreright_6_top, centreright_6_bottom, centreright_6_centre, centreright_7_top, centreright_7_bottom, centreright_7_centre, centreright_8_top, centreright_8_bottom, centreright_8_centre, centreright_9_top, centreright_9_bottom, centreright_9_centre, centreright_10_top, centreright_10_bottom, centreright_10_centre,
        centreright_1_top_upper, centreright_2_top_upper, centreright_3_top_upper, centreright_4_top_upper, centreright_5_top_upper, centreright_6_top_upper, centreright_7_top_upper, centreright_8_top_upper, centreright_9_top_upper, centreright_10_top_upper,
        centreright_1_top_middle, centreright_2_top_middle, centreright_3_top_middle, centreright_4_top_middle, centreright_5_top_middle, centreright_6_top_middle, centreright_7_top_middle, centreright_8_top_middle, centreright_9_top_middle, centreright_10_top_middle;

JScrollPane js;
JButton btn1;
BoxLayout centreleft_1_top_box, centreleft_2_top_box, centreleft_3_top_box, centreleft_4_top_box, centreleft_5_top_box, centreleft_6_top_box, centreleft_7_top_box, centreleft_8_top_box, centreleft_9_top_box,
        centreleft_1_top_box_upper, centreleft_2_top_box_upper, centreleft_3_top_box_upper, centreleft_4_top_box_upper, centreleft_5_top_box_upper, centreleft_6_top_box_upper, centreleft_7_top_box_upper, centreleft_8_top_box_upper, centreleft_9_top_box_upper,
        centrecentre_1_top_box, centrecentre_2_top_box, centrecentre_3_top_box, centrecentre_4_top_box, centrecentre_5_top_box, centrecentre_6_top_box, centrecentre_7_top_box,
        centrecentre_1_top_box_upper, centrecentre_2_top_box_upper, centrecentre_3_top_box_upper, centrecentre_4_top_box_upper, centrecentre_5_top_box_upper, centrecentre_6_top_box_upper, centrecentre_7_top_box_upper,
        centreright_1_top_box, centreright_2_top_box, centreright_3_top_box, centreright_4_top_box, centreright_5_top_box, centreright_6_top_box, centreright_7_top_box, centreright_8_top_box, centreright_9_top_box, centreright_10_top_box,
        centreright_1_top_box_upper, centreright_2_top_box_upper, centreright_3_top_box_upper, centreright_4_top_box_upper, centreright_5_top_box_upper, centreright_6_top_box_upper, centreright_7_top_box_upper, centreright_8_top_box_upper, centreright_9_top_box_upper, centreright_10_top_box_upper;

JLabel centreleft_1_top_label, centreleft_2_top_label, centreleft_3_top_label, centreleft_4_top_label, centreleft_5_top_label, centreleft_6_top_label, centreleft_7_top_label, centreleft_8_top_label, centreleft_9_top_label,
        centreleft_1_top_label_next_exampted1, centreleft_1_top_label_next_taxable1,
        centreleft_2_top_label_next_exampted1, centreleft_2_top_label_next_taxable1,
        centreleft_3_top_label_next_exampted1, centreleft_3_top_label_next_taxable1,
        centreleft_4_top_label_next_exampted1, centreleft_4_top_label_next_taxable1,
        centreleft_5_top_label_next_exampted1, centreleft_5_top_label_next_taxable1,
        centreleft_6_top_label_next_exampted1, centreleft_6_top_label_next_taxable1,
        centreleft_7_top_label_next_exampted1, centreleft_7_top_label_next_taxable1,
        centreleft_8_top_label_next_exampted1, centreleft_8_top_label_next_taxable1,
        centreleft_9_top_label_next_exampted1, centreleft_9_top_label_next_taxable1;

JLabel centrecentre_1_top_label, centrecentre_2_top_label, centrecentre_3_top_label, centrecentre_4_top_label, centrecentre_5_top_label, centrecentre_6_top_label, centrecentre_7_top_label,
        centrecentre_1_top_label_next_1, centrecentre_1_top_label_next_2,
        centrecentre_2_top_label_next_1, centrecentre_2_top_label_next_2,
        centrecentre_3_top_label_next_1, centrecentre_3_top_label_next_2,
        centrecentre_4_top_label_next_1, centrecentre_4_top_label_next_2,
        centrecentre_5_top_label_next_1, centrecentre_5_top_label_next_2,
        centrecentre_6_top_label_next_1, centrecentre_6_top_label_next_2,
        centrecentre_7_top_label_next_1, centrecentre_7_top_label_next_2,
        centrecentre_5_top_label_next_heading;

JLabel centreright_1_top_label, centreright_2_top_label, centreright_3_top_label, centreright_4_top_label, centreright_5_top_label, centreright_6_top_label, centreright_7_top_label, centreright_8_top_label, centreright_9_top_label, centreright_10_top_label,
        centreright_1_top_label_next_exampted1, centreright_1_top_label_next_taxable2,
        centreright_2_top_label_next_exampted1, centreright_2_top_label_next_taxable2,
        centreright_3_top_label_next_exampted1, centreright_3_top_label_next_taxable2,
        centreright_4_top_label_next_exampted1, centreright_4_top_label_next_taxable2,
        centreright_5_top_label_next_exampted1, centreright_5_top_label_next_taxable2,
        centreright_6_top_label_next_exampted1, centreright_6_top_label_next_taxable2,
        centreright_7_top_label_next_exampted1, centreright_7_top_label_next_taxable2,
        centreright_8_top_label_next_exampted1, centreright_8_top_label_next_taxable2,
        centreright_9_top_label_next_exampted1, centreright_9_top_label_next_taxable2,
        centreright_10_top_label_next_exampted1, centreright_10_top_label_next_taxable2,
        centreright_7_top_label_next_taxdeducted1, centreright_7_top_label_next_advancetax2, centreright_7_top_label_next_taxpaid3, centreright_7_top_label_next_adjustrefund4;

JTextField centreleft_1_top_textfield, centreleft_2_top_textfield, centreleft_3_top_textfield, centreleft_4_top_textfield, centreleft_5_top_textfield, centreleft_6_top_textfield, centreleft_7_top_textfield, centreleft_8_top_textfield, centreleft_9_top_textfield,
        centreleft_1_top_textfield_next_exampted1, centreleft_1_top_textfield_next_taxable1,
        centreleft_2_top_textfield_next_exampted1, centreleft_2_top_textfield_next_taxable1,
        centreleft_3_top_textfield_next_exampted1, centreleft_3_top_textfield_next_taxable1,
        centreleft_4_top_textfield_next_exampted1, centreleft_4_top_textfield_next_taxable1,
        centreleft_5_top_textfield_next_exampted1, centreleft_5_top_textfield_next_taxable1,
        centreleft_6_top_textfield_next_exampted1, centreleft_6_top_textfield_next_taxable1,
        centreleft_7_top_textfield_next_exampted1, centreleft_7_top_textfield_next_taxable1,
        centreleft_8_top_textfield_next_exampted1, centreleft_8_top_textfield_next_taxable1,
        centreleft_9_top_textfield_next_exampted1, centreleft_9_top_textfield_next_taxable1,
        centrecentre_1_top_textfield, centrecentre_2_top_textfield, centrecentre_3_top_textfield, centrecentre_4_top_textfield, centrecentre_5_top_textfield, centrecentre_6_top_textfield, centrecentre_7_top_textfield,
        centrecentre_1_top_textfield_next_1, centrecentre_1_top_textfield_next_2,
        centrecentre_2_top_textfield_next_1, centrecentre_2_top_textfield_next_2,
        centrecentre_3_top_textfield_next_1, centrecentre_3_top_textfield_next_2,
        centrecentre_4_top_textfield_next_1, centrecentre_4_top_textfield_next_2,
        centrecentre_5_top_textfield_next_1, centrecentre_5_top_textfield_next_2,
        centrecentre_6_top_textfield_next_1, centrecentre_6_top_textfield_next_2,
        centrecentre_7_top_textfield_next_1, centrecentre_7_top_textfield_next_2,
        centrecentre_5_top_textfield_next_heading,
        centreright_1_top_textfield, centreright_2_top_textfield, centreright_3_top_textfield, centreright_4_top_textfield, centreright_5_top_textfield, centreright_6_top_textfield, centreright_7_top_textfield, centreright_8_top_textfield, centreright_9_top_textfield, centreright_10_top_textfield,
        centreright_1_top_textfield_next_exampted1, centreright_1_top_textfield_next_taxable2,
        centreright_2_top_textfield_next_exampted1, centreright_2_top_textfield_next_taxable2,
        centreright_3_top_textfield_next_exampted1, centreright_3_top_textfield_next_taxable2,
        centreright_4_top_textfield_next_exampted1, centreright_4_top_textfield_next_taxable2,
        centreright_5_top_textfield_next_exampted1, centreright_5_top_textfield_next_taxable2,
        centreright_6_top_textfield_next_exampted1, centreright_6_top_textfield_next_taxable2,
        centreright_7_top_textfield_next_exampted1, centreright_7_top_textfield_next_taxable2,
        centreright_8_top_textfield_next_exampted1, centreright_8_top_textfield_next_taxable2,
        centreright_9_top_textfield_next_exampted1, centreright_9_top_textfield_next_taxable2,
        centreright_10_top_textfield_next_exampted1, centreright_10_top_textfield_next_taxable2,
        centreright_7_top_textfield_next_taxdeducted1, centreright_7_top_textfield_next_advancetax2, centreright_7_top_textfield_next_taxpaid3, centreright_7_top_textfield_next_adjustrefund4;

JButton centreleft_1_top_adddetail, centreleft_2_top_adddetail, centreleft_3_top_adddetail, centreleft_4_top_adddetail, centreleft_5_top_adddetail, centreleft_6_top_adddetail, centreleft_7_top_adddetail, centreleft_8_top_adddetail, centreleft_9_top_adddetail, centreleft_1_top_add, centreleft_2_top_add, centreleft_3_top_add, centreleft_4_top_add, centreleft_5_top_add, centreleft_6_top_add, centreleft_7_top_add, centreleft_8_top_add, centreleft_9_top_add, centreleft_1_top_end, centreleft_2_top_end, centreleft_3_top_end, centreleft_4_top_end, centreleft_5_top_end, centreleft_6_top_end, centreleft_7_top_end, centreleft_8_top_end, centreleft_9_top_end;

JButton centrecentre_1_top_adddetail, centrecentre_2_top_adddetail, centrecentre_3_top_adddetail, centrecentre_4_top_adddetail, centrecentre_5_top_adddetail, centrecentre_6_top_adddetail, centrecentre_7_top_adddetail, centrecentre_1_top_add, centrecentre_2_top_add, centrecentre_3_top_add, centrecentre_4_top_add, centrecentre_5_top_add, centrecentre_6_top_add, centrecentre_7_top_add, centrecentre_1_top_end, centrecentre_2_top_end, centrecentre_3_top_end, centrecentre_4_top_end, centrecentre_5_top_end, centrecentre_6_top_end, centrecentre_7_top_end,
        centrecentre_5_top_new,
        centrecentre_5_top_terminate;

JButton centreright_1_top_adddetail, centreright_2_top_adddetail, centreright_3_top_adddetail, centreright_4_top_adddetail, centreright_5_top_adddetail, centreright_6_top_adddetail, centreright_7_top_adddetail, centreright_8_top_adddetail, centreright_9_top_adddetail, centreright_10_top_adddetail, centreright_1_top_add, centreright_2_top_add, centreright_3_top_add, centreright_4_top_add, centreright_5_top_add, centreright_6_top_add, centreright_7_top_add, centreright_8_top_add, centreright_9_top_add, centreright_10_top_add, centreright_1_top_end, centreright_2_top_end, centreright_3_top_end, centreright_4_top_end, centreright_5_top_end, centreright_6_top_end, centreright_7_top_end, centreright_8_top_end, centreright_9_top_end, centreright_10_top_end;
    public class SimpleBottomLine implements PdfPCellEvent {
                        public void cellLayout(PdfPCell cell, Rectangle position, PdfContentByte[] canvas) {
                     // TODO Auto-generated method stub
                     PdfContentByte cb1 = canvas[PdfPTable.LINECANVAS];
                     cb1.saveState();
                     cb1.setLineCap(PdfContentByte.LINE_CAP_ROUND);
                     cb1.setLineDash(0, 5, 1);
                     
                     cb1.moveTo(position.getLeft(), position.getBottom());
                     cb1.lineTo(position.getRight(), position.getBottom());
                     cb1.stroke();
                     cb1.restoreState();
             }
 
         }
public HomeForm(String role) throws ClassNotFoundException, SQLException, JSONException {
   
         this.role=role;

    this.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
    this.setSize(screen.width - 20, screen.height - 70);
    setTitle("Saddamnvn");
    int count = 1;
    for (int i = 0; i < 20; i++) {
        ayear[i] = currentyear - count;
        count++;
        // System.out.print(ayear[i]);

    }
  
    mainbody();
   

}

public static void main(String[] args) throws ClassNotFoundException, JSONException {
    HomeForm window1;
    try {
        window1 = new HomeForm(" ");
        window1.setVisible(true);

    } catch (SQLException ex) {
        Logger.getLogger(HomeForm.class.getName()).log(Level.SEVERE, null, ex);
    }

}


//create table
public void mainbody() throws JSONException {
    mainbody = new JPanel();
    mainbody.setLayout(new BorderLayout());
    left = new JPanel();
    left.setBackground(Color.green);
    right = new JPanel();
    right.setBackground(Color.red);
    top = new JPanel();
    top.setBackground(Color.green);
    bottom = new JPanel();
    bottom.setBackground(Color.blue);
    centre = new JPanel();
    centre.setBackground(Color.black);
    mainbody.add(left, BorderLayout.WEST);
    mainbody.add(right, BorderLayout.EAST);
    mainbody.add(top, BorderLayout.NORTH);
    mainbody.add(bottom, BorderLayout.SOUTH);
    mainbody.add(centre, BorderLayout.CENTER);
    //adding scroll bar
    js = new JScrollPane(mainbody);
    js.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    this.add(js);
    top();
    centre(ayear);
    bottom();

}

public void top() {
    JLabel[] jj = new JLabel[30];
    for(int i=0;i<15;i++)
    {
        if(i==14)
        {
         //jj[i]=new JLabel("        x          ");
         cr=new JButton("       X        ");
               top.add(cr); 
        }
        else if(i==7)
        {
           jj[i]=new JLabel("        Saddamnvn Company Limited Tangail,BD.       ");
             top.add(jj[i]);
        }
        else
        {
            jj[i]=new JLabel("                          ");
             top.add(jj[i]); 
        }
        

    }
    cr.addActionListener(e->{
        System.exit(0);
    });
       

}

public void centre(int[] ayear) throws JSONException {
    centre.setLayout(new BorderLayout());
    centreleft = new JPanel();
    centreleft.setBackground(Color.yellow);
    centreright = new JPanel();
    centreright.setBackground(Color.orange);
    centrecentre = new JPanel();
    centrecentre.setBackground(Color.gray);
    centre.add(centreleft, BorderLayout.CENTER);//west
    centre.add(centreright, BorderLayout.EAST);
    centre.add(centrecentre, BorderLayout.WEST);//center
    centreleft();
    centreright();
    centremiddle();
    centrebottom();

}

public void addmenubar() {

}

public void centreleft() throws JSONException {
    //main  frst outdoor
    centreleft.setLayout(new BorderLayout());
    centreleft_1_top = new JPanel();
    centreleft_1_centre = new JPanel();
    centreleft_1_bottom = new JPanel();

    centreleft_1_top.add(Box.createVerticalStrut(20));
    centreleft.add(centreleft_1_top, BorderLayout.NORTH);
    centreleft.add(centreleft_1_centre, BorderLayout.CENTER);
    //centreleft.add(centreleft_1_bottom,BorderLayout.SOUTH);

    //second indoor
    centreleft_1_centre.setLayout(new BorderLayout());
    centreleft_2_top = new JPanel();
    centreleft_2_centre = new JPanel();
    centreleft_2_bottom = new JPanel();

    centreleft_2_top.add(Box.createVerticalStrut(20));
    centreleft_1_centre.add(centreleft_2_top, BorderLayout.NORTH);
    centreleft_1_centre.add(centreleft_2_centre, BorderLayout.CENTER);
    //centreleft_1_centre.add(centreleft_2_bottom,BorderLayout.SOUTH);
    //third indoor
    centreleft_2_centre.setLayout(new BorderLayout());
    centreleft_3_top = new JPanel();
    centreleft_3_centre = new JPanel();
    centreleft_3_bottom = new JPanel();

    centreleft_1_top.add(Box.createVerticalStrut(20));
    centreleft_2_centre.add(centreleft_3_top, BorderLayout.NORTH);
    centreleft_2_centre.add(centreleft_3_centre, BorderLayout.CENTER);
    // centreleft_2_centre.add(centreleft_3_bottom,BorderLayout.SOUTH);
    //fourth indoor
    centreleft_3_centre.setLayout(new BorderLayout());
    centreleft_4_top = new JPanel();
    centreleft_4_centre = new JPanel();
    centreleft_4_bottom = new JPanel();

    centreleft_4_top.add(Box.createVerticalStrut(20));
    centreleft_3_centre.add(centreleft_4_top, BorderLayout.NORTH);
    centreleft_3_centre.add(centreleft_4_centre, BorderLayout.CENTER);
    //centreleft_3_centre.add(centreleft_4_bottom,BorderLayout.SOUTH);

    //five indoor
    centreleft_4_centre.setLayout(new BorderLayout());
    centreleft_5_top = new JPanel();
    centreleft_5_centre = new JPanel();
    centreleft_5_bottom = new JPanel();

    centreleft_5_top.add(Box.createVerticalStrut(20));
    centreleft_4_centre.add(centreleft_5_top, BorderLayout.NORTH);
    centreleft_4_centre.add(centreleft_5_centre, BorderLayout.CENTER);
    //centreleft_4_centre.add(centreleft_5_bottom,BorderLayout.SOUTH);

    //six indoor
    centreleft_5_centre.setLayout(new BorderLayout());
    centreleft_6_top = new JPanel();
    centreleft_6_centre = new JPanel();
    centreleft_6_bottom = new JPanel();

    centreleft_6_top.add(Box.createVerticalStrut(20));
    centreleft_5_centre.add(centreleft_6_top, BorderLayout.NORTH);
    centreleft_5_centre.add(centreleft_6_centre, BorderLayout.CENTER);
    // centreleft_5_centre.add(centreleft_6_bottom,BorderLayout.SOUTH);
    //seven indoor
    centreleft_6_centre.setLayout(new BorderLayout());
    centreleft_7_top = new JPanel();
    centreleft_7_centre = new JPanel();
    centreleft_7_bottom = new JPanel();

    centreleft_7_top.add(Box.createVerticalStrut(20));
    centreleft_6_centre.add(centreleft_7_top, BorderLayout.NORTH);
    centreleft_6_centre.add(centreleft_7_centre, BorderLayout.CENTER);
    // centreleft_5_centre.add(centreleft_6_bottom,BorderLayout.SOUTH);
    //Eight indoor
    centreleft_7_centre.setLayout(new BorderLayout());
    centreleft_8_top = new JPanel();
    centreleft_8_centre = new JPanel();
    centreleft_8_bottom = new JPanel();

    centreleft_8_top.add(Box.createVerticalStrut(20));
    centreleft_7_centre.add(centreleft_8_top, BorderLayout.NORTH);
    centreleft_7_centre.add(centreleft_8_centre, BorderLayout.CENTER);
    // centreleft_5_centre.add(centreleft_6_bottom,BorderLayout.SOUTH);
    //nine indoor
    centreleft_8_centre.setLayout(new BorderLayout());
    centreleft_9_top = new JPanel();
    centreleft_9_centre = new JPanel();
    centreleft_9_bottom = new JPanel();

    centreleft_9_top.add(Box.createVerticalStrut(20));
    centreleft_8_centre.add(centreleft_9_top, BorderLayout.NORTH);
    //centreleft_8_centre.add(centreleft_9_centre,BorderLayout.CENTER);
    // centreleft_5_centre.add(centreleft_6_bottom,BorderLayout.SOUTH);

    addleftcontent();

}

public void addleftcontent() throws JSONException {
    centreleft_1_top.setLayout(new BorderLayout());
    JPanel singleleft1 = new JPanel();
    JPanel singletop1 = new JPanel();
    JPanel singlemidle1 = new JPanel();
    JPanel singleright1 = new JPanel();
    centreleft_1_top.add(singletop1, BorderLayout.NORTH);
    centreleft_1_top.add(singleleft1, BorderLayout.WEST);
    centreleft_1_top.add(singleright1, BorderLayout.EAST);
    centreleft_1_top.add(singlemidle1, BorderLayout.CENTER);
    
     menu=new JMenu("Project        ");
   //return from database info
    
    bar = new JMenuBar();
    projectname=new JMenu("Add Flat");
        capital=new JMenu("Add Sharemate");
       editflat=new JMenu("Edi Flat");
       editshare=new JMenu("Edi Sharemate");
       deleteflat=new JMenu("Delete Flat");
       deleteshare=new JMenu("Delete Sharemate");
       utilityincome=new JMenu("Set Utility & Others");
        
     result=connection.getsharemateprojectname();
     result.forEach(e->{
         json=connection.getsharemateprojectflatinfo(e);
         JMenu flatname=new JMenu(e);
         Iterator<String> keys = json.keys();
             while(keys.hasNext())
             {
                  flatname.add(new JMenuItem(keys.next()));
             }
         utilityincome.add(flatname);
         projectname.add(e);
         capital.add(e);
         editflat.add(e);
         editshare.add(e);
         deleteflat.add(e);
         deleteshare.add(e);
     });
    //add project income and capital
    menu.add("Create Project");
    menu.add(projectname);
    menu.add(capital);
    menu.add(editflat);
    menu.add(editshare);
    menu.add(deleteflat);
    menu.add(deleteshare);
    menu.add(utilityincome);
   
   // System.out.print(menu.getItem(0).getText());
    bar.add(menu);
    setJMenuBar(bar);
   // singleleft.add(search);
    singleleft1.add(bar);
    // centreleft_1_top.add(regis);
    centreleft_1_top.add(Box.createVerticalStrut(30));
    
     menu.getItem(0).addActionListener(e -> {
        CreateProject  kk;
        try {
            kk = new CreateProject (role);
              kk.setVisible(true);
        dispose();
        } catch (ParseException ex) {
            Logger.getLogger(HomeForm.class.getName()).log(Level.SEVERE, null, ex);
        }
      
    });
 xy= (JMenu) menu.getItem(1);
        count=xy.getItemCount();
       for(int i=0;i<count;i++)
       {
           String prn=xy.getItem(i).getText();
           xy.getItem(i).addActionListener(e->{
              // CreateProjectAddCapital 
                           AddExtraflat  kk;
               try {
                   kk = new AddExtraflat(role,e.getActionCommand());
                   kk.setVisible(true);
                   dispose();
               } catch (ParseException ex) {
                   Logger.getLogger(HomeForm.class.getName()).log(Level.SEVERE, null, ex);
               }
                            
           });

       }
        xy= (JMenu) menu.getItem(2);
        count=xy.getItemCount();
       for(int i=0;i<count;i++)
       {
           String prn=xy.getItem(i).getText();
           xy.getItem(i).addActionListener(e->{
              // CreateProjectAddCapital 
                           AddExtrasharemate  kk;
               try {
                   kk = new AddExtrasharemate(role,e.getActionCommand());
                   kk.setVisible(true);
                   dispose();
               } catch (ParseException ex) {
                   Logger.getLogger(HomeForm.class.getName()).log(Level.SEVERE, null, ex);
               } catch (JSONException ex) {
                   Logger.getLogger(HomeForm.class.getName()).log(Level.SEVERE, null, ex);
               }
                            
           });

       }
    xy= (JMenu) menu.getItem(3);
        count=xy.getItemCount();
       for(int i=0;i<count;i++)
       {
           String prn=xy.getItem(i).getText();
           xy.getItem(i).addActionListener(e->{
              // CreateProjectAddCapital 
                          EditExtraflat  kk;
               try {
                   kk = new EditExtraflat(role,e.getActionCommand());
                   kk.setVisible(true);
                   dispose();
               } catch (ParseException ex) {
                   Logger.getLogger(HomeForm.class.getName()).log(Level.SEVERE, null, ex);
               } catch (JSONException ex) {
                   Logger.getLogger(HomeForm.class.getName()).log(Level.SEVERE, null, ex);
               }
                            
           });

       }
    
 xy= (JMenu) menu.getItem(4);
        count=xy.getItemCount();
       for(int i=0;i<count;i++)
       {
           String prn=xy.getItem(i).getText();
           xy.getItem(i).addActionListener(e->{
              // CreateProjectAddCapital 
                          EditExtrasharemate  kk;
               try {
                   kk = new EditExtrasharemate(role,e.getActionCommand());
                   kk.setVisible(true);
                   dispose();
               } catch (ParseException ex) {
                   Logger.getLogger(HomeForm.class.getName()).log(Level.SEVERE, null, ex);
               } catch (JSONException ex) {
                   Logger.getLogger(HomeForm.class.getName()).log(Level.SEVERE, null, ex);
               }
                            
           });

       }
    xy= (JMenu) menu.getItem(5);
        count=xy.getItemCount();
       for(int i=0;i<count;i++)
       {
           String prn=xy.getItem(i).getText();
           xy.getItem(i).addActionListener(e->{
              // CreateProjectAddCapital 
                          DeleteExtraflat kk;
               try {
                   kk = new  DeleteExtraflat(role,e.getActionCommand());
                   kk.setVisible(true);
                   dispose();
               } catch (ParseException ex) {
                   Logger.getLogger(HomeForm.class.getName()).log(Level.SEVERE, null, ex);
               } catch (JSONException ex) {
                   Logger.getLogger(HomeForm.class.getName()).log(Level.SEVERE, null, ex);
               }
                            
           });

       }
    
       xy= (JMenu) menu.getItem(6);
        count=xy.getItemCount();
       for(int i=0;i<count;i++)
       {
           String prn=xy.getItem(i).getText();
           xy.getItem(i).addActionListener(e->{
              // CreateProjectAddCapital 
                         DeleteExtrasharemate kk;
               try {
                   kk = new  DeleteExtrasharemate(role,e.getActionCommand());
                   kk.setVisible(true);
                   dispose();
               } catch (ParseException ex) {
                   Logger.getLogger(HomeForm.class.getName()).log(Level.SEVERE, null, ex);
               } catch (JSONException ex) {
                   Logger.getLogger(HomeForm.class.getName()).log(Level.SEVERE, null, ex);
               }
                            
           });

       }
       
     //project flat Incomeutilityother
     xy= (JMenu) menu.getItem(7);
     count=xy.getItemCount();
     for(int i=0;i<count;i++)
     {
                JMenu xyz=(JMenu) xy.getItem(i);
                String prn=xy.getItem(i).getText();
                bge=xyz;
                  int cc=xyz.getItemCount();
                  for(int j=0;j<cc;j++)
                    {
                     bge.getItem(j).addActionListener(e->{
                        Setutilityother  kk = new Setutilityother (role);
                         kk.setprnflt(prn,e.getActionCommand());
                          kk.setVisible(true);
                           dispose();
                     });
                    }
     }
    
    

    //2
    centreleft_2_top.setLayout(new BorderLayout());
    JPanel singleleft = new JPanel();
    JPanel singletop = new JPanel();
    JPanel singlemidle = new JPanel();
    JPanel singleright = new JPanel();
    centreleft_2_top.add(singletop, BorderLayout.NORTH);
    centreleft_2_top.add(singleleft, BorderLayout.WEST);
    centreleft_2_top.add(singleright, BorderLayout.EAST);
    centreleft_2_top.add(singlemidle, BorderLayout.CENTER);
    JLabel jl = new JLabel("                                                                          ");
   // JButton search = new JButton("Click      ");
     menu=new JMenu("Add Credit");
   //return from database info
    
    bar = new JMenuBar();
    projectname=new JMenu("Project Name");
    capital=new JMenu("Add Capitals");
    extraincome=new JMenu("Other Income");
    utilitybill=new JMenu("Income Utility & Others");
     result=connection.getsharemateprojectname();
     result.forEach(e->{
         json=connection.getsharemateprojectflatinfo(e);
         JMenu flatname=new JMenu(e);
         Iterator<String> keys = json.keys();
             while(keys.hasNext())
             {
                  flatname.add(new JMenuItem(keys.next()));
             }
         
          projectname.add(flatname);
          capital.add(e);
          extraincome.add(e);
     });
     result=connection.getsharemateprojectname();
     result.forEach(e->{
         json=connection.getsharemateprojectflatinfo(e);
         JMenu flatname=new JMenu(e);
         Iterator<String> keys = json.keys();
             while(keys.hasNext())
             {
                  flatname.add(new JMenuItem(keys.next()));
             }
         
           utilitybill.add(flatname);
     });
    //add project income and capital
    menu.add(projectname);
    menu.add(capital);
    menu.add(extraincome);
    menu.add(utilitybill);

   // System.out.print(menu.getItem(0).getText());
    bar.add(menu);
    setJMenuBar(bar);
   // singleleft.add(search);
    singleleft.add(bar);
    singleright.add(jl);
    
     xy= (JMenu) menu.getItem(3);
     count=xy.getItemCount();
     for(int i=0;i<count;i++)
     {
                JMenu xyz=(JMenu) xy.getItem(i);
                String prn=xy.getItem(i).getText();
                bge=xyz;
                  int cc=xyz.getItemCount();
                  for(int j=0;j<cc;j++)
                    {
                     bge.getItem(j).addActionListener(e->{
                        Incomeutilityother kk = new Incomeutilityother (role);
                         kk.setprnflt(prn,e.getActionCommand());
                          kk.setVisible(true);
                           dispose();
                     });
                    }
     }
    
    //extraincome
      xy= (JMenu) menu.getItem(2);
     count=xy.getItemCount();
    for(int i=0;i<count;i++)
    {
        String prn=xy.getItem(i).getText();
        xy.getItem(i).addActionListener(e->{
           // CreateProjectAddCapital 
                   Extraincome  kk = new Extraincome (role);
                         kk.setprnflt(prn,"10");
                          kk.setVisible(true);
                           dispose();
        });
        
    }
    //capitals
      xy= (JMenu) menu.getItem(1);
     count=xy.getItemCount();
    for(int i=0;i<count;i++)
    {
        String prn=xy.getItem(i).getText();
        xy.getItem(i).addActionListener(e->{
           // CreateProjectAddCapital 
                    CreateProjectAddCapital  kk = new CreateProjectAddCapital (role);
                         kk.setprnflt(prn,"10");
                          kk.setVisible(true);
                           dispose();
        });
        
    }
    //project flat
     xy= (JMenu) menu.getItem(0);
     count=xy.getItemCount();
     for(int i=0;i<count;i++)
     {
                JMenu xyz=(JMenu) xy.getItem(i);
                String prn=xy.getItem(i).getText();
                bge=xyz;
                  int cc=xyz.getItemCount();
                  for(int j=0;j<cc;j++)
                    {
                     bge.getItem(j).addActionListener(e->{
                         CreateProjectIncome  kk = new CreateProjectIncome (role);
                         kk.setprnflt(prn,e.getActionCommand());
                          kk.setVisible(true);
                           dispose();
                     });
                    }
     }
    
    centreleft_3_top.add(Box.createVerticalStrut(30));

    //3
    centreleft_3_top.setLayout(new BorderLayout());
    JPanel allleft = new JPanel();
    JPanel alltop = new JPanel();
    JPanel allmidle = new JPanel();
    JPanel allright = new JPanel();
    JPanel allbottom = new JPanel();
    centreleft_3_top.add(alltop, BorderLayout.NORTH);
    centreleft_3_top.add(allleft, BorderLayout.WEST);
    centreleft_3_top.add(allright, BorderLayout.EAST);
    centreleft_3_top.add(allmidle, BorderLayout.CENTER);

    JLabel alljl = new JLabel("                                                                                                                                                 ");
   
    
     menu=new JMenu("Add Debit");
   //return from database info
    
    bar = new JMenuBar();
    projectname=new JMenu("Project Name");
        capital=new JMenu("WithDraw Capitals");
       extradebit=new JMenuItem("Extra Debit");
     result=connection.getsharemateprojectname();
     result.forEach(e->{
         //int count=connection.getsharemateprojectflatnumber(e);
         //JMenuItem flatname=new JMenu(e);
          projectname.add(e);
         capital.add(e);
     });
    //add project income and capital
    menu.add(projectname);
    menu.add(capital);
    menu.add(extradebit);
    menu.add(new JMenuItem("Bank"));

   // System.out.print(menu.getItem(0).getText());
    bar.add(menu);
    setJMenuBar(bar);
   // singleleft.add(search);
     allleft.add(bar);
    allright.add(alljl);
    menu.getItem(3).addActionListener(e->{
       Bank ex=new Bank(role);
       ex.setprnflt("f","10");
       ex.setVisible(true);
       dispose();
      });
    //extra debit
      menu.getItem(2).addActionListener(e->{
       Extradebit ex=new Extradebit(role);
       ex.setprnflt("f","10");
       ex.setVisible(true);
       dispose();
      });
     //capitals
      xy= (JMenu) menu.getItem(1);
     count=xy.getItemCount();
    for(int i=0;i<count;i++)
    {
        String prn=xy.getItem(i).getText();
        xy.getItem(i).addActionListener(e->{
           // CreateProjectAddCapital 
                        CreateProjectWithDrawCapital  kk = new CreateProjectWithDrawCapital(role);
                         kk.setprnflt(prn,"10");
                          kk.setVisible(true);
                          dispose();
        });
        
    }
    
    //project
      xy= (JMenu) menu.getItem(0);
        count=xy.getItemCount();
       for(int i=0;i<count;i++)
       {
           String prn=xy.getItem(i).getText();
           xy.getItem(i).addActionListener(e->{
              // CreateProjectAddCapital 
                           CreateProjectdebit  kk = new CreateProjectdebit(role);
                            kk.setprnflt(prn,"10");
                             kk.setVisible(true);
                              dispose();
           });

       }
    

    centreleft_3_top.add(Box.createVerticalStrut(30));

    //4
    //4
    centreleft_4_top.setLayout(new BorderLayout());
    JPanel allleft4 = new JPanel();
    JPanel alltop4 = new JPanel();
    JPanel allmidle4 = new JPanel();
    JPanel allright4 = new JPanel();
    JPanel allbottom4 = new JPanel();
    centreleft_4_top.add(alltop4, BorderLayout.NORTH);
    centreleft_4_top.add(allleft4, BorderLayout.WEST);
    centreleft_4_top.add(allright4, BorderLayout.EAST);
    centreleft_4_top.add(allmidle4, BorderLayout.CENTER);
   JButton ed=new JButton("     Edit   ");
    ed.addActionListener(e->{
    Edit d;
        try {
            d = new Edit(role);
             d.setVisible(true);
             dispose();
        } catch (ParseException ex) {
            Logger.getLogger(HomeForm.class.getName()).log(Level.SEVERE, null, ex);
        }
   
    });
    allleft4.add(ed);
     
    centreleft_4_top.add(Box.createVerticalStrut(30));

    //5
    centreleft_5_top.setLayout(new BorderLayout());
    downloadleft1 = new JPanel();
     downloadtop1 = new JPanel();
     downloadmidle1 = new JPanel();
     downloadright1 = new JPanel();
    centreleft_5_top.add(downloadtop1, BorderLayout.NORTH);
    centreleft_5_top.add(downloadleft1, BorderLayout.WEST);
    centreleft_5_top.add(downloadright1, BorderLayout.EAST);
    centreleft_5_top.add(downloadmidle1, BorderLayout.CENTER);
    downloadbody();
    
    centreleft_6_top.add(Box.createVerticalStrut(30));
    //centreleft_6_top_box = new BoxLayout(centreleft_6_top, BoxLayout.Y_AXIS);
    //centreleft_6_top.setLayout(centreleft_6_top_box);
    centreleft_6_top.setLayout(new BorderLayout());
    JPanel allleft6 = new JPanel();
    JPanel alltop6 = new JPanel();
    JPanel allmidle6 = new JPanel();
    JPanel allright6 = new JPanel();
    JPanel allbottom6 = new JPanel();
    centreleft_6_top.add(alltop6, BorderLayout.NORTH);
    centreleft_6_top.add(allleft6, BorderLayout.WEST);
    centreleft_6_top.add(allright6, BorderLayout.EAST);
    centreleft_6_top.add(allmidle6, BorderLayout.CENTER);
    centreleft_6_top.add(allmidle6, BorderLayout.SOUTH);
    //centreleft_6_top_textfield = new JTextField();
    JButton de=new JButton("    Delete   ");
    de.addActionListener(e->{
    Delete d;
        try {
            d = new Delete(role);
             d.setVisible(true);
             dispose();
        } catch (ParseException ex) {
            Logger.getLogger(HomeForm.class.getName()).log(Level.SEVERE, null, ex);
        }
   
    });
    allleft6.add(de);
    //deletebody(allleft6,allright6,allleft4,allright4);
    
    centreleft_7_top.add(Box.createVerticalStrut(30));
  
    //centreleft_6_top_box = new BoxLayout(centreleft_6_top, BoxLayout.Y_AXIS);
    //centreleft_6_top.setLayout(centreleft_6_top_box);
    centreleft_7_top.setLayout(new BorderLayout());
     allleft7 = new JPanel();
     alltop7 = new JPanel();
     allmidle7 = new JPanel();
     allright7 = new JPanel();
    JPanel allbottom7 = new JPanel();
    centreleft_7_top.add(alltop7, BorderLayout.NORTH);
    centreleft_7_top.add(allleft7, BorderLayout.WEST);
    centreleft_7_top.add(allright7, BorderLayout.EAST);
    centreleft_7_top.add(allmidle7, BorderLayout.CENTER);
    centreleft_7_top.add(allmidle7, BorderLayout.SOUTH);
   JButton re=new JButton("    Restore   ");
    re.addActionListener(e->{
    Restore d;
        try {
            d = new Restore(role);
             d.setVisible(true);
             dispose();
        } catch (ParseException ex) {
            Logger.getLogger(HomeForm.class.getName()).log(Level.SEVERE, null, ex);
        }
   
    });
    allleft7.add(re);     
     centreleft_8_top.add(Box.createVerticalStrut(30));
     EXIT = new JButton("                        Registration                                 ");
    //centreleft_6_top_box = new BoxLayout(centreleft_6_top, BoxLayout.Y_AXIS);
    //centreleft_6_top.setLayout(centreleft_6_top_box);
    centreleft_8_top.setLayout(new BorderLayout());
    JPanel allleft8 = new JPanel();
    JPanel alltop8 = new JPanel();
    JPanel allmidle8 = new JPanel();
    JPanel allright8 = new JPanel();
    JPanel allbottom8 = new JPanel();
    centreleft_8_top.add(alltop8, BorderLayout.NORTH);
    centreleft_8_top.add(allleft8, BorderLayout.WEST);
    centreleft_8_top.add(allright8, BorderLayout.EAST);
    centreleft_8_top.add(allmidle8, BorderLayout.CENTER);
    centreleft_8_top.add(allmidle8, BorderLayout.SOUTH);
    
    
    
    bar = new JMenuBar();
    JMenu other=new JMenu("Other              ");
    other.add(new JMenuItem("Registration"));
    other.add(new JMenuItem("Delete Account"));
    other.add(new JMenuItem("Backup"));
    bar.add(other);
    setJMenuBar(bar);
    allleft8.add(bar);
 
     
     
     if(role.equals("Admin"))
     {
         
     }
    else if(role.equals("CoAdmin"))
     {
           Component[] components =  allleft6.getComponents();//delete
        for (Component component : components) {
           component.setVisible(false);
        }
        components =  allleft7.getComponents();//restore
        for (Component component : components) {
           component.setVisible(false);
        }
         components =  singleleft1.getComponents();//restore
        for (Component component : components) {
           component.setVisible(false);
        }
         other.getItem(0).setVisible(false);
         other.getItem(1).setVisible(false);
//registration
        // regis.setVisible(false);

     }
     else
     {
            // Disable all components in the panel
        Component[] components =  allleft4.getComponents();//edit
        for (Component component : components) {
           component.setVisible(false);
        }
        components =  allleft6.getComponents();//delete
        for (Component component : components) {
           component.setVisible(false);
        }
         components =  allleft7.getComponents();//restore
        for (Component component : components) {
           component.setVisible(false);
        }
        components =  singleleft1.getComponents();//restore
        for (Component component : components) {
           component.setVisible(false);
        }
        // regis.setVisible(false);
         other.getItem(0).setVisible(false);
         other.getItem(1).setVisible(false);

     }
    
     other.getItem(2).addActionListener(e->{
        connection.backup();
     });
      other.getItem(1).addActionListener(e->{
          json=connection.registrationdata();
     array = new JSONArray();
     jsondata = new JSONObject();
     arraymoney = new JSONArray();
     arrayincomesource = new JSONArray();
        try {
            array=new JSONArray(json.getString("data"));
        } catch (JSONException ex) {
            Logger.getLogger(HomeForm.class.getName()).log(Level.SEVERE, null, ex);
        }
     panel = new JPanel(new GridLayout(2, 1, 0, 0));
    JPanel panelone = new JPanel(new GridLayout(array.length(), 11, 5, 5));
    JPanel paneltwo = new JPanel(new GridLayout(1, 1, 0, 0));// 0 rows, 4 columns
  // JTextField[] incomefield=new   JTextField[array.length()]; 
    //JTextField[] incomemoneyfield=new JTextField[array.length()]; 
     //JDateChooser[] endDateChooser = new JDateChooser[array.length()];
     usernamef=new String [array.length()];
     passwordf=new String [array.length()];
     rolingf=new String [array.length()];
     deletef=new JButton[array.length()];
     for(int i=0;i<array.length();i++){
                                   
              try {
                  jsondata=new JSONObject(array.getString(i));
                  usernamef[i]=new JSONArray(jsondata.getString("username")).getString(0);
                 rolingf[i]=new JSONArray(jsondata.getString("role")).getString(0);
                 passwordf[i]=new JSONArray(jsondata.getString("password")).getString(0);
                 deletef[i]=new JButton("Delete");
              } catch (JSONException ex) {
                  Logger.getLogger(HomeForm.class.getName()).log(Level.SEVERE, null, ex);
              }
       
       
       panelone.add(new Label( usernamef[i]));
         panelone.add(new Label(  passwordf[i]));
       panelone.add(new Label( rolingf[i]));
       panelone.add(deletef[i]);
        panelone.add(new JLabel("                     "));
       panel.add(panelone);
       panel.add(paneltwo);
     }
      for(int n=0;n<array.length();n++)
                                    {
                    int jk=n;
                    String ab=usernamef[n];String abc=passwordf[n] ;String abcd=rolingf[n];
                     deletef[n].addActionListener(u->{ 
                        try {
                            connection.deleteregistration(ab,abc,abcd);
                        } catch (ClassNotFoundException ex) {
                            Logger.getLogger(HomeForm.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (SQLException ex) {
                            Logger.getLogger(HomeForm.class.getName()).log(Level.SEVERE, null, ex);
                        }
                         
                         deletef[jk].setEnabled(false);
                         
                         // panel.revalidate();
                         
                         // panel.p
              });

                }

            JScrollPane scrollPane = new JScrollPane(panel);
              scrollPane.setPreferredSize(panel.getPreferredSize());
              int option = JOptionPane.showOptionDialog(null, scrollPane, "Registration information",
                       JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, null, null);

               if (option == JOptionPane.OK_OPTION) {
               scrollPane.removeAll(); // Remove all components from the panel
                scrollPane.revalidate(); // Revalidate the panel to reflect the changes
              scrollPane.repaint();
               }                               

                              
     });

     other.getItem(0).addActionListener(e->{
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
            
            if(!username.isBlank()&& !password.isBlank())
            {
              try {
                  boolean res=connection.registration(username, password,selectedRole);
                  if(res)
                  {
                     JOptionPane.showMessageDialog(null, "Registration is done successfully"); 
                  }
                  else
                  {
                      JOptionPane.showMessageDialog(null, "Registration is incomplete");
                  }
              } catch (ParseException ex) {
                  Logger.getLogger(HomeForm.class.getName()).log(Level.SEVERE, null, ex);
              }  
            }
            else
            {
                 JOptionPane.showMessageDialog(null, "Please Fillup all field"); 
            }
              
            
        } else {
            System.out.println("Registration canceled.");
        }
     });
   // centreleft_6_top.add(menu);

}
public void downloadbody()
    {
      
    JLabel downloadjl1 = new JLabel("                                                                          ");
     menu=new JMenu("Download");
   //return from database info
    
        bar = new JMenuBar();
        projectname=new JMenu("Flat Download(All)");
        capital=new JMenu("Single Project Download (All)");
        timeperiod=new JMenu("Single Project Download (Period)");
        editsetutility=new JMenu("Sharemate Information");
        result=connection.getsharemateprojectname();
        result.forEach(e->{
          json=connection.getsharemateprojectflatinfo(e);
           JMenu flatname=new JMenu(e);
            JMenu flatnamep=new JMenu(e);
            flatnamep.add(new JMenuItem("OneDay"));
            flatnamep.add(new JMenuItem("OneMoreDay"));
             flatnamep.add(new JMenuItem("PeriodDay"));
           Iterator<String> keys = json.keys();
             while(keys.hasNext())
             {
                 String txt=keys.next();
                  flatname.add(new JMenuItem(txt));
             }
         projectname.add(flatname);
         capital.add(e);
         editsetutility.add(e);
         timeperiod.add(flatnamep);
     });
    //add project income and capital
    menu.add(projectname);
    menu.add(capital);
    menu.add( timeperiod);
    JMenu others=new JMenu("Others");
    others.add(new JMenuItem("All"));
    others.add(new JMenuItem("Period"));
    JMenu projects=new JMenu("All Projects");
    projects.add(new JMenuItem("All"));
    projects.add(new JMenuItem("Period"));
    menu.add(others);
    menu.add(projects);
    menu.add(editsetutility);

   // System.out.print(menu.getItem(0).getText());
    
    bar = new JMenuBar();
    bar.add(menu);
    setJMenuBar(bar);
    
    downloadleft1.add(bar);
    downloadright1.add(downloadjl1);
    
      xy= (JMenu) menu.getItem(5);
     count=xy.getItemCount();
    for(int i=0;i<count;i++)
    {
        String prn=xy.getItem(i).getText();
        xy.getItem(i).addActionListener(e->{
            try {
                
                System.out.print("presd");
                // CreateProjectAddCapital
                sharemateprojectpdffunction  kk =new  sharemateprojectpdffunction ();
                kk.allpdf(prn);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(HomeForm.class.getName()).log(Level.SEVERE, null, ex);
            } catch (DocumentException ex) {
                Logger.getLogger(HomeForm.class.getName()).log(Level.SEVERE, null, ex);
            } catch (JSONException ex) {
                Logger.getLogger(HomeForm.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(HomeForm.class.getName()).log(Level.SEVERE, null, ex);
            }
           
        });
        
    }
    
     //capitals
           xy= (JMenu) menu.getItem(4);
           xy.getItem(0).addActionListener(e->{
       System.out.print("You Have Press in all\n");
       Allpdffunction Allpdffunction=new Allpdffunction();
        try {
            Allpdffunction.allpdf();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(HomeForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DocumentException ex) {
            Logger.getLogger(HomeForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JSONException ex) {
            Logger.getLogger(HomeForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(HomeForm.class.getName()).log(Level.SEVERE, null, ex);
        }
     });
     
            xy.getItem(1).addActionListener(e->{
       
                    JDateChooser endDateChooser = new JDateChooser();
                    endDateChooser.setDateFormatString("yyyy-MM-dd");
                    endDateChooser.setPreferredSize(new java.awt.Dimension(300, 50));
                    java.awt.Font font =  endDateChooser.getFont();
                    float newSize = font.getSize() + 4; // Increase the font size by 4
                    endDateChooser.setFont(font.deriveFont(newSize));

                    JDateChooser startDateChooser = new JDateChooser();
                    startDateChooser.setDateFormatString("yyyy-MM-dd");
                    startDateChooser.setPreferredSize(new java.awt.Dimension(300, 50));
                    font =  startDateChooser.getFont();
                    newSize = font.getSize() + 4; // Increase the font size by 4
                    startDateChooser.setFont(font.deriveFont(newSize));
                    JPanel panel = new JPanel();

                    panel.add(new JLabel("Start date:"));
                    panel.add(startDateChooser);
                    panel.add(new JLabel("End date:"));
                    panel.add(endDateChooser);

                   int option = JOptionPane.showOptionDialog(null, panel, "Information from Start to select date",
                           JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, null, null);

                   if (option == JOptionPane.OK_OPTION) {

                       java.util.Date endDate = endDateChooser.getDate();
                        java.util.Date startDate = startDateChooser.getDate();
                        try {
                            Allpdffunctionwithperiod pe=new Allpdffunctionwithperiod();
                            
                        pe.allpdf(new SimpleDateFormat("yyyy-MM-dd").format(startDate),new SimpleDateFormat("yyyy-MM-dd").format(endDate));
                        } catch (JSONException ex) {
                            Logger.getLogger(HomeForm.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (DocumentException ex) {
                            Logger.getLogger(HomeForm.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (IOException ex) {
                            Logger.getLogger(HomeForm.class.getName()).log(Level.SEVERE, null, ex);
                        }

                   } 

                                  
     });
     
       xy= (JMenu) menu.getItem(3);
           xy.getItem(0).addActionListener(e->{
       Otherspdf Allpdffunction;
        try {
            Allpdffunction = new Otherspdf();
        } catch (DocumentException ex) {
            Logger.getLogger(HomeForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JSONException ex) {
            Logger.getLogger(HomeForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(HomeForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        
     });
     
            xy.getItem(1).addActionListener(e->{
       
                    JDateChooser endDateChooser = new JDateChooser();
                    endDateChooser.setDateFormatString("yyyy-MM-dd");
                    endDateChooser.setPreferredSize(new java.awt.Dimension(300, 50));
                    java.awt.Font font =  endDateChooser.getFont();
                    float newSize = font.getSize() + 4; // Increase the font size by 4
                    endDateChooser.setFont(font.deriveFont(newSize));

                    JDateChooser startDateChooser = new JDateChooser();
                    startDateChooser.setDateFormatString("yyyy-MM-dd");
                    startDateChooser.setPreferredSize(new java.awt.Dimension(300, 50));
                    font =  startDateChooser.getFont();
                    newSize = font.getSize() + 4; // Increase the font size by 4
                    startDateChooser.setFont(font.deriveFont(newSize));
                    JPanel panel = new JPanel();

                    panel.add(new JLabel("Start date:"));
                    panel.add(startDateChooser);
                    panel.add(new JLabel("End date:"));
                    panel.add(endDateChooser);

                   int option = JOptionPane.showOptionDialog(null, panel, "Information from Start to select date",
                           JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, null, null);

                   if (option == JOptionPane.OK_OPTION) {

                       java.util.Date endDate = endDateChooser.getDate();
                        java.util.Date startDate = startDateChooser.getDate();
                        try {
                              Otherspdfperiod pe=new  Otherspdfperiod(new SimpleDateFormat("yyyy-MM-dd").format(startDate),new SimpleDateFormat("yyyy-MM-dd").format(endDate));
                        } catch (JSONException ex) {
                            Logger.getLogger(HomeForm.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (DocumentException ex) {
                            Logger.getLogger(HomeForm.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (IOException ex) {
                            Logger.getLogger(HomeForm.class.getName()).log(Level.SEVERE, null, ex);
                        }

                   } 

                                  
     });
     
     
            
     xy= (JMenu) menu.getItem(2);
     count=xy.getItemCount();
     for(int i=0;i<count;i++)
     {
                JMenu xyz=(JMenu) xy.getItem(i);
                String prn=xy.getItem(i).getText();
                bge=xyz;
                  int cc=xyz.getItemCount();
                  for(int j=0;j<cc;j++)
                    {
                     bge.getItem(j).addActionListener(e->{
                                if(e.getActionCommand().equals("OneDay"))
                                {
                                    JDateChooser endDateChooser = new JDateChooser();
                                    endDateChooser.setDateFormatString("yyyy-MM-dd");
                                    endDateChooser.setPreferredSize(new java.awt.Dimension(300, 50));
                                    java.awt.Font font =  endDateChooser.getFont();
                                    float newSize = font.getSize() + 4; // Increase the font size by 4
                                    endDateChooser.setFont(font.deriveFont(newSize));
                                    JPanel panel = new JPanel();
                                    panel.add(new JLabel("Select date:"));
                                    panel.add(endDateChooser);

                                   int option = JOptionPane.showOptionDialog(null, panel, "Single day information",
                                           JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, null, null);

                                   if (option == JOptionPane.OK_OPTION) {
                                       java.util.Date endDate = endDateChooser.getDate();
                                        try {
                                            //singleDaypdffunction pe=new  singleDaypdffunction(prn,new SimpleDateFormat("yyyy-MM-dd").format(endDate));
                                             Singledaypdf hh=new Singledaypdf(prn,new SimpleDateFormat("yyyy-MM-dd").format(endDate));
                                        } catch (FileNotFoundException ex) {
                                            Logger.getLogger(HomeForm.class.getName()).log(Level.SEVERE, null, ex);
                                        } catch (DocumentException ex) {
                                            Logger.getLogger(HomeForm.class.getName()).log(Level.SEVERE, null, ex);
                                        } catch (JSONException ex) {
                                            Logger.getLogger(HomeForm.class.getName()).log(Level.SEVERE, null, ex);
                                        } catch (IOException ex) {
                                            Logger.getLogger(HomeForm.class.getName()).log(Level.SEVERE, null, ex);
                                        }

                                   }   
                                }
                                else if(e.getActionCommand().equals("OneMoreDay"))
                                {
                                    JDateChooser endDateChooser = new JDateChooser();
                                    endDateChooser.setDateFormatString("yyyy-MM-dd");
                                    endDateChooser.setPreferredSize(new java.awt.Dimension(300, 50));
                                    java.awt.Font font =  endDateChooser.getFont();
                                    float newSize = font.getSize() + 4; // Increase the font size by 4
                                    endDateChooser.setFont(font.deriveFont(newSize));
                                    JPanel panel = new JPanel();
                                    panel.add(new JLabel("Select date:"));
                                    panel.add(endDateChooser);

                                   int option = JOptionPane.showOptionDialog(null, panel, "Information from Start to select date",
                                           JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, null, null);

                                   if (option == JOptionPane.OK_OPTION) {
                                       
                                       java.util.Date endDate = endDateChooser.getDate();
                                        try {
                                             OneModedaypdf  hh=new OneModedaypdf(prn,new SimpleDateFormat("yyyy-MM-dd").format(endDate));
                                        } catch (FileNotFoundException ex) {
                                            Logger.getLogger(HomeForm.class.getName()).log(Level.SEVERE, null, ex);
                                        } catch (DocumentException ex) {
                                            Logger.getLogger(HomeForm.class.getName()).log(Level.SEVERE, null, ex);
                                        } catch (JSONException ex) {
                                            Logger.getLogger(HomeForm.class.getName()).log(Level.SEVERE, null, ex);
                                        } catch (IOException ex) {
                                            Logger.getLogger(HomeForm.class.getName()).log(Level.SEVERE, null, ex);
                                        }

                                   } 
                                    
                                }
                                else
                                {
                                    JDateChooser endDateChooser = new JDateChooser();
                                    endDateChooser.setDateFormatString("yyyy-MM-dd");
                                    endDateChooser.setPreferredSize(new java.awt.Dimension(300, 50));
                                    java.awt.Font font =  endDateChooser.getFont();
                                    float newSize = font.getSize() + 4; // Increase the font size by 4
                                    endDateChooser.setFont(font.deriveFont(newSize));
                                    
                                    JDateChooser startDateChooser = new JDateChooser();
                                    startDateChooser.setDateFormatString("yyyy-MM-dd");
                                    startDateChooser.setPreferredSize(new java.awt.Dimension(300, 50));
                                    font =  startDateChooser.getFont();
                                    newSize = font.getSize() + 4; // Increase the font size by 4
                                    startDateChooser.setFont(font.deriveFont(newSize));
                                    JPanel panel = new JPanel();
                                    
                                    panel.add(new JLabel("Start date:"));
                                    panel.add(startDateChooser);
                                    panel.add(new JLabel("End date:"));
                                    panel.add(endDateChooser);

                                   int option = JOptionPane.showOptionDialog(null, panel, "Information from Start to select date",
                                           JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, null, null);

                                   if (option == JOptionPane.OK_OPTION) {
                                       
                                       java.util.Date endDate = endDateChooser.getDate();
                                        java.util.Date startDate = startDateChooser.getDate();
                                        try {
                                            Periodpdf pe=new Periodpdf(prn,new SimpleDateFormat("yyyy-MM-dd").format(startDate),new SimpleDateFormat("yyyy-MM-dd").format(endDate));
                                        } catch (FileNotFoundException ex) {
                                            Logger.getLogger(HomeForm.class.getName()).log(Level.SEVERE, null, ex);
                                        } catch (DocumentException ex) {
                                            Logger.getLogger(HomeForm.class.getName()).log(Level.SEVERE, null, ex);
                                        } catch (JSONException ex) {
                                            Logger.getLogger(HomeForm.class.getName()).log(Level.SEVERE, null, ex);
                                        } catch (IOException ex) {
                                            Logger.getLogger(HomeForm.class.getName()).log(Level.SEVERE, null, ex);
                                        }

                                   } 
                                   
                                    
                                }

                     });
                    }
     }
     
     xy= (JMenu) menu.getItem(1);
     count=xy.getItemCount();
    for(int i=0;i<count;i++)
    {
        String prn=xy.getItem(i).getText();
        xy.getItem(i).addActionListener(e->{
            try {
                
                System.out.print("presd");
                // CreateProjectAddCapital
                projectpdffunction  kk =new  projectpdffunction (prn);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(HomeForm.class.getName()).log(Level.SEVERE, null, ex);
            } catch (DocumentException ex) {
                Logger.getLogger(HomeForm.class.getName()).log(Level.SEVERE, null, ex);
            } catch (JSONException ex) {
                Logger.getLogger(HomeForm.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(HomeForm.class.getName()).log(Level.SEVERE, null, ex);
            }
           
        });
        
    }
    
     xy= (JMenu) menu.getItem(0);
     count=xy.getItemCount();
     for(int i=0;i<count;i++)
     {
                JMenu xyz=(JMenu) xy.getItem(i);
                String prn=xy.getItem(i).getText();
                bge=xyz;
                  int cc=xyz.getItemCount();
                  for(int j=0;j<cc;j++)
                    {
                     bge.getItem(j).addActionListener(e->{
                         try {
                             flatpdffunction  kk =new  flatpdffunction (prn,e.getActionCommand());
                         } catch (FileNotFoundException ex) {
                             Logger.getLogger(HomeForm.class.getName()).log(Level.SEVERE, null, ex);
                         } catch (DocumentException ex) {
                             Logger.getLogger(HomeForm.class.getName()).log(Level.SEVERE, null, ex);
                         } catch (JSONException ex) {
                             Logger.getLogger(HomeForm.class.getName()).log(Level.SEVERE, null, ex);
                         } catch (IOException ex) {
                             Logger.getLogger(HomeForm.class.getName()).log(Level.SEVERE, null, ex);
                         }
                     });
                    }
     }
    
  
    }

public void centremiddle() {
    //main  frst outdoor
    centrecentre.setLayout(new BorderLayout());
    centrecentre_1_top = new JPanel();
    centrecentre_1_centre = new JPanel();
    centrecentre_1_bottom = new JPanel();

    centrecentre_1_top.add(Box.createVerticalStrut(20));
    centrecentre.add(centrecentre_1_top, BorderLayout.NORTH);
    centrecentre.add(centrecentre_1_centre, BorderLayout.CENTER);
    //centreleft.add(centreleft_1_bottom,BorderLayout.SOUTH);

    addcentrecontent();

}

public void addcentrecontent() {
    centrecentre_1_top_box = new BoxLayout(centrecentre_1_top, BoxLayout.Y_AXIS);
    centrecentre_1_top.setLayout(centrecentre_1_top_box);
    centrecentre_1_top.add(Box.createVerticalStrut(20));
    centrecentre_1_top_label = new JLabel("                                                                                                                                                                        ");
    centrecentre_1_top_textfield = new JTextField();
    centrecentre_1_top.add(centrecentre_1_top_label);

}

public void centreright() {
    //main  frst outdoor
    centreright.setLayout(new BorderLayout());
    centreright_1_top = new JPanel();
    centreright_1_centre = new JPanel();
    centreright_1_bottom = new JPanel();

    centreright_1_top.add(Box.createVerticalStrut(20));
    centreright.add(centreright_1_top, BorderLayout.NORTH);
    centreright.add(centreright_1_centre, BorderLayout.CENTER);

    //second indoor
    centreright_1_centre.setLayout(new BorderLayout());
    centreright_2_top = new JPanel();
    centreright_2_centre = new JPanel();
    centreright_2_bottom = new JPanel();

    centreright_2_top.add(Box.createVerticalStrut(20));
    centreright_1_centre.add(centreright_2_top, BorderLayout.NORTH);
    centreright_1_centre.add(centreright_2_centre, BorderLayout.CENTER);
    //centreleft_1_centre.add(centreleft_2_bottom,BorderLayout.SOUTH);
    //third indoor
    centreright_2_centre.setLayout(new BorderLayout());
    centreright_3_top = new JPanel();
    centreright_3_centre = new JPanel();
    centreright_3_bottom = new JPanel();

    centreright_1_top.add(Box.createVerticalStrut(20));
    centreright_2_centre.add(centreright_3_top, BorderLayout.NORTH);
    centreright_2_centre.add(centreright_3_centre, BorderLayout.CENTER);
    // centreleft_2_centre.add(centreleft_3_bottom,BorderLayout.SOUTH);
    //fourth indoor
    centreright_3_centre.setLayout(new BorderLayout());
    centreright_4_top = new JPanel();
    centreright_4_centre = new JPanel();
    centreright_4_bottom = new JPanel();

    centreright_4_top.add(Box.createVerticalStrut(20));
    centreright_3_centre.add(centreright_4_top, BorderLayout.NORTH);
    centreright_3_centre.add(centreright_4_centre, BorderLayout.CENTER);
    //centreleft_3_centre.add(centreleft_4_bottom,BorderLayout.SOUTH);

    //five indoor
    centreright_4_centre.setLayout(new BorderLayout());
    centreright_5_top = new JPanel();
    centreright_5_centre = new JPanel();
    centreright_5_bottom = new JPanel();

    centreright_5_top.add(Box.createVerticalStrut(20));
    centreright_4_centre.add(centreright_5_top, BorderLayout.NORTH);
    centreright_4_centre.add(centreright_5_centre, BorderLayout.CENTER);
    //centreleft_4_centre.add(centreleft_5_bottom,BorderLayout.SOUTH);

    //six indoor
    centreright_5_centre.setLayout(new BorderLayout());
    centreright_6_top = new JPanel();
    centreright_6_centre = new JPanel();
    centreright_6_bottom = new JPanel();

    centreright_6_top.add(Box.createVerticalStrut(20));
    centreright_5_centre.add(centreright_6_top, BorderLayout.NORTH);
    centreright_5_centre.add(centreright_6_centre, BorderLayout.CENTER);
    // centreleft_5_centre.add(centreleft_6_bottom,BorderLayout.SOUTH);

    //seven indoor
    centreright_6_centre.setLayout(new BorderLayout());
    centreright_7_top = new JPanel();
    centreright_7_centre = new JPanel();
    centreright_7_bottom = new JPanel();

    centreright_7_top.add(Box.createVerticalStrut(20));
    centreright_6_centre.add(centreright_7_top, BorderLayout.NORTH);
    centreright_6_centre.add(centreright_7_centre, BorderLayout.CENTER);
    // centreleft_5_centre.add(centreleft_6_bottom,BorderLayout.SOUTH);

    //eight indoor
    centreright_7_centre.setLayout(new BorderLayout());
    centreright_8_top = new JPanel();
    centreright_8_centre = new JPanel();
    centreright_8_bottom = new JPanel();

    centreright_8_top.add(Box.createVerticalStrut(20));
    centreright_7_centre.add(centreright_8_top, BorderLayout.NORTH);
    centreright_7_centre.add(centreright_8_centre, BorderLayout.CENTER);
    // centreleft_5_centre.add(centreleft_6_bottom,BorderLayout.SOUTH);
    //nine indoor
    centreright_8_centre.setLayout(new BorderLayout());
    centreright_9_top = new JPanel();
    centreright_9_centre = new JPanel();
    centreright_9_bottom = new JPanel();

    centreright_9_top.add(Box.createVerticalStrut(20));
    centreright_8_centre.add(centreright_9_top, BorderLayout.NORTH);
    centreright_8_centre.add(centreright_9_centre, BorderLayout.CENTER);
    // centreleft_5_centre.add(centreleft_6_bottom,BorderLayout.SOUTH);

    //nine indoor
    centreright_9_centre.setLayout(new BorderLayout());
    centreright_10_top = new JPanel();
    centreright_10_centre = new JPanel();
    centreright_10_bottom = new JPanel();

    centreright_10_top.add(Box.createVerticalStrut(20));
    centreright_9_centre.add(centreright_10_top, BorderLayout.NORTH);
    centreright_9_centre.add(centreright_10_centre, BorderLayout.CENTER);
    // centreleft_5_centre.add(centreleft_6_bottom,BorderLayout.SOUTH);

    addrightcontent();

}

public void addrightcontent() {
    centreright_1_top_box = new BoxLayout(centreright_1_top, BoxLayout.Y_AXIS);
    centreright_1_top.setLayout(centreright_1_top_box);
    centreright_1_top_label = new JLabel("Total(serial 1-9):                                ");
    centreright_1_top_textfield = new JTextField();
    centreright_1_top_textfield.setEnabled(false);
    centreright_1_top.add(centreright_1_top_label);
    centreright_1_top.add(centreright_1_top_textfield);

    //2
    centreright_2_top_box = new BoxLayout(centreright_2_top, BoxLayout.Y_AXIS);
    centreright_2_top.setLayout(centreright_2_top_box);
    centreright_2_top_label = new JLabel("Foreign Income:                                      ");
    centreright_2_top_textfield = new JTextField();
    centreright_2_top.add(centreright_2_top_label);
    centreright_2_top.add(centreright_2_top_textfield);

    //3
    centreright_3_top_box = new BoxLayout(centreright_3_top, BoxLayout.Y_AXIS);
    centreright_3_top.setLayout(centreright_3_top_box);
    centreright_3_top_label = new JLabel("Total Income(Serial 10-11):                                   ");
    centreright_3_top_textfield = new JTextField();
    centreright_3_top_textfield.setEnabled(false);
    centreright_3_top.add(centreright_3_top_label);
    centreright_3_top.add(centreright_3_top_textfield);
    //4
    centreright_4_top_box = new BoxLayout(centreright_4_top, BoxLayout.Y_AXIS);
    centreright_4_top.setLayout(centreright_4_top_box);
    centreright_4_top_label = new JLabel("Tax Leviable on total income:                                    ");
    centreright_4_top_textfield = new JTextField();
    centreright_4_top.add(centreright_4_top_label);
    centreright_4_top.add(centreright_4_top_textfield);
    //5
    centreright_5_top_box = new BoxLayout(centreright_5_top, BoxLayout.Y_AXIS);
    centreright_5_top.setLayout(centreright_5_top_box);
    centreright_5_top_label = new JLabel("Tax rebate:u/s 44(2)(b)(as per schedule-3):                                ");
    centreright_5_top_textfield = new JTextField();
    centreright_5_top_textfield.setEnabled(false);
    centreright_5_top.add(centreright_5_top_label);
    centreright_5_top.add(centreright_5_top_textfield);
    //6
    centreright_6_top_box = new BoxLayout(centreright_6_top, BoxLayout.Y_AXIS);
    centreright_6_top.setLayout(centreright_6_top_box);
    centreright_6_top_label = new JLabel("Tax payable(difference between serial 13 and 14):                              ");
    centreright_6_top_textfield = new JTextField();
    centreright_6_top_textfield.setEnabled(false);
    centreright_6_top.add(centreright_6_top_label);
    centreright_6_top.add(centreright_6_top_textfield);
    //7
    centreright_7_top_box = new BoxLayout(centreright_7_top, BoxLayout.Y_AXIS);
    centreright_7_top.setLayout(centreright_7_top_box);
    centreright_7_top_label = new JLabel("Tax Payments:                               ");
    centreright_7_top_textfield = new JTextField();
    centreright_7_top_textfield.setEnabled(false);
    centreright_7_top_adddetail = new JButton("Add Detail");
    centreright_7_top.add(centreright_7_top_label);
    centreright_7_top.add(centreright_7_top_textfield);
    centreright_7_top.add(centreright_7_top_adddetail);
    centreright_7_top_adddetail.addActionListener(e -> adddetails_right_7());
    //8
    centreright_8_top_box = new BoxLayout(centreright_8_top, BoxLayout.Y_AXIS);
    centreright_8_top.setLayout(centreright_8_top_box);
    centreright_8_top_label = new JLabel("Difference between serial 15 and 16(if any):                                 ");
    centreright_8_top_textfield = new JTextField();
    centreright_8_top_textfield.setEnabled(false);
    centreright_8_top.add(centreright_8_top_label);
    centreright_8_top.add(centreright_8_top_textfield);
    //9
    centreright_9_top_box = new BoxLayout(centreright_9_top, BoxLayout.Y_AXIS);
    centreright_9_top.setLayout(centreright_9_top_box);
    centreright_9_top_label = new JLabel("Tax exempted & Tax Free Income:                                     ");
    centreright_9_top_textfield = new JTextField();
    centreright_9_top_textfield.setEnabled(false);
    centreright_9_top.add(centreright_9_top_label);
    centreright_9_top.add(centreright_9_top_textfield);

    //10
    centreright_10_top_box = new BoxLayout(centreright_10_top, BoxLayout.Y_AXIS);
    centreright_10_top.setLayout(centreright_10_top_box);
    centreright_10_top_label = new JLabel("Income tax paid in the last assessment year:                                     ");
    centreright_10_top_textfield = new JTextField();
    JLabel yy = new JLabel("                                                                                                                                                                                                                                                                                                                 ");
    centreright_10_top.add(centreright_10_top_label);
    centreright_10_top.add(centreright_10_top_textfield);
    // centreright_10_top.add(yy);

}

public void adddetails_right_7() {
    //centreleft_1_top.setLayout(new BorderLayout());
    centreright_7_top_upper = new JPanel();
    centreright_7_top_box_upper = new BoxLayout(centreright_7_top_upper, BoxLayout.Y_AXIS);
    centreright_7_top_upper.setLayout(centreright_7_top_box_upper);

    centreright_7_top_middle = new JPanel();
    centreright_7_top_middle.setBackground(Color.green);

    centreright_7_top.add(centreright_7_top_upper, BorderLayout.NORTH);
    centreright_7_top.add(centreright_7_top_middle, BorderLayout.CENTER);
    centreright_7_top_label_next_taxdeducted1 = new JLabel("Tax deducted/Collected source(Please submit supporting documents/statement):");
    centreright_7_top_textfield_next_taxdeducted1 = new JTextField();
    centreright_7_top_label_next_advancetax2 = new JLabel("Advance tax u/s 64/68(Please Attach challan):");
    centreright_7_top_textfield_next_advancetax2 = new JTextField();

    centreright_7_top_label_next_taxpaid3 = new JLabel("Tax paid on the basis of this return(u/s 74)(Please please attach challan/pay order/bank draft/cheque):");
    centreright_7_top_textfield_next_taxpaid3 = new JTextField();
    centreright_7_top_label_next_adjustrefund4 = new JLabel("Adjust of Tax Refund (if any):");
    centreright_7_top_textfield_next_adjustrefund4 = new JTextField();

    centreright_7_top_add = new JButton("Add");
    centreright_7_top_add.addActionListener(e -> adddetails_centre_add());
    centreright_7_top_upper.add(Box.createVerticalStrut(20));
    centreright_7_top_upper.add(centreright_7_top_label_next_taxdeducted1);
    centreright_7_top_upper.add(centreright_7_top_textfield_next_taxdeducted1);
    centreright_7_top_upper.add(Box.createVerticalStrut(20));
    centreright_7_top_upper.add(centreright_7_top_label_next_advancetax2);
    centreright_7_top_upper.add(centreright_7_top_textfield_next_advancetax2);
    centreright_7_top_upper.add(Box.createVerticalStrut(20));

    centreright_7_top_upper.add(centreright_7_top_label_next_taxpaid3);
    centreright_7_top_upper.add(centreright_7_top_textfield_next_taxpaid3);
    centreright_7_top_upper.add(Box.createVerticalStrut(20));
    centreright_7_top_upper.add(centreright_7_top_label_next_adjustrefund4);
    centreright_7_top_upper.add(centreright_7_top_textfield_next_adjustrefund4);
    centreright_7_top_upper.add(Box.createVerticalStrut(20));
    centreright_7_top_middle.add(centreright_7_top_add);
    mainbody.revalidate();

}

public void adddetails_centre_add() {

}

public void centrebottom() {
    bottom.setLayout(new BorderLayout());
    bottom_left = new JPanel();
    bottom_left.setBackground(Color.ORANGE);
    bottom_right = new JPanel();
    bottom_right.setBackground(Color.black);
    bottom_top = new JPanel();
    bottom_top.setBackground(Color.green);
    bottom_bottom = new JPanel();
    bottom_bottom.setBackground(Color.gray);
    bottom_centre = new JPanel();
    bottom_centre.setBackground(Color.green);
    bottom.add(bottom_left, BorderLayout.WEST);
    bottom.add(bottom_right, BorderLayout.EAST);
    bottom.add(bottom_top, BorderLayout.NORTH);
    bottom.add(bottom_bottom, BorderLayout.SOUTH);
    bottom.add(bottom_centre, BorderLayout.CENTER);

    JButton jj = new JButton("Login              ");
    bottom_top.add(jj);
    jj.addActionListener(e -> 
    {
        loginForm ll=new loginForm();
         ll.setVisible(true);
         dispose();
    });

}

public void submit() {
}

public void bottom() {

    centreright.setVisible(false);

}
}
