package Registration;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Rectangle;
import com.sun.jdi.connect.spi.Connection;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.security.Timestamp;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.stream.Collectors;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import org.json.JSONArray;
import org.json.JSONObject;
  

public class Database {
    TableClass TableClass;
             Date sqlDate;    
        JSONObject jsonObject = new JSONObject();
        JSONObject jsondata = new JSONObject();
        JSONObject jsoncpmbine = new JSONObject();
        JSONArray array = new JSONArray();
        JSONArray arrayn = new JSONArray();
                HashSet<TableClass> resultdata=new HashSet();  

        
    public  JSONObject allproject(String pn) {
        HashSet<String> result=new HashSet(); 
        

     try {
        java.sql.Connection con = databasebasecon();
        String query;
        if (con != null) {
            //project capital
            String querymax = "SELECT SUM(money)as money  FROM projectcapitalincome where projectname='"+pn+"' ;";
            Statement state = con.createStatement();
            ResultSet rrr = state.executeQuery(querymax);
            int test = 0;
            array = new JSONArray();
            while (rrr.next()) {
                jsondata = new JSONObject();
                jsondata.append("name", pn);
                jsondata.append("money", rrr.getString("money"));
                array.put(jsondata);
              test = 1; 
                           
            }
            jsonObject.put("capitalincome", array);
            jsoncpmbine = new JSONObject();
            array = new JSONArray();
            querymax = "SELECT SUM(money)as money FROM projectincome where projectname='"+pn+"' ;";
            state = con.createStatement();
            rrr = state.executeQuery(querymax);
            test = 0;
            while (rrr.next()) {
                jsondata = new JSONObject();
                jsondata.append("money", rrr.getString("money"));
                array.put(jsondata);
              test = 1; 
                
                test = 1;
            }
             jsonObject.put("flatincome", array);
             
            jsoncpmbine = new JSONObject();
            array = new JSONArray();
            querymax = "SELECT SUM(money)as money FROM projectdebitwithdraw where projectname='"+pn+"' ;";
            state = con.createStatement();
            rrr = state.executeQuery(querymax);
            test = 0;
            while (rrr.next()) {
                jsondata = new JSONObject();
                jsondata.append("money", rrr.getString("money"));
                array.put(jsondata);
              test = 1; 
                
                test = 1;
            }
              jsonObject.put("flatdebit", array);
              
             jsoncpmbine = new JSONObject();
            array = new JSONArray();
            querymax = "SELECT SUM(money)as money FROM projectdebit where projectname='"+pn+"' ;";
            state = con.createStatement();
            rrr = state.executeQuery(querymax);
            test = 0;
            while (rrr.next()) {
                jsondata = new JSONObject();
                jsondata.append("money", rrr.getString("money"));
                array.put(jsondata);
              test = 1; 
                
                test = 1;
            }
              jsonObject.put("projectdebit", array);
            
        } else {
            JOptionPane.showMessageDialog(null, "Not Conected");
        }

    } catch (Exception ee) {
    ee.printStackTrace();

    }
    return (jsonObject);
    }
   public  JSONObject singleproject(String pn) {
        HashSet<String> result=new HashSet(); 
        

     try {
        java.sql.Connection con = databasebasecon();
        String query;
        if (con != null) {
            //project capital
            String querymax = "SELECT SUM(money)as money  FROM projectcapitalincome where projectname='"+pn+"' ;";
            Statement state = con.createStatement();
            ResultSet rrr = state.executeQuery(querymax);
            int test = 0;
            array = new JSONArray();
            while (rrr.next()) {
                jsondata = new JSONObject();
                jsondata.append("name", pn);
                jsondata.append("money", rrr.getString("money"));
                array.put(jsondata);
              test = 1; 
                           
            }
            jsonObject.put("projectcapitalincome", array);
            jsoncpmbine = new JSONObject();
            array = new JSONArray();
            querymax = "SELECT SUM(money)as money FROM projectincome where projectname='"+pn+"' ;";
            state = con.createStatement();
            rrr = state.executeQuery(querymax);
            test = 0;
            while (rrr.next()) {
                jsondata = new JSONObject();
                jsondata.append("money", rrr.getString("money"));
                array.put(jsondata);
              test = 1; 
                
                test = 1;
            }
             jsonObject.put("projectincome", array);
             
            jsoncpmbine = new JSONObject();
            array = new JSONArray();
            querymax = "SELECT SUM(money)as money FROM projectdebitwithdraw where projectname='"+pn+"' ;";
            state = con.createStatement();
            rrr = state.executeQuery(querymax);
            test = 0;
            while (rrr.next()) {
                jsondata = new JSONObject();
                jsondata.append("money", rrr.getString("money"));
                array.put(jsondata);
              test = 1; 
                
                test = 1;
            }
              jsonObject.put("projectdebitwithdraw", array);
              
             jsoncpmbine = new JSONObject();
            array = new JSONArray();
            querymax = "SELECT SUM(money)as money FROM projectdebit where projectname='"+pn+"' ;";
            state = con.createStatement();
            rrr = state.executeQuery(querymax);
            test = 0;
            while (rrr.next()) {
                jsondata = new JSONObject();
                jsondata.append("money", rrr.getString("money"));
                array.put(jsondata);
              test = 1; 
                
                test = 1;
            }
              jsonObject.put("projectdebit", array);
              
              jsoncpmbine = new JSONObject();
            array = new JSONArray();
            querymax = "SELECT SUM(money)as money FROM projectextraincome where projectname='"+pn+"' ;";
            state = con.createStatement();
            rrr = state.executeQuery(querymax);
            test = 0;
            while (rrr.next()) {
                jsondata = new JSONObject();
                jsondata.append("money", rrr.getString("money"));
                array.put(jsondata);
              test = 1; 
                
                test = 1;
            }
              jsonObject.put("projectextraincome", array);
            
        } else {
            JOptionPane.showMessageDialog(null, "Not Conected");
        }

    } catch (Exception ee) {
    ee.printStackTrace();

    }
    return (jsonObject);
    }
  public  JSONObject singleprojectfix(String pn,String date) {
        HashSet<String> result=new HashSet(); 
        

     try {
        java.sql.Connection con = databasebasecon();
        String query;
        if (con != null) {
            //project capital
            String querymax = "SELECT SUM(money)as money  FROM projectcapitalincome where projectname='"+pn+"' AND date='"+date+"' ;";
            Statement state = con.createStatement();
            ResultSet rrr = state.executeQuery(querymax);
            int test = 0;
            array = new JSONArray();
            while (rrr.next()) {
                jsondata = new JSONObject();
                jsondata.append("name", pn);
                jsondata.append("money", rrr.getString("money"));
                array.put(jsondata);
              test = 1; 
                           
            }
            jsonObject.put("projectcapitalincome", array);
            jsoncpmbine = new JSONObject();
            array = new JSONArray();
            querymax = "SELECT SUM(money)as money FROM projectincome where projectname='"+pn+"' AND date='"+date+"';";
            state = con.createStatement();
            rrr = state.executeQuery(querymax);
            test = 0;
            while (rrr.next()) {
                jsondata = new JSONObject();
                jsondata.append("money", rrr.getString("money"));
                array.put(jsondata);
              test = 1; 
                
                test = 1;
            }
             jsonObject.put("projectincome", array);
             
            jsoncpmbine = new JSONObject();
            array = new JSONArray();
            querymax = "SELECT SUM(money)as money FROM projectdebitwithdraw where projectname='"+pn+"' AND date='"+date+"';";
            state = con.createStatement();
            rrr = state.executeQuery(querymax);
            test = 0;
            while (rrr.next()) {
                jsondata = new JSONObject();
                jsondata.append("money", rrr.getString("money"));
                array.put(jsondata);
              test = 1; 
                
                test = 1;
            }
              jsonObject.put("projectdebitwithdraw", array);
              
             jsoncpmbine = new JSONObject();
            array = new JSONArray();
            querymax = "SELECT SUM(money)as money FROM projectdebit where projectname='"+pn+"'AND date='"+date+"' ;";
            state = con.createStatement();
            rrr = state.executeQuery(querymax);
            test = 0;
            while (rrr.next()) {
                jsondata = new JSONObject();
                jsondata.append("money", rrr.getString("money"));
                array.put(jsondata);
              test = 1; 
                
                test = 1;
            }
              jsonObject.put("projectdebit", array);
              
              jsoncpmbine = new JSONObject();
            array = new JSONArray();
            querymax = "SELECT SUM(money)as money FROM projectextraincome where projectname='"+pn+"'AND date='"+date+"' ;";
            state = con.createStatement();
            rrr = state.executeQuery(querymax);
            test = 0;
            while (rrr.next()) {
                jsondata = new JSONObject();
                jsondata.append("money", rrr.getString("money"));
                array.put(jsondata);
              test = 1; 
                
                test = 1;
            }
              jsonObject.put("projectextraincome", array);
            
        } else {
            JOptionPane.showMessageDialog(null, "Not Conected");
        }

    } catch (Exception ee) {
    ee.printStackTrace();

    }
    return (jsonObject);
    }
  
  public  JSONObject singleprojectfixonemore(String pn,String date) {
        HashSet<String> result=new HashSet(); 
        

     try {
        java.sql.Connection con = databasebasecon();
        String query;
        if (con != null) {
            //project capital
            String querymax = "SELECT SUM(money)as money  FROM projectcapitalincome where projectname='"+pn+"' AND date<'"+Date.valueOf(date)+"' ;";
            Statement state = con.createStatement();
            ResultSet rrr = state.executeQuery(querymax);
            int test = 0;
            array = new JSONArray();
            while (rrr.next()) {
                jsondata = new JSONObject();
                jsondata.append("name", pn);
                jsondata.append("money", rrr.getString("money"));
                array.put(jsondata);
              test = 1; 
                           
            }
            jsonObject.put("projectcapitalincome", array);
            jsoncpmbine = new JSONObject();
            array = new JSONArray();
            querymax = "SELECT SUM(money)as money FROM projectincome where projectname='"+pn+"' AND date<'"+Date.valueOf(date)+"';";
            state = con.createStatement();
            rrr = state.executeQuery(querymax);
            test = 0;
            while (rrr.next()) {
                jsondata = new JSONObject();
                jsondata.append("money", rrr.getString("money"));
                array.put(jsondata);
              test = 1; 
                
                test = 1;
            }
             jsonObject.put("projectincome", array);
             
            jsoncpmbine = new JSONObject();
            array = new JSONArray();
            querymax = "SELECT SUM(money)as money FROM projectdebitwithdraw where projectname='"+pn+"' AND date<'"+Date.valueOf(date)+"';";
            state = con.createStatement();
            rrr = state.executeQuery(querymax);
            test = 0;
            while (rrr.next()) {
                jsondata = new JSONObject();
                jsondata.append("money", rrr.getString("money"));
                array.put(jsondata);
              test = 1; 
                
                test = 1;
            }
              jsonObject.put("projectdebitwithdraw", array);
              
             jsoncpmbine = new JSONObject();
            array = new JSONArray();
            querymax = "SELECT SUM(money)as money FROM projectdebit where projectname='"+pn+"'AND date<'"+Date.valueOf(date)+"' ;";
            state = con.createStatement();
            rrr = state.executeQuery(querymax);
            test = 0;
            while (rrr.next()) {
                jsondata = new JSONObject();
                jsondata.append("money", rrr.getString("money"));
                array.put(jsondata);
              test = 1; 
                
                test = 1;
            }
              jsonObject.put("projectdebit", array);
              
              jsoncpmbine = new JSONObject();
            array = new JSONArray();
            querymax = "SELECT SUM(money)as money FROM projectextraincome where projectname='"+pn+"'AND date<'"+Date.valueOf(date)+"' ;";
            state = con.createStatement();
            rrr = state.executeQuery(querymax);
            test = 0;
            while (rrr.next()) {
                jsondata = new JSONObject();
                jsondata.append("money", rrr.getString("money"));
                array.put(jsondata);
              test = 1; 
                
                test = 1;
            }
              jsonObject.put("projectextraincome", array);
            
        } else {
            JOptionPane.showMessageDialog(null, "Not Conected");
        }

    } catch (Exception ee) {
    ee.printStackTrace();

    }
    return (jsonObject);
    }
   public  JSONObject singleprojectfixonemoreperiod(String pn,String startdate,String enddate) {
        HashSet<String> result=new HashSet(); 
        

     try {
        java.sql.Connection con = databasebasecon();
        String query;
        if (con != null) {
            //project capital
            String querymax = "SELECT SUM(money)as money  FROM projectcapitalincome where projectname='"+pn+"' AND date<='"+Date.valueOf(enddate)+"'AND date>='"+Date.valueOf(startdate)+"' ;";
            Statement state = con.createStatement();
            ResultSet rrr = state.executeQuery(querymax);
            int test = 0;
            array = new JSONArray();
            while (rrr.next()) {
                jsondata = new JSONObject();
                jsondata.append("name", pn);
                jsondata.append("money", rrr.getString("money"));
                array.put(jsondata);
              test = 1; 
                           
            }
            jsonObject.put("projectcapitalincome", array);
            jsoncpmbine = new JSONObject();
            array = new JSONArray();
            querymax = "SELECT SUM(money)as money FROM projectincome where projectname='"+pn+"' AND date<='"+Date.valueOf(enddate)+"'AND date>='"+Date.valueOf(startdate)+"' ;";
            state = con.createStatement();
            rrr = state.executeQuery(querymax);
            test = 0;
            while (rrr.next()) {
                jsondata = new JSONObject();
                jsondata.append("money", rrr.getString("money"));
                array.put(jsondata);
              test = 1; 
                
                test = 1;
            }
             jsonObject.put("projectincome", array);
             
            jsoncpmbine = new JSONObject();
            array = new JSONArray();
            querymax = "SELECT SUM(money)as money FROM projectdebitwithdraw where projectname='"+pn+"' AND date<='"+Date.valueOf(enddate)+"'AND date>='"+Date.valueOf(startdate)+"' ;";
            state = con.createStatement();
            rrr = state.executeQuery(querymax);
            test = 0;
            while (rrr.next()) {
                jsondata = new JSONObject();
                jsondata.append("money", rrr.getString("money"));
                array.put(jsondata);
              test = 1; 
                
                test = 1;
            }
              jsonObject.put("projectdebitwithdraw", array);
              
             jsoncpmbine = new JSONObject();
            array = new JSONArray();
            querymax = "SELECT SUM(money)as money FROM projectdebit where projectname='"+pn+"'AND date<='"+Date.valueOf(enddate)+"'AND date>='"+Date.valueOf(startdate)+"'  ;";
            state = con.createStatement();
            rrr = state.executeQuery(querymax);
            test = 0;
            while (rrr.next()) {
                jsondata = new JSONObject();
                jsondata.append("money", rrr.getString("money"));
                array.put(jsondata);
              test = 1; 
                
                test = 1;
            }
              jsonObject.put("projectdebit", array);
              
              jsoncpmbine = new JSONObject();
            array = new JSONArray();
            querymax = "SELECT SUM(money)as money FROM projectextraincome where projectname='"+pn+"'AND date<='"+Date.valueOf(enddate)+"'AND date>='"+Date.valueOf(startdate)+"' ;";
            state = con.createStatement();
            rrr = state.executeQuery(querymax);
            test = 0;
            while (rrr.next()) {
                jsondata = new JSONObject();
                jsondata.append("money", rrr.getString("money"));
                array.put(jsondata);
              test = 1; 
                
                test = 1;
            }
              jsonObject.put("projectextraincome", array);
            
        } else {
            JOptionPane.showMessageDialog(null, "Not Conected");
        }

    } catch (Exception ee) {
    ee.printStackTrace();

    }
    return (jsonObject);
    }
  
    public  JSONObject sharematepdfdata(String pn) {
        HashSet<String> result=new HashSet(); 
        

     try {
        java.sql.Connection con = databasebasecon();
        String query;
        if (con != null) {
            //project capital
            String querymax = "SELECT * FROM sharemate where projectname='"+pn+"' ;";
            Statement state = con.createStatement();
            ResultSet rrr = state.executeQuery(querymax);
            int test = 0;
            array = new JSONArray();
            while (rrr.next()) {
                jsondata = new JSONObject();
                jsondata.append("name",rrr.getString("sharematename"));
                jsondata.append("percentage", rrr.getString("sharemateamount"));
                array.put(jsondata);
              test = 1; 
                           
            }
            jsonObject.put("sharematedata", array);
            
        } else {
            JOptionPane.showMessageDialog(null, "Not Conected");
        }

    } catch (Exception ee) {
    ee.printStackTrace();

    }
    return (jsonObject);
    }
  
   
    public  JSONObject singleproject(String pn,String startdate,String enddate) {
        HashSet<String> result=new HashSet(); 
        

     try {
        java.sql.Connection con = databasebasecon();
        String query;
        if (con != null) {
            //project capital
            String querymax = "SELECT SUM(money)as money  FROM projectcapitalincome as t1 WHERE t1.date <= '"+Date.valueOf(enddate)+"'AND t1.date >= '"+Date.valueOf(startdate)+"'  AND t1.projectname='"+pn+"' ;";
            Statement state = con.createStatement();
            ResultSet rrr = state.executeQuery(querymax);
            int test = 0;
            array = new JSONArray();
            while (rrr.next()) {
                jsondata = new JSONObject();
                jsondata.append("name", pn);
                jsondata.append("money", rrr.getString("money"));
                array.put(jsondata);
              test = 1; 
                           
            }
            jsonObject.put("projectcapitalincome", array);
            jsoncpmbine = new JSONObject();
            array = new JSONArray();
            querymax = "SELECT SUM(money)as money FROM projectincome as t1 WHERE t1.date <= '"+Date.valueOf(enddate)+"'AND t1.date >= '"+Date.valueOf(startdate)+"'  AND t1.projectname='"+pn+"' ; ;";
            state = con.createStatement();
            rrr = state.executeQuery(querymax);
            test = 0;
            while (rrr.next()) {
                jsondata = new JSONObject();
                jsondata.append("money", rrr.getString("money"));
                array.put(jsondata);
              test = 1; 
                
                test = 1;
            }
             jsonObject.put("projectincome", array);
             
            jsoncpmbine = new JSONObject();
            array = new JSONArray();
            querymax = "SELECT SUM(money)as money FROM projectdebitwithdraw as t1 WHERE t1.date <= '"+Date.valueOf(enddate)+"'AND t1.date >= '"+Date.valueOf(startdate)+"'  AND t1.projectname='"+pn+"' ;";
            state = con.createStatement();
            rrr = state.executeQuery(querymax);
            test = 0;
            while (rrr.next()) {
                jsondata = new JSONObject();
                jsondata.append("money", rrr.getString("money"));
                array.put(jsondata);
              test = 1; 
                
                test = 1;
            }
              jsonObject.put("projectdebitwithdraw", array);
              
             jsoncpmbine = new JSONObject();
            array = new JSONArray();
            querymax = "SELECT SUM(money)as money FROM projectdebit  as t1 WHERE t1.date <= '"+Date.valueOf(enddate)+"'AND t1.date >= '"+Date.valueOf(startdate)+"'  AND t1.projectname='"+pn+"' ;";
            state = con.createStatement();
            rrr = state.executeQuery(querymax);
            test = 0;
            while (rrr.next()) {
                jsondata = new JSONObject();
                jsondata.append("money", rrr.getString("money"));
                array.put(jsondata);
              test = 1; 
                
                test = 1;
            }
              jsonObject.put("projectdebit", array);
              
              jsoncpmbine = new JSONObject();
            array = new JSONArray();
            querymax = "SELECT SUM(money)as money FROM projectextraincome as t1 WHERE t1.date <= '"+Date.valueOf(enddate)+"'AND t1.date >= '"+Date.valueOf(startdate)+"'  AND t1.projectname='"+pn+"' ;";
            state = con.createStatement();
            rrr = state.executeQuery(querymax);
            test = 0;
            while (rrr.next()) {
                jsondata = new JSONObject();
                jsondata.append("money", rrr.getString("money"));
                array.put(jsondata);
              test = 1; 
                
                test = 1;
            }
              jsonObject.put("projectextraincome", array);
            
        } else {
            JOptionPane.showMessageDialog(null, "Not Conected");
        }

    } catch (Exception ee) {
    ee.printStackTrace();

    }
    return (jsonObject);
    }
  
   
   public  JSONObject projectcapital(String pn) {
        HashSet<String> result=new HashSet(); 
        

     try {
        java.sql.Connection con = databasebasecon();
        String query;
        if (con != null) {
            String querymax = "SELECT *  FROM projectcapitalincome where projectname='"+pn+"' ;";
            Statement state = con.createStatement();
            ResultSet rrr = state.executeQuery(querymax);
            int test = 0;
            array = new JSONArray();
            while (rrr.next()) {


                // serialize the object to JSON string
                
                jsondata = new JSONObject();
                jsondata.append("name", rrr.getString("incomesource"));
                jsondata.append("money", rrr.getString("money"));
                 array.put(jsondata);
                test = 1;              
            }
            jsonObject.put("credit", array);
            jsoncpmbine = new JSONObject();
            array = new JSONArray();
            querymax = "SELECT *  FROM projectdebit where projectname='"+pn+"' ;";
            state = con.createStatement();
            rrr = state.executeQuery(querymax);
            test = 0;
            while (rrr.next()) {
                
                jsondata = new JSONObject();
                jsondata.append("name", rrr.getString("debitsource"));
                jsondata.append("money", rrr.getString("money"));
                array.put(jsondata);
                test = 1;
            }
             jsonObject.put("debit", array);
            
        } else {
            JOptionPane.showMessageDialog(null, "Not Conected");
        }

    } catch (Exception ee) {
    ee.printStackTrace();

    }
    return (jsonObject);
    }
   public  JSONObject extradebitall() {
        HashSet<String> result=new HashSet(); 
        

     try {
        java.sql.Connection con = databasebasecon();
        String query;
        if (con != null) {
            String querymax = "SELECT *  FROM projectextradebit  ;";
            Statement state = con.createStatement();
            ResultSet rrr = state.executeQuery(querymax);
            int test = 0;
            array = new JSONArray();
            while (rrr.next()) {


                // serialize the object to JSON string
                
                jsondata = new JSONObject();
                jsondata.append("name", rrr.getString("debitsource"));
                 jsondata.append("date", rrr.getString("date"));
                jsondata.append("money", rrr.getString("money"));
                 array.put(jsondata);
                test = 1;              
            }
            jsonObject.put("debit", array);
            
            
        } else {
            JOptionPane.showMessageDialog(null, "Not Conected");
        }

    } catch (Exception ee) {
    ee.printStackTrace();

    }
    return (jsonObject);
    }
  
