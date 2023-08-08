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
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author 01957
 */
public class projectpdffunction {
   //1 top
    //2 bottom
    //4 left
    //8 right
           Database connection = new  Database();
 HashSet<String> result=new HashSet();
ReturnTable ReturnTable=new ReturnTable();
                                HashSet<TableClass> resultdata=new HashSet();
        String companyName="SaddamNvn Company Limited ,Tangail, Bangladesh ";
         JSONObject json=null ;
 int dif1=0,dif2=0,dif3=0,dif4=0,dif5=0;
     int sum1=0,sum2=0,sum3=0,sum4=0,sum5=0,sum6=0,utilitybill=0,othersbill=0,sellingbill=0;
    flatpdffunction flatpdffunction;
    int creditsum=0,debitsum2=0,debitsum=0,projectincome=0,projectdebit=0,projectcapital=0, projectwithdraw=0,finaloutput=0;
     Paragraph paragraph;
      PdfPTable table,table1,table2;
      PdfPCell cell,cell1,cell2;
        JSONObject jsonObject = new JSONObject();
         JSONObject jsonObject1 = new JSONObject();
          JSONObject exjsonObject = new JSONObject();

        JSONObject jsondata = new JSONObject();
         JSONObject exjsondata = new JSONObject();
        JSONArray array = new JSONArray();
        JSONArray exarray = new JSONArray();
        JSONArray arrayn = new JSONArray();
                JSONArray arrayname = new JSONArray();
                 JSONArray exarrayname = new JSONArray();
                        JSONArray arraymoney = new JSONArray();
                         JSONArray arrayamount = new JSONArray();
                           JSONArray arraydate = new JSONArray();
                            JSONArray exarraymoney = new JSONArray();
                         JSONArray exarrayamount = new JSONArray();
                           JSONArray exarraydate = new JSONArray();
         JSONArray array1 = new JSONArray();
          JSONArray array2 = new JSONArray();
           JSONArray array3 = new JSONArray();
            JSONArray array4 = new JSONArray();
             JSONArray array5= new JSONArray();
             JSONArray percentage= new JSONArray();

             Database database=new Database();
     Database  Database=new Database();
    
