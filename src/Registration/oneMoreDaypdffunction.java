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
import javax.swing.JOptionPane;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author 01957
 */
public class oneMoreDaypdffunction {
    //1 top
    //2 bottom
    //4 left
    //8 right
    int creditsum=0,debitsum=0;
    String companyName="SaddamNvn Company Limited ,Tangail, Bangladesh ";
     Paragraph paragraph;
      PdfPTable table,table1,table2;
      PdfPCell cell,cell1,cell2;
        JSONObject jsonObject = new JSONObject();
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
                             JSONArray arrayincometype = new JSONArray();
                         JSONArray exarrayamount = new JSONArray();
                           JSONArray exarraydate = new JSONArray(); 
                           JSONArray exprojectname = new JSONArray(); 
    Database Database=new Database();
    public String projectname,flatname;
    public oneMoreDaypdffunction(String pn,String enddate) throws FileNotFoundException, DocumentException, JSONException, BadElementException, IOException
    {
        super();
        datacalculation(pn,enddate);
    }
    public void datacalculation(String pn,String enddate) throws FileNotFoundException, DocumentException, JSONException, BadElementException, IOException
     {
                  jsonObject= Database.projectcapital(pn,enddate);
                  
                  
                
      
                Document doc = new Document(PageSize.A4.rotate());
                OutputStream outputStream;
                outputStream = new FileOutputStream(new File( System.getProperty("user.home") + "/Downloads/"+ pn+ " (Start To "+enddate+").pdf"));
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
                paragraph = new Paragraph("(Start To"+enddate+")", new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.HELVETICA, 12));
                paragraph.setAlignment(Element.ALIGN_CENTER);
                paragraph.setSpacingAfter(20f);
                doc.add(paragraph);
                paragraph = new Paragraph("                   Project Name: "+pn+"       ", new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.HELVETICA, 12));
                paragraph.setAlignment(Element.ALIGN_LEFT);
                paragraph.setSpacingAfter(10f);
                doc.add(paragraph);
                //
                
                table = new PdfPTable(2);
                int[] columnWidth= new int[]{60, 40};
                table.setWidths(columnWidth);
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
                table = new PdfPTable(2);
                table.setWidths(columnWidth);
                // table.getDefaultCell().setBorderWidth(0f);
                 table1 = new PdfPTable(4);
                 cell1=new PdfPCell();
                 cell1.addElement(paragraphreturn("Description", "center","bold"));
                 table1.addCell(cell1);
                 cell1=new PdfPCell();
                 cell1.addElement(paragraphreturn("Reciever", "center","bold"));
                 table1.addCell(cell1);
                 
                 cell1=new PdfPCell();
                 cell1.addElement(paragraphreturn("Date", "center","bold"));
                 cell1.disableBorderSide(8);
                 table1.addCell(cell1);
                 
                 cell1=new PdfPCell();
                 cell1.addElement(paragraphreturn("Money", "center","bold"));
                 cell1.disableBorderSide(8);
                 table1.addCell(cell1);
                 
                   array=new JSONArray(jsonObject.getString("credit"));
                  for(int i=0;i<=array.length();i++)
                 {
                     if(i==array.length())
                     {
                       exjsonObject= Database.extracredit(pn,enddate);
                             exarray=new JSONArray(exjsonObject.getString("data"));
                          for(int j=0;j<=exarray.length();j++)
                          {
                              if(j==exarray.length())
                              {
                                cell1=new PdfPCell();
                                cell1.addElement(new Paragraph("Total"));
                                table1.addCell(cell1);

                                cell1=new PdfPCell();
                                cell1.addElement(new Paragraph());
                                table1.addCell(cell1);
                                
                                 cell1=new PdfPCell();
                                cell1.addElement(new Paragraph());
                                table1.addCell(cell1);

                                 cell1=new PdfPCell();
                                 paragraph = new Paragraph(""+creditsum+""+"/=", new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.HELVETICA, 12));
                                 paragraph.setAlignment(Element.ALIGN_RIGHT);
                                cell1.addElement(paragraph);
                                cell1.disableBorderSide(8);
                                table1.addCell(cell1);  
                              }
                              else
                              {
                                exjsondata=new JSONObject(exarray.getString(j));
                                 exprojectname=new JSONArray(exjsondata.getString("projectname"));
                                exarrayname=new JSONArray(exjsondata.getString("name"));
                               // System.out.print(arrayname.getString(0)+"\n");
                                exarraymoney=new JSONArray(exjsondata.getString("money"));
                                 exarraydate=new JSONArray(exjsondata.getString("date"));
                                //System.out.print(arraymoney.getString(0)+"\n");
                                creditsum=creditsum+Integer.parseInt(exarraymoney.getString(0));
                               
                               cell1=new PdfPCell();
                               cell1.addElement(new Paragraph(exprojectname.getString(0)+"(Others)"));
                               table1.addCell(cell1);
                               
                               cell1=new PdfPCell();
                               cell1.addElement(new Paragraph(exarrayname.getString(0)));
                               table1.addCell(cell1);

                               cell1=new PdfPCell();
                               cell1.addElement(new Paragraph(exarraydate.getString(0)));
                               table1.addCell(cell1);

                                cell1=new PdfPCell();
                                paragraph = new Paragraph(""+exarraymoney.getString(0)+""+"/=", new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.HELVETICA, 12));
                                paragraph.setAlignment(Element.ALIGN_RIGHT);
                               cell1.addElement(paragraph);
                               //cell1.disableBorderSide(8);
                               table1.addCell(cell1);   
                              }
                               
                          } 
                     }
                     else
                     {
                     jsondata=new JSONObject(array.getString(i));
                     arrayname=new JSONArray(jsondata.getString("name"));
                     arrayincometype=new JSONArray(jsondata.getString("incometype"));
                    // System.out.print(arrayname.getString(0)+"\n");arrayincometype
                     arraymoney=new JSONArray(jsondata.getString("money"));
                       arraydate=new JSONArray(jsondata.getString("date"));
                     //System.out.print(arraymoney.getString(0)+"\n");
                     creditsum=creditsum+Integer.parseInt(arraymoney.getString(0));
                     
                     cell1=new PdfPCell();
                    cell1.addElement(new Paragraph(arrayincometype.getString(0)));
                    table1.addCell(cell1);
                     
                    cell1=new PdfPCell();
                    cell1.addElement(new Paragraph(arrayname.getString(0)));
                    table1.addCell(cell1);
                    
                     cell1=new PdfPCell();
                    cell1.addElement(new Paragraph(arraydate.getString(0)));
                    table1.addCell(cell1);
                    
                     cell1=new PdfPCell();
                     paragraph = new Paragraph(""+arraymoney.getString(0)+""+"/=", new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.HELVETICA, 12));
                     paragraph.setAlignment(Element.ALIGN_RIGHT);
                    cell1.addElement(paragraph);
                    cell1.disableBorderSide(8);
                    table1.addCell(cell1);
                     }
                 }
                  table.addCell(table1);
                //table1 end
                 table2 = new PdfPTable(3);
                 cell1=new PdfPCell();
                 cell1.addElement(paragraphreturn("Description", "center","bold"));
                 table2.addCell(cell1);

                 
                 cell1=new PdfPCell();
                 cell1.addElement(paragraphreturn("Date", "center","bold"));
                 cell1.disableBorderSide(8);
                 table2.addCell(cell1);
                 
                 cell1=new PdfPCell();
                 cell1.addElement(paragraphreturn("Money", "center","bold"));
                 cell1.disableBorderSide(8);
                 table2.addCell(cell1);
                 
                 array=new JSONArray(jsonObject.getString("debit"));
                  for(int i=0;i<=array.length();i++)
                 {
                    if(i==array.length())
                    {
                       cell1=new PdfPCell();
                    cell1.addElement(new Paragraph("Total"));
                    table2.addCell(cell1);
      
                    
                     cell1=new PdfPCell();
                    cell1.addElement(new Paragraph());
                    table2.addCell(cell1);
                    
                    cell1=new PdfPCell();
                     paragraph = new Paragraph(""+ debitsum+""+"/=", new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.HELVETICA, 12));
                     paragraph.setAlignment(Element.ALIGN_RIGHT);
                     cell1.addElement(paragraph);
                    table2.addCell(cell1);  
                    }
                     else
                    {
                    
                     jsondata=new JSONObject(array.getString(i));
                      arrayincometype=new JSONArray(jsondata.getString("incometype"));
                    // System.out.print(arrayname.getString(0)+"\n");arrayincometype
                     arraymoney=new JSONArray(jsondata.getString("money"));
                       arraydate=new JSONArray(jsondata.getString("date"));
                    debitsum=debitsum+Integer.parseInt(arraymoney.getString(0));
                     
                     cell1=new PdfPCell();
                    cell1.addElement(new Paragraph(arrayincometype.getString(0)));
                    table2.addCell(cell1);
      
                    
                     cell1=new PdfPCell();
                    cell1.addElement(new Paragraph(arraydate.getString(0)));
                    table2.addCell(cell1);
                    
                    cell1=new PdfPCell();
                     paragraph = new Paragraph(""+arraymoney.getString(0)+""+"/=", new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.HELVETICA, 12));
                     paragraph.setAlignment(Element.ALIGN_RIGHT);
                     cell1.addElement(paragraph);
                    table2.addCell(cell1);
                 } 
                 }
                 table.addCell(table2);
                 table.setSpacingAfter(30f);
                 doc.add(table);
                 int sum=creditsum-debitsum;
                 if(sum>=0)
                 {
                   doc.add(paragraphreturn("Profit is:  "+sum+"/=", "center","bold"));
                 }
                 else
                 {
                 doc.add(paragraphreturn("Due is:  "+sum+"/=", "center","bold"));  
                 }
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