    public  JSONObject extradebitall(String startdate,String enddate) {
        HashSet<String> result=new HashSet(); 
        

     try {
        java.sql.Connection con = databasebasecon();
        String query;
        if (con != null) {
            String querymax = "SELECT *  FROM projectextradebit as t1 WHERE t1.date <= '"+Date.valueOf(enddate)+"'AND t1.date >= '"+Date.valueOf(startdate)+"' ;";
            Statement state = con.createStatement();
            ResultSet rrr = state.executeQuery(querymax);
            int test = 0;
            array = new JSONArray();
            while (rrr.next()) {


                // serialize the object to JSON string
                
                jsondata = new JSONObject();
                jsondata.append("name", rrr.getString("debitsource"));
                 jsondata.append("date", rrr.getString("date"));
                jsondata.append("money", rrr.getString("money"));
                 array.put(jsondata);
                test = 1;              
            }
            jsonObject.put("debit", array);
            
            
        } else {
            JOptionPane.showMessageDialog(null, "Not Conected");
        }

    } catch (Exception ee) {
    ee.printStackTrace();

    }
    return (jsonObject);
    }
  
     public  HashSet<TableClass> itemdetailsreturn(String prn,String flt,String tblname,String columnname,String columnvalue) {
        HashSet<TableClass> result=new HashSet(); 
        

     try {
        java.sql.Connection con = databasebasecon();
        String query;
        if (con != null) {
            String querymax = "SELECT *  FROM "+tblname+"  WHERe projectname = '"+prn+"'AND  flatname = '"+flt+"' AND "+columnname+"='"+columnvalue+"'   ;";
            Statement state = con.createStatement();
            ResultSet rrr = state.executeQuery(querymax);
            int test = 0;
            array = new JSONArray();
            while (rrr.next()) {
                 TableClass=new TableClass();
                 TableClass.setDate(rrr.getString("date"));
                 TableClass.setMoney(rrr.getString("money"));
                 result.add(TableClass);
            
            }
            
            
        } else {
            JOptionPane.showMessageDialog(null, "Not Conected");
        }

    } catch (Exception ee) {
    ee.printStackTrace();

    }
    return (result);
    }
     public  HashSet<TableClass> itemdetailsreturnothers(String prn,String tblname,String columnname,String columnvalue) {
        HashSet<TableClass> result=new HashSet(); 
        

     try {
        java.sql.Connection con = databasebasecon();
        String query;
        if (con != null) {
            String querymax = "SELECT *  FROM "+tblname+"  WHERe projectname = '"+prn+"' AND "+columnname+"='"+columnvalue+"'   ;";
            Statement state = con.createStatement();
            ResultSet rrr = state.executeQuery(querymax);
            int test = 0;
            array = new JSONArray();
            while (rrr.next()) {
                 TableClass=new TableClass();
                 TableClass.setDate(rrr.getString("date"));
                 TableClass.setMoney(rrr.getString("money"));
                 result.add(TableClass);
            
            }
            
            
        } else {
            JOptionPane.showMessageDialog(null, "Not Conected");
        }

    } catch (Exception ee) {
    ee.printStackTrace();

    }
    return (result);
    }
     public  HashSet<TableClass> bankinfodata(String tblname,String columnname,String columnvalue) {
        HashSet<TableClass> result=new HashSet(); 
        

     try {
        java.sql.Connection con = databasebasecon();
        String query;
        if (con != null) {
            String querymax = "SELECT *  FROM "+tblname+"  WHERe  "+columnname+"='"+columnvalue+"'   ;";
            Statement state = con.createStatement();
            ResultSet rrr = state.executeQuery(querymax);
            int test = 0;
            array = new JSONArray();
            while (rrr.next()) {
                 TableClass=new TableClass();
                 TableClass.setDate(rrr.getString("date"));
                 TableClass.setMoney(rrr.getString("money"));
                 result.add(TableClass);
            
            }
            
            
        } else {
            JOptionPane.showMessageDialog(null, "Not Conected");
        }

    } catch (Exception ee) {
    ee.printStackTrace();

    }
    return (result);
    }
      public  HashSet<TableClass> itemdetailsreturn(String prn,String flt,String tblname,String columnname,String columnvalue,String type) {
        HashSet<TableClass> result=new HashSet(); 
        

     try {
        java.sql.Connection con = databasebasecon();
        String query;
        if (con != null) {
            String querymax = "SELECT *  FROM "+tblname+"  WHERe projectname = '"+prn+"'AND  flatname = '"+flt+"' AND "+columnname+"='"+columnvalue+"' AND type='"+type+"'  ;";
            Statement state = con.createStatement();
            ResultSet rrr = state.executeQuery(querymax);
            int test = 0;
            array = new JSONArray();
            while (rrr.next()) {
                 TableClass=new TableClass();
                 TableClass.setDate(rrr.getString("date"));
                 TableClass.setMoney(rrr.getString("money"));
                 result.add(TableClass);
            
            }
            
            
        } else {
            JOptionPane.showMessageDialog(null, "Not Conected");
        }

    } catch (Exception ee) {
    ee.printStackTrace();

    }
    return (result);
    }
      
  
    public  JSONObject projectcapital(String pn,String startdate,String enddate) {
        HashSet<String> result=new HashSet(); 
        
     try {
        java.sql.Connection con = databasebasecon();
        String query;
        if (con != null) {
            String  querymax="SELECT CONCAT( flatname,'(project)') as incometype, incomesource,money,date FROM  [HabitatLimited].[dbo].[projectincome] as t1 WHERE t1.date <= '"+Date.valueOf(enddate)+"'AND t1.date >= '"+Date.valueOf(startdate)+"'  AND t1.projectname='"+pn+"' UNION SELECT CONCAT( projectname,'(capital)') as incometype, incomesource,money,date FROM [HabitatLimited].[dbo].[projectcapitalincome] as t2 WHERE t2.date <= '"+Date.valueOf(enddate)+"'AND t2.date >= '"+Date.valueOf(startdate)+"'  AND t2.projectname='"+pn+"';";
             Statement state = con.createStatement();
            ResultSet rrr = state.executeQuery(querymax);
            int test = 0;
            array = new JSONArray();
            while (rrr.next()) {

                jsondata = new JSONObject();
                jsondata.append("name", rrr.getString("incomesource"));
                jsondata.append("money", rrr.getString("money"));
                 jsondata.append("incometype", rrr.getString("incometype"));
                // System.out.println(rrr.getString("incometype"));
                jsondata.append("date", rrr.getDate("date"));
                 array.put(jsondata);
                test = 1;              
            }
            jsonObject.put("credit", array);
            jsoncpmbine = new JSONObject();
            array = new JSONArray();
            querymax = "SELECT CONCAT( debitsource,'(project)') as incometype,money,date FROM  [HabitatLimited].[dbo].[projectdebit] as t1 WHERE t1.date <= '"+Date.valueOf(enddate)+"'AND t1.date >= '"+Date.valueOf(startdate)+"'  AND t1.projectname='"+pn+"' UNION SELECT CONCAT( debitsource,'(capital)') as incometype, money,date FROM [HabitatLimited].[dbo].[projectdebitwithdraw] as t2 WHERE t2.date<= '"+Date.valueOf(enddate)+"' AND t2.date>= '"+Date.valueOf(startdate)+"' AND t2.projectname='"+pn+"';";
            state = con.createStatement();
            rrr = state.executeQuery(querymax);
            test = 0;
            while (rrr.next()) {
                
                jsondata = new JSONObject();
                jsondata.append("incometype", rrr.getString("incometype"));
                jsondata.append("money", rrr.getString("money"));
                jsondata.append("date", rrr.getDate("date"));
                array.put(jsondata);
                test = 1;
            }
             jsonObject.put("debit", array);
            
        } else {
            JOptionPane.showMessageDialog(null, "Not Conected");
        }

    } catch (Exception ee) {
    ee.printStackTrace();

    }
    return (jsonObject);
    }
   public   JSONObject projectcapital(String pn,String enddate) {
        System.out.println(enddate);
String  flatinfo=null;
     try {
        java.sql.Connection con = databasebasecon();
        String query;
        if (con != null) {
            String  querymax="SELECT CONCAT( flatname,'(project)')as incometype, incomesource,money,date FROM  [HabitatLimited].[dbo].[projectincome] as t1 WHERE t1.date <= '"+enddate+"'  AND t1.projectname='"+pn+"' UNION SELECT CONCAT( projectname,'(capital)') as incometype, incomesource,money,date FROM [HabitatLimited].[dbo].[projectcapitalincome] as t2 WHERE t2.date <= '"+enddate+"' AND t2.projectname='"+pn+"';";
            Statement state = con.createStatement();
            ResultSet rrr = state.executeQuery(querymax);
            int test = 0;
            array = new JSONArray();
            while (rrr.next()) {
                jsondata = new JSONObject();
                jsondata.append("name", rrr.getString("incomesource"));
                jsondata.append("money", rrr.getString("money"));
                 jsondata.append("incometype", rrr.getString("incometype"));
                // System.out.println(rrr.getString("incometype"));
                jsondata.append("date", rrr.getDate("date"));
                 array.put(jsondata);
                test = 1;                
            }
            jsonObject.put("credit", array);
            jsoncpmbine = new JSONObject();
            array = new JSONArray();
            querymax = "SELECT CONCAT( debitsource,'(project)')as incometype,money,date FROM  [HabitatLimited].[dbo].[projectdebit] as t1 WHERE t1.date <= '"+enddate+"'  AND t1.projectname='"+pn+"' UNION SELECT CONCAT( debitsource,'(capital)') as incometype, money,date FROM [HabitatLimited].[dbo].[projectdebitwithdraw] as t2 WHERE t2.date<= '"+enddate+"'  AND t2.projectname='"+pn+"';";
           state = con.createStatement();
            rrr = state.executeQuery(querymax);
            test = 0;
            while (rrr.next()) {
                
                jsondata = new JSONObject();
                jsondata.append("incometype", rrr.getString("incometype"));
                jsondata.append("money", rrr.getString("money"));
                jsondata.append("date", rrr.getDate("date"));
                array.put(jsondata);
                test = 1;
            }
             jsonObject.put("debit", array);
            
        } else {
            JOptionPane.showMessageDialog(null, "Not Conected");
        }

    } catch (Exception ee) {
    ee.printStackTrace();

    }
    return (jsonObject);
    }
  
   public   JSONObject projectcapitalsingleday(String pn,String enddate) {
        System.out.println(enddate);
String  flatinfo=null;
     try {
        java.sql.Connection con = databasebasecon();
        String query;
        if (con != null) {
            String  querymax="SELECT CONCAT( flatname,'(project)')as incometype, incomesource,money,date FROM  [HabitatLimited].[dbo].[projectincome] as t1 WHERE t1.date = '"+enddate+"'  AND t1.projectname='"+pn+"' UNION SELECT CONCAT( projectname,'(capital)') as incometype, incomesource,money,date FROM [HabitatLimited].[dbo].[projectcapitalincome] as t2 WHERE t2.date = '"+enddate+"' AND t2.projectname='"+pn+"';";
            Statement state = con.createStatement();
            ResultSet rrr = state.executeQuery(querymax);
            int test = 0;
            array = new JSONArray();
            while (rrr.next()) {
                jsondata = new JSONObject();
                jsondata.append("name", rrr.getString("incomesource"));
                jsondata.append("money", rrr.getString("money"));
                 jsondata.append("incometype", rrr.getString("incometype"));
                // System.out.println(rrr.getString("incometype"));
                jsondata.append("date", rrr.getDate("date"));
                 array.put(jsondata);
                test = 1;                
            }
            jsonObject.put("credit", array);
            jsoncpmbine = new JSONObject();
            array = new JSONArray();
            querymax = "SELECT CONCAT( debitsource,'(project)')as incometype,money,date FROM  [HabitatLimited].[dbo].[projectdebit] as t1 WHERE t1.date <= '"+enddate+"'  AND t1.projectname='"+pn+"' UNION SELECT CONCAT( debitsource,'(capital)') as incometype, money,date FROM [HabitatLimited].[dbo].[projectdebitwithdraw] as t2 WHERE t2.date<= '"+enddate+"'  AND t2.projectname='"+pn+"';";
           state = con.createStatement();
            rrr = state.executeQuery(querymax);
            test = 0;
            while (rrr.next()) {
                
                jsondata = new JSONObject();
                jsondata.append("incometype", rrr.getString("incometype"));
                jsondata.append("money", rrr.getString("money"));
                jsondata.append("date", rrr.getDate("date"));
                array.put(jsondata);
                test = 1;
            }
             jsonObject.put("debit", array);
            
        } else {
            JOptionPane.showMessageDialog(null, "Not Conected");
        }

    } catch (Exception ee) {
    ee.printStackTrace();

    }
    return (jsonObject);
    }
  
     public   JSONObject getflatdebitcredit(String pn,String fn) {
        
String  flatinfo=null;
     try {
        java.sql.Connection con = databasebasecon();
        String query;
        if (con != null) {
            String querymax = "SELECT *  FROM projectincome where projectname='"+pn+"' AND flatname='"+fn+"' ;";
            Statement state = con.createStatement();
            ResultSet rrr = state.executeQuery(querymax);
            int test = 0;
            array = new JSONArray();
            while (rrr.next()) {


                // serialize the object to JSON string
                
                jsondata = new JSONObject();
                jsondata.append("name", rrr.getString("incomesource"));
                jsondata.append("date", rrr.getString("date"));
                jsondata.append("money", rrr.getString("money"));
                 array.put(jsondata);
                test = 1;              
            }
            jsonObject.put("credit", array);
            
            querymax = "SELECT *  FROM setutility where projectname='"+pn+"' AND flatname='"+fn+"' ;";
            state = con.createStatement();
            rrr = state.executeQuery(querymax);
            test = 0;
            array = new JSONArray();
            while (rrr.next()) {
                jsondata = new JSONObject();
                jsondata.append("name", rrr.getString("incomesource"));
                jsondata.append("date", rrr.getString("date"));
                jsondata.append("money", rrr.getString("money"));
                 array.put(jsondata);
                test = 1;              
            }
            jsonObject.put("setutility", array);
            
            querymax = "SELECT *  FROM setutility where projectname='"+pn+"' AND flatname='"+fn+"' ;";
            state = con.createStatement();
            rrr = state.executeQuery(querymax);
            test = 0;
            array = new JSONArray();
            while (rrr.next()) {
                jsondata = new JSONObject();
                jsondata.append("name", rrr.getString("incomesource"));
                jsondata.append("date", rrr.getString("date"));
                jsondata.append("money", rrr.getString("money"));
                 array.put(jsondata);
                test = 1;              
            }
            jsonObject.put("other", array);
            
            jsoncpmbine = new JSONObject();
            array = new JSONArray();
            querymax = "SELECT *  FROM sharemate where projectname='"+pn+"' ;";
            state = con.createStatement();
            rrr = state.executeQuery(querymax);
            test = 0;
            while (rrr.next()) {
                flatinfo=rrr.getString("flatinfo");
                test = 1;
            }
            // System.out.print(fn+"  vol"+"\n");

             
             JSONObject js = new JSONObject(flatinfo);
             Iterator<String> keys = js.keys();
             while(keys.hasNext())
             {
                 String data=keys.next();
                
                 if(data.equals(fn)){
                     
                  jsondata = new JSONObject();
                  jsondata.append("money", js.getString(data));
                  array.put(jsondata);
                   break;
                }
             } 
             jsonObject.put("debit", array);
            
        } else {
            JOptionPane.showMessageDialog(null, "Not Conected");
        }

    } catch (Exception ee) {
    ee.printStackTrace();

    }
    return (jsonObject);
    }
  
      public   JSONObject getflatdebitcredit(String pn,String fn,String date) {
        
String  flatinfo=null;
     try {
        java.sql.Connection con = databasebasecon();
        String query;
        if (con != null) {
            String querymax = "SELECT *  FROM projectincome where projectname='"+pn+"' AND flatname='"+fn+"' AND date='"+date+"' ;";
            Statement state = con.createStatement();
            ResultSet rrr = state.executeQuery(querymax);
            int test = 0;
            array = new JSONArray();
            while (rrr.next()) {


                // serialize the object to JSON string
                
                jsondata = new JSONObject();
                jsondata.append("name", rrr.getString("incomesource"));
                jsondata.append("date", rrr.getString("date"));
                jsondata.append("money", rrr.getString("money"));
                 array.put(jsondata);
                test = 1;              
            }
            jsonObject.put("credit", array);
            
            querymax = "SELECT *  FROM setutility where projectname='"+pn+"' AND flatname='"+fn+"' AND date='"+date+"' ;";
            state = con.createStatement();
            rrr = state.executeQuery(querymax);
            test = 0;
            array = new JSONArray();
            while (rrr.next()) {
                jsondata = new JSONObject();
                jsondata.append("name", rrr.getString("incomesource"));
                jsondata.append("date", rrr.getString("date"));
                jsondata.append("money", rrr.getString("money"));
                 array.put(jsondata);
                test = 1;              
            }
            jsonObject.put("setutility", array);
            
            querymax = "SELECT *  FROM setutility where projectname='"+pn+"' AND flatname='"+fn+"' AND date='"+date+"' ;";
            state = con.createStatement();
            rrr = state.executeQuery(querymax);
            test = 0;
            array = new JSONArray();
            while (rrr.next()) {
                jsondata = new JSONObject();
                jsondata.append("name", rrr.getString("incomesource"));
                jsondata.append("date", rrr.getString("date"));
                jsondata.append("money", rrr.getString("money"));
                 array.put(jsondata);
                test = 1;              
            }
            jsonObject.put("other", array);
            
            jsoncpmbine = new JSONObject();
            array = new JSONArray();
            querymax = "SELECT *  FROM sharemate where projectname='"+pn+"' ;";
            state = con.createStatement();
            rrr = state.executeQuery(querymax);
            test = 0;
            while (rrr.next()) {
                flatinfo=rrr.getString("flatinfo");
                test = 1;
            }
            // System.out.print(fn+"  vol"+"\n");

             
             JSONObject js = new JSONObject(flatinfo);
             Iterator<String> keys = js.keys();
             while(keys.hasNext())
             {
                 String data=keys.next();
                System.out.print(data+"  vol"+"\n");
                
                 if(data.equals(fn)){
                  jsondata = new JSONObject();
                  jsondata.append("money", js.getString(data));
                  array.put(jsondata);
                   break;
                }
             } 
             jsonObject.put("debit", array);
            
        } else {
            JOptionPane.showMessageDialog(null, "Not Conected");
        }

    } catch (Exception ee) {
    ee.printStackTrace();

    }
    return (jsonObject);
    }
  
