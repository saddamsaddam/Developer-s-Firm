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
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
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
import javax.swing.JOptionPane;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author 01957
 */
public class flatpdffunction {
                HashSet<String> result=new HashSet();
ReturnTable ReturnTable=new ReturnTable();
                                HashSet<TableClass> resultdata=new HashSet();

    //1 top
    //2 bottom
    //4 left
    //8 right
    Database connection = new  Database();
    int creditsum=0,debitsum=0;
    String companyName="SaddamNvn Company Limited ,Tangail, Peru ";
     Paragraph paragraph;
      PdfPTable table,table1,table2;
      PdfPCell cell,cell1,cell2;
        JSONObject jsonObject = new JSONObject();

        JSONObject jsondata = new JSONObject();
        JSONArray array = new JSONArray();
        JSONArray arrayn = new JSONArray();
                JSONArray arrayname = new JSONArray();
                        JSONArray arraymoney = new JSONArray();
                         JSONArray arrayamount = new JSONArray();
                         JSONArray arraydate = new JSONArray();
    Database Database=new Database();
    public String projectname,flatname;
    public flatpdffunction(String pn,String fn) throws FileNotFoundException, DocumentException, JSONException, BadElementException, IOException
    {
        super();
        this.projectname=pn;
        this.flatname=fn;
        System.out.print(pn+"\n");
        datacalculation(this.projectname,this.flatname);
    }
    public void datacalculation(String pn,String fn) throws FileNotFoundException, DocumentException, JSONException, BadElementException, IOException
     {
                  jsonObject= Database.getflatdebitcredit(pn,fn);
                  
                  
                
      
                Document doc = new Document(PageSize.A4.rotate());
                OutputStream outputStream;
                outputStream = new FileOutputStream(new File(System.getProperty("user.home") + "/Downloads/" + pn+ "(" + fn + ")   ("+new SimpleDateFormat("dd-MM-yyyy hh-mm-ss a").format(new Date()).toString()+").pdf"));
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
                paragraph = new Paragraph("Income Expenditure Account", new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.HELVETICA, 12));
                paragraph.setAlignment(Element.ALIGN_CENTER);
                doc.add(paragraph);
                paragraph = new Paragraph(""+new SimpleDateFormat("dd/MM/yyyy hh:mm:ss a").format(new Date())+"", new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.HELVETICA, 12));
                paragraph.setAlignment(Element.ALIGN_CENTER);
                paragraph.setSpacingAfter(20f);
                doc.add(paragraph);
                paragraph = new Paragraph("                   Project Name: "+pn+"       "+"Flat name: "+fn, new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.HELVETICA, 12));
                paragraph.setAlignment(Element.ALIGN_LEFT);
                paragraph.setSpacingAfter(10f);
                doc.add(paragraph);
                //
                
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
                result=Database.itemnamereturntopdf(pn,fn,"projectincome","incomesource");
                result.forEach(e->{
                resultdata=Database.itemdetailsreturn(pn, fn, "projectincome", "incomesource",e);
                   resultdata.forEach(f->{
                   creditsum=creditsum+Integer.parseInt(f.getMoney());
                    });
                table1.addCell(ReturnTable.returntabebodyandfooter(e, resultdata));
                });
                
                result=Database.itemnamereturntopdf(pn,fn,"incomeutility","incomesource");
                result.forEach(e->{
                resultdata=Database.itemdetailsreturn(pn, fn, "incomeutility", "incomesource",e);
                    resultdata.forEach(f->{
                    creditsum=creditsum+Integer.parseInt(f.getMoney());
                    });
                table1.addCell(ReturnTable.returntabebodyandfooter(e, resultdata));
                });
                
                table2.addCell(ReturnTable.returntabeheader("Selling Price", "Utility Bill", "Other",.33f,.33f,.33f));
                Database.sellingpriceAutilityAother(pn,fn);
                //doc.add(ReturnTable.returntabeheader("Name", "Date", "Money"));
                resultdata=Database.sellingpriceAutilityAother(pn,fn);
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
                 
                 
                 int sum=creditsum-Database.sellingpriceAutilityAothersum(projectname,flatname);
                 if(sum>=0)
                 {
                   doc.add(paragraphreturn("Profit is:  "+sum+"/=", "center","bold"));
                 }
                 else
                 {
                 doc.add(paragraphreturn("Due is:  "+sum+"/=", "center","bold"));  
                 }
                 
                 doc.add(paragraphreturn(" ", "center","bold"));  
                 doc.add(paragraphreturn("             Utility", "left","bold"));  
                 doc.add(paragraphreturn("     ", "center","bold"));  
                 table = new PdfPTable(1);
                 table.addCell(ReturnTable.returntabeheader("Name", "Date", "Money",.5f,.25f,.25f));
                 result=Database.itemnamereturntopdf(pn,fn,"setutility","incomesource","Utility");
                 creditsum=0;
                 result.forEach(e->{
                 resultdata=Database.itemdetailsreturn(pn, fn, "setutility", "incomesource",e,"Utility");
                    resultdata.forEach(f->{
                    creditsum=creditsum+Integer.parseInt(f.getMoney());
                    });
                 
                 table.addCell(ReturnTable.returntabebodyandfooter(e, resultdata));
                 
                 
                });
                 table1 = new PdfPTable(2);
                 float[] columnWidths = {.75f,.25f};
                 table1.setWidths(columnWidths);
                 cell1=new PdfPCell();
                 cell1.addElement(paragraphreturn("Total", "left","bold"));
                 cell1.disableBorderSide(8);
                 table1.addCell(cell1);
                 
                 
                 cell1=new PdfPCell();
                 cell1.addElement(paragraphreturn(Integer.toString(creditsum)+"/=", "right","bold"));
                 table1.addCell(cell1);
                 table.addCell(table1);
                 
                table.setSpacingAfter(30f);
                doc.add(table);
                 
                 
                  
                 doc.add(paragraphreturn(" ", "center","bold"));  
                 doc.add(paragraphreturn("             Other", "left","bold"));  
                 doc.add(paragraphreturn("     ", "center","bold"));  

                 table = new PdfPTable(1);
                 table.addCell(ReturnTable.returntabeheader("Name", "Date", "Money",.5f,.25f,.25f));
                 result=Database.itemnamereturntopdf(pn,fn,"setutility","incomesource","Other");
                 creditsum=0;
                 result.forEach(e->{
                 resultdata=Database.itemdetailsreturn(pn, fn, "setutility", "incomesource",e,"Other");
                    resultdata.forEach(f->{
                    creditsum=creditsum+Integer.parseInt(f.getMoney());
                    });
                 
                 table.addCell(ReturnTable.returntabebodyandfooter(e, resultdata));
                 
                 
                });
                 table1 = new PdfPTable(2);
                 table1.setWidths(columnWidths);
                 cell1=new PdfPCell();
                 cell1.disableBorderSide(8);

                 cell1.addElement(paragraphreturn("Total", "left","bold"));
                 table1.addCell(cell1);
                 
                 
                 cell1=new PdfPCell();
                 cell1.addElement(paragraphreturn(Integer.toString(creditsum)+"/=", "right","bold"));
                 table1.addCell(cell1);
                 table.addCell(table1);
                 
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
