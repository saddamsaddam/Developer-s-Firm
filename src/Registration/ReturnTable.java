/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Registration;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import java.util.HashSet;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author 01957
 */
public class ReturnTable {
    
    HashSet<String> result=new HashSet();

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
    int count=0;
    int sum=0;
    public PdfPTable returntabebodyandfooter(String itemname,HashSet<TableClass> result)
    {   
        System.out.println(itemname);
                         sum=0;
                        table = new PdfPTable(2);
                        table1 = new PdfPTable(1);
                        table2 = new PdfPTable(2);
                        
                        
                        cell1=new PdfPCell();
                        cell1.disableBorderSide(1);
                            cell1.disableBorderSide(2);
                           cell1.disableBorderSide(4);
                           cell1.disableBorderSide(8);
                        cell1.addElement(new Paragraph(itemname));
                        table1.addCell(cell1);
                         
                        result.forEach(e->{

                          cell1=new PdfPCell();
                            cell1.disableBorderSide(1);
                            cell1.disableBorderSide(2);
                           cell1.disableBorderSide(4);
                           cell1.disableBorderSide(8);

                          cell1.addElement(new Paragraph(e.getDate()));
                          table2.addCell(cell1);

                           cell1=new PdfPCell();
                           cell1.disableBorderSide(1);
                            cell1.disableBorderSide(2);
                           cell1.disableBorderSide(4);
                           cell1.disableBorderSide(8);
                           paragraph = new Paragraph(""+e.getMoney()+""+"/=", new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.HELVETICA, 12));
                           paragraph.setAlignment(Element.ALIGN_RIGHT);
                           cell1.addElement(paragraph);
                           //cell1.disableBorderSide(8);
                           table2.addCell(cell1); 
                           sum=sum+Integer.parseInt(e.getMoney());
                          });
                       
                        if(result.size()>1)
                        {
                           cell1=new PdfPCell();
                           cell1.disableBorderSide(1);
                            cell1.disableBorderSide(2);
                           cell1.disableBorderSide(4);
                           cell1.disableBorderSide(8);
                          cell1.addElement(new Paragraph("Total"));
                          table2.addCell(cell1);

                           cell1=new PdfPCell();
                           cell1.disableBorderSide(1);
                            cell1.disableBorderSide(2);
                           cell1.disableBorderSide(4);
                           cell1.disableBorderSide(8);
                           paragraph = new Paragraph(""+Integer.toString(sum)+""+"/=", new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.HELVETICA, 12));
                           paragraph.setAlignment(Element.ALIGN_RIGHT);
                          cell1.addElement(paragraph);
                         // cell1.disableBorderSide(8);
                          table2.addCell(cell1);  
                        }
                        table1.getDefaultCell().setBorderWidth(0);
                        table1.setTableEvent(null);
                        table2.getDefaultCell().setBorderWidth(0);
                        table2.setTableEvent(null);
                        
                         table.addCell(table1);
                        table.addCell(table2);
                        
                        table.getDefaultCell().setBorderWidth(0);
                        table.setTableEvent(null);
                        return table;

    }
    
    public PdfPTable returntabeheader(String fst,String snd,String thrd,float a,float b,float c) throws DocumentException
    {
                 table1 = new PdfPTable(3);
                 table1.getDefaultCell().setBorderWidth(0);
                  table1.setTableEvent(null);

                 // Set the relative widths of the columns
                 float[] columnWidths = {a, b, c};
                 table1.setWidths(columnWidths);
                 cell1=new PdfPCell();
                 cell1.addElement(paragraphreturn(fst, "center","bold"));
                 table1.addCell(cell1);
                 
                 cell1=new PdfPCell();
                 cell1.addElement(paragraphreturn(snd, "center","bold"));
                 //cell1.disableBorderSide(8);
                 table1.addCell(cell1);
                 
                 cell1=new PdfPCell();
                 cell1.addElement(paragraphreturn(thrd, "center","bold"));
                 //cell1.disableBorderSide(8);
                 table1.addCell(cell1);
                        
                        
                        return table1;

    }
    
    public PdfPTable returntableutilityothersselling(String fst,String snd,String thrd) throws DocumentException
    {
                 table1 = new PdfPTable(3);
                 table1.getDefaultCell().setBorderWidth(0);
                  table1.setTableEvent(null);

                 // Set the relative widths of the columns
                 
                 cell1=new PdfPCell();
                 cell1.addElement(paragraphreturn(fst+"/=", "right","bold"));
                 table1.addCell(cell1);
                 
                 cell1=new PdfPCell();
                 cell1.addElement(paragraphreturn(snd+"/=", "right","bold"));
                 //cell1.disableBorderSide(8);
                 table1.addCell(cell1);
                 
                 cell1=new PdfPCell();
                 cell1.addElement(paragraphreturn(thrd+"/=", "right","bold"));
                 //cell1.disableBorderSide(8);
                 table1.addCell(cell1);
                        
                        
                        return table1;

    }
    public PdfPTable flattotal(int total) throws DocumentException
    {
                 table1 = new PdfPTable(2);
                 table1.getDefaultCell().setBorderWidth(0);
                  table1.setTableEvent(null);

                 // Set the relative widths of the columns
                 
                 cell1=new PdfPCell();
                 cell1.addElement(paragraphreturn("Total", "left","bold"));
                 table1.addCell(cell1);
                 
                 cell1=new PdfPCell();
                 cell1.addElement(paragraphreturn(Integer.toString(total)+"/=", "right","bold"));
                 //cell1.disableBorderSide(8);
                 table1.addCell(cell1);
                        
                        
                        return table1;

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