       public   JSONObject getflatdebitcreditonemore(String pn,String fn,String date) {
        
String  flatinfo=null;
     try {
        java.sql.Connection con = databasebasecon();
        String query;
        if (con != null) {
            String querymax = "SELECT *  FROM projectincome where projectname='"+pn+"' AND flatname='"+fn+"' AND date<'"+Date.valueOf(date)+"' ;";
            Statement state = con.createStatement();
            ResultSet rrr = state.executeQuery(querymax);
            int test = 0;
            array = new JSONArray();
            while (rrr.next()) {


                // serialize the object to JSON string
                
                jsondata = new JSONObject();
                jsondata.append("name", rrr.getString("incomesource"));
                jsondata.append("date", rrr.getString("date"));
                jsondata.append("money", rrr.getString("money"));
                 array.put(jsondata);
                test = 1;              
            }
            jsonObject.put("credit", array);
            
            querymax = "SELECT *  FROM setutility where projectname='"+pn+"' AND flatname='"+fn+"' AND date<'"+Date.valueOf(date)+"' ;";
            state = con.createStatement();
            rrr = state.executeQuery(querymax);
            test = 0;
            array = new JSONArray();
            while (rrr.next()) {
                jsondata = new JSONObject();
                jsondata.append("name", rrr.getString("incomesource"));
                jsondata.append("date", rrr.getString("date"));
                jsondata.append("money", rrr.getString("money"));
                 array.put(jsondata);
                test = 1;              
            }
            jsonObject.put("setutility", array);
            
            querymax = "SELECT *  FROM setutility where projectname='"+pn+"' AND flatname='"+fn+"' AND date<'"+Date.valueOf(date)+"' ;";
            state = con.createStatement();
            rrr = state.executeQuery(querymax);
            test = 0;
            array = new JSONArray();
            while (rrr.next()) {
                jsondata = new JSONObject();
                jsondata.append("name", rrr.getString("incomesource"));
                jsondata.append("date", rrr.getString("date"));
                jsondata.append("money", rrr.getString("money"));
                 array.put(jsondata);
                test = 1;              
            }
            jsonObject.put("other", array);
            
            jsoncpmbine = new JSONObject();
            array = new JSONArray();
            querymax = "SELECT *  FROM sharemate where projectname='"+pn+"' ;";
            state = con.createStatement();
            rrr = state.executeQuery(querymax);
            test = 0;
            while (rrr.next()) {
                flatinfo=rrr.getString("flatinfo");
                test = 1;
            }
            // System.out.print(fn+"  vol"+"\n");

             
             JSONObject js = new JSONObject(flatinfo);
             Iterator<String> keys = js.keys();
             while(keys.hasNext())
             {
                 String data=keys.next();
                System.out.print(data+"  vol"+"\n");
                
                 if(data.equals(fn)){
                  jsondata = new JSONObject();
                  jsondata.append("money", js.getString(data));
                  array.put(jsondata);
                   break;
                }
             } 
             jsonObject.put("debit", array);
            
        } else {
            JOptionPane.showMessageDialog(null, "Not Conected");
        }

    } catch (Exception ee) {
    ee.printStackTrace();

    }
    return (jsonObject);
    }
   public   JSONObject getflatdebitcreditonemoreperiod(String pn,String fn,String startdate,String enddate) {
        
String  flatinfo=null;
     try {
        java.sql.Connection con = databasebasecon();
        String query;
        if (con != null) {
            String querymax = "SELECT *  FROM projectincome where projectname='"+pn+"' AND flatname='"+fn+"' AND date<='"+Date.valueOf(enddate)+"' AND date>='"+Date.valueOf(startdate)+"';";
            Statement state = con.createStatement();
            ResultSet rrr = state.executeQuery(querymax);
            int test = 0;
            array = new JSONArray();
            while (rrr.next()) {


                // serialize the object to JSON string
                
                jsondata = new JSONObject();
                jsondata.append("name", rrr.getString("incomesource"));
                jsondata.append("date", rrr.getString("date"));
                jsondata.append("money", rrr.getString("money"));
                 array.put(jsondata);
                test = 1;              
            }
            jsonObject.put("credit", array);
            
            querymax = "SELECT *  FROM setutility where projectname='"+pn+"' AND flatname='"+fn+"' AND date<='"+Date.valueOf(enddate)+"' AND date>='"+Date.valueOf(startdate)+"' ;";
            state = con.createStatement();
            rrr = state.executeQuery(querymax);
            test = 0;
            array = new JSONArray();
            while (rrr.next()) {
                jsondata = new JSONObject();
                jsondata.append("name", rrr.getString("incomesource"));
                jsondata.append("date", rrr.getString("date"));
                jsondata.append("money", rrr.getString("money"));
                 array.put(jsondata);
                test = 1;              
            }
            jsonObject.put("setutility", array);
            
            querymax = "SELECT *  FROM setutility where projectname='"+pn+"' AND flatname='"+fn+"' AND date<='"+Date.valueOf(enddate)+"' AND date>='"+Date.valueOf(startdate)+"' ;";
            state = con.createStatement();
            rrr = state.executeQuery(querymax);
            test = 0;
            array = new JSONArray();
            while (rrr.next()) {
                jsondata = new JSONObject();
                jsondata.append("name", rrr.getString("incomesource"));
                jsondata.append("date", rrr.getString("date"));
                jsondata.append("money", rrr.getString("money"));
                 array.put(jsondata);
                test = 1;              
            }
            jsonObject.put("other", array);
            
            jsoncpmbine = new JSONObject();
            array = new JSONArray();
            querymax = "SELECT *  FROM sharemate where projectname='"+pn+"' ;";
            state = con.createStatement();
            rrr = state.executeQuery(querymax);
            test = 0;
            while (rrr.next()) {
                flatinfo=rrr.getString("flatinfo");
                test = 1;
            }
            // System.out.print(fn+"  vol"+"\n");

             
             JSONObject js = new JSONObject(flatinfo);
             Iterator<String> keys = js.keys();
             while(keys.hasNext())
             {
                 String data=keys.next();
                System.out.print(data+"  vol"+"\n");
                
                 if(data.equals(fn)){
                  jsondata = new JSONObject();
                  jsondata.append("money", js.getString(data));
                  array.put(jsondata);
                   break;
                }
             } 
             jsonObject.put("debit", array);
            
        } else {
            JOptionPane.showMessageDialog(null, "Not Conected");
        }

    } catch (Exception ee) {
    ee.printStackTrace();

    }
    return (jsonObject);
    }
  
      public   JSONObject getsetutilityandother(String pn,String fn) {
        
String  flatinfo=null;
     try {
        java.sql.Connection con = databasebasecon();
        String query;
        if (con != null) {
            String querymax = "SELECT *  FROM setutility where projectname='"+pn+"' AND flatname='"+fn+"' AND type='Utility' ;";
            Statement state = con.createStatement();
            ResultSet rrr = state.executeQuery(querymax);
            int test = 0;
            array = new JSONArray();
            while (rrr.next()) {


                // serialize the object to JSON string
                
                jsondata = new JSONObject();
                jsondata.append("name", rrr.getString("incomesource"));
                jsondata.append("date", rrr.getString("date"));
                jsondata.append("money", rrr.getString("money"));
                 array.put(jsondata);
                test = 1;              
            }
            jsonObject.put("utility", array);
            
            querymax = "SELECT *  FROM setutility where projectname='"+pn+"' AND flatname='"+fn+"' AND type='Other' ;";
            state = con.createStatement();
            rrr = state.executeQuery(querymax);
            test = 0;
            array = new JSONArray();
            while (rrr.next()) {
                jsondata = new JSONObject();
                jsondata.append("name", rrr.getString("incomesource"));
                jsondata.append("date", rrr.getString("date"));
                jsondata.append("money", rrr.getString("money"));
                 array.put(jsondata);
                test = 1;              
            }
            jsonObject.put("other", array);
            
            querymax = "SELECT *  FROM incomeutility where projectname='"+pn+"' AND flatname='"+fn+"' ;";
            state = con.createStatement();
            rrr = state.executeQuery(querymax);
            test = 0;
            array = new JSONArray();
            while (rrr.next()) {
                jsondata = new JSONObject();
                jsondata.append("name", rrr.getString("incomesource")+"("+rrr.getString("type")+")");
                jsondata.append("date", rrr.getString("date"));
                jsondata.append("money", rrr.getString("money"));
                 array.put(jsondata);
                test = 1;              
            }
            jsonObject.put("incomeutility", array);
            
            
            jsoncpmbine = new JSONObject();
            array = new JSONArray();
            querymax = "SELECT *  FROM sharemate where projectname='"+pn+"' ;";
            state = con.createStatement();
            rrr = state.executeQuery(querymax);
            test = 0;
            while (rrr.next()) {
                flatinfo=rrr.getString("flatinfo");
                test = 1;
            }
            // System.out.print(fn+"  vol"+"\n");

             
             JSONObject js = new JSONObject(flatinfo);
             Iterator<String> keys = js.keys();
             while(keys.hasNext())
             {
                 String data=keys.next();                
                 if(data.equals(fn)){
                  jsondata = new JSONObject();
                  jsondata.append("money", js.getString(data));
                  array.put(jsondata);
                   break;
                }
             } 
             jsonObject.put("debit", array);
            
        } else {
            JOptionPane.showMessageDialog(null, "Not Conected");
        }

    } catch (Exception ee) {
    ee.printStackTrace();

    }
    return (jsonObject);
    }
  
       public   JSONObject getsetutilityandother(String pn,String fn,String date) {
        
String  flatinfo=null;
     try {
        java.sql.Connection con = databasebasecon();
        String query;
        if (con != null) {
            String querymax = "SELECT *  FROM setutility where projectname='"+pn+"' AND flatname='"+fn+"' AND type='Utility' AND date='"+date+"' ;";
            Statement state = con.createStatement();
            ResultSet rrr = state.executeQuery(querymax);
            int test = 0;
            array = new JSONArray();
            while (rrr.next()) {


                // serialize the object to JSON string
                
                jsondata = new JSONObject();
                jsondata.append("name", rrr.getString("incomesource"));
                jsondata.append("date", rrr.getString("date"));
                jsondata.append("money", rrr.getString("money"));
                 array.put(jsondata);
                test = 1;              
            }
            jsonObject.put("utility", array);
            
            querymax = "SELECT *  FROM setutility where projectname='"+pn+"' AND flatname='"+fn+"' AND type='Other' AND date='"+date+"' ;";
            state = con.createStatement();
            rrr = state.executeQuery(querymax);
            test = 0;
            array = new JSONArray();
            while (rrr.next()) {
                jsondata = new JSONObject();
                jsondata.append("name", rrr.getString("incomesource"));
                jsondata.append("date", rrr.getString("date"));
                jsondata.append("money", rrr.getString("money"));
                 array.put(jsondata);
                test = 1;              
            }
            jsonObject.put("other", array);
            
            querymax = "SELECT *  FROM incomeutility where projectname='"+pn+"' AND flatname='"+fn+"' AND date='"+date+"' ;";
            state = con.createStatement();
            rrr = state.executeQuery(querymax);
            test = 0;
            array = new JSONArray();
            while (rrr.next()) {
                jsondata = new JSONObject();
                jsondata.append("name", rrr.getString("incomesource")+"("+rrr.getString("type")+")");
                jsondata.append("date", rrr.getString("date"));
                jsondata.append("money", rrr.getString("money"));
                 array.put(jsondata);
                test = 1;              
            }
            jsonObject.put("incomeutility", array);
            
            
            jsoncpmbine = new JSONObject();
            array = new JSONArray();
            querymax = "SELECT *  FROM sharemate where projectname='"+pn+"';";
            state = con.createStatement();
            rrr = state.executeQuery(querymax);
            test = 0;
            while (rrr.next()) {
                flatinfo=rrr.getString("flatinfo");
                test = 1;
            }
            // System.out.print(fn+"  vol"+"\n");

             
             JSONObject js = new JSONObject(flatinfo);
             Iterator<String> keys = js.keys();
             while(keys.hasNext())
             {
                 String data=keys.next();
                System.out.print(data+"  vol"+"\n");
                
                 if(data.equals(fn)){
                  jsondata = new JSONObject();
                  jsondata.append("money", js.getString(data));
                  array.put(jsondata);
                   break;
                }
             } 
             jsonObject.put("debit", array);
            
        } else {
            JOptionPane.showMessageDialog(null, "Not Conected");
        }

    } catch (Exception ee) {
    ee.printStackTrace();

    }
    return (jsonObject);
    }
  public   JSONObject getsetutilityandotheronemore(String pn,String fn,String date) {
        
String  flatinfo=null;
     try {
        java.sql.Connection con = databasebasecon();
        String query;
        if (con != null) {
            String querymax = "SELECT *  FROM setutility where projectname='"+pn+"' AND flatname='"+fn+"' AND type='Utility' AND date<'"+Date.valueOf(date)+"' ;";
            Statement state = con.createStatement();
            ResultSet rrr = state.executeQuery(querymax);
            int test = 0;
            array = new JSONArray();
            while (rrr.next()) {


                // serialize the object to JSON string
                
                jsondata = new JSONObject();
                jsondata.append("name", rrr.getString("incomesource"));
                jsondata.append("date", rrr.getString("date"));
                jsondata.append("money", rrr.getString("money"));
                 array.put(jsondata);
                test = 1;              
            }
            jsonObject.put("utility", array);
            
            querymax = "SELECT *  FROM setutility where projectname='"+pn+"' AND flatname='"+fn+"' AND type='Other' AND date<'"+Date.valueOf(date)+"' ;";
            state = con.createStatement();
            rrr = state.executeQuery(querymax);
            test = 0;
            array = new JSONArray();
            while (rrr.next()) {
                jsondata = new JSONObject();
                jsondata.append("name", rrr.getString("incomesource"));
                jsondata.append("date", rrr.getString("date"));
                jsondata.append("money", rrr.getString("money"));
                 array.put(jsondata);
                test = 1;              
            }
            jsonObject.put("other", array);
            
            querymax = "SELECT *  FROM incomeutility where projectname='"+pn+"' AND flatname='"+fn+"' AND date<'"+Date.valueOf(date)+"' ;";
            state = con.createStatement();
            rrr = state.executeQuery(querymax);
            test = 0;
            array = new JSONArray();
            while (rrr.next()) {
                jsondata = new JSONObject();
                jsondata.append("name", rrr.getString("incomesource")+"("+rrr.getString("type")+")");
                jsondata.append("date", rrr.getString("date"));
                jsondata.append("money", rrr.getString("money"));
                 array.put(jsondata);
                test = 1;              
            }
            jsonObject.put("incomeutility", array);
            
            
            jsoncpmbine = new JSONObject();
            array = new JSONArray();
            querymax = "SELECT *  FROM sharemate where projectname='"+pn+"';";
            state = con.createStatement();
            rrr = state.executeQuery(querymax);
            test = 0;
            while (rrr.next()) {
                flatinfo=rrr.getString("flatinfo");
                test = 1;
            }
            // System.out.print(fn+"  vol"+"\n");

             
             JSONObject js = new JSONObject(flatinfo);
             Iterator<String> keys = js.keys();
             while(keys.hasNext())
             {
                 String data=keys.next();
                System.out.print(data+"  vol"+"\n");
                
                 if(data.equals(fn)){
                  jsondata = new JSONObject();
                  jsondata.append("money", js.getString(data));
                  array.put(jsondata);
                   break;
                }
             } 
             jsonObject.put("debit", array);
            
        } else {
            JOptionPane.showMessageDialog(null, "Not Conected");
        }

    } catch (Exception ee) {
    ee.printStackTrace();

    }
    return (jsonObject);
    }
  public   JSONObject getsetutilityandotheronemoreperiod(String pn,String fn,String startdate,String enddate) {
        
String  flatinfo=null;
     try {
        java.sql.Connection con = databasebasecon();
        String query;
        if (con != null) {
            String querymax = "SELECT *  FROM setutility where projectname='"+pn+"' AND flatname='"+fn+"' AND type='Utility' AND date<='"+Date.valueOf(enddate)+"'AND date >='"+Date.valueOf(startdate)+"' ;";
            Statement state = con.createStatement();
            ResultSet rrr = state.executeQuery(querymax);
            int test = 0;
            array = new JSONArray();
            while (rrr.next()) {


                // serialize the object to JSON string
                
                jsondata = new JSONObject();
                jsondata.append("name", rrr.getString("incomesource"));
                jsondata.append("date", rrr.getString("date"));
                jsondata.append("money", rrr.getString("money"));
                 array.put(jsondata);
                test = 1;              
            }
            jsonObject.put("utility", array);
            
            querymax = "SELECT *  FROM setutility where projectname='"+pn+"' AND flatname='"+fn+"' AND type='Other' AND date<='"+Date.valueOf(enddate)+"'AND date >='"+Date.valueOf(startdate)+"' ;";
            state = con.createStatement();
            rrr = state.executeQuery(querymax);
            test = 0;
            array = new JSONArray();
            while (rrr.next()) {
                jsondata = new JSONObject();
                jsondata.append("name", rrr.getString("incomesource"));
                jsondata.append("date", rrr.getString("date"));
                jsondata.append("money", rrr.getString("money"));
                 array.put(jsondata);
                test = 1;              
            }
            jsonObject.put("other", array);
            
            querymax = "SELECT *  FROM incomeutility where projectname='"+pn+"' AND flatname='"+fn+"' AND date<='"+Date.valueOf(enddate)+"'AND date >='"+Date.valueOf(startdate)+"' ;";
            state = con.createStatement();
            rrr = state.executeQuery(querymax);
            test = 0;
            array = new JSONArray();
            while (rrr.next()) {
                jsondata = new JSONObject();
                jsondata.append("name", rrr.getString("incomesource")+"("+rrr.getString("type")+")");
                jsondata.append("date", rrr.getString("date"));
                jsondata.append("money", rrr.getString("money"));
                 array.put(jsondata);
                test = 1;              
            }
            jsonObject.put("incomeutility", array);
            
            
            jsoncpmbine = new JSONObject();
            array = new JSONArray();
            querymax = "SELECT *  FROM sharemate where projectname='"+pn+"';";
            state = con.createStatement();
            rrr = state.executeQuery(querymax);
            test = 0;
            while (rrr.next()) {
                flatinfo=rrr.getString("flatinfo");
                test = 1;
            }
            // System.out.print(fn+"  vol"+"\n");

             
             JSONObject js = new JSONObject(flatinfo);
             Iterator<String> keys = js.keys();
             while(keys.hasNext())
             {
                 String data=keys.next();
                System.out.print(data+"  vol"+"\n");
                
                 if(data.equals(fn)){
                  jsondata = new JSONObject();
                  jsondata.append("money", js.getString(data));
                  array.put(jsondata);
                   break;
                }
             } 
             jsonObject.put("debit", array);
            
        } else {
            JOptionPane.showMessageDialog(null, "Not Conected");
        }

    } catch (Exception ee) {
    ee.printStackTrace();

    }
    return (jsonObject);
    }
  
    public boolean projectsharemate( String jtf,String flatjtf,String sharematename,String sharemateamount,JSONObject flatinfo,String values15)
    {
       

       
         boolean a = false;
    try {
        java.sql.Connection con = databasebasecon();
        String query;
        if (con != null) {
            query = "insert into sharemate(projectname,flatnumber,sharematename,sharemateamount,flatinfo,date) VALUES(?,?,?,?,?,?);";
            PreparedStatement pst = con.prepareStatement(query);
             pst.setString(1,jtf);
             pst.setString(2,flatjtf);
             pst.setString(3,sharematename);
             pst.setString(4,sharemateamount); 
             //ByteArrayInputStream bais = new ByteArrayInputStream(immAsBytes);
             //pst.setBinaryStream(5, bais, immAsBytes.length);
             pst.setString(5,flatinfo.toString());
              pst.setDate(6,currentdatereturn());
             pst.executeUpdate();
            a = true;
        }

    } catch (Exception ee) {
    ee.printStackTrace();
    }
    return a;
    }
public boolean updatesharemateinfodata( String prn,String flatjtf,String sharematename,String sharemateamount,JSONObject flatinfo,String values15,int count)
    {
       

       
         boolean a = false;
    try {
        java.sql.Connection con = databasebasecon();
        String query;PreparedStatement pst;
        if (con != null) {
            if(count==0)
            {
            query="DELETE FROM[HabitatLimited].[dbo].[sharemate] WHERE  projectname='"+prn+"';";
             pst = con.prepareStatement(query);
             pst.executeUpdate();   
            }
            query = "insert into sharemate(projectname,flatnumber,sharematename,sharemateamount,flatinfo,date) VALUES(?,?,?,?,?,?);";
             pst = con.prepareStatement(query);
             pst = con.prepareStatement(query);
             pst.setString(1,prn);
             pst.setString(2,flatjtf);
             pst.setString(3,sharematename);
             pst.setString(4,sharemateamount); 
             //ByteArrayInputStream bais = new ByteArrayInputStream(immAsBytes);
             //pst.setBinaryStream(5, bais, immAsBytes.length);
             pst.setString(5,flatinfo.toString());
              pst.setDate(6,  new java.sql.Date(new SimpleDateFormat("yyyy-MM-dd").parse(values15).getTime()));
             pst.executeUpdate();
            a = true;
        }

    } catch (Exception ee) {
    ee.printStackTrace();
    }
    return a;
    }
public boolean Editsharemateinfodata( String prn,String flatjtf,String sharematename,String sharemateamount,JSONObject flatinfo,String values15,int count)
    {
       

       
         boolean a = false;
    try {
        java.sql.Connection con = databasebasecon();
        String query;PreparedStatement pst;
        if (con != null) {
            if(count==0)
            {
            query="DELETE FROM[HabitatLimited].[dbo].[sharemate] WHERE  projectname='"+prn+"';";
             pst = con.prepareStatement(query);
             pst.executeUpdate();   
            }
            query = "insert into sharemate(projectname,flatnumber,sharematename,sharemateamount,flatinfo,date) VALUES(?,?,?,?,?,?);";
             pst = con.prepareStatement(query);
             pst = con.prepareStatement(query);
             pst.setString(1,prn);
             pst.setString(2,flatjtf);
             pst.setString(3,sharematename);
             pst.setString(4,sharemateamount); 
             //ByteArrayInputStream bais = new ByteArrayInputStream(immAsBytes);
             //pst.setBinaryStream(5, bais, immAsBytes.length);
             pst.setString(5,flatinfo.toString());
              pst.setDate(6,  new java.sql.Date(new SimpleDateFormat("yyyy-MM-dd").parse(values15).getTime()));
             pst.executeUpdate();
            a = true;
        }

    } catch (Exception ee) {
    ee.printStackTrace();
    }
    return a;
    }

