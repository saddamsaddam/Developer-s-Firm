/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Registration;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author 01957
 */
public class Allpdffunction {
    HashSet<String> result=new HashSet();
ReturnTable ReturnTable=new ReturnTable();
                                HashSet<TableClass> resultdata=new HashSet();
        String companyName="SaddamNvn Company Limited ,Tangail, Bangladesh ";

     int dif1=0,dif2=0,dif3=0,dif4=0,dif5=0;
     int sum1=0,sum2=0,sum3=0,sum4=0,sum5=0,sum6=0;
       Database connection = new  Database();
         HashSet<JMenuItem> jmenuitem=new HashSet();
        JMenu projectname,capital;
         JMenu xy,bge;
     flatpdffunction flatpdffunction;
    int creditsum=0,debitsum=0,projectincome=0,projectdebit=0;
     Paragraph paragraph;
      PdfPTable table,table1,table2;
      PdfPCell cell,cell1,cell2;
        JSONObject jsonObject = new JSONObject();

        JSONObject jsondata = new JSONObject();
        JSONArray array = new JSONArray();
         JSONArray array1 = new JSONArray();
          JSONArray array2 = new JSONArray();
           JSONArray array3 = new JSONArray();
            JSONArray array4 = new JSONArray();
             JSONArray array5= new JSONArray();
        JSONArray arrayn = new JSONArray();
                JSONArray arrayname = new JSONArray();
                        JSONArray arraymoney = new JSONArray();
                         JSONArray arrayamount = new JSONArray();
    Database Database=new Database();    
    public void allpdf() throws FileNotFoundException, DocumentException, JSONException, BadElementException, IOException
    {
        Document doc = new Document(PageSize.A4.rotate());
                OutputStream outputStream;
                outputStream = new FileOutputStream(new File(System.getProperty("user.home") + "/Downloads/"+" All"+new SimpleDateFormat("dd-MM-yyyy   hh-mm-ss a").format(new Date())+".pdf"));
                System.out.println(System.getProperty("user.home") + "/Downloads"+" All"+new SimpleDateFormat("dd-MM-yyyy   hh-mm-ss a").format(new Date())+".pdf");
                PdfWriter writer= PdfWriter.getInstance(doc, outputStream);
                doc.setMargins(5, 1,10, 20);
               
                doc.open();
                doc.add(Database.logo());
                doc.add(Database.rect());
                 MyPageEvent event = new MyPageEvent();
                 writer.setPageEvent(event);

                ColumnText columnText = new ColumnText(writer.getDirectContent());
                columnText.setSimpleColumn(Database.rect());
                columnText.addElement(new Paragraph("PrintTime: "+new SimpleDateFormat("dd/MM/yyyy hh:mm:ss a").format(new Date())));
                columnText.setAlignment(Element.ALIGN_CENTER);
                columnText.go();
                
                String header1 = "Bismillah Habitat Company Limited ,Tangail, Bangladesh ";                
                paragraph = new Paragraph(companyName, new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.HELVETICA, 11,Font.BOLD));
                paragraph.setAlignment(Element.ALIGN_CENTER);
                doc.add(paragraph);
                paragraph = new Paragraph("Project Account", new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.HELVETICA, 12));
                paragraph.setAlignment(Element.ALIGN_CENTER);
                doc.add(paragraph);
                paragraph = new Paragraph(""+new SimpleDateFormat("dd/MM/yyyy hh:mm:ss a").format(new Date())+"", new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.HELVETICA, 12));
                paragraph.setAlignment(Element.ALIGN_CENTER);
                paragraph.setSpacingAfter(20f);
                doc.add(paragraph);
                doc.add(paragraphreturn("                    All Project Information: ", "left", "bold"));
                table = new PdfPTable(2);
                table.getDefaultCell().setBorderWidth(0f);
                cell1=new PdfPCell();
                cell1.addElement(paragraphreturn("Credit:", "center","bold"));
                cell1.setBorderWidth(0);
                table.addCell(cell1);
                cell1=new PdfPCell();
                cell1.addElement(paragraphreturn("Debit:", "center","bold"));
                cell1.setBorderWidth(0);
                table.addCell(cell1);
                table.setSpacingAfter(10f);
                doc.add(table);
                
                 table1 = new PdfPTable(7);
                // table.getDefaultCell().setBorderWidth(0f);
                 cell1=new PdfPCell();
                 cell1.addElement(paragraphreturn("Project Name", "center","bold"));
                 table1.addCell(cell1);
                 
                 cell1=new PdfPCell();
                 cell1.addElement(paragraphreturn("Capital", "center","bold"));
                 cell1.disableBorderSide(8);
                 table1.addCell(cell1);
                 
                  cell1=new PdfPCell();
                 cell1.addElement(paragraphreturn("Income", "center","bold"));
                 cell1.disableBorderSide(8);
                 table1.addCell(cell1);
                 
                 cell1=new PdfPCell();
                 cell1.addElement(paragraphreturn("Others", "center","bold"));
                 cell1.disableBorderSide(8);
                 table1.addCell(cell1);
                 
                  cell1=new PdfPCell();
                 cell1.addElement(paragraphreturn("WithDraw", "center","bold"));
                 cell1.disableBorderSide(8);
                 table1.addCell(cell1);
                 
                  cell1=new PdfPCell();
                 cell1.addElement(paragraphreturn("Debit", "center","bold"));
                 //cell1.disableBorderSide(8);
                 table1.addCell(cell1);
                 
                  cell1=new PdfPCell();
                 cell1.addElement(paragraphreturn("+/-", "center","bold"));
                 //cell1.disableBorderSide(8);
                 table1.addCell(cell1);
                 doc.add(table1);
                 
                result=connection.getsharemateprojectname();
                 result.forEach(e->{
                     dif1=0;dif2=0;dif3=0;dif4=0;
                     
                     creditsum=0;debitsum=0;
                     jsonObject=  Database.singleproject(e);
                     
                    try {
                        array=new JSONArray(jsonObject.getString("projectcapitalincome"));
                        array1=new JSONArray(jsonObject.getString("projectincome"));
                        array2=new JSONArray(jsonObject.getString("projectdebitwithdraw"));
                        array3=new JSONArray(jsonObject.getString("projectdebit"));
                        array4=new JSONArray(jsonObject.getString("projectextraincome"));
                    } catch (JSONException ex) {
                        Logger.getLogger(Allpdffunction.class.getName()).log(Level.SEVERE, null, ex);
                    }
                     for(int i=0;i<array.length();i++)
                  {
                            table1 = new PdfPTable(7);
                            if(i==array.length())
                            {

                            }
                            else
                            {
                                try {
                                    //name and capital capital
                                      jsondata=new JSONObject(array.getString(i));
                                      arrayname=new JSONArray(jsondata.getString("name"));
                                      arraymoney=new JSONArray(jsondata.getString("money"));
                                     // creditsum=creditsum+Integer.parseInt(arraymoney.getString(0));
                                      cell1=new PdfPCell();
                                      cell1.addElement(new Paragraph(arrayname.getString(0)));   
                                      table1.addCell(cell1);

                                      cell1=new PdfPCell();
                                      
                                      if(arraymoney.getString(0).equals("null"))
                                      {
                                      paragraph = new Paragraph("0/=", new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.HELVETICA, 12));

                                      }
                                      else
                                      {
                                      paragraph = new Paragraph(""+arraymoney.getString(0)+""+"/=", new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.HELVETICA, 12));  
                                      sum1=sum1+Integer.parseInt(arraymoney.getString(0));
                                      dif1=Integer.parseInt(arraymoney.getString(0));
                                      }
                                      paragraph.setAlignment(Element.ALIGN_RIGHT);
                                       cell1.addElement(paragraph);
                                       table1.addCell(cell1);
                                       //income
                                      jsondata=new JSONObject(array1.getString(i));
                                      arraymoney=new JSONArray(jsondata.getString("money"));

                                      cell1=new PdfPCell();
                                      if(arraymoney.getString(0).equals("null"))
                                      {
                                      paragraph = new Paragraph(Integer.toString(Database.sumutility(e))+"/=", new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.HELVETICA, 12));
                                        sum2=sum2+Database.sumutility(e);
                                        dif2=Database.sumutility(e);
                                      }
                                      else
                                      {
                                    int ff  =Integer.parseInt(arraymoney.getString(0))+Database.sumutility(e);
                                      paragraph = new Paragraph(""+Integer.toString(ff)+""+"/=", new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.HELVETICA, 12));  
                                        sum2=sum2+Integer.parseInt(arraymoney.getString(0))+Database.sumutility(e);
                                        dif2=Integer.parseInt(arraymoney.getString(0))+Database.sumutility(e);
                                      } 
                                      paragraph.setAlignment(Element.ALIGN_RIGHT);
                                       cell1.addElement(paragraph);
                                       table1.addCell(cell1);

                                      jsondata=new JSONObject(array4.getString(i));
                                      arraymoney=new JSONArray(jsondata.getString("money"));

                                      cell1=new PdfPCell();
                                      if(arraymoney.getString(0).equals("null"))
                                      {
                                      paragraph = new Paragraph("0/=", new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.HELVETICA, 12));

                                      }
                                      else
                                      {
                                      paragraph = new Paragraph(""+arraymoney.getString(0)+""+"/=", new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.HELVETICA, 12));  
                                        sum3=sum3+Integer.parseInt(arraymoney.getString(0));
                                        dif3=Integer.parseInt(arraymoney.getString(0));
                                      } 
                                      paragraph.setAlignment(Element.ALIGN_RIGHT);
                                       cell1.addElement(paragraph);
                                       table1.addCell(cell1);
                                       
                                       jsondata=new JSONObject(array2.getString(i));
                                      arraymoney=new JSONArray(jsondata.getString("money"));

                                      cell1=new PdfPCell();
                                      if(arraymoney.getString(0).equals("null"))
                                      {
                                      paragraph = new Paragraph("0/=", new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.HELVETICA, 12));

                                      }
                                      else
                                      {
                                      paragraph = new Paragraph(""+arraymoney.getString(0)+""+"/=", new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.HELVETICA, 12));  
                                      sum4=sum4+Integer.parseInt(arraymoney.getString(0));
                                      dif4=Integer.parseInt(arraymoney.getString(0));
                                      }
                                        paragraph.setAlignment(Element.ALIGN_RIGHT);
                                       cell1.addElement(paragraph);
                                       table1.addCell(cell1);

                                      jsondata=new JSONObject(array3.getString(i));
                                      arraymoney=new JSONArray(jsondata.getString("money"));

                                      cell1=new PdfPCell();
                                      if(arraymoney.getString(0).equals("null"))
                                      {
                                      paragraph = new Paragraph("0/=", new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.HELVETICA, 12));

                                      }
                                      else
                                      {
                                      paragraph = new Paragraph(""+arraymoney.getString(0)+""+"/=", new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.HELVETICA, 12));  
                                      sum5=sum5+Integer.parseInt(arraymoney.getString(0));
                                      dif5=Integer.parseInt(arraymoney.getString(0));
                                      }
                                        paragraph.setAlignment(Element.ALIGN_RIGHT);
                                       cell1.addElement(paragraph);
                                       table1.addCell(cell1);
                                       
                                       



                                      cell1=new PdfPCell();

                                       paragraph = new Paragraph(" " +((dif1+dif2+dif3)-(dif5+dif4))+"/="  , new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.HELVETICA, 12));  
                                       sum6=sum6+((dif1+dif2+dif3)-(dif5+dif4));
                                       paragraph.setAlignment(Element.ALIGN_RIGHT);
                                       cell1.addElement(paragraph);
                                       table1.addCell(cell1);


                                } catch (JSONException ex) {
                                    Logger.getLogger(Allpdffunction.class.getName()).log(Level.SEVERE, null, ex);
                                }

                            }
                                try {
                                    doc.add(table1);
                                } catch (DocumentException ex) {
                                    Logger.getLogger(Allpdffunction.class.getName()).log(Level.SEVERE, null, ex);
                                }
                 }
                     
                
                 }); 
                    table1=new PdfPTable(7);
                    cell1=new PdfPCell();
                    cell1.addElement(new Paragraph("Total"));
                    table1.addCell(cell1);
                    
                     cell1=new PdfPCell();
                     paragraph = new Paragraph(""+sum1+""+"/=", new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.HELVETICA, 12));
                     paragraph.setAlignment(Element.ALIGN_RIGHT);
                     cell1.addElement(paragraph);
                     table1.addCell(cell1);
                    
                     cell1=new PdfPCell();
                     paragraph = new Paragraph(""+sum2+""+"/=", new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.HELVETICA, 12));
                     paragraph.setAlignment(Element.ALIGN_RIGHT);
                     cell1.addElement(paragraph);
                     table1.addCell(cell1);
                    
                     cell1=new PdfPCell();
                     paragraph = new Paragraph(""+sum3+""+"/=", new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.HELVETICA, 12));
                     paragraph.setAlignment(Element.ALIGN_RIGHT);
                     cell1.addElement(paragraph);
                     table1.addCell(cell1);
                    
                     cell1=new PdfPCell();
                     paragraph = new Paragraph(""+sum4+""+"/=", new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.HELVETICA, 12));
                     paragraph.setAlignment(Element.ALIGN_RIGHT);
                     cell1.addElement(paragraph);
                     table1.addCell(cell1);
                     //doc.add(table1);
                    
                    cell1=new PdfPCell();
                    paragraph = new Paragraph(""+sum5+""+"/=", new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.HELVETICA, 12));
                    paragraph.setAlignment(Element.ALIGN_RIGHT);
                    cell1.addElement(paragraph);
                    table1.addCell(cell1);
                   // doc.add(table1);
                    
                    cell1=new PdfPCell();
                    paragraph = new Paragraph(""+sum6+""+"/=", new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.HELVETICA, 12));
                    paragraph.setAlignment(Element.ALIGN_RIGHT);
                    cell1.addElement(paragraph);
                    table1.addCell(cell1);
                    
                    doc.add(table1);
                    
                    
                    
                paragraph = new Paragraph();
                 paragraph.setSpacingBefore(30f);
                paragraph.setSpacingAfter(30f);
                doc.add(paragraph);
       
                 int sum=(sum1+sum2)-(sum3+sum4);
                  if(sum>=0)
                 {
                   doc.add(paragraphreturn("Total Income:  "+(sum1+sum2)+"/=", "center","bold"));
                   doc.add(paragraphreturn("Total Debit:  "+ (sum3+sum4)+"/=", "center","bold"));
                   doc.add(paragraphreturn("Project Profit is:  "+sum+"/=", "center","bold"));
                 }
                 else
                 {
                   doc.add(paragraphreturn("Total Income:  "+(sum1+sum2)+"/=", "center","bold"));
                   doc.add(paragraphreturn("Total Debit:  "+ (sum3+sum4)+"/=", "center","bold"));
                 doc.add(paragraphreturn("Project Loss is:  "+sum+"/=", "center","bold"));  
                 }
                doc.add(new Paragraph(""));
                doc.add(new Paragraph(""));
                paragraph = new Paragraph("              Bank Deposit:", new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.HELVETICA, 12));
                paragraph.setAlignment(Element.ALIGN_LEFT);
                paragraph.setSpacingAfter(10f);
                doc.add(paragraph);
                
                 table = new PdfPTable(1);
                 table.addCell(ReturnTable.returntabeheader("Name", "Date", "Money",.5f,.25f,.25f));
                 result=Database.BankInfo("Bank","debitsource");
                 creditsum=0;
                 result.forEach(e->{
                 resultdata=Database.bankinfodata("Bank","debitsource",e);
                    resultdata.forEach(f->{
                    creditsum=creditsum+Integer.parseInt(f.getMoney());
                    });
                 
                 table.addCell(ReturnTable.returntabebodyandfooter(e, resultdata));
                 
                 
                });
                 projectdebit=creditsum;
                 table.addCell(ReturnTable.flattotal(creditsum));
                table.setSpacingAfter(30f);
                doc.add(table);
                
                doc.add(new Paragraph(""));
                doc.add(new Paragraph(""));
                paragraph = new Paragraph("              Others/Stationary:", new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.HELVETICA, 12));
                paragraph.setAlignment(Element.ALIGN_LEFT);
                paragraph.setSpacingAfter(10f);
                doc.add(paragraph);
                
                 table = new PdfPTable(1);
                 table.addCell(ReturnTable.returntabeheader("Name", "Date", "Money",.5f,.25f,.25f));
                 result=Database.BankInfo("projectextradebit","debitsource");
                 creditsum=0;
                 result.forEach(e->{
                 resultdata=Database.bankinfodata("projectextradebit","debitsource",e);
                    resultdata.forEach(f->{
                    creditsum=creditsum+Integer.parseInt(f.getMoney());
                    });
                 
                 table.addCell(ReturnTable.returntabebodyandfooter(e, resultdata));
                 
                 
                });
                 projectdebit=creditsum;
                 table.addCell(ReturnTable.flattotal(creditsum));
                table.setSpacingAfter(30f);
                doc.add(table);
                
                doc.add(new Paragraph(""));
                doc.add(new Paragraph(""));
                paragraph = new Paragraph("              Bank Deposit:", new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.HELVETICA, 12));
                paragraph.setAlignment(Element.ALIGN_LEFT);
                paragraph.setSpacingAfter(10f);
                doc.add(paragraph);
                
                 table = new PdfPTable(1);
                 table.addCell(ReturnTable.returntabeheader("Name", "Date", "Money",.5f,.25f,.25f));
                 result=Database.BankInfo("Bank","debitsource");
                 creditsum=0;
                 result.forEach(e->{
                 resultdata=Database.bankinfodata("Bank","debitsource",e);
                    resultdata.forEach(f->{
                    creditsum=creditsum+Integer.parseInt(f.getMoney());
                    });
                 
                 table.addCell(ReturnTable.returntabebodyandfooter(e, resultdata));
                 
                 
                });
                 projectdebit=creditsum;
                 table.addCell(ReturnTable.flattotal(creditsum));
                table.setSpacingAfter(30f);
                doc.add(table);
                  
                 doc.close();
                 JOptionPane.showMessageDialog(null, "File downloaded Successfully");

    }
    
     public Paragraph paragraphreturn(String data,String alignment,String thikness)
    {
        if(alignment.equals("top"))
        {
            if(thikness.equals("bold"))
            {
                paragraph = new Paragraph(data, new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.HELVETICA, 11,Font.BOLD));
                paragraph.setAlignment(Element.ALIGN_TOP);
            }
            else
            {
                paragraph = new Paragraph(data, new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.HELVETICA, 11));
                paragraph.setAlignment(Element.ALIGN_TOP); 
            }
            
        }
        else if(alignment.equals("center"))
        {
           if(thikness.equals("bold"))
            {
                paragraph = new Paragraph(data, new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.HELVETICA, 11,Font.BOLD));
                paragraph.setAlignment(Element.ALIGN_CENTER);
                 return paragraph; 
            }
            else
            {
                paragraph = new Paragraph(data, new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.HELVETICA, 11));
                paragraph.setAlignment(Element.ALIGN_CENTER); 
                 return paragraph; 
            }
        }
        else if(alignment.equals("right"))
        {
            if(thikness.equals("bold"))
            {
                paragraph = new Paragraph(data, new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.HELVETICA, 11,Font.BOLD));
                paragraph.setAlignment(Element.ALIGN_RIGHT);
                 return paragraph; 
            }
            else
            {
                paragraph = new Paragraph(data, new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.HELVETICA, 11));
                paragraph.setAlignment(Element.ALIGN_RIGHT);
                 return paragraph; 
            }
        }
         else if(alignment.equals("middle"))
        {
            if(thikness.equals("bold"))
            {
                paragraph = new Paragraph(data, new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.HELVETICA, 11,Font.BOLD));
                paragraph.setAlignment(Element.ALIGN_MIDDLE);
                 return paragraph; 
            }
            else
            {
                paragraph = new Paragraph(data, new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.HELVETICA, 11));
                paragraph.setAlignment(Element.ALIGN_MIDDLE);
                 return paragraph; 
            }
        }
        else
        {
             if(thikness.equals("bold"))
            {
                paragraph = new Paragraph(data, new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.HELVETICA, 11,Font.BOLD));
              return paragraph; 
            }
            else
            {
                paragraph = new Paragraph(data, new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.HELVETICA, 11));
                 return paragraph; 
              
            }
        }
       return paragraph; 
    }
    
}