    public String projectname,flatname;
    public projectpdffunction (String pn) throws FileNotFoundException, DocumentException, JSONException, BadElementException, IOException
    {
        super();
        this.projectname=pn;
        projectdatacalculation(this.projectname);
    }
    public void  projectdatacalculation(String pn) throws FileNotFoundException, DocumentException, JSONException, BadElementException, IOException
    {
                json=database.getsharemateprojectflatinfo(pn);
                Document doc = new Document(PageSize.A4.rotate());
                OutputStream outputStream;
                outputStream = new FileOutputStream(new File( System.getProperty("user.home") + "/Downloads/" + pn+ " ("+new SimpleDateFormat("dd-MM-yyyy hh-mm-ss a").format(new Date())+").pdf"));
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
                doc.add(paragraphreturn("            Project Name: "+pn, "left", "bold"));
                
               Iterator<String> keys = json.keys();
               while(keys.hasNext())
             {
                creditsum=0;debitsum=0;
                String data=keys.next();
                System.out.print(data+"  vol"+"\n");
                jsondata.append("money", json.getString(data));
                creditsum=0;debitsum=0;
                jsonObject= database.getflatdebitcredit(pn,data);
                 paragraph = new Paragraph("              Flat name: "+(data), new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.HELVETICA, 12));
                paragraph.setAlignment(Element.ALIGN_LEFT);
                paragraph.setSpacingAfter(10f);
                doc.add(paragraph);
                
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
                
                
                 table=new PdfPTable(2);
                table1=new PdfPTable(1);
                table2=new PdfPTable(1);
                table1.getDefaultCell().setBorderWidth(0);
                table1.setTableEvent(null);
                table2.getDefaultCell().setBorderWidth(0);
                table2.setTableEvent(null);
               
                table1.addCell(ReturnTable.returntabeheader("Name", "Date", "Money",.5f,.25f,.25f));
                result=Database.itemnamereturntopdf(pn,data,"projectincome","incomesource");
                result.forEach(e->{
                resultdata=Database.itemdetailsreturn(pn, data, "projectincome", "incomesource",e);
                   resultdata.forEach(f->{
                   creditsum=creditsum+Integer.parseInt(f.getMoney());
                    });
                table1.addCell(ReturnTable.returntabebodyandfooter(e, resultdata));
                });
                
                result=Database.itemnamereturntopdf(pn,data,"incomeutility","incomesource");
                result.forEach(e->{
                resultdata=Database.itemdetailsreturn(pn, data, "incomeutility", "incomesource",e);
                    resultdata.forEach(f->{
                    creditsum=creditsum+Integer.parseInt(f.getMoney());
                    });
                table1.addCell(ReturnTable.returntabebodyandfooter(e, resultdata));
                });
                table1.addCell(ReturnTable.flattotal(creditsum));
                
                table2.addCell(ReturnTable.returntabeheader("Selling Price", "Utility Bill", "Other",.33f,.33f,.33f));
                Database.sellingpriceAutilityAother(pn,data);
                //doc.add(ReturnTable.returntabeheader("Name", "Date", "Money"));
                resultdata=Database.sellingpriceAutilityAother(pn,data);
                resultdata.forEach(e->{
                      try {
                       table2.addCell(ReturnTable.returntableutilityothersselling(e.getSellingprice(),e.getUtilitybill(),e.getOthers()));
                      } catch (DocumentException ex) {
                          Logger.getLogger(flatpdffunction.class.getName()).log(Level.SEVERE, null, ex);
                      }
         
                });
               
                table.addCell(table1);
                table.addCell(table2);
                table.setSpacingAfter(30f);
                 doc.add(table);
                 
                 projectincome=projectincome+creditsum;
                 int sum=creditsum-Database.sellingpriceAutilityAothersum(pn,data);
                 if(sum>=0)
                 {
                   doc.add(paragraphreturn("Profit is:  "+sum+"/=", "center","bold"));
                 }
                 else
                 {
                 doc.add(paragraphreturn("Due is:  "+sum+"/=", "center","bold"));  
                 }
                 
                 
                 
                  
                  
                }
                paragraph = new Paragraph("              Others Income:", new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.HELVETICA, 12));
                paragraph.setAlignment(Element.ALIGN_LEFT);
                paragraph.setSpacingAfter(10f);
                doc.add(paragraph);
                
                 table = new PdfPTable(1);
                 table.addCell(ReturnTable.returntabeheader("Name", "Date", "Money",.5f,.25f,.25f));
                 result=Database.itemnamereturntopdf(pn,"projectextraincome","incomesource");
                 creditsum=0;
                 result.forEach(e->{
                 resultdata=Database.itemdetailsreturnothers(pn,"projectextraincome","incomesource",e);
                    resultdata.forEach(f->{
                    creditsum=creditsum+Integer.parseInt(f.getMoney());
                    });
                 
                 table.addCell(ReturnTable.returntabebodyandfooter(e, resultdata));
                 
                 
                });
                 int  othersincome=creditsum;
                 table.addCell(ReturnTable.flattotal(creditsum));
                 
                table.setSpacingAfter(30f);
                doc.add(table);
                
                
                paragraph = new Paragraph("              Project Debit:", new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.HELVETICA, 12));
                paragraph.setAlignment(Element.ALIGN_LEFT);
                paragraph.setSpacingAfter(10f);
                doc.add(paragraph);
                
                 table = new PdfPTable(1);
                 table.addCell(ReturnTable.returntabeheader("Name", "Date", "Money",.5f,.25f,.25f));
                 result=Database.itemnamereturntopdf(pn,"projectdebit","debitsource");
                 creditsum=0;
                 result.forEach(e->{
                 resultdata=Database.itemdetailsreturnothers(pn,"projectdebit","debitsource",e);
                    resultdata.forEach(f->{
                    creditsum=creditsum+Integer.parseInt(f.getMoney());
                    });
                 
                 table.addCell(ReturnTable.returntabebodyandfooter(e, resultdata));
                 
                 
                });
                 projectdebit=creditsum;
                 table.addCell(ReturnTable.flattotal(creditsum));
                 
                table.setSpacingAfter(30f);
                doc.add(table);
                
                
                paragraph = new Paragraph("              Project Widthraw:", new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.HELVETICA, 12));
                paragraph.setAlignment(Element.ALIGN_LEFT);
                paragraph.setSpacingAfter(10f);
                doc.add(paragraph);
                
                 table = new PdfPTable(1);
                 table.addCell(ReturnTable.returntabeheader("Name", "Date", "Money",.5f,.25f,.25f));
                 result=Database.itemnamereturntopdf(pn,"projectdebitwithdraw","debitsource");
                 creditsum=0;
                 result.forEach(e->{
                 resultdata=Database.itemdetailsreturnothers(pn,"projectdebitwithdraw","debitsource",e);
                    resultdata.forEach(f->{
                    creditsum=creditsum+Integer.parseInt(f.getMoney());
                    });
                 
                 table.addCell(ReturnTable.returntabebodyandfooter(e, resultdata));
                 
                 
                });
                 int widthraw=creditsum;
                table.addCell(ReturnTable.flattotal(creditsum));
                 
                table.setSpacingAfter(30f);
                doc.add(table);
                
                paragraph = new Paragraph("              Project Capital:", new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.HELVETICA, 12));
                paragraph.setAlignment(Element.ALIGN_LEFT);
                paragraph.setSpacingAfter(10f);
                doc.add(paragraph);
                
                 table = new PdfPTable(1);
                 table.addCell(ReturnTable.returntabeheader("Name", "Date", "Money",.5f,.25f,.25f));
                 result=Database.itemnamereturntopdf(pn,"projectcapitalincome","incomesource");
                 creditsum=0;
                 result.forEach(e->{
                 resultdata=Database.itemdetailsreturnothers(pn,"projectcapitalincome","incomesource",e);
                    resultdata.forEach(f->{
                    creditsum=creditsum+Integer.parseInt(f.getMoney());
                    });
                 
                 table.addCell(ReturnTable.returntabebodyandfooter(e, resultdata));
                 
                 
                });
                table.addCell(ReturnTable.flattotal(creditsum));
                 int capital=creditsum;
                table.setSpacingAfter(30f);
                doc.add(table);
                
 
                paragraph = new Paragraph();
                paragraph.setAlignment(Element.ALIGN_CENTER);
                paragraph.setSpacingAfter(30f);
                  paragraph.setSpacingBefore(30f);
                doc.add(paragraph);
                
                
                
                int  sum=(projectincome+othersincome)-projectdebit;
                  if(sum>=0)
                 {
                   doc.add(paragraphreturn("All Flat Income:  "+projectincome+"/=", "center","bold"));
                   doc.add(paragraphreturn("Others Income:  "+othersincome+"/=", "center","bold"));
                   doc.add(paragraphreturn("All Flat Selling Price:  "+ sellingbill+"/=", "center","bold"));
                   doc.add(paragraphreturn("All Flat Utility Bill:  "+ utilitybill+"/=", "center","bold"));
                   doc.add(paragraphreturn("All Flat Other Price:  "+ othersbill+"/=", "center","bold"));
                   doc.add(paragraphreturn("Profit is:  "+sum+"/=", "center","bold"));
                 }
                 else
                 {
                   doc.add(paragraphreturn("All Flat Income:  "+projectincome+"/=", "center","bold"));
                  doc.add(paragraphreturn("Others Income:  "+othersincome+"/=", "center","bold"));
                   doc.add(paragraphreturn("All Flat Selling Price:  "+sellingbill+"/=", "center","bold"));
                   doc.add(paragraphreturn("All Flat Utility Bill:  "+ utilitybill+"/=", "center","bold"));
                   doc.add(paragraphreturn("All Flat Other Price:  "+ othersbill+"/=", "center","bold"));
                 doc.add(paragraphreturn("Due is:  "+sum+"/=", "center","bold"));  
                 }
                 
                paragraph = new Paragraph();
                paragraph.setSpacingBefore(30f);
                paragraph.setSpacingAfter(30f);
                doc.add(paragraph);
                
                 doc.add(paragraphreturn("                    Project Information: ", "left", "bold"));
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
                 table1 = new PdfPTable(7);
                 
                 cell1=new PdfPCell();
                 cell1.addElement(new Paragraph(pn));   
                 table1.addCell(cell1);
                 
                 cell1=new PdfPCell();
                 
                cell1.addElement(paragraphreturn(Integer.toString(capital)+"/=", "right","bold"));

                 table1.addCell(cell1);
                 
                 cell1=new PdfPCell();
               
                    cell1.addElement(paragraphreturn(Integer.toString(projectincome)+"/=", "right","bold"));

                 table1.addCell(cell1);
                 
                 cell1=new PdfPCell();
              
                    cell1.addElement(paragraphreturn(Integer.toString(othersincome)+"/=", "right","bold"));
                 table1.addCell(cell1);
                 
                 cell1=new PdfPCell();
                
                    cell1.addElement(paragraphreturn(Integer.toString(widthraw)+"/=", "right","bold"));
                    table1.addCell(cell1);
                 
                 cell1=new PdfPCell();
             
                 cell1.addElement(paragraphreturn(Integer.toString(projectdebit)+"/=", "right","bold"));
                 table1.addCell(cell1);
                 
                 cell1=new PdfPCell();
                 cell1.addElement(paragraphreturn(Integer.toString((othersincome+projectincome+capital)-(widthraw+projectdebit))+"/=", "right","bold"));
                 table1.addCell(cell1);
                 doc.add(table1);
                 
                      
                     paragraph = new Paragraph();
                     paragraph.setSpacingBefore(30f);
                      paragraph.setSpacingAfter(30f);
                      doc.add(paragraph); 
                      
                      paragraph = new Paragraph("                           Sharemate Information:");
                      paragraph.setSpacingAfter(30f);
                      doc.add(paragraph);  
                  table1 = new PdfPTable(7);
                // table.getDefaultCell().setBorderWidth(0f);
                 cell1=new PdfPCell();
                 cell1.addElement(paragraphreturn("Sharemate Name", "center","bold"));
                 table1.addCell(cell1);
                 
                 cell1=new PdfPCell();
                 cell1.addElement(paragraphreturn("Deposit Money", "center","bold"));
                 cell1.disableBorderSide(8);
                 table1.addCell(cell1);
                 
                 cell1=new PdfPCell();
                 cell1.addElement(paragraphreturn("Withdraw Money", "center","bold"));
                 cell1.disableBorderSide(8);
                 table1.addCell(cell1);
                 
                  cell1=new PdfPCell();
                 cell1.addElement(paragraphreturn("Share Percentage(%) ", "center","bold"));
                 cell1.disableBorderSide(8);
                 table1.addCell(cell1);
                 
                 cell1=new PdfPCell();
                 cell1.addElement(paragraphreturn("Net Deposit ", "center","bold"));
                 cell1.disableBorderSide(8);
                 table1.addCell(cell1);
                 
                  cell1=new PdfPCell();
                 cell1.addElement(paragraphreturn("Earned Percentage(%)", "center","bold"));
                 //cell1.disableBorderSide(8);
                 table1.addCell(cell1);
                  cell1=new PdfPCell();
                 cell1.addElement(paragraphreturn("Profit/Loss", "center","bold"));
                 //cell1.disableBorderSide(8);
                 table1.addCell(cell1);
                 
                  
                 doc.add(table1);
                 
                 
                 
                jsonObject=connection.sharematepdfdata(pn);
                array=new JSONArray(jsonObject.getString("sharematedata"));
                int totalsum=0;
                for(int j=0;j<array.length();j++)
                {
                    jsondata=new JSONObject(array.getString(j));
                    arrayname=new JSONArray(jsondata.getString("name"));//
                   int  depositsum;
                   String summ=(connection.deposit(pn,arrayname.getString(0)));//
                    if(summ==null)
                    {
                       depositsum=0; 
                    }
                    else
                    {
                       depositsum=Integer.parseInt(summ);
                    }
                    int  withdrawtsum;
                    summ=(connection.withdraw(pn,arrayname.getString(0)));//
                    if(summ==null)
                    {
                       withdrawtsum=0; 
                    }
                    else
                    {
                       withdrawtsum=Integer.parseInt(summ);
                    }
                    int finalsum=depositsum-withdrawtsum;//
                    totalsum=totalsum+finalsum;
                    
                }
                for(int j=0;j<array.length();j++)
                {
                    table1 = new PdfPTable(7);
                    jsondata=new JSONObject(array.getString(j));
                    arrayname=new JSONArray(jsondata.getString("name"));//
                    percentage=new JSONArray(jsondata.getString("percentage"));//
                    int  depositsum;
                    String summ=(connection.deposit(pn,arrayname.getString(0)));//
                    if(summ==null)
                    {
                       depositsum=0; 
                    }
                    else
                    {
                       depositsum=Integer.parseInt(summ);
                    }
                    int  withdrawtsum; summ=(connection.withdraw(pn,arrayname.getString(0)));//
                    if(summ==null)
                    {
                       withdrawtsum=0; 
                    }
                    else
                    {
                       withdrawtsum=Integer.parseInt(summ);
                    }
                    int finalsum=depositsum-withdrawtsum;//
                    double earnpercentage=100*((double)finalsum/(double)totalsum);//
                    //name
                    cell1=new PdfPCell();
                    cell1.addElement(new Paragraph(arrayname.getString(0)));   
                    table1.addCell(cell1);
                     //Deposit
                    cell1=new PdfPCell();
                    cell1.addElement(new Paragraph(Integer.toString(depositsum)));   
                    table1.addCell(cell1);
                    
                     //withdraw
                    cell1=new PdfPCell();
                    cell1.addElement(new Paragraph(Integer.toString(withdrawtsum)));   
                    table1.addCell(cell1);
                    //sharepercentage
                    cell1=new PdfPCell();
                    cell1.addElement(new Paragraph(percentage.getString(0)));   
                    table1.addCell(cell1);
                     //net
                    cell1=new PdfPCell();
                    cell1.addElement(new Paragraph(Integer.toString(finalsum)));   
                    table1.addCell(cell1);
                    
                     //earn
                    cell1=new PdfPCell();
                    cell1.addElement(new Paragraph(Double.toString(earnpercentage)));   
                    table1.addCell(cell1);
                    
                    //lost or profit
                    cell1=new PdfPCell();
                    cell1.addElement(new Paragraph(Double.toString( (earnpercentage*(double)((othersincome+projectincome+capital)-(widthraw+projectdebit)))/(double)100 )));   
                    table1.addCell(cell1);
                    
                    doc.add(table1);
                }
                         
                    
                paragraph = new Paragraph();
                 paragraph.setSpacingBefore(30f);
                paragraph.setSpacingAfter(30f);
                doc.add(paragraph);
        
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