     public boolean projectincome( String projectname,String flatname,String incomesource,String money)
    {
        System.out.println(currentdatereturn());
        String bb="gh";
         boolean a = false;
    try {
        java.sql.Connection con = databasebasecon();
        String query;
        if (con != null) {
            query = "insert into projectincome(projectname,flatname,incomesource,money,date) VALUES(?,?,?,?,?);";
            PreparedStatement pst = con.prepareStatement(query);
             pst.setString(1,projectname);
             pst.setString(2,flatname);
             pst.setString(3,incomesource); 
             pst.setInt(4,Integer.parseInt(money));
              pst.setDate(5,currentdatereturn());
             pst.executeUpdate();
            a = true;
        }

    } catch (Exception ee) {
    ee.printStackTrace();
    }
    return a;
    }
     
     public boolean projectcapitalincome( String projectname,String incomesource,String money)
    {
        String bb="gh";
         boolean a = false;
    try {
        java.sql.Connection con = databasebasecon();
        String query;
        if (con != null) {
            query = "insert into projectcapitalincome(projectname,incomesource,money,date) VALUES(?,?,?,?);";
            PreparedStatement pst = con.prepareStatement(query);
             pst.setString(1,projectname);
             pst.setString(2,incomesource); 
             pst.setInt(3,Integer.parseInt(money));
              pst.setDate(4,currentdatereturn());
             pst.executeUpdate();
            a = true;
        }

    } catch (Exception ee) {
    ee.printStackTrace();
    }
    return a;
    }

      public boolean setutility( String projectname,String flat,String type,String incomesource,String money)
    {
        String bb="gh";
         boolean a = false;
    try {
        java.sql.Connection con = databasebasecon();
        String query;
        if (con != null) {
            query = "insert into setutility(projectname,flatname,type,incomesource,money,date) VALUES(?,?,?,?,?,?);";
            PreparedStatement pst = con.prepareStatement(query);
             pst.setString(1,projectname);
             pst.setString(2,flat); 
               pst.setString(3,type); 
                 pst.setString(4,incomesource); 
             pst.setInt(5,Integer.parseInt(money));
              pst.setDate(6,currentdatereturn());
             pst.executeUpdate();
            a = true;
        }

    } catch (Exception ee) {
    ee.printStackTrace();
    }
    return a;
    }
 public boolean incomeutility( String projectname,String flat,String type,String incomesource,String money)
    {
        String bb="gh";
         boolean a = false;
    try {
        java.sql.Connection con = databasebasecon();
        String query;
        if (con != null) {
            query = "insert into incomeutility(projectname,flatname,type,incomesource,money,date) VALUES(?,?,?,?,?,?);";
            PreparedStatement pst = con.prepareStatement(query);
             pst.setString(1,projectname);
             pst.setString(2,flat); 
               pst.setString(3,type); 
                 pst.setString(4,incomesource); 
             pst.setInt(5,Integer.parseInt(money));
              pst.setDate(6,currentdatereturn());
             pst.executeUpdate();
            a = true;
        }

    } catch (Exception ee) {
    ee.printStackTrace();
    }
    return a;
    }

      public boolean projectextraincome( String projectname,String incomesource,String money)
    {
        String bb="gh";
         boolean a = false;
    try {
        java.sql.Connection con = databasebasecon();
        String query;
        if (con != null) {
            query = "insert into projectextraincome(projectname,incomesource,money,date) VALUES(?,?,?,?);";
            PreparedStatement pst = con.prepareStatement(query);
             pst.setString(1,projectname);
             pst.setString(2,incomesource); 
             pst.setInt(3,Integer.parseInt(money));
              pst.setDate(4,currentdatereturn());
             pst.executeUpdate();
            a = true;
        }

    } catch (Exception ee) {
    ee.printStackTrace();
    }
    return a;
    }

       public boolean projectdebitwithdraw( String projectname,String debitsource,String money)
    {
        String bb="gh";
         boolean a = false;
    try {
        java.sql.Connection con = databasebasecon();
        String query;
        if (con != null) {
            query = "insert into projectdebitwithdraw(projectname,debitsource,money,date) VALUES(?,?,?,?);";
            PreparedStatement pst = con.prepareStatement(query);
             pst.setString(1,projectname);
             pst.setString(2,debitsource); 
             pst.setInt(3,Integer.parseInt(money));
              pst.setDate(4,currentdatereturn());
             pst.executeUpdate();
            a = true;
        }

    } catch (Exception ee) {
    ee.printStackTrace();
    }
    return a;
    }
  public boolean itemadd( String prn,String tablename,String itemname)
    {
        String bb="gh";
         boolean a = false;
    try {
        java.sql.Connection con = databasebasecon();
        String query;
        if (con != null) {
            query = "insert into itemname(projectname,tablename,itemname,date) VALUES(?,?,?,?);";
            PreparedStatement pst = con.prepareStatement(query);
             pst.setString(1,prn);
             pst.setString(2,tablename);
             pst.setString(3,itemname); 
             pst.setDate(4,currentdatereturn());
             pst.executeUpdate();
            a = true;
        }

    } catch (Exception ee) {
    ee.printStackTrace();
    }
    return a;
    }


      public boolean projectdebit( String projectname,String debitsource,String money) throws ParseException
    {
        String bb="gh";
         boolean a = false;
          String dateString = "2023-05-15";
           DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
           java.util.Date utilDate = dateFormat.parse(dateString);
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
    try {
        java.sql.Connection con = databasebasecon();
        String query;
        if (con != null) {
            query = "insert into projectdebit(projectname,debitsource,money,date) VALUES(?,?,?,?);";
            PreparedStatement pst = con.prepareStatement(query);
             pst.setString(1,projectname);
             pst.setString(2,debitsource); 
             pst.setInt(3,Integer.parseInt(money));
              pst.setDate(4, currentdatereturn());
             pst.executeUpdate();
            a = true;
        }

    } catch (Exception ee) {
    ee.printStackTrace();
    }
    return a;
    }
       public boolean projectextradebit( String projectname,String debitsource,String money) throws ParseException
    {
        String bb="gh";
         boolean a = false;
          String dateString = "2023-05-15";
           DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
           java.util.Date utilDate = dateFormat.parse(dateString);
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
    try {
        java.sql.Connection con = databasebasecon();
        String query;
        if (con != null) {
            query = "insert into projectextradebit(debittype,debitsource,money,date) VALUES(?,?,?,?);";
            PreparedStatement pst = con.prepareStatement(query);
             pst.setString(1,projectname);
             pst.setString(2,debitsource); 
             pst.setInt(3,Integer.parseInt(money));
              pst.setDate(4, currentdatereturn());
             pst.executeUpdate();
            a = true;
        }

    } catch (Exception ee) {
    ee.printStackTrace();
   JOptionPane.showMessageDialog(null, ee);

    
    }
    return a;
    }
        public boolean Bank( String projectname,String debitsource,String money) throws ParseException
    {
        String bb="gh";
         boolean a = false;
          String dateString = "2023-05-15";
           DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
           java.util.Date utilDate = dateFormat.parse(dateString);
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
    try {
        java.sql.Connection con = databasebasecon();
        String query;
        if (con != null) {
            query = "insert into Bank(debittype,debitsource,money,date) VALUES(?,?,?,?);";
            PreparedStatement pst = con.prepareStatement(query);
             pst.setString(1,projectname);
             pst.setString(2,debitsource); 
             pst.setInt(3,Integer.parseInt(money));
              pst.setDate(4, currentdatereturn());
             pst.executeUpdate();
            a = true;
        }

    } catch (Exception ee) {
    ee.printStackTrace();
   JOptionPane.showMessageDialog(null, ee);

    
    }
    return a;
    }
          public boolean registration( String username,String password,String role) throws ParseException
    {
         boolean a = false;
        
    try {
        java.sql.Connection con = databasebasecon();
        String query;
        if (con != null) {
            query = "insert into registration (username,password,role) VALUES(?,?,?);";
            PreparedStatement pst = con.prepareStatement(query);
             pst.setString(1,username);
             pst.setString(2,password); 
             pst.setString(3,role);
             pst.executeUpdate();
            a = true;
        }

    } catch (Exception ee) {
    ee.printStackTrace();
    }
    return a;
    }


      public boolean projectdebitcapital( String projectname,String flatname,String debitsource,String amount,String money,String values15)
    {
        String bb="gh";
         boolean a = false;
    try {
        java.sql.Connection con = databasebasecon();
        String query;
        if (con != null) {
             query = "insert into projectdebitcapital(projectname,flatname,debitsource,amount,money,date) VALUES(?,?,?,?,?,?);";
             PreparedStatement pst = con.prepareStatement(query);
             pst.setString(1,projectname);
             pst.setString(2,flatname);
             pst.setString(3,debitsource); 
             pst.setInt(4,Integer.parseInt(amount));
             pst.setInt(5,Integer.parseInt(money));
             pst.setDate(6,currentdatereturn());
             pst.executeUpdate();
            a = true;
                    System.out.print("debit");

        }

    } catch (Exception ee) {
    ee.printStackTrace();
    }
    return a;
    }

   public  String getsharemate() {
        String result=null;
    try {
        java.sql.Connection con = databasebasecon();
        String query;
        if (con != null) {
            String querymax = "SELECT * FROM sharemate ;";
            Statement state = con.createStatement();
            ResultSet rrr = state.executeQuery(querymax);
            int test = 0;
            while (rrr.next()) {
                test = 1;
                
              // result=rrr.getString("sharemateinfo");
               //System.out.print(result);
            }

        } else {
            JOptionPane.showMessageDialog(null, "Not Conected");
        }

    } catch (Exception ee) {
    ee.printStackTrace();

    }
    return (result);
    }
    public  HashSet<String> getsharemateprojectname() {
        HashSet<String> result=new HashSet();  
    try {
        java.sql.Connection con = databasebasecon();
        String query;
        if (con != null) {
            String querymax = "SELECT distinct projectname FROM sharemate ;";
            Statement state = con.createStatement();
            ResultSet rrr = state.executeQuery(querymax);
            int test = 0;
            while (rrr.next()) {
                test = 1;
                result.add(rrr.getString("projectname"));                
            }

        } else {
            JOptionPane.showMessageDialog(null, "Not Conected");
        }

    } catch (Exception ee) {
    ee.printStackTrace();

    }
    return (result);
    }
     public  HashSet<TableClass>  sellingpriceAutilityAother(String prn,String flt) {
       resultdata=new HashSet(); 
       TableClass=new TableClass();

       String bill="0";
      String  flatinfo=null;
      Statement state;
      ResultSet rrr ;
      String querymax;
    try {
        java.sql.Connection con = databasebasecon();
        String query;
        if (con != null) {
            querymax = "SELECT flatinfo  FROM sharemate where projectname='"+prn+"' ;";
            state = con.createStatement();
            rrr = state.executeQuery(querymax);
            while (rrr.next()) {
                flatinfo=rrr.getString("flatinfo");
                break;
            }
            // System.out.print(fn+"  vol"+"\n");

             
             JSONObject js = new JSONObject(flatinfo);
             Iterator<String> keys = js.keys();
             while(keys.hasNext())
             {
                 String data=keys.next();
                
                 if(data.equals(flt)){
                    TableClass.setSellingprice(js.getString(data));
                  
                }
             }
             
            querymax = "SELECT SUM(money) as money  FROM setutility where projectname='"+prn+"' AND flatname='"+flt+"' AND type='Utility' ;";
            state = con.createStatement();
            rrr = state.executeQuery(querymax);
            while (rrr.next()) {
                bill=rrr.getString("money");
            }
            TableClass.setUtilitybill(bill);
            bill="0";
            querymax = "SELECT SUM(money) as money  FROM setutility where projectname='"+prn+"' AND flatname='"+flt+"' AND type='Other' ;";
            state = con.createStatement();
            rrr = state.executeQuery(querymax);
            while (rrr.next()) {
                bill=rrr.getString("money");
            }
            TableClass.setOthers(bill);
             resultdata.add(TableClass);
        } else {
            JOptionPane.showMessageDialog(null, "Not Conected");
        }

    } catch (Exception ee) {
    ee.printStackTrace();

    }
    return (resultdata);
    }
      public  int  sellingpriceAutilityAothersum(String prn,String flt) {
       int sum=0;

       String bill="0";
      String  flatinfo=null;
      Statement state;
      ResultSet rrr ;
      String querymax;
    try {
        java.sql.Connection con = databasebasecon();
        String query;
        if (con != null) {
            querymax = "SELECT flatinfo  FROM sharemate where projectname='"+prn+"' ;";
            state = con.createStatement();
            rrr = state.executeQuery(querymax);
            while (rrr.next()) {
                flatinfo=rrr.getString("flatinfo");
                break;
            }
            // System.out.print(fn+"  vol"+"\n");

             
             JSONObject js = new JSONObject(flatinfo);
             Iterator<String> keys = js.keys();
             while(keys.hasNext())
             {
                 String data=keys.next();
                
                 if(data.equals(flt)){
                    sum=sum+Integer.parseInt(js.getString(data));
                  
                }
             }
             
            querymax = "SELECT SUM(money) as money  FROM setutility where projectname='"+prn+"' AND flatname='"+flt+"' AND type='Utility' ;";
            state = con.createStatement();
            rrr = state.executeQuery(querymax);
            while (rrr.next()) {
                bill=rrr.getString("money");
                if(bill==null)
                {
                 sum=sum+0;
                }
                else
                {
                sum=sum+Integer.parseInt(bill);
 
                }
            }
            querymax = "SELECT SUM(money) as money  FROM setutility where projectname='"+prn+"' AND flatname='"+flt+"' AND type='Other' ;";
            state = con.createStatement();
            rrr = state.executeQuery(querymax);
            while (rrr.next()) {
                bill=rrr.getString("money");
                 if(bill==null)
                {
                 sum=sum+0;
                }
                else
                {
                sum=sum+Integer.parseInt(bill);
 
                }            }

        } else {
            JOptionPane.showMessageDialog(null, "Not Conected");
        }

    } catch (Exception ee) {
    ee.printStackTrace();

    }
    return (sum);
    }
     public  HashSet<String> itemnamereturntopdf(String prn,String flt,String tblname,String colmnname) {
        HashSet<String> result=new HashSet();  
    try {
        java.sql.Connection con = databasebasecon();
        String query;
        if (con != null) {
           String querymax = "SELECT DISTINCT " + colmnname + " FROM " + tblname + " WHERE projectname = '" + prn + "' AND flatname = '" + flt + "';";
 
           Statement state = con.createStatement();
            ResultSet rrr = state.executeQuery(querymax);
            int test = 0;
            while (rrr.next()) {
                test = 1;
                result.add(rrr.getString(colmnname));                
            }

        } else {
            JOptionPane.showMessageDialog(null, "Not Conected");
        }

    } catch (Exception ee) {
    ee.printStackTrace();

    }
    return (result);
    }
     public  HashSet<String> itemnamereturntopdf(String prn,String tblname,String colmnname) {
        HashSet<String> result=new HashSet();  
    try {
        java.sql.Connection con = databasebasecon();
        String query;
        if (con != null) {
           String querymax = "SELECT DISTINCT " + colmnname + " FROM " + tblname + " WHERE projectname = '" + prn + "';";
 
           Statement state = con.createStatement();
            ResultSet rrr = state.executeQuery(querymax);
            int test = 0;
            while (rrr.next()) {
                test = 1;
                result.add(rrr.getString(colmnname));                
            }

        } else {
            JOptionPane.showMessageDialog(null, "Not Conected");
        }

    } catch (Exception ee) {
    ee.printStackTrace();

    }
    return (result);
    }
     
