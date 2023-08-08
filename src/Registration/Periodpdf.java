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
public class Periodpdf {
   //1 top
    //2 bottom
    //4 left
    //8 right
           Database connection = new  Database();

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
          JSONObject exjsonObject = new JSONObject();
             JSONObject jsonObject1 = new JSONObject();
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
    String startdate,enddate;
    public String projectname,flatname;
    public Periodpdf (String pn,String startdate,String enddate) throws FileNotFoundException, DocumentException, JSONException, BadElementException, IOException
    {
        super();
        this.projectname=pn;
        this.startdate=startdate;
         this.enddate=enddate;
        projectdatacalculation(this.projectname,this.startdate,this.enddate);
    }
    public void  projectdatacalculation(String pn,String startdate,String enddate) throws FileNotFoundException, DocumentException, JSONException, BadElementException, IOException
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
                jsonObject= database.getflatdebitcreditonemoreperiod(pn,data,startdate,enddate);
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
                 table = new PdfPTable(2);
                // table.getDefaultCell().setBorderWidth(0f)
                 table1 = new PdfPTable(3);
                 cell1=new PdfPCell();
                 cell1.addElement(paragraphreturn("Name", "center","bold"));
                 table1.addCell(cell1);
                 
                 cell1=new PdfPCell();
                 cell1.addElement(paragraphreturn("Date", "center","bold"));
                 cell1.disableBorderSide(8);
                 table1.addCell(cell1);
                 
                 cell1=new PdfPCell();
                 cell1.addElement(paragraphreturn("Money", "center","bold"));
                 cell1.disableBorderSide(8);
                 table1.addCell(cell1);
                 
                 
                    array1=new JSONArray(jsonObject.getString("setutility"));
                     array2=new JSONArray(jsonObject.getString("other"));
                 array=new JSONArray(jsonObject.getString("credit"));
                  for(int i=0;i<=array.length()+1;i++)
                 {
                     if(i==array.length()+1)
                     {
                     cell1=new PdfPCell();
                    cell1.addElement(new Paragraph("Total"));
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
                     else if(i==array.length())
                     {
                       jsonObject1= Database.getsetutilityandotheronemoreperiod(pn,data,startdate,enddate); 
                       array5=new JSONArray(jsonObject1.getString("incomeutility"));
                       for(int j=0;j<array.length();j++)
                       {
                           jsondata=new JSONObject(array5.getString(j));
                           arrayname=new JSONArray(jsondata.getString("name"));
                          // System.out.print(arrayname.getString(0)+"\n");
                           arraymoney=new JSONArray(jsondata.getString("money"));
                             arraydate=new JSONArray(jsondata.getString("date"));
                           //System.out.print(arraymoney.getString(0)+"\n");
                           creditsum=creditsum+Integer.parseInt(arraymoney.getString(0));

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
                     else
                     {
                     jsondata=new JSONObject(array.getString(i));
                     arrayname=new JSONArray(jsondata.getString("name"));
                    // System.out.print(arrayname.getString(0)+"\n");
                     arraymoney=new JSONArray(jsondata.getString("money"));
                       arraydate=new JSONArray(jsondata.getString("date"));
                     //System.out.print(arraymoney.getString(0)+"\n");
                     creditsum=creditsum+Integer.parseInt(arraymoney.getString(0));
                     
                    cell1=new PdfPCell();
                    cell1.addElement(new Paragraph(arrayname.getString(0)+"(Flat)"));
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
                 cell1.addElement(paragraphreturn("Selling Price", "center","bold"));
                 table2.addCell(cell1);
                 
                 cell1=new PdfPCell();
                 cell1.addElement(paragraphreturn("Utility Bill", "center","bold"));
                 table2.addCell(cell1);
                 
                 cell1=new PdfPCell();
                 cell1.addElement(paragraphreturn("Other", "center","bold"));
                 table2.addCell(cell1);                 
                  int summing=0;
                   array=new JSONArray(jsonObject.getString("debit"));
                  for(int i=0;i<array.length();i++)
                 {
                     //seling price
                     jsondata=new JSONObject(array.getString(i));
                     arraymoney=new JSONArray(jsondata.getString("money"));
                     debitsum=debitsum+Integer.parseInt(arraymoney.getString(0));
                     sellingbill=sellingbill+Integer.parseInt(arraymoney.getString(0));
                     
                     cell1=new PdfPCell();
                     paragraph = new Paragraph(""+arraymoney.getString(0)+""+"/=", new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.HELVETICA, 12));
                     paragraph.setAlignment(Element.ALIGN_RIGHT);
                     cell1.addElement(paragraph);
                    table2.addCell(cell1);
                    
                    cell1=new PdfPCell();
                    if(connection.utilitypriceonemoreperiod(pn,data,startdate,enddate)==null)
                    {
                        summing=0;
                    }else
                    {
                        summing=Integer.parseInt(connection.utilitypriceonemoreperiod(pn,data,startdate,enddate));
                        debitsum=debitsum+summing;
                        utilitybill=utilitybill+summing;
                    }
                     paragraph = new Paragraph(""+summing+""+"/=", new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.HELVETICA, 12));
                     paragraph.setAlignment(Element.ALIGN_RIGHT);
                     cell1.addElement(paragraph);
                    table2.addCell(cell1);
                    
                    cell1=new PdfPCell();
                    if(connection.otherpriceonemoreperiod(pn,data,startdate,enddate)==null)
                    {
                        summing=0;
                        
                    }else
                    {
                        summing=Integer.parseInt(connection.otherpriceonemoreperiod(pn,data,startdate,enddate));
                        debitsum=debitsum+summing;
                        othersbill= othersbill+summing;
                    }
                     paragraph = new Paragraph(""+summing+""+"/=", new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.HELVETICA, 12));
                     paragraph.setAlignment(Element.ALIGN_RIGHT);
                     cell1.addElement(paragraph);
                    table2.addCell(cell1);
                     }  
                 
                 table.addCell(table2);
                 table.setSpacingAfter(30f);
                 doc.add(table); 
                 // other income
               
                 int sum=creditsum-debitsum;
                 if(sum>=0)
                 {
                   doc.add(paragraphreturn("Profit is:  "+sum+"/=", "center","bold"));
                 }
                 else
                 {
                 doc.add(paragraphreturn("Due is:  "+sum+"/=", "center","bold"));  
                 }
                 
                 //total calculation
                  projectincome=projectincome+creditsum;
                  projectdebit=projectdebit+debitsum;
                  
                  
                }
                paragraph = new Paragraph("              Others Income:", new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.HELVETICA, 12));
                paragraph.setAlignment(Element.ALIGN_LEFT);
                paragraph.setSpacingAfter(10f);
                doc.add(paragraph);
                