     public  HashSet<String> BankInfo(String tblname,String colmnname) {
        HashSet<String> result=new HashSet();  
    try {
        java.sql.Connection con = databasebasecon();
        String query;
        if (con != null) {
           String querymax = "SELECT DISTINCT " + colmnname + " FROM " + tblname + " ;";
 
           Statement state = con.createStatement();
            ResultSet rrr = state.executeQuery(querymax);
            int test = 0;
            while (rrr.next()) {
                test = 1;
                result.add(rrr.getString(colmnname));                
            }

        } else {
            JOptionPane.showMessageDialog(null, "Not Conected");
        }

    } catch (Exception ee) {
    ee.printStackTrace();

    }
    return (result);
    }
     public  HashSet<String> itemnamereturntopdf(String prn,String flt,String tblname,String colmnname,String type) {
        HashSet<String> result=new HashSet();  
    try {
        java.sql.Connection con = databasebasecon();
        String query;
        if (con != null) {
           String querymax = "SELECT DISTINCT " + colmnname + " FROM " + tblname + " WHERE projectname = '" + prn + "' AND flatname = '" + flt + "' AND type = '" + type + "' ;";
 
           Statement state = con.createStatement();
            ResultSet rrr = state.executeQuery(querymax);
            int test = 0;
            while (rrr.next()) {
                test = 1;
                result.add(rrr.getString(colmnname));                
            }

        } else {
            JOptionPane.showMessageDialog(null, "Not Conected");
        }

    } catch (Exception ee) {
    ee.printStackTrace();

    }
    return (result);
    }
     public  String deposit(String prn, String name) {
         String sum=null;
    try {
        java.sql.Connection con = databasebasecon();
        String query;
        if (con != null) {
            String querymax = "SELECT SUM(money)as money FROM projectcapitalincome where projectname='"+prn+"' AND incomesource='"+name+"' ;";
            Statement state = con.createStatement();
            ResultSet rrr = state.executeQuery(querymax);
            int test = 0;
            while (rrr.next()) {
                test = 1;
                sum=(rrr.getString("money"));
            }

        } else {
            JOptionPane.showMessageDialog(null, "Not Conected");
        }

    } catch (Exception ee) {
    ee.printStackTrace();

    }
    return (sum);
    }
      public  int sumutility(String prn) {
         String sum=null;
    try {
        java.sql.Connection con = databasebasecon();
        String query;
        if (con != null) {
            String querymax = "SELECT SUM(money)as money FROM incomeutility where projectname='"+prn+"' ;";
            Statement state = con.createStatement();
            ResultSet rrr = state.executeQuery(querymax);
            int test = 0;
            while (rrr.next()) {
                test = 1;
                sum=(rrr.getString("money"));
            }

        } else {
            JOptionPane.showMessageDialog(null, "Not Conected");
        }

    } catch (Exception ee) {
    ee.printStackTrace();

    }
    if(sum==null)
    {
        sum="0";
    }
    
    return (Integer.parseInt(sum));
    }
       public  int sumutility(String prn,String std,String etd) {
         String sum=null;
    try {
        java.sql.Connection con = databasebasecon();
        String query;
        if (con != null) {
            String querymax = "SELECT SUM(money)as money FROM incomeutility where projectname='"+prn+"' AND date<='"+Date.valueOf(etd)+"'AND date>='"+Date.valueOf(std)+"' ;";
            Statement state = con.createStatement();
            ResultSet rrr = state.executeQuery(querymax);
            int test = 0;
            while (rrr.next()) {
                test = 1;
                sum=(rrr.getString("money"));
            }

        } else {
            JOptionPane.showMessageDialog(null, "Not Conected");
        }

    } catch (Exception ee) {
    ee.printStackTrace();

    }
    if(sum==null)
    {
        sum="0";
    }
    
    return (Integer.parseInt(sum));
    }
       public  String utilityprice(String prn, String name) {
         String sum=null;
    try {
        java.sql.Connection con = databasebasecon();
        String query;
        if (con != null) {
            String querymax = "SELECT SUM(money)as money FROM setutility where projectname='"+prn+"' AND flatname='"+name+"'AND type='Utility' ;";
            Statement state = con.createStatement();
            ResultSet rrr = state.executeQuery(querymax);
            int test = 0;
            while (rrr.next()) {
                test = 1;
                sum=(rrr.getString("money"));
            }

        } else {
            JOptionPane.showMessageDialog(null, "Not Conected");
        }

    } catch (Exception ee) {
    ee.printStackTrace();

    }
    return (sum);
    }
        public  String utilityprice(String prn, String name,String date) {
         String sum=null;
    try {
        java.sql.Connection con = databasebasecon();
        String query;
        if (con != null) {
            String querymax = "SELECT SUM(money)as money FROM setutility where projectname='"+prn+"' AND flatname='"+name+"'AND type='Utility' AND date='"+date+"' ;";
            Statement state = con.createStatement();
            ResultSet rrr = state.executeQuery(querymax);
            int test = 0;
            while (rrr.next()) {
                test = 1;
                sum=(rrr.getString("money"));
            }

        } else {
            JOptionPane.showMessageDialog(null, "Not Conected");
        }

    } catch (Exception ee) {
    ee.printStackTrace();

    }
    return (sum);
    }
         public  String utilitypriceonemore(String prn, String name,String date) {
         String sum=null;
    try {
        java.sql.Connection con = databasebasecon();
        String query;
        if (con != null) {
            String querymax = "SELECT SUM(money)as money FROM setutility where projectname='"+prn+"' AND flatname='"+name+"'AND type='Utility' AND date<'"+Date.valueOf(date)+"' ;";
            Statement state = con.createStatement();
            ResultSet rrr = state.executeQuery(querymax);
            int test = 0;
            while (rrr.next()) {
                test = 1;
                sum=(rrr.getString("money"));
            }

        } else {
            JOptionPane.showMessageDialog(null, "Not Conected");
        }

    } catch (Exception ee) {
    ee.printStackTrace();

    }
    return (sum);
    }
          public  String utilitypriceonemoreperiod(String prn, String name,String startdate,String enddate) {
         String sum=null;
    try {
        java.sql.Connection con = databasebasecon();
        String query;
        if (con != null) {
            String querymax = "SELECT SUM(money)as money FROM setutility where projectname='"+prn+"' AND flatname='"+name+"'AND type='Utility' AND date<='"+Date.valueOf(enddate)+"'AND date>='"+Date.valueOf(startdate)+"' ;";
            Statement state = con.createStatement();
            ResultSet rrr = state.executeQuery(querymax);
            int test = 0;
            while (rrr.next()) {
                test = 1;
                sum=(rrr.getString("money"));
            }

        } else {
            JOptionPane.showMessageDialog(null, "Not Conected");
        }

    } catch (Exception ee) {
    ee.printStackTrace();

    }
    return (sum);
    }
        public  String otherprice(String prn, String name) {
         String sum=null;
    try {
        java.sql.Connection con = databasebasecon();
        String query;
        if (con != null) {
            String querymax = "SELECT SUM(money)as money FROM setutility where projectname='"+prn+"' AND flatname='"+name+"' AND type='Other' ;";
            Statement state = con.createStatement();
            ResultSet rrr = state.executeQuery(querymax);
            int test = 0;
            while (rrr.next()) {
                test = 1;
                sum=(rrr.getString("money"));
            }

        } else {
            JOptionPane.showMessageDialog(null, "Not Conected");
        }

    } catch (Exception ee) {
    ee.printStackTrace();

    }
    return (sum);
    }
        public  String otherprice(String prn, String name,String date) {
         String sum=null;
    try {
        java.sql.Connection con = databasebasecon();
        String query;
        if (con != null) {
            String querymax = "SELECT SUM(money)as money FROM setutility where projectname='"+prn+"' AND flatname='"+name+"' AND type='Other' AND date='"+date+"' ;";
            Statement state = con.createStatement();
            ResultSet rrr = state.executeQuery(querymax);
            int test = 0;
            while (rrr.next()) {
                test = 1;
                sum=(rrr.getString("money"));
            }

        } else {
            JOptionPane.showMessageDialog(null, "Not Conected");
        }

    } catch (Exception ee) {
    ee.printStackTrace();

    }
    return (sum);
    }
        public  String otherpriceonemore(String prn, String name,String date) {
         String sum=null;
    try {
        java.sql.Connection con = databasebasecon();
        String query;
        if (con != null) {
            String querymax = "SELECT SUM(money)as money FROM setutility where projectname='"+prn+"' AND flatname='"+name+"' AND type='Other' AND date<'"+Date.valueOf(date)+"' ;";
            Statement state = con.createStatement();
            ResultSet rrr = state.executeQuery(querymax);
            int test = 0;
            while (rrr.next()) {
                test = 1;
                sum=(rrr.getString("money"));
            }

        } else {
            JOptionPane.showMessageDialog(null, "Not Conected");
        }

    } catch (Exception ee) {
    ee.printStackTrace();

    }
    return (sum);
    }
         public  String otherpriceonemoreperiod(String prn, String name,String startdate,String enddate) {
         String sum=null;
    try {
        java.sql.Connection con = databasebasecon();
        String query;
        if (con != null) {
            String querymax = "SELECT SUM(money)as money FROM setutility where projectname='"+prn+"' AND flatname='"+name+"' AND type='Other' AND date<='"+Date.valueOf(enddate)+"'AND date>='"+Date.valueOf(startdate)+"' ;";
            Statement state = con.createStatement();
            ResultSet rrr = state.executeQuery(querymax);
            int test = 0;
            while (rrr.next()) {
                test = 1;
                sum=(rrr.getString("money"));
            }

        } else {
            JOptionPane.showMessageDialog(null, "Not Conected");
        }

    } catch (Exception ee) {
    ee.printStackTrace();

    }
    return (sum);
    }
      public  String withdraw(String prn, String name) {
         String sum=null;
    try {
        java.sql.Connection con = databasebasecon();
        String query;
        if (con != null) {
            String querymax = "SELECT SUM(money)as money FROM projectdebitwithdraw where projectname='"+prn+"' AND debitsource='"+name+"' ;";
            Statement state = con.createStatement();
            ResultSet rrr = state.executeQuery(querymax);
            int test = 0;
            while (rrr.next()) {
                test = 1;
                sum=(rrr.getString("money"));
            }

        } else {
            JOptionPane.showMessageDialog(null, "Not Conected");
        }

    } catch (Exception ee) {
    ee.printStackTrace();

    }
    return (sum);
    }
       public  int totalsumforwithdraw(String prn) {
         int sum=0;
    try {
        java.sql.Connection con = databasebasecon();
        String query;
        if (con != null) {
            String querymax = "SELECT SUM(money)as money FROM projectdebitwithdraw where projectname='"+prn+"' ;";
            Statement state = con.createStatement();
            ResultSet rrr = state.executeQuery(querymax);
            int test = 0;
            while (rrr.next()) {
                test = 1;
                sum=Integer.parseInt(rrr.getString("money"));
            }

        } else {
            JOptionPane.showMessageDialog(null, "Not Conected");
        }

    } catch (Exception ee) {
    ee.printStackTrace();

    }
    return (sum);
    }
        public  int totalsumfordeposit(String prn) {
         int sum=0;
    try {
        java.sql.Connection con = databasebasecon();
        String query;
        if (con != null) {
            String querymax = "SELECT SUM(money)as money FROM projectcapitalincome where projectname='"+prn+"' ;";
            Statement state = con.createStatement();
            ResultSet rrr = state.executeQuery(querymax);
            int test = 0;
            while (rrr.next()) {
                test = 1;
                sum=Integer.parseInt(rrr.getString("money"));
            }

        } else {
            JOptionPane.showMessageDialog(null, "Not Conected");
        }

    } catch (Exception ee) {
    ee.printStackTrace();

    }
    return (sum);
    }
     public  HashSet<String> getsharemateprojectnamebackup() {
        HashSet<String> result=new HashSet();  
    try {
        java.sql.Connection con = databasebasecon();
        String query;
        if (con != null) {
            String querymax = "SELECT distinct projectname FROM sharematebackup ;";
            Statement state = con.createStatement();
            ResultSet rrr = state.executeQuery(querymax);
            int test = 0;
            while (rrr.next()) {
                test = 1;
                result.add(rrr.getString("projectname"));                
            }

        } else {
            JOptionPane.showMessageDialog(null, "Not Conected");
        }

    } catch (Exception ee) {
    ee.printStackTrace();

    }
    return (result);
    }
    
     public  HashSet<String> getsharemateprojectcapital(String pn) {
        HashSet<String> result=new HashSet();  
    try {
        java.sql.Connection con = databasebasecon();
        String query;
        if (con != null) {
            String querymax = "SELECT distinct date FROM [HabitatLimited].[dbo].[projectcapitalincome] where projectname='"+pn+"' ;";
            Statement state = con.createStatement();
            ResultSet rrr = state.executeQuery(querymax);
            int test = 0;
            while (rrr.next()) {
                test = 1;
                result.add(rrr.getDate("date").toString());                
            }

        } else {
            JOptionPane.showMessageDialog(null, "Not Conected");
        }

    } catch (Exception ee) {
    ee.printStackTrace();

    }
    return (result);
    }
    
      public  HashSet<String> getsharemateprojectcapitalbackup(String pn) {
        HashSet<String> result=new HashSet();  
    try {
        java.sql.Connection con = databasebasecon();
        String query;
        if (con != null) {
            String querymax = "SELECT distinct date FROM [HabitatLimited].[dbo].[projectcapitalincomebackup] where projectname='"+pn+"' ;";
            Statement state = con.createStatement();
            ResultSet rrr = state.executeQuery(querymax);
            int test = 0;
            while (rrr.next()) {
                test = 1;
                result.add(rrr.getDate("date").toString());                
            }

        } else {
            JOptionPane.showMessageDialog(null, "Not Conected");
        }

    } catch (Exception ee) {
    ee.printStackTrace();

    }
    return (result);
    }
    
      public  HashSet<String> getsharemateprojectwithdraw(String pn) {
        HashSet<String> result=new HashSet();  
    try {
        java.sql.Connection con = databasebasecon();
        String query;
        if (con != null) {
            String querymax = "SELECT distinct date FROM  projectdebitwithdraw where projectname='"+pn+"' ;";
            Statement state = con.createStatement();
            ResultSet rrr = state.executeQuery(querymax);
            int test = 0;
            while (rrr.next()) {
                test = 1;
                result.add(rrr.getDate("date").toString());                
            }

        } else {
            JOptionPane.showMessageDialog(null, "Not Conected");
        }

    } catch (Exception ee) {
    ee.printStackTrace();

    }
    return (result);
    }
    
      public  HashSet<String> getsharemateprojectwithdrawbackup(String pn) {
        HashSet<String> result=new HashSet();  
    try {
        java.sql.Connection con = databasebasecon();
        String query;
        if (con != null) {
            String querymax = "SELECT distinct date FROM  projectdebitwithdrawbackup where projectname='"+pn+"' ;";
            Statement state = con.createStatement();
            ResultSet rrr = state.executeQuery(querymax);
            int test = 0;
            while (rrr.next()) {
                test = 1;
                result.add(rrr.getDate("date").toString());                
            }

        } else {
            JOptionPane.showMessageDialog(null, "Not Conected");
        }

    } catch (Exception ee) {
    ee.printStackTrace();

    }
    return (result);
    }
    
       public  HashSet<String> getothersdatebackup(String pn) {
        HashSet<String> result=new HashSet();  
    try {
        java.sql.Connection con = databasebasecon();
        String query;
        if (con != null) {
            String querymax = "SELECT distinct date FROM  projectextraincomebackup where projectname='"+pn+"' ;";
            Statement state = con.createStatement();
            ResultSet rrr = state.executeQuery(querymax);
            int test = 0;
            while (rrr.next()) {
                test = 1;
                result.add(rrr.getDate("date").toString());                
            }

        } else {
            JOptionPane.showMessageDialog(null, "Not Conected");
        }

    } catch (Exception ee) {
    ee.printStackTrace();

    }
    return (result);
    }
    
       public  HashSet<String> getothersincomedate(String pn) {
        HashSet<String> result=new HashSet();  
    try {
        java.sql.Connection con = databasebasecon();
        String query;
        if (con != null) {
            String querymax = "SELECT distinct date FROM  projectextraincome where projectname='"+pn+"' ;";
            Statement state = con.createStatement();
            ResultSet rrr = state.executeQuery(querymax);
            int test = 0;
            while (rrr.next()) {
                test = 1;
                result.add(rrr.getDate("date").toString());                
            }

        } else {
            JOptionPane.showMessageDialog(null, "Not Conected");
        }

    } catch (Exception ee) {
    ee.printStackTrace();

    }
    return (result);
    }
    
       public  HashSet<String> getsharemateprojectdebit(String pn) {
        HashSet<String> result=new HashSet();  
    try {
        java.sql.Connection con = databasebasecon();
        String query;
        if (con != null) {
            String querymax = "SELECT distinct date FROM  projectdebit where projectname='"+pn+"' ;";
            Statement state = con.createStatement();
            ResultSet rrr = state.executeQuery(querymax);
            int test = 0;
            while (rrr.next()) {
                test = 1;
                result.add(rrr.getDate("date").toString());                
            }

        } else {
            JOptionPane.showMessageDialog(null, "Not Conected");
        }

    } catch (Exception ee) {
    ee.printStackTrace();

    }
    return (result);
    }
     
        public  HashSet<String> itemnamereturn(String pn) {
        HashSet<String> result=new HashSet();  
    try {
        java.sql.Connection con = databasebasecon();
        String query;
        if (con != null) {
            String querymax = "SELECT distinct itemname FROM  itemname where projectname='"+pn+"' ;";
            Statement state = con.createStatement();
            ResultSet rrr = state.executeQuery(querymax);
            int test = 0;
            while (rrr.next()) {
                test = 1;
                result.add(rrr.getString("itemname").toString());                
            }

        } else {
            JOptionPane.showMessageDialog(null, "Not Conected");
        }

    } catch (Exception ee) {
    ee.printStackTrace();

    }
    return (result);
    }
     
     public  HashSet<String> getsharemateprojectdebitbackup(String pn) {
        HashSet<String> result=new HashSet();  
    try {
        java.sql.Connection con = databasebasecon();
        String query;
        if (con != null) {
            String querymax = "SELECT distinct date FROM  projectdebitbackup where projectname='"+pn+"' ;";
            Statement state = con.createStatement();
            ResultSet rrr = state.executeQuery(querymax);
            int test = 0;
            while (rrr.next()) {
                test = 1;
                result.add(rrr.getDate("date").toString());                
            }

        } else {
            JOptionPane.showMessageDialog(null, "Not Conected");
        }

    } catch (Exception ee) {
    ee.printStackTrace();

    }
    return (result);
    }
        public  HashSet<String> getextraincomedate(String pn) {
        HashSet<String> result=new HashSet();  
    try {
        java.sql.Connection con = databasebasecon();
        String query;
        if (con != null) {
            String querymax = "SELECT distinct date FROM  projectextraincome where projectname='"+pn+"' ;";
            Statement state = con.createStatement();
            ResultSet rrr = state.executeQuery(querymax);
            int test = 0;
            while (rrr.next()) {
                test = 1;
                result.add(rrr.getDate("date").toString());                
            }

        } else {
            JOptionPane.showMessageDialog(null, "Not Conected");
        }

    } catch (Exception ee) {
    ee.printStackTrace();

    }
    return (result);
    }
    
         public  HashSet<String> extradebitdate() {
        HashSet<String> result=new HashSet();  
    try {
        java.sql.Connection con = databasebasecon();
        String query;
        if (con != null) {
            String querymax = "SELECT distinct date FROM  projectextradebit ;";
            Statement state = con.createStatement();
            ResultSet rrr = state.executeQuery(querymax);
            int test = 0;
            while (rrr.next()) {
                test = 1;
                result.add(rrr.getDate("date").toString());                
            }

        } else {
            JOptionPane.showMessageDialog(null, "Not Conected");
        }

    } catch (Exception ee) {
    ee.printStackTrace();

    }
    return (result);
    }
       public  HashSet<String> extradebitdatebackup() {
        HashSet<String> result=new HashSet();  
    try {
        java.sql.Connection con = databasebasecon();
        String query;
        if (con != null) {
            String querymax = "SELECT distinct date FROM  projectextradebitbackup ;";
            Statement state = con.createStatement();
            ResultSet rrr = state.executeQuery(querymax);
            int test = 0;
            while (rrr.next()) {
                test = 1;
                result.add(rrr.getDate("date").toString());                
            }

        } else {
            JOptionPane.showMessageDialog(null, "Not Conected");
        }

    } catch (Exception ee) {
    ee.printStackTrace();

    }
    return (result);
    }
    
     public  HashSet<String> getsharemateprojectflatdate(String pn,String fn) {
        HashSet<String> result=new HashSet();  
    try {
        java.sql.Connection con = databasebasecon();
        String query;
        if (con != null) {
            String querymax = "SELECT distinct date FROM [HabitatLimited].[dbo].[projectincome] where projectname='"+pn+"' AND flatname='"+fn+"' ;";
            Statement state = con.createStatement();
            ResultSet rrr = state.executeQuery(querymax);
            int test = 0;
            while (rrr.next()) {
                test = 1;
                result.add(rrr.getDate("date").toString());            
               // System.out.println(rrr.getDate("date"));
            }

        } else {
            JOptionPane.showMessageDialog(null, "Not Conected");
        }

    } catch (Exception ee) {
    ee.printStackTrace();

    }
                    //System.out.println(result.size());

    return (result);
    }
      public  HashSet<String> getsetutilitydate(String pn,String fn) {
        HashSet<String> result=new HashSet();  
    try {
        java.sql.Connection con = databasebasecon();
        String query;
        if (con != null) {
            String querymax = "SELECT distinct date FROM [HabitatLimited].[dbo].[setutility] where projectname='"+pn+"' AND flatname='"+fn+"' ;";
            Statement state = con.createStatement();
            ResultSet rrr = state.executeQuery(querymax);
            int test = 0;
            while (rrr.next()) {
                test = 1;
                result.add(rrr.getDate("date").toString());            
               // System.out.println(rrr.getDate("date"));
            }

        } else {
            JOptionPane.showMessageDialog(null, "Not Conected");
        }

    } catch (Exception ee) {
    ee.printStackTrace();

    }
                    //System.out.println(result.size());

    return (result);
    }
       public  HashSet<String> getsetutilitydatebackup(String pn,String fn) {
        HashSet<String> result=new HashSet();  
    try {
        java.sql.Connection con = databasebasecon();
        String query;
        if (con != null) {
            String querymax = "SELECT distinct date FROM [HabitatLimited].[dbo].[setutilitybackup] where projectname='"+pn+"' AND flatname='"+fn+"' ;";
            Statement state = con.createStatement();
            ResultSet rrr = state.executeQuery(querymax);
            int test = 0;
            while (rrr.next()) {
                test = 1;
                result.add(rrr.getDate("date").toString());            
               // System.out.println(rrr.getDate("date"));
            }

        } else {
            JOptionPane.showMessageDialog(null, "Not Conected");
        }

    } catch (Exception ee) {
    ee.printStackTrace();

    }
                    //System.out.println(result.size());

    return (result);
    }
       public  HashSet<String> getincomeutilitydate(String pn,String fn) {
        HashSet<String> result=new HashSet();  
    try {
        java.sql.Connection con = databasebasecon();
        String query;
        if (con != null) {
            String querymax = "SELECT distinct date FROM [HabitatLimited].[dbo].[incomeutility] where projectname='"+pn+"' AND flatname='"+fn+"' ;";
            Statement state = con.createStatement();
            ResultSet rrr = state.executeQuery(querymax);
            int test = 0;
            while (rrr.next()) {
                test = 1;
                result.add(rrr.getDate("date").toString());            
               // System.out.println(rrr.getDate("date"));
            }

        } else {
            JOptionPane.showMessageDialog(null, "Not Conected");
        }

    } catch (Exception ee) {
    ee.printStackTrace();

    }
                    //System.out.println(result.size());

    return (result);
    }
        public  HashSet<String> getincomeutilitydatebackup(String pn,String fn) {
        HashSet<String> result=new HashSet();  
    try {
        java.sql.Connection con = databasebasecon();
        String query;
        if (con != null) {
            String querymax = "SELECT distinct date FROM [HabitatLimited].[dbo].[incomeutilitybackup] where projectname='"+pn+"' AND flatname='"+fn+"' ;";
            Statement state = con.createStatement();
            ResultSet rrr = state.executeQuery(querymax);
            int test = 0;
            while (rrr.next()) {
                test = 1;
                result.add(rrr.getDate("date").toString());            
               // System.out.println(rrr.getDate("date"));
            }

        } else {
            JOptionPane.showMessageDialog(null, "Not Conected");
        }

    } catch (Exception ee) {
    ee.printStackTrace();

    }
                    //System.out.println(result.size());

    return (result);
    }
      public  HashSet<String> sharematename(String pn) {
        HashSet<String> result=new HashSet();  
    try {
        java.sql.Connection con = databasebasecon();
        String query;
        if (con != null) {
            String querymax = "SELECT distinct sharematename FROM [HabitatLimited].[dbo].[sharemate] where projectname='"+pn+"' ;";
            Statement state = con.createStatement();
            ResultSet rrr = state.executeQuery(querymax);
            int test = 0;
            while (rrr.next()) {
                test = 1;
                result.add(rrr.getString("sharematename"));            
               // System.out.println(rrr.getDate("date"));
            }

        } else {
            JOptionPane.showMessageDialog(null, "Not Conected");
        }

    } catch (Exception ee) {
    ee.printStackTrace();

    }
                    //System.out.println(result.size());

    return (result);
    }
     public  HashSet<String> getsharemateprojectflatdatebackup(String pn,String fn) {
        HashSet<String> result=new HashSet();  
    try {
        java.sql.Connection con = databasebasecon();
        String query;
        if (con != null) {
            String querymax = "SELECT distinct date FROM [HabitatLimited].[dbo].[projectincomebackup] where projectname='"+pn+"' AND flatname='"+fn+"' ;";
            Statement state = con.createStatement();
            ResultSet rrr = state.executeQuery(querymax);
            int test = 0;
            while (rrr.next()) {
                test = 1;
                result.add(rrr.getDate("date").toString());            
               // System.out.println(rrr.getDate("date"));
            }

        } else {
            JOptionPane.showMessageDialog(null, "Not Conected");
        }

    } catch (Exception ee) {
    ee.printStackTrace();

    }
                    //System.out.println(result.size());

    return (result);
    }
    
     public  int getsharemateprojectflatnumber(String projectname) {
        int result=0;
        String flatinfo=null;
       try {
        java.sql.Connection con = databasebasecon();
        String query;
        if (con != null) {
            String querymax = "SELECT  flatnumber,flatinfo FROM sharemate where projectname='"+projectname+"' ;";
            Statement state = con.createStatement();
            ResultSet rrr = state.executeQuery(querymax);
            int test = 0;
            while (rrr.next()) {
                test = 1;
                result=Integer.parseInt(rrr.getString("flatnumber"));
                flatinfo=rrr.getString("flatinfo");
               // System.out.print(flatinfo+"\n");
                break;
            }
            JSONObject js = new JSONObject(flatinfo);
            //System.out.print(js.getString("rtyh")+"\n");
             Iterator<String> keys = js.keys();
             while(keys.hasNext())
             {
                // System.out.print(keys.next()+"\n");
             }
           // System.out.print(js+"\n");
         
        } else {
            JOptionPane.showMessageDialog(null, "Not Conected");
        }

    } catch (Exception ee) {
    ee.printStackTrace();

    }
    return (result);
    }
     
      public  JSONObject getsharemateprojectflatinfo(String projectname) {
        int result=0;
        JSONObject js=null ;
        String flatinfo=null;
       try {
        java.sql.Connection con = databasebasecon();
        String query;
        if (con != null) {
            String querymax = "SELECT  flatnumber,flatinfo FROM sharemate where projectname='"+projectname+"' ;";
            Statement state = con.createStatement();
            ResultSet rrr = state.executeQuery(querymax);
            int test = 0;
            while (rrr.next()) {
                test = 1;
                result=Integer.parseInt(rrr.getString("flatnumber"));
                flatinfo=rrr.getString("flatinfo");
                break;
            }
             js = new JSONObject(flatinfo);
         
        } else {
            JOptionPane.showMessageDialog(null, "Not Conected");
        }

    } catch (Exception ee) {
    ee.printStackTrace();

    }
    return (js);
    }
       public  JSONObject getsharemateprojectflatinfobackup(String projectname) {
        int result=0;
         JSONObject js=null ;
        String flatinfo=null;
       try {
        java.sql.Connection con = databasebasecon();
        String query;
        if (con != null) {
            String querymax = "SELECT  flatnumber,flatinfo FROM sharematebackup where projectname='"+projectname+"' ;";
            Statement state = con.createStatement();
            ResultSet rrr = state.executeQuery(querymax);
            int test = 0;
            while (rrr.next()) {
                test = 1;
                result=Integer.parseInt(rrr.getString("flatnumber"));
                flatinfo=rrr.getString("flatinfo");
                break;
            }
             js = new JSONObject(flatinfo);
         
        } else {
            JOptionPane.showMessageDialog(null, "Not Conected");
        }

    } catch (Exception ee) {
    ee.printStackTrace();

    }
    return (js);
    }
      public  JSONObject getsharemateprojecteditinfo(String projectname,String flt ,String date) {
         JSONObject   js = new JSONObject();
         array = new JSONArray();
       try {
        java.sql.Connection con = databasebasecon();
        String query;
        if (con != null) {
            String querymax = "SELECT  * FROM projectincome where projectname='"+projectname+"' AND flatname='"+flt+"' AND date='"+date+"' ;";
            Statement state = con.createStatement();
            ResultSet rrr = state.executeQuery(querymax);
            int test = 0;
            while (rrr.next()) {
                jsondata = new JSONObject();
                jsondata.append("money", rrr.getString("money"));
                jsondata.append("incomesource", rrr.getString("incomesource"));
                 array.put(jsondata);
                test = 1;              
            }
            js.put("data", array);
         
        } else {
            JOptionPane.showMessageDialog(null, "Not Conected");
        }

    } catch (Exception ee) {
    ee.printStackTrace();

    }
       System.out.println(js);
    return (js);
    }
       public  JSONObject setutilityeditinfo(String projectname,String flt ,String date) {
         JSONObject   js = new JSONObject();
         array = new JSONArray();
       try {
        java.sql.Connection con = databasebasecon();
        String query;
        if (con != null) {
            String querymax = "SELECT  * FROM setutility where projectname='"+projectname+"' AND flatname='"+flt+"' AND date='"+date+"' ;";
            Statement state = con.createStatement();
            ResultSet rrr = state.executeQuery(querymax);
            int test = 0;
            while (rrr.next()) {
                jsondata = new JSONObject();
                jsondata.append("type", rrr.getString("type"));
                jsondata.append("money", rrr.getString("money"));
                jsondata.append("incomesource", rrr.getString("incomesource"));
                 array.put(jsondata);
                test = 1;              
            }
            js.put("data", array);
         
        } else {
            JOptionPane.showMessageDialog(null, "Not Conected");
        }

    } catch (Exception ee) {
    ee.printStackTrace();

    }
       System.out.println(js);
    return (js);
    }
       public  JSONObject setutilityeditinfobackup(String projectname,String flt ,String date) {
         JSONObject   js = new JSONObject();
         array = new JSONArray();
       try {
        java.sql.Connection con = databasebasecon();
        String query;
        if (con != null) {
            String querymax = "SELECT  * FROM setutilitybackup where projectname='"+projectname+"' AND flatname='"+flt+"' AND date='"+date+"' ;";
            Statement state = con.createStatement();
            ResultSet rrr = state.executeQuery(querymax);
            int test = 0;
            while (rrr.next()) {
                jsondata = new JSONObject();
                jsondata.append("type", rrr.getString("type"));
                jsondata.append("money", rrr.getString("money"));
                jsondata.append("incomesource", rrr.getString("incomesource"));
                 array.put(jsondata);
                test = 1;              
            }
            js.put("data", array);
         
        } else {
            JOptionPane.showMessageDialog(null, "Not Conected");
        }

    } catch (Exception ee) {
    ee.printStackTrace();

    }
       System.out.println(js);
    return (js);
    }
       public  JSONObject incomeutilityeditinfo(String projectname,String flt ,String date) {
         JSONObject   js = new JSONObject();
         array = new JSONArray();
       try {
        java.sql.Connection con = databasebasecon();
        String query;
        if (con != null) {
            String querymax = "SELECT  * FROM incomeutility where projectname='"+projectname+"' AND flatname='"+flt+"' AND date='"+date+"' ;";
            Statement state = con.createStatement();
            ResultSet rrr = state.executeQuery(querymax);
            int test = 0;
            while (rrr.next()) {
                jsondata = new JSONObject();
                jsondata.append("type", rrr.getString("type"));
                jsondata.append("money", rrr.getString("money"));
                jsondata.append("incomesource", rrr.getString("incomesource"));
                 array.put(jsondata);
                test = 1;              
            }
            js.put("data", array);
         
        } else {
            JOptionPane.showMessageDialog(null, "Not Conected");
        }

    } catch (Exception ee) {
    ee.printStackTrace();

    }
       System.out.println(js);
    return (js);
    }
        public  JSONObject incomeutilityeditinfobackup(String projectname,String flt ,String date) {
         JSONObject   js = new JSONObject();
         array = new JSONArray();
       try {
        java.sql.Connection con = databasebasecon();
        String query;
        if (con != null) {
            String querymax = "SELECT  * FROM incomeutilitybackup where projectname='"+projectname+"' AND flatname='"+flt+"' AND date='"+date+"' ;";
            Statement state = con.createStatement();
            ResultSet rrr = state.executeQuery(querymax);
            int test = 0;
            while (rrr.next()) {
                jsondata = new JSONObject();
                jsondata.append("type", rrr.getString("type"));
                jsondata.append("money", rrr.getString("money"));
                jsondata.append("incomesource", rrr.getString("incomesource"));
                 array.put(jsondata);
                test = 1;              
            }
            js.put("data", array);
         
        } else {
            JOptionPane.showMessageDialog(null, "Not Conected");
        }

    } catch (Exception ee) {
    ee.printStackTrace();

    }
       System.out.println(js);
    return (js);
    }
       public  JSONObject getsharemateprojecteditinfobackup(String projectname,String flt ,String date) {
         JSONObject   js = new JSONObject();
         array = new JSONArray();
       try {
        java.sql.Connection con = databasebasecon();
        String query;
        if (con != null) {
            String querymax = "SELECT  * FROM projectincomebackup where projectname='"+projectname+"' AND flatname='"+flt+"' AND date='"+date+"' ;";
            Statement state = con.createStatement();
            ResultSet rrr = state.executeQuery(querymax);
            int test = 0;
            while (rrr.next()) {
                jsondata = new JSONObject();
                jsondata.append("money", rrr.getString("money"));
                jsondata.append("incomesource", rrr.getString("incomesource"));
                 array.put(jsondata);
                test = 1;              
            }
            js.put("data", array);
         
        } else {
            JOptionPane.showMessageDialog(null, "Not Conected");
        }

    } catch (Exception ee) {
    ee.printStackTrace();

    }
       System.out.println(js);
    return (js);
    }
       public  JSONObject extradebit(String date) {
         JSONObject   js = new JSONObject();
         array = new JSONArray();
       try {
        java.sql.Connection con = databasebasecon();
        String query;
        if (con != null) {
            String querymax = "SELECT  * FROM projectextradebit where  date='"+date+"' ;";
            Statement state = con.createStatement();
            ResultSet rrr = state.executeQuery(querymax);
            int test = 0;
            while (rrr.next()) {
                jsondata = new JSONObject();
                jsondata.append("money", rrr.getString("money"));
                jsondata.append("incomesource", rrr.getString("debitsource"));
                 array.put(jsondata);
                test = 1;              
            }
            js.put("data", array);
         
        } else {
            JOptionPane.showMessageDialog(null, "Not Conected");
        }

    } catch (Exception ee) {
    ee.printStackTrace();

    }
       System.out.println(js);
    return (js);
    }
         public  JSONObject extradebitbackup(String date) {
         JSONObject   js = new JSONObject();
         array = new JSONArray();
       try {
        java.sql.Connection con = databasebasecon();
        String query;
        if (con != null) {
            String querymax = "SELECT  * FROM projectextradebitbackup where  date='"+date+"' ;";
            Statement state = con.createStatement();
            ResultSet rrr = state.executeQuery(querymax);
            int test = 0;
            while (rrr.next()) {
                jsondata = new JSONObject();
                jsondata.append("money", rrr.getString("money"));
                jsondata.append("incomesource", rrr.getString("debitsource"));
                 array.put(jsondata);
                test = 1;              
            }
            js.put("data", array);
         
        } else {
            JOptionPane.showMessageDialog(null, "Not Conected");
        }

    } catch (Exception ee) {
    ee.printStackTrace();

    }
       System.out.println(js);
    return (js);
    }
        public  JSONObject extracredit(String prn) {
         JSONObject   js = new JSONObject();
         array = new JSONArray();
       try {
        java.sql.Connection con = databasebasecon();
        String query;
        if (con != null) {
            String querymax = "SELECT  * FROM projectextraincome where  projectname='"+prn+"' ;";
            Statement state = con.createStatement();
            ResultSet rrr = state.executeQuery(querymax);
            int test = 0;
            while (rrr.next()) {
                jsondata = new JSONObject();
                 jsondata.append("projectname", rrr.getString("projectname"));
                jsondata.append("money", rrr.getString("money"));
                jsondata.append("name", rrr.getString("incomesource"));
                 jsondata.append("date", rrr.getDate("date"));
                 array.put(jsondata);
                test = 1;              
            }
            js.put("data", array);
         
        } else {
            JOptionPane.showMessageDialog(null, "Not Conected");
        }

    } catch (Exception ee) {
    ee.printStackTrace();

    }
       System.out.println(js);
    return (js);
    }
        public  JSONObject extracreditfix(String prn,String date) {
         JSONObject   js = new JSONObject();
         array = new JSONArray();
       try {
        java.sql.Connection con = databasebasecon();
        String query;
        if (con != null) {
            String querymax = "SELECT  * FROM projectextraincome where  projectname='"+prn+"' AND date='"+date+"' ;";
            Statement state = con.createStatement();
            ResultSet rrr = state.executeQuery(querymax);
            int test = 0;
            while (rrr.next()) {
                jsondata = new JSONObject();
                 jsondata.append("projectname", rrr.getString("projectname"));
                jsondata.append("money", rrr.getString("money"));
                jsondata.append("name", rrr.getString("incomesource"));
                 jsondata.append("date", rrr.getDate("date"));
                 array.put(jsondata);
                test = 1;              
            }
            js.put("data", array);
         
        } else {
            JOptionPane.showMessageDialog(null, "Not Conected");
        }

    } catch (Exception ee) {
    ee.printStackTrace();

    }
       System.out.println(js);
    return (js);
    }
         public  JSONObject extracreditfixonemore(String prn,String date) {
         JSONObject   js = new JSONObject();
         array = new JSONArray();
       try {
        java.sql.Connection con = databasebasecon();
        String query;
        if (con != null) {
            String querymax = "SELECT  * FROM projectextraincome where  projectname='"+prn+"' AND date<'"+Date.valueOf(date)+"' ;";
            Statement state = con.createStatement();
            ResultSet rrr = state.executeQuery(querymax);
            int test = 0;
            while (rrr.next()) {
                jsondata = new JSONObject();
                 jsondata.append("projectname", rrr.getString("projectname"));
                jsondata.append("money", rrr.getString("money"));
                jsondata.append("name", rrr.getString("incomesource"));
                 jsondata.append("date", rrr.getDate("date"));
                 array.put(jsondata);
                test = 1;              
            }
            js.put("data", array);
         
        } else {
            JOptionPane.showMessageDialog(null, "Not Conected");
        }

    } catch (Exception ee) {
    ee.printStackTrace();

    }
       System.out.println(js);
    return (js);
    }
         public  JSONObject extracreditfixonemoreperiod(String prn,String startdate,String enddate) {
         JSONObject   js = new JSONObject();
         array = new JSONArray();
       try {
        java.sql.Connection con = databasebasecon();
        String query;
        if (con != null) {
            String querymax = "SELECT  * FROM projectextraincome where  projectname='"+prn+"' AND date<='"+Date.valueOf(enddate)+"'AND date>='"+Date.valueOf(startdate)+"' ;";
            Statement state = con.createStatement();
            ResultSet rrr = state.executeQuery(querymax);
            int test = 0;
            while (rrr.next()) {
                jsondata = new JSONObject();
                 jsondata.append("projectname", rrr.getString("projectname"));
                jsondata.append("money", rrr.getString("money"));
                jsondata.append("name", rrr.getString("incomesource"));
                 jsondata.append("date", rrr.getDate("date"));
                 array.put(jsondata);
                test = 1;              
            }
            js.put("data", array);
         
        } else {
            JOptionPane.showMessageDialog(null, "Not Conected");
        }

    } catch (Exception ee) {
    ee.printStackTrace();

    }
       System.out.println(js);
    return (js);
    }
         public  JSONObject projectdebitcal(String prn) {
         JSONObject   js = new JSONObject();
         array = new JSONArray();
       try {
        java.sql.Connection con = databasebasecon();
        String query;
        if (con != null) {
            String querymax = "SELECT  * FROM projectdebit where  projectname='"+prn+"' ;";
            Statement state = con.createStatement();
            ResultSet rrr = state.executeQuery(querymax);
            int test = 0;
            while (rrr.next()) {
                jsondata = new JSONObject();
                 jsondata.append("projectname", rrr.getString("projectname"));
                jsondata.append("money", rrr.getString("money"));
                jsondata.append("name", rrr.getString("debitsource"));
                 jsondata.append("date", rrr.getDate("date"));
                 array.put(jsondata);
                test = 1;              
            }
            js.put("data", array);
         
        } else {
            JOptionPane.showMessageDialog(null, "Not Conected");
        }

    } catch (Exception ee) {
    ee.printStackTrace();

    }
       System.out.println(js);
    return (js);
    }
         public  JSONObject projectdebitcalfix(String prn,String date) {
         JSONObject   js = new JSONObject();
         array = new JSONArray();
       try {
        java.sql.Connection con = databasebasecon();
        String query;
        if (con != null) {
            String querymax = "SELECT  * FROM projectdebit where  projectname='"+prn+"' AND date='"+date+"' ;";
            Statement state = con.createStatement();
            ResultSet rrr = state.executeQuery(querymax);
            int test = 0;
            while (rrr.next()) {
                jsondata = new JSONObject();
                 jsondata.append("projectname", rrr.getString("projectname"));
                jsondata.append("money", rrr.getString("money"));
                jsondata.append("name", rrr.getString("debitsource"));
                 jsondata.append("date", rrr.getDate("date"));
                 array.put(jsondata);
                test = 1;              
            }
            js.put("data", array);
         
        } else {
            JOptionPane.showMessageDialog(null, "Not Conected");
        }

    } catch (Exception ee) {
    ee.printStackTrace();

    }
       System.out.println(js);
    return (js);
    }
         public  JSONObject projectdebitcalfixonemore(String prn,String date) {
         JSONObject   js = new JSONObject();
         array = new JSONArray();
       try {
        java.sql.Connection con = databasebasecon();
        String query;
        if (con != null) {
            String querymax = "SELECT  * FROM projectdebit where  projectname='"+prn+"' AND date<'"+Date.valueOf(date)+"' ;";
            Statement state = con.createStatement();
            ResultSet rrr = state.executeQuery(querymax);
            int test = 0;
            while (rrr.next()) {
                jsondata = new JSONObject();
                 jsondata.append("projectname", rrr.getString("projectname"));
                jsondata.append("money", rrr.getString("money"));
                jsondata.append("name", rrr.getString("debitsource"));
                 jsondata.append("date", rrr.getDate("date"));
                 array.put(jsondata);
                test = 1;              
            }
            js.put("data", array);
         
        } else {
            JOptionPane.showMessageDialog(null, "Not Conected");
        }

    } catch (Exception ee) {
    ee.printStackTrace();

    }
       System.out.println(js);
    return (js);
    }
          public  JSONObject projectdebitcalfixonemoreperiod(String prn,String startdate,String enddate) {
         JSONObject   js = new JSONObject();
         array = new JSONArray();
       try {
        java.sql.Connection con = databasebasecon();
        String query;
        if (con != null) {
            String querymax = "SELECT  * FROM projectdebit where  projectname='"+prn+"' AND date<='"+Date.valueOf(enddate)+"'AND date>='"+Date.valueOf(startdate)+"' ;";
            Statement state = con.createStatement();
            ResultSet rrr = state.executeQuery(querymax);
            int test = 0;
            while (rrr.next()) {
                jsondata = new JSONObject();
                 jsondata.append("projectname", rrr.getString("projectname"));
                jsondata.append("money", rrr.getString("money"));
                jsondata.append("name", rrr.getString("debitsource"));
                 jsondata.append("date", rrr.getDate("date"));
                 array.put(jsondata);
                test = 1;              
            }
            js.put("data", array);
         
        } else {
            JOptionPane.showMessageDialog(null, "Not Conected");
        }

    } catch (Exception ee) {
    ee.printStackTrace();

    }
       System.out.println(js);
    return (js);
    }
        public  JSONObject extracredit(String prn,String startdate,String enddate) {
         JSONObject   js = new JSONObject();
         array = new JSONArray();
       try {
        java.sql.Connection con = databasebasecon();
        String query;
        if (con != null) {
            String querymax = "SELECT  * FROM projectextraincome as t1 WHERE t1.date <= '"+Date.valueOf(enddate)+"'AND t1.date >= '"+Date.valueOf(startdate)+"'  AND  t1.projectname='"+prn+"' ;";
            Statement state = con.createStatement();
            ResultSet rrr = state.executeQuery(querymax);
            int test = 0;
            while (rrr.next()) {
                jsondata = new JSONObject();
                 jsondata.append("projectname", rrr.getString("projectname"));
                jsondata.append("money", rrr.getString("money"));
                jsondata.append("name", rrr.getString("incomesource"));
                 jsondata.append("date", rrr.getDate("date"));
                 array.put(jsondata);
                test = 1;              
            }
            js.put("data", array);
         
        } else {
            JOptionPane.showMessageDialog(null, "Not Conected");
        }

    } catch (Exception ee) {
    ee.printStackTrace();

    }
       System.out.println(js);
    return (js);
    }
        public  JSONObject extracredit(String prn,String enddate) {
         JSONObject   js = new JSONObject();
         array = new JSONArray();
       try {
        java.sql.Connection con = databasebasecon();
        String query;
        if (con != null) {
            String querymax = "SELECT  * FROM projectextraincome as t1 WHERE t1.date <= '"+Date.valueOf(enddate)+"'  AND  t1.projectname='"+prn+"' ;";
            Statement state = con.createStatement();
            ResultSet rrr = state.executeQuery(querymax);
            int test = 0;
            while (rrr.next()) {
                jsondata = new JSONObject();
                 jsondata.append("projectname", rrr.getString("projectname"));
                jsondata.append("money", rrr.getString("money"));
                jsondata.append("name", rrr.getString("incomesource"));
                 jsondata.append("date", rrr.getDate("date"));
                 array.put(jsondata);
                test = 1;              
            }
            js.put("data", array);
         
        } else {
            JOptionPane.showMessageDialog(null, "Not Conected");
        }

    } catch (Exception ee) {
    ee.printStackTrace();

    }
       System.out.println(js);
    return (js);
    }
         public  JSONObject extracreditonday(String prn,String enddate) {
         JSONObject   js = new JSONObject();
         array = new JSONArray();
       try {
        java.sql.Connection con = databasebasecon();
        String query;
        if (con != null) {
            String querymax = "SELECT  * FROM projectextraincome as t1 WHERE t1.date = '"+Date.valueOf(enddate)+"'  AND  t1.projectname='"+prn+"' ;";
            Statement state = con.createStatement();
            ResultSet rrr = state.executeQuery(querymax);
            int test = 0;
            while (rrr.next()) {
                jsondata = new JSONObject();
                 jsondata.append("projectname", rrr.getString("projectname"));
                jsondata.append("money", rrr.getString("money"));
                jsondata.append("name", rrr.getString("incomesource"));
                 jsondata.append("date", rrr.getDate("date"));
                 array.put(jsondata);
                test = 1;              
            }
            js.put("data", array);
         
        } else {
            JOptionPane.showMessageDialog(null, "Not Conected");
        }

    } catch (Exception ee) {
    ee.printStackTrace();

    }
       System.out.println(js);
    return (js);
    }
           public  JSONObject registrationdata() {
         JSONObject   js = new JSONObject();
         array = new JSONArray();
       try {
        java.sql.Connection con = databasebasecon();
        String query;
        if (con != null) {
            String querymax = "SELECT  * FROM registration  ;";
            Statement state = con.createStatement();
            ResultSet rrr = state.executeQuery(querymax);
            int test = 0;
            while (rrr.next()) {
                jsondata = new JSONObject();
                 jsondata.append("username", rrr.getString("username"));
                jsondata.append("password", rrr.getString("password"));
                jsondata.append("role", rrr.getString("role"));
                 array.put(jsondata);
                test = 1;              
            }
            js.put("data", array);
         
        } else {
            JOptionPane.showMessageDialog(null, "Not Conected");
        }

    } catch (Exception ee) {
    ee.printStackTrace();

    }
       System.out.println(js);
    return (js);
    }
             public  JSONObject sharemateinfo(String prn) {
         JSONObject   js = new JSONObject();
         array = new JSONArray();
       try {
        java.sql.Connection con = databasebasecon();
        String query;
        if (con != null) {
            String querymax = "SELECT  * FROM sharemate where projectname='"+prn+"'  ;";
            Statement state = con.createStatement();
            ResultSet rrr = state.executeQuery(querymax);
            int test = 0;
            while (rrr.next()) {
                jsondata = new JSONObject();
                jsondata.append("sharematename", rrr.getString("sharematename"));
                jsondata.append("sharemateamount", rrr.getString("sharemateamount"));
                jsondata.append("flatinfo", rrr.getString("flatinfo"));
                jsondata.append("date", rrr.getString("date"));
                array.put(jsondata);
                test = 1;              
            }
            js.put("data", array);
         
        } else {
            JOptionPane.showMessageDialog(null, "Not Conected");
        }

    } catch (Exception ee) {
    ee.printStackTrace();

    }
       System.out.println(js);
    return (js);
    }
       public  boolean logintest(String username,String password) {
         array = new JSONArray();
        boolean test =false;

       try {
        java.sql.Connection con = databasebasecon();
        String query;
        if (con != null) {
            String querymax = "SELECT  * FROM registration where username='"+username+"' AND password='"+password+"' ;";
            Statement state = con.createStatement();
            ResultSet rrr = state.executeQuery(querymax);
            while (rrr.next()) {

                test =true;              
            }
         
        } else {
            JOptionPane.showMessageDialog(null, "Not Conected");
        }

    } catch (Exception ee) {
    ee.printStackTrace();

    }
    return (test);
    }
        public  String loginrole(String username,String password) {
         array = new JSONArray();
        String test=null ;

       try {
        java.sql.Connection con = databasebasecon();
        String query;
        if (con != null) {
            String querymax = "SELECT  * FROM registration where username='"+username+"' AND password='"+password+"' ;";
            Statement state = con.createStatement();
            ResultSet rrr = state.executeQuery(querymax);
            while (rrr.next()) {

                test =rrr.getString("role");              
            }
         
        } else {
            JOptionPane.showMessageDialog(null, "Not Conected");
        }

    } catch (Exception ee) {
    ee.printStackTrace();

    }
    return (test);
    }
      