                 table1 = new PdfPTable(3);
                 cell1=new PdfPCell();
                 cell1.addElement(paragraphreturn("Name", "center","bold"));
                 table1.addCell(cell1);
                 
                 cell1=new PdfPCell();
                 cell1.addElement(paragraphreturn("Date", "center","bold"));
                 cell1.disableBorderSide(8);
                 table1.addCell(cell1);
                 
                 cell1=new PdfPCell();
                 cell1.addElement(paragraphreturn("Money", "center","bold"));
                 //cell1.disableBorderSide(8);
                 table1.addCell(cell1);
                             exjsonObject= database.extracreditfixonemoreperiod(pn,startdate,enddate);
                             exarray=new JSONArray(exjsonObject.getString("data"));
                             creditsum=0;debitsum=0;
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
                                 paragraph = new Paragraph(""+creditsum+""+"/=", new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.HELVETICA, 12));
                                 paragraph.setAlignment(Element.ALIGN_RIGHT);
                                cell1.addElement(paragraph);
                                //cell1.disableBorderSide(8);
                                table1.addCell(cell1);  
                              }
                              else
                              {
                                exjsondata=new JSONObject(exarray.getString(j));
                                exarrayname=new JSONArray(exjsondata.getString("name"));
                               // System.out.print(arrayname.getString(0)+"\n");
                                exarraymoney=new JSONArray(exjsondata.getString("money"));
                                 exarraydate=new JSONArray(exjsondata.getString("date"));
                                //System.out.print(arraymoney.getString(0)+"\n");
                                creditsum=creditsum+Integer.parseInt(exarraymoney.getString(0));

                               cell1=new PdfPCell();
                               cell1.addElement(new Paragraph(exarrayname.getString(0)+"(OthersIncome)"));
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
                           doc.add(table1);
                  paragraph = new Paragraph();
                 paragraph.setSpacingBefore(30f);
                paragraph.setSpacingAfter(30f);
                doc.add(paragraph);
                  
                 paragraph = new Paragraph("              Project Debit:", new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.HELVETICA, 12));
                paragraph.setAlignment(Element.ALIGN_LEFT);
                paragraph.setSpacingAfter(10f);
                doc.add(paragraph);
                
                 table1 = new PdfPTable(3);
                 cell1=new PdfPCell();
                 cell1.addElement(paragraphreturn("Name", "center","bold"));
                 table1.addCell(cell1);
                 
                 cell1=new PdfPCell();
                 cell1.addElement(paragraphreturn("Date", "center","bold"));
                 cell1.disableBorderSide(8);
                 table1.addCell(cell1);
                 
                 cell1=new PdfPCell();
                 cell1.addElement(paragraphreturn("Money", "center","bold"));
                 //cell1.disableBorderSide(8);
                 table1.addCell(cell1);
                             exjsonObject= database.projectdebitcalfixonemoreperiod(pn,startdate,enddate);
                             exarray=new JSONArray(exjsonObject.getString("data"));
                            debitsum2=0;
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
                                 paragraph = new Paragraph(""+ debitsum2+""+"/=", new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.HELVETICA, 12));
                                 paragraph.setAlignment(Element.ALIGN_RIGHT);
                                cell1.addElement(paragraph);
                                //cell1.disableBorderSide(8);
                                table1.addCell(cell1);  
                              }
                              else
                              {
                                exjsondata=new JSONObject(exarray.getString(j));
                                exarrayname=new JSONArray(exjsondata.getString("name"));
                               // System.out.print(arrayname.getString(0)+"\n");
                                exarraymoney=new JSONArray(exjsondata.getString("money"));
                                 exarraydate=new JSONArray(exjsondata.getString("date"));
                                //System.out.print(arraymoney.getString(0)+"\n");
                                debitsum2=debitsum2+Integer.parseInt(exarraymoney.getString(0));

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
                           doc.add(table1);
                  
                  
                  
                paragraph = new Paragraph();
                paragraph.setAlignment(Element.ALIGN_CENTER);
                paragraph.setSpacingAfter(30f);
                  paragraph.setSpacingBefore(30f);
                doc.add(paragraph);
                
                
                
                int  sum=(projectincome+creditsum)-projectdebit;
                  if(sum>=0)
                 {
                   doc.add(paragraphreturn("All Flat Income:  "+projectincome+"/=", "center","bold"));
                   doc.add(paragraphreturn("Others Income:  "+creditsum+"/=", "center","bold"));
                   doc.add(paragraphreturn("All Flat Selling Price:  "+ sellingbill+"/=", "center","bold"));
                   doc.add(paragraphreturn("All Flat Utility Bill:  "+ utilitybill+"/=", "center","bold"));
                   doc.add(paragraphreturn("All Flat Other Price:  "+ othersbill+"/=", "center","bold"));
                   doc.add(paragraphreturn("Profit is:  "+sum+"/=", "center","bold"));
                 }
                 else
                 {
                   doc.add(paragraphreturn("All Flat Income:  "+projectincome+"/=", "center","bold"));
                  doc.add(paragraphreturn("Others Income:  "+creditsum+"/=", "center","bold"));
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
                 
                       dif1=0;dif2=0;dif3=0;dif4=0;dif5=0;
                     
                     jsonObject=  database.singleprojectfixonemoreperiod(pn,startdate,enddate);
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
                                      projectcapital=Integer.parseInt(arraymoney.getString(0));
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
                                      paragraph = new Paragraph("0/=", new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.HELVETICA, 12));

                                      }
                                      else
                                      {
                                      paragraph = new Paragraph(""+projectincome+""+"/=", new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.HELVETICA, 12));  
                                        sum2=sum2+Integer.parseInt(arraymoney.getString(0));
                                        dif2=Integer.parseInt(arraymoney.getString(0));
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
                                      paragraph = new Paragraph(""+creditsum+""+"/=", new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.HELVETICA, 12));  
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
                                      projectwithdraw=Integer.parseInt(arraymoney.getString(0));
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
                                      paragraph = new Paragraph(""+debitsum2+""+"/=", new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.HELVETICA, 12));  
                                      sum5=sum5+Integer.parseInt(arraymoney.getString(0));
                                      dif5=Integer.parseInt(arraymoney.getString(0));
                                      }
                                        paragraph.setAlignment(Element.ALIGN_RIGHT);
                                       cell1.addElement(paragraph);
                                       table1.addCell(cell1);
                                       
                                       



                                      cell1=new PdfPCell();
                                          finaloutput=((projectcapital+projectincome+creditsum)-( projectwithdraw+debitsum2));
                                       paragraph = new Paragraph(" " +finaloutput+""  , new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.HELVETICA, 12));  
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
                    
                     paragraph = new Paragraph();
                     paragraph.setSpacingBefore(30f);
                      paragraph.setSpacingAfter(30f);
                      doc.add(paragraph); 
                                              
                    
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