       public  JSONObject getsharemateprojecteditinfocapital(String projectname,String flt ,String date) {
         JSONObject   js = new JSONObject();
         array = new JSONArray();
       try {
        java.sql.Connection con = databasebasecon();
        String query,querymax;
        if (con != null) {
           
             if(flt.equals("Capital"))
            {
            querymax = "SELECT  * FROM [HabitatLimited].[dbo].[projectcapitalincome] where projectname='"+projectname+"' AND  date='"+date+"' ;";
            Statement state = con.createStatement();
            ResultSet rrr = state.executeQuery(querymax);
            int test = 0;
            while (rrr.next()) {
                jsondata = new JSONObject();
                jsondata.append("money", rrr.getString("money"));
                jsondata.append("incomesource", rrr.getString("incomesource"));
                 array.put(jsondata);
                test = 1;              
            }
            js.put("data", array);
            }
            else if(flt.equals("Debit"))
            {
            querymax = "SELECT  * FROM [HabitatLimited].[dbo].[projectdebit] where projectname='"+projectname+"' AND  date='"+date+"' ;";
            Statement state = con.createStatement();
            ResultSet rrr = state.executeQuery(querymax);
            int test = 0;
            while (rrr.next()) {
                jsondata = new JSONObject();
                jsondata.append("money", rrr.getString("money"));
                jsondata.append("incomesource", rrr.getString("debitsource"));
                 array.put(jsondata);
                test = 1;              
            }
            js.put("data", array);
            }
            else if(flt.equals("Widthraw"))
            {
            querymax = "SELECT  * FROM [HabitatLimited].[dbo].[projectdebitwithdraw] where projectname='"+projectname+"' AND  date='"+date+"' ;";
           Statement state = con.createStatement();
            ResultSet rrr = state.executeQuery(querymax);
            int test = 0;
            while (rrr.next()) {
                jsondata = new JSONObject();
                jsondata.append("money", rrr.getString("money"));
                jsondata.append("incomesource", rrr.getString("debitsource"));
                 array.put(jsondata);
                test = 1;              
            }
            js.put("data", array);
            }
             else
                {
            querymax = "SELECT  * FROM [HabitatLimited].[dbo].[projectextraincome] where projectname='"+projectname+"' AND  date='"+date+"' ;";
           Statement state = con.createStatement();
            ResultSet rrr = state.executeQuery(querymax);
            int test = 0;
            while (rrr.next()) {
                jsondata = new JSONObject();
                jsondata.append("money", rrr.getString("money"));
                jsondata.append("incomesource", rrr.getString("incomesource"));
                 array.put(jsondata);
                test = 1;              
            }
            js.put("data", array);
            }
            
         
        } else {
            JOptionPane.showMessageDialog(null, "Not Conected");
        }

    } catch (Exception ee) {
    ee.printStackTrace();

    }
       System.out.println(js);
    return (js);
    }
        public  JSONObject getsharemateprojecteditinfocapitalbackup(String projectname,String flt ,String date) {
         JSONObject   js = new JSONObject();
         array = new JSONArray();
       try {
        java.sql.Connection con = databasebasecon();
        String query,querymax;
        if (con != null) {
           
             if(flt.equals("Capital"))
            {
            querymax = "SELECT  * FROM [HabitatLimited].[dbo].[projectcapitalincomebackup] where projectname='"+projectname+"' AND  date='"+date+"' ;";
            Statement state = con.createStatement();
            ResultSet rrr = state.executeQuery(querymax);
            int test = 0;
            while (rrr.next()) {
                jsondata = new JSONObject();
                jsondata.append("money", rrr.getString("money"));
                jsondata.append("incomesource", rrr.getString("incomesource"));
                 array.put(jsondata);
                test = 1;              
            }
            js.put("data", array);
            }
            else if(flt.equals("Debit"))
            {
            querymax = "SELECT  * FROM [HabitatLimited].[dbo].[projectdebitbackup] where projectname='"+projectname+"' AND  date='"+date+"' ;";
            Statement state = con.createStatement();
            ResultSet rrr = state.executeQuery(querymax);
            int test = 0;
            while (rrr.next()) {
                jsondata = new JSONObject();
                jsondata.append("money", rrr.getString("money"));
                jsondata.append("incomesource", rrr.getString("debitsource"));
                 array.put(jsondata);
                test = 1;              
            }
            js.put("data", array);
            }
            else if(flt.equals("Widthraw"))
            {
            querymax = "SELECT  * FROM [HabitatLimited].[dbo].[projectdebitwithdrawbackup] where projectname='"+projectname+"' AND  date='"+date+"' ;";
           Statement state = con.createStatement();
            ResultSet rrr = state.executeQuery(querymax);
            int test = 0;
            while (rrr.next()) {
                jsondata = new JSONObject();
                jsondata.append("money", rrr.getString("money"));
                jsondata.append("incomesource", rrr.getString("debitsource"));
                 array.put(jsondata);
                test = 1;              
            }
            js.put("data", array);
            }
             else
                {
            querymax = "SELECT  * FROM [HabitatLimited].[dbo].[projectextraincomebackup] where projectname='"+projectname+"' AND  date='"+date+"' ;";
            Statement state = con.createStatement();
            ResultSet rrr = state.executeQuery(querymax);
            int test = 0;
            while (rrr.next()) {
                jsondata = new JSONObject();
                jsondata.append("money", rrr.getString("money"));
                jsondata.append("incomesource", rrr.getString("incomesource"));
                 array.put(jsondata);
                test = 1;              
            }
            js.put("data", array);
            }
            
         
        } else {
            JOptionPane.showMessageDialog(null, "Not Conected");
        }

    } catch (Exception ee) {
    ee.printStackTrace();

    }
       System.out.println(js);
    return (js);
    }
      //Salary submit
public void incomeUpdate(String prn,String flt,String oldmoney,String newmoney,String oldincomesource,String newincomesource,String olddate,String newdate) throws ClassNotFoundException, SQLException {
    try {
        System.out.println(oldmoney+" "+newmoney);
          //System.out.println(newmoney);
       java.sql.Connection con = databasebasecon();
        if (con != null) {
            String query="UPDATE [HabitatLimited].[dbo].[projectincome] SET money ='"+newmoney+"' ,date='"+newdate+"',incomesource='"+newincomesource+"' WHERE money ='"+oldmoney+"' AND date='"+olddate+"'AND incomesource='"+oldincomesource+"' AND projectname='"+prn+"' AND flatname='"+flt+"';";
            PreparedStatement pst = con.prepareStatement(query);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Update SuccessFully");
        } else {
            JOptionPane.showMessageDialog(null, "Not Conected");
        }
    } catch (Exception ee) {
        System.out.println(ee.toString());
    }

}
public void setutilityUpdate(String prn,String flt,String oldmoney,String newmoney,String oldincomesource,String newincomesource,String olddate,String newdate,String oldtype,String newtype) throws ClassNotFoundException, SQLException {
    try {
        System.out.println(oldmoney+" "+newmoney);
          //System.out.println(newmoney);
       java.sql.Connection con = databasebasecon();
        if (con != null) {
            String query="UPDATE [HabitatLimited].[dbo].[setutility] SET type='"+newtype+"', money ='"+newmoney+"' ,date='"+newdate+"',incomesource='"+newincomesource+"' WHERE type='"+oldtype+"' AND  money ='"+oldmoney+"' AND date='"+olddate+"'AND incomesource='"+oldincomesource+"' AND projectname='"+prn+"' AND flatname='"+flt+"';";
            PreparedStatement pst = con.prepareStatement(query);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Update SuccessFully");
        } else {
            JOptionPane.showMessageDialog(null, "Not Conected");
        }
    } catch (Exception ee) {
        System.out.println(ee.toString());
    }

}
public void incomeutilityUpdate(String prn,String flt,String oldmoney,String newmoney,String oldincomesource,String newincomesource,String olddate,String newdate,String oldtype,String newtype) throws ClassNotFoundException, SQLException {
    try {
        System.out.println(oldmoney+" "+newmoney);
          //System.out.println(newmoney);
       java.sql.Connection con = databasebasecon();
        if (con != null) {
            String query="UPDATE [HabitatLimited].[dbo].[incomeutility] SET type='"+newtype+"', money ='"+newmoney+"' ,date='"+newdate+"',incomesource='"+newincomesource+"' WHERE type='"+oldtype+"' AND  money ='"+oldmoney+"' AND date='"+olddate+"'AND incomesource='"+oldincomesource+"' AND projectname='"+prn+"' AND flatname='"+flt+"';";
            PreparedStatement pst = con.prepareStatement(query);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Update SuccessFully");
        } else {
            JOptionPane.showMessageDialog(null, "Not Conected");
        }
    } catch (Exception ee) {
        System.out.println(ee.toString());
    }

}
public void deleteUpdate(String prn,String flt,String oldmoney,String newmoney,String oldincomesource,String newincomesource,String olddate,String newdate) throws ClassNotFoundException, SQLException {
    try {
        System.out.println(oldmoney+" "+newmoney);
          //System.out.println(newmoney);
       java.sql.Connection con = databasebasecon();
        if (con != null) {
            String query="DELETE FROM [HabitatLimited].[dbo].[projectincome]  WHERE money ='"+oldmoney+"' AND date='"+olddate+"'AND incomesource='"+oldincomesource+"' AND projectname='"+prn+"' AND flatname='"+flt+"';";
            PreparedStatement pst = con.prepareStatement(query);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Delete SuccessFully");
        } else {
            JOptionPane.showMessageDialog(null, "Not Conected");
        }
    } catch (Exception ee) {
        System.out.println(ee.toString());
    }

}
public void deleteUpdatebackup(String prn,String flt,String oldmoney,String newmoney,String oldincomesource,String newincomesource,String olddate,String newdate) throws ClassNotFoundException, SQLException {
    try {
        System.out.println(oldmoney+" "+newmoney);
          //System.out.println(newmoney);
       java.sql.Connection con = databasebasecon();
        if (con != null) {
            String query="DELETE FROM [HabitatLimited].[dbo].[projectincomebackup]  WHERE money ='"+oldmoney+"' AND date='"+olddate+"'AND incomesource='"+oldincomesource+"' AND projectname='"+prn+"' AND flatname='"+flt+"';";
            PreparedStatement pst = con.prepareStatement(query);
            pst.executeUpdate();
            query = "insert into projectincome(projectname,flatname,incomesource,money,date) VALUES(?,?,?,?,?);";
             pst = con.prepareStatement(query);
             pst.setString(1,prn);
             pst.setString(2,flt);
             pst.setString(3,newincomesource); 
             pst.setInt(4,Integer.parseInt(newmoney));
             pst.setDate(5,java.sql.Date.valueOf(newdate));
             pst.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Restored SuccessFully");
        } else {
            JOptionPane.showMessageDialog(null, "Not Conected");
        }
    } catch (Exception ee) {
        System.out.println(ee.toString());
    }

}
public void capitalUpdate(String prn,String flt,String oldmoney,String newmoney,String oldincomesource,String newincomesource,String olddate,String newdate) throws ClassNotFoundException, SQLException {
    try {
        System.out.println(oldincomesource+" "+newincomesource);
         String query; //System.out.println(newmoney);
       java.sql.Connection con = databasebasecon();
        if (con != null) {
            if(flt.equals("Capital"))
            {
               query="UPDATE [HabitatLimited].[dbo].[projectcapitalincome] SET money ='"+newmoney+"' ,date='"+newdate+"',incomesource='"+newincomesource+"' WHERE money ='"+oldmoney+"' AND date='"+olddate+"'AND incomesource='"+oldincomesource+"' AND projectname='"+prn+"';";

            }
            else if(flt.equals("Debit"))
            {
                query="UPDATE [HabitatLimited].[dbo].[projectdebit] SET money ='"+newmoney+"' ,date='"+newdate+"',debitsource='"+newincomesource+"' WHERE money ='"+oldmoney+"' AND date='"+olddate+"'AND debitsource='"+oldincomesource+"' AND projectname='"+prn+"';";

            }
            else if(flt.equals("Widthraw"))
            {
                query="UPDATE [HabitatLimited].[dbo].[projectdebitwithdraw] SET money ='"+newmoney+"' ,date='"+newdate+"',debitsource='"+newincomesource+"' WHERE money ='"+oldmoney+"' AND date='"+olddate+"'AND debitsource='"+oldincomesource+"' AND projectname='"+prn+"';";

            }
            else if(flt.equals("ExtraIncome"))
            {
                query="UPDATE [HabitatLimited].[dbo].[projectextraincome] SET money ='"+newmoney+"' ,date='"+newdate+"',incomesource='"+newincomesource+"' WHERE money ='"+oldmoney+"' AND date='"+olddate+"'AND incomesource='"+oldincomesource+"' AND projectname='"+prn+"';";

            }
            else
            {
               query="UPDATE [HabitatLimited].[dbo].[projectextradebit] SET money ='"+newmoney+"' ,date='"+newdate+"',debitsource='"+newincomesource+"' WHERE money ='"+oldmoney+"' AND date='"+olddate+"'AND debitsource='"+oldincomesource+"' ;";
  
            }
            PreparedStatement pst = con.prepareStatement(query);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Update SuccessFully");
        } else {
            JOptionPane.showMessageDialog(null, "Not Conected");
        }
    } catch (Exception ee) {
        System.out.println(ee.toString());
    }

}
public void updateflatinfo(String prn, JSONObject flatinfo) throws ClassNotFoundException, SQLException {
    try {
        
         String query; //System.out.println(newmoney);
       java.sql.Connection con = databasebasecon();
        if (con != null) {
               query="UPDATE [HabitatLimited].[dbo].[sharemate] SET flatinfo ='"+flatinfo+"'  WHERE  projectname='"+prn+"';";
           
            PreparedStatement pst = con.prepareStatement(query);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "successfully Flat Information added ");
        } else {
                    JOptionPane.showMessageDialog(null, "Not Inserted");
        }
    } catch (Exception ee) {
        System.out.println(ee.toString());
    }

}
public void Editflatinfo(String prn, JSONObject flatinfo) throws ClassNotFoundException, SQLException {
    try {
        
         String query; //System.out.println(newmoney);
       java.sql.Connection con = databasebasecon();
        if (con != null) {
               query="UPDATE [HabitatLimited].[dbo].[sharemate] SET flatinfo ='"+flatinfo+"'  WHERE  projectname='"+prn+"';";
           
            PreparedStatement pst = con.prepareStatement(query);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "successfully Flat Information Updated ");
        } else {
                    JOptionPane.showMessageDialog(null, "Not Inserted");
        }
    } catch (Exception ee) {
        System.out.println(ee.toString());
    }

}
public void deletecapitalUpdatebackup(String prn,String flt,String oldmoney,String newmoney,String oldincomesource,String newincomesource,String olddate,String newdate) throws ClassNotFoundException, SQLException {
    try {
        System.out.println(oldmoney+" "+newmoney);
         String query,query1; //System.out.println(newmoney);
       java.sql.Connection con = databasebasecon();
        if (con != null) {
            if(flt.equals("Capital"))
            {
             query1="DELETE FROM[HabitatLimited].[dbo].[projectcapitalincomebackup] WHERE money ='"+oldmoney+"' AND date='"+olddate+"'AND incomesource='"+oldincomesource+"' AND projectname='"+prn+"';";
             query = "insert into projectcapitalincome(projectname,incomesource,money,date) VALUES(?,?,?,?);";
             PreparedStatement pst1 = con.prepareStatement(query);
             pst1 = con.prepareStatement(query);
             pst1.setString(1,prn);
             pst1.setString(2,newincomesource); 
             pst1.setInt(3,Integer.parseInt(newmoney));
             pst1.setDate(4,java.sql.Date.valueOf(newdate));
             pst1.executeUpdate();
            }
            else if(flt.equals("Debit"))
            {
                query1="DELETE FROM [HabitatLimited].[dbo].[projectdebitbackup]  WHERE money ='"+oldmoney+"' AND date='"+olddate+"'AND debitsource='"+oldincomesource+"' AND projectname='"+prn+"';";
             query = "insert into projectdebit(projectname,debitsource,money,date) VALUES(?,?,?,?);";
             PreparedStatement pst1 = con.prepareStatement(query);
             pst1 = con.prepareStatement(query);
             pst1.setString(1,prn);
             pst1.setString(2,newincomesource); 
             pst1.setInt(3,Integer.parseInt(newmoney));
             pst1.setDate(4,java.sql.Date.valueOf(newdate));
             pst1.executeUpdate();
            }
            else if(flt.equals("Widthraw"))
            {
             query1="DELETE FROM [HabitatLimited].[dbo].[projectdebitwithdrawbackup]  WHERE money ='"+oldmoney+"' AND date='"+olddate+"'AND debitsource='"+oldincomesource+"' AND projectname='"+prn+"';";
             query = "insert into projectdebitwithdraw (projectname,debitsource,money,date) VALUES(?,?,?,?);";
             PreparedStatement pst1 = con.prepareStatement(query);
             pst1 = con.prepareStatement(query);
             pst1.setString(1,prn);
             pst1.setString(2,newincomesource); 
             pst1.setInt(3,Integer.parseInt(newmoney));
             pst1.setDate(4,java.sql.Date.valueOf(newdate));
             pst1.executeUpdate();
            }
            else if(flt.equals("Extradebit"))
            {
             query1="DELETE FROM [HabitatLimited].[dbo].[projectextradebitbackup]  WHERE money ='"+oldmoney+"' AND date='"+olddate+"'AND debitsource='"+oldincomesource+"';";
             query = "insert into projectextradebit(debittype,debitsource,money,date) VALUES(?,?,?,?);";
             PreparedStatement pst1 = con.prepareStatement(query);
             pst1 = con.prepareStatement(query);
             pst1.setString(1,prn);
             pst1.setString(2,newincomesource); 
             pst1.setInt(3,Integer.parseInt(newmoney));
             pst1.setDate(4,java.sql.Date.valueOf(newdate));
             pst1.executeUpdate(); 
            }
            else 
            {
             query1="DELETE FROM[HabitatLimited].[dbo].[projectextraincomebackup] WHERE money ='"+oldmoney+"' AND date='"+olddate+"'AND incomesource='"+oldincomesource+"' AND projectname='"+prn+"';";
             query = "insert into projectextraincome(projectname,incomesource,money,date) VALUES(?,?,?,?);";
             PreparedStatement pst1 = con.prepareStatement(query);
             pst1 = con.prepareStatement(query);
             pst1.setString(1,prn);
             pst1.setString(2,newincomesource); 
             pst1.setInt(3,Integer.parseInt(newmoney));
             pst1.setDate(4,java.sql.Date.valueOf(newdate));
             pst1.executeUpdate(); 
            }
            PreparedStatement pst = con.prepareStatement(query1);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Restore SuccessFully");
        } else {
            JOptionPane.showMessageDialog(null, "Not Conected");
        }
    } catch (Exception ee) {
        System.out.println(ee.toString());
    }

}
public void setutilitybackup(String prn,String flt,String oldmoney,String newmoney,String oldincomesource,String newincomesource,String olddate,String newdate,String oldtype,String newtype) throws ClassNotFoundException, SQLException {
    try {
        System.out.println(oldmoney+" "+newmoney);
         String query,query1; //System.out.println(newmoney);
       java.sql.Connection con = databasebasecon();
        if (con != null) {
             query1="DELETE FROM[HabitatLimited].[dbo].[setutilitybackup] WHERE type='"+oldtype+"' AND money ='"+oldmoney+"' AND date='"+olddate+"'AND incomesource='"+oldincomesource+"' AND projectname='"+prn+"' AND flatname='"+flt+"';";
             query = "insert into setutility(projectname,flatname,type,incomesource,money,date) VALUES(?,?,?,?,?,?);";
             PreparedStatement pst = con.prepareStatement(query);
             pst.setString(1,prn);
             pst.setString(2,flt); 
             pst.setString(3,newtype); 
             pst.setString(4,newincomesource); 
             pst.setInt(5,Integer.parseInt(newmoney));
             pst.setDate(6,currentdatereturn());
             pst.executeUpdate();
            PreparedStatement pst1 = con.prepareStatement(query1);
            pst1.executeUpdate();
            JOptionPane.showMessageDialog(null, "Restore SuccessFully");
        } else {
            JOptionPane.showMessageDialog(null, "Not Conected");
        }
    } catch (Exception ee) {
        System.out.println(ee.toString());
    }

}
public void incomeutilitybackup(String prn,String flt,String oldmoney,String newmoney,String oldincomesource,String newincomesource,String olddate,String newdate,String oldtype,String newtype) throws ClassNotFoundException, SQLException {
    try {
        System.out.println(oldmoney+" "+newmoney);
         String query,query1; //System.out.println(newmoney);
       java.sql.Connection con = databasebasecon();
        if (con != null) {
             query1="DELETE FROM[HabitatLimited].[dbo].[incomeutilitybackup] WHERE type='"+oldtype+"' AND money ='"+oldmoney+"' AND date='"+olddate+"'AND incomesource='"+oldincomesource+"' AND projectname='"+prn+"' AND flatname='"+flt+"';";
             query = "insert into incomeutility(projectname,flatname,type,incomesource,money,date) VALUES(?,?,?,?,?,?);";
             PreparedStatement pst = con.prepareStatement(query);
             pst.setString(1,prn);
             pst.setString(2,flt); 
             pst.setString(3,newtype); 
             pst.setString(4,newincomesource); 
             pst.setInt(5,Integer.parseInt(newmoney));
             pst.setDate(6,currentdatereturn());
             pst.executeUpdate();
            PreparedStatement pst1 = con.prepareStatement(query1);
            pst1.executeUpdate();
            JOptionPane.showMessageDialog(null, "Restore SuccessFully");
        } else {
            JOptionPane.showMessageDialog(null, "Not Conected");
        }
    } catch (Exception ee) {
        System.out.println(ee.toString());
    }

}
public void projectdeletebackup(String prn) throws ClassNotFoundException, SQLException {
    try {
 String[] tb = {"sharemate"};

         String query,query1,querymax; //System.out.println(newmoney);
       java.sql.Connection con = databasebasecon();
       ResultSet rrr;Statement state;
        PreparedStatement pst1,pst;
        if (con != null) {
            
            
             state = con.createStatement();
            querymax = "SELECT  * FROM [HabitatLimited].[dbo].[sharematebackup] WHERE  projectname='"+prn+"';";
            rrr = state.executeQuery(querymax);
            while (rrr.next()) {
             query = "insert into sharemate(projectname,flatnumber,sharematename,sharemateamount,flatinfo,date) VALUES(?,?,?,?,?,?);";
             pst1 = con.prepareStatement(query);
             pst1 = con.prepareStatement(query);
             pst1.setString(1,prn);
             pst1.setInt(2,rrr.getInt("flatnumber"));
             pst1.setString(3,rrr.getString("sharematename")); 
             pst1.setInt(4,rrr.getInt("sharemateamount"));
             pst1.setString(5,rrr.getString("flatinfo")); 
             pst1.setDate(6,rrr.getDate("date"));
             pst1.executeUpdate();          
            }
            query1="DELETE FROM[HabitatLimited].[dbo].[sharematebackup] WHERE  projectname='"+prn+"';";
            pst = con.prepareStatement(query1);
            pst.executeUpdate();
            
             state = con.createStatement();
            querymax = "SELECT  * FROM [HabitatLimited].[dbo].[projectincomebackup] WHERE  projectname='"+prn+"';";
            rrr = state.executeQuery(querymax);
            while (rrr.next()) {
             query = "insert into projectincome(projectname,incomesource,money,date,flatname) VALUES(?,?,?,?,?);";
             pst1 = con.prepareStatement(query);
             pst1 = con.prepareStatement(query);
             pst1.setString(1,prn);
             pst1.setString(2,rrr.getString("incomesource")); 
             pst1.setInt(3,rrr.getInt("money"));
             pst1.setDate(4,rrr.getDate("date"));
            pst1.setString(5,rrr.getString("flatname")); 
             pst1.executeUpdate();          
            }
            query1="DELETE FROM[HabitatLimited].[dbo].[projectincomebackup] WHERE  projectname='"+prn+"';";
            pst = con.prepareStatement(query1);
            pst.executeUpdate();
            
            state = con.createStatement();
            querymax = "SELECT  * FROM [HabitatLimited].[dbo].[projectextraincomebackup] WHERE  projectname='"+prn+"';";
            rrr = state.executeQuery(querymax);
            while (rrr.next()) {
             query = "insert into projectextraincome(projectname,incomesource,money,date) VALUES(?,?,?,?);";
             pst1 = con.prepareStatement(query);
             pst1 = con.prepareStatement(query);
             pst1.setString(1,prn);
             pst1.setString(2,rrr.getString("incomesource")); 
             pst1.setInt(3,rrr.getInt("money"));
             pst1.setDate(4,rrr.getDate("date"));
             pst1.executeUpdate();          
            }
            query1="DELETE FROM[HabitatLimited].[dbo].[projectextraincomebackup] WHERE  projectname='"+prn+"';";
            pst = con.prepareStatement(query1);
            pst.executeUpdate();
            
            
            state = con.createStatement();
            querymax = "SELECT  * FROM [HabitatLimited].[dbo].[projectcapitalincomebackup] WHERE  projectname='"+prn+"';";
            rrr = state.executeQuery(querymax);
            while (rrr.next()) {
             query = "insert into projectcapitalincome(projectname,incomesource,money,date) VALUES(?,?,?,?);";
             pst1 = con.prepareStatement(query);
             pst1 = con.prepareStatement(query);
             pst1.setString(1,prn);
             pst1.setString(2,rrr.getString("incomesource")); 
             pst1.setInt(3,rrr.getInt("money"));
             pst1.setDate(4,rrr.getDate("date"));
             pst1.executeUpdate();          
            }
            query1="DELETE FROM[HabitatLimited].[dbo].[projectcapitalincomebackup] WHERE  projectname='"+prn+"';";
            pst = con.prepareStatement(query1);
            pst.executeUpdate();
            
            state = con.createStatement();
            querymax = "SELECT  * FROM [HabitatLimited].[dbo].[projectdebitbackup] WHERE  projectname='"+prn+"';";
            rrr = state.executeQuery(querymax);
            while (rrr.next()) {
             query = "insert into projectdebit(projectname,debitsource,money,date) VALUES(?,?,?,?);";
             pst1 = con.prepareStatement(query);
             pst1 = con.prepareStatement(query);
             pst1.setString(1,prn);
             pst1.setString(2,rrr.getString("debitsource")); 
             pst1.setInt(3,rrr.getInt("money"));
             pst1.setDate(4,rrr.getDate("date"));
             pst1.executeUpdate();         
            }
            query1="DELETE FROM[HabitatLimited].[dbo].[projectdebitbackup] WHERE  projectname='"+prn+"';";
            pst = con.prepareStatement(query1);
            pst.executeUpdate();
            
            state = con.createStatement();
            querymax = "SELECT  * FROM [HabitatLimited].[dbo].[projectdebitwithdrawbackup] WHERE  projectname='"+prn+"';";
            rrr = state.executeQuery(querymax);
            while (rrr.next()) {
             query = "insert into projectdebitwithdraw (projectname,debitsource,money,date) VALUES(?,?,?,?);";
             pst1 = con.prepareStatement(query);
             pst1 = con.prepareStatement(query);
             pst1.setString(1,prn);
             pst1.setString(2,rrr.getString("debitsource")); 
             pst1.setInt(3,rrr.getInt("money"));
             pst1.setDate(4,rrr.getDate("date"));
             pst1.executeUpdate();         
            }
            query1="DELETE FROM[HabitatLimited].[dbo].[projectdebitwithdrawbackup] WHERE  projectname='"+prn+"';";
            pst = con.prepareStatement(query1);
            pst.executeUpdate();
            
            
            JOptionPane.showMessageDialog(null, "Restore SuccessFully");
        } else {
            JOptionPane.showMessageDialog(null, "Not Conected");
        }
    } catch (Exception ee) {
        System.out.println(ee.toString());
    }

}
public void deletecapitalUpdate(String prn,String flt,String oldmoney,String newmoney,String oldincomesource,String newincomesource,String olddate,String newdate) throws ClassNotFoundException, SQLException {
    try {
        System.out.println(oldmoney+" "+newmoney);
         String query; //System.out.println(newmoney);
       java.sql.Connection con = databasebasecon();
        if (con != null) {
            if(flt.equals("Capital"))
            {
               query="DELETE FROM[HabitatLimited].[dbo].[projectcapitalincome] WHERE money ='"+oldmoney+"' AND date='"+olddate+"'AND incomesource='"+oldincomesource+"' AND projectname='"+prn+"';";
           
            }
            else if(flt.equals("Debit"))
            {
                query="DELETE FROM [HabitatLimited].[dbo].[projectdebit]  WHERE money ='"+oldmoney+"' AND date='"+olddate+"'AND debitsource='"+oldincomesource+"' AND projectname='"+prn+"';";

            }
            else if(flt.equals("Widthraw"))
            {
                query="DELETE FROM [HabitatLimited].[dbo].[projectdebitwithdraw]  WHERE money ='"+oldmoney+"' AND date='"+olddate+"'AND debitsource='"+oldincomesource+"' AND projectname='"+prn+"';";

            }
            else if(flt.equals("Extradebit"))
            {
              query="DELETE FROM [HabitatLimited].[dbo].[projectextradebit]  WHERE money ='"+oldmoney+"' AND date='"+olddate+"'AND debitsource='"+oldincomesource+"';";  
            }
            else
            {
             query="DELETE FROM [HabitatLimited].[dbo].[projectextraincome]  WHERE money ='"+oldmoney+"' AND date='"+olddate+"'AND incomesource='"+oldincomesource+"' AND projectname='"+prn+"';";
 
            }
            PreparedStatement pst = con.prepareStatement(query);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Delete SuccessFully");
        } else {
            JOptionPane.showMessageDialog(null, "Not Conected");
        }
    } catch (Exception ee) {
        System.out.println(ee.toString());
    }

}
public void setutilitydelete(String prn,String flt,String oldmoney,String newmoney,String oldincomesource,String newincomesource,String olddate,String newdate,String oldtype,String newtype) throws ClassNotFoundException, SQLException {
    try {
        System.out.println(oldmoney+" "+newmoney);
         String query; //System.out.println(newmoney);
       java.sql.Connection con = databasebasecon();
        if (con != null) {
            query="DELETE FROM[HabitatLimited].[dbo].[setutility] WHERE type='"+oldtype+"' AND money ='"+oldmoney+"' AND date='"+olddate+"'AND incomesource='"+oldincomesource+"' AND projectname='"+prn+"' AND flatname='"+flt+"';";
            PreparedStatement pst = con.prepareStatement(query);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Delete SuccessFully");
        } else {
            JOptionPane.showMessageDialog(null, "Not Conected");
        }
    } catch (Exception ee) {
        System.out.println(ee.toString());
    }

}
public void incomeutilitydelete(String prn,String flt,String oldmoney,String newmoney,String oldincomesource,String newincomesource,String olddate,String newdate,String oldtype,String newtype) throws ClassNotFoundException, SQLException {
    try {
        System.out.println(oldmoney+" "+newmoney);
         String query; //System.out.println(newmoney);
       java.sql.Connection con = databasebasecon();
        if (con != null) {
            query="DELETE FROM[HabitatLimited].[dbo].[incomeutility] WHERE type='"+oldtype+"' AND money ='"+oldmoney+"' AND date='"+olddate+"'AND incomesource='"+oldincomesource+"' AND projectname='"+prn+"' AND flatname='"+flt+"';";
            PreparedStatement pst = con.prepareStatement(query);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Delete SuccessFully");
        } else {
            JOptionPane.showMessageDialog(null, "Not Conected");
        }
    } catch (Exception ee) {
        System.out.println(ee.toString());
    }

}

public void deleteregistration(String username,String password, String role) throws ClassNotFoundException, SQLException {
    try {
         String query; //System.out.println(newmoney);
       java.sql.Connection con = databasebasecon();
        if (con != null) {
                         query="DELETE FROM[HabitatLimited].[dbo].[registration] WHERE username ='"+username+"' AND password='"+password+"'AND role='"+role+"';";

            PreparedStatement pst = con.prepareStatement(query);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Delete SuccessFully");
        } else {
            JOptionPane.showMessageDialog(null, "Not Conected");
        }
    } catch (Exception ee) {
        System.out.println(ee.toString());
    }

}
public void projectdelete(String prn) throws ClassNotFoundException, SQLException {
    try {
        String[] tb = {"sharemate", "projectincome","projectextraincome","projectdebitwithdraw","projectdebit","projectcapitalincome"};
       java.sql.Connection con = databasebasecon();
        if (con != null) {
           for(int i=0;i<tb.length;i++)
           {
            String query="DELETE FROM[HabitatLimited].[dbo].["+tb[i]+"] WHERE  projectname='"+prn+"';";
            PreparedStatement pst = con.prepareStatement(query);
            pst.executeUpdate();   
           }
            
            JOptionPane.showMessageDialog(null, "Project Delete SuccessFully");
        } else {
            JOptionPane.showMessageDialog(null, "Not Conected");
        }
    } catch (Exception ee) {
        System.out.println(ee.toString());
    }

}
public void backup()
{
           String directoryPath = "C:\\Backup\\";

        File directory = new File(directoryPath);

        if (!directory.exists()) {
            boolean created = directory.mkdirs();

            if (created) {
                System.out.println("Directory created successfully.");
            } else {
                System.out.println("Failed to create the directory.");
            }
        } else {
            System.out.println("Directory already exists.");
        }
        
        // Generate backup file name with datetime
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");
        String dateTimeString = currentDateTime.format(formatter);
        String backupFileName = "HabitatLimited" + "_" + dateTimeString + ".bak";
        String backupFilePath = directoryPath + backupFileName;
       try {
        java.sql.Connection con = databasebasecon();
        if (con != null) {
         String backupCommand = "BACKUP DATABASE HabitatLimited TO DISK = '"+backupFilePath+"'"; 
         Statement state = con.createStatement();
          state.execute(backupCommand);
          JOptionPane.showMessageDialog(null, "Database backup created successfully "+" in (C:\\Backup\\) directory");
        } else {
            JOptionPane.showMessageDialog(null, "Not Conected");
        }

    } catch (Exception ee) {
    ee.printStackTrace();

    }
}
  public JPanel Stringcheckup(LinkedList<String> ll)
    {
        JPanel panel=new JPanel();
         panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        for(int i=0;i<ll.size();i++)
        {
            try {
            int number = Integer.parseInt(ll.get(i));
            } catch (NumberFormatException e) {
                JLabel btn=new JLabel("Flat"+(i+1)+" cost '"+ll.get(i)+"' is not a number\n");
                panel.add(btn);
            }
        }
        return panel;
    }
  public java.sql.Date currentdatereturn()
  {
     try {
            Calendar calendar = Calendar.getInstance();
            java.util.Date currentDate = calendar.getTime();
            SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
            String dateString = format.format(currentDate);
            java.util.Date utilDate = format.parse(dateString);
            sqlDate = new Date(utilDate.getTime());

        } catch (Exception e) {
            e.printStackTrace();
        }
        
     return sqlDate;     
  }
  public Image logo() throws BadElementException, IOException
  {
                Image image = Image.getInstance("E:\\pdf/building.PNG");
                image.scaleToFit(100, 60);
                image.setAbsolutePosition(100, PageSize.A4.getWidth()-image.getWidth()+300);
                return image;
  }
  public Rectangle rect()
  {
     Rectangle rectangle = new Rectangle(600,490,800,510); // (x1, y1, x2, y2)
                rectangle.setBorder(Rectangle.BOX);
                rectangle.setBorderColor(BaseColor.BLACK);
                rectangle.setBorderWidth(0);
                return rectangle;
  }
   public  java.sql.Connection databasebasecon() throws ClassNotFoundException, SQLException
   {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String url = "jdbc:sqlserver://SADDAMNVN:1433;databaseName=HabitatLimited;";
        java.sql.Connection con = DriverManager.getConnection(url,"root","root");
        return  con;
   }
   
}
