import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
 
/**
 * This class is used to create a pdf file using iText jar.
 * @author w3spoint
 */
public class PDFTableExample {
  public static void main(String args[]){
    try {
	Document document = new Document();
	OutputStream outputStream =  new FileOutputStream(new File("E:\\pdf\\gof.pdf"));
        PdfWriter.getInstance(document, outputStream);
        document.open();
        document.add(new Paragraph("Hello world, " +
       	"this is a test pdf file."));
        document.add(new Paragraph("Hello world, " +
       	"this is a test pdf file."));
        document.add(new Paragraph("Hello world, " +
       	"this is a test pdf file."));
        document.add(new Paragraph("Hello world, " +
       	"this is a test pdf file."));
         document.add(new Paragraph("         "));
        PdfPTable pdfPTablenested = new PdfPTable(2);
        PdfPCell pdfPCell1nested = new PdfPCell(new Paragraph("Cell 1"));
        PdfPCell pdfPCell2nested = new PdfPCell(new Paragraph("Cell 2"));
        PdfPCell pdfPCell3nested = new PdfPCell(new Paragraph("Cell 3"));
        PdfPCell pdfPCell4nested = new PdfPCell(new Paragraph("Cell 4"));
        pdfPTablenested.addCell(pdfPCell1nested);
        pdfPTablenested.addCell(pdfPCell2nested);
        pdfPTablenested.addCell(pdfPCell3nested);
        pdfPTablenested.addCell(pdfPCell4nested);
        PdfPTable pdfPTable = new PdfPTable(4);
 
        //Create cells
        PdfPCell pdfPCell1 = new PdfPCell(new Paragraph("Cell 1"));
        PdfPCell pdfPCell2 = new PdfPCell(new Paragraph("Cell 2"));
        PdfPCell pdfPCell3 = new PdfPCell(new Paragraph("Cell 3"));
        PdfPCell pdfPCell4 = new PdfPCell(pdfPTablenested);
 
        //Add cells to table
        pdfPTable.addCell(pdfPCell1);
        pdfPTable.addCell(pdfPCell2);
        pdfPTable.addCell(pdfPCell3);
        pdfPTable.addCell(pdfPCell4);
 
        //Add content to the document using Table objects.
        document.add(pdfPTable);
        document.add(pdfPTable);
        document.add(pdfPTable);
        document.add(pdfPTable);
        document.add(pdfPTable);
        document.add(pdfPTable);

        document.add(pdfPTable);
        document.add(pdfPTable);
        document.add(pdfPTable);
        document.add(pdfPTable);
        document.add(pdfPTable);
        document.add(pdfPTable);
        document.add(pdfPTable);
        document.add(pdfPTable);
        document.add(pdfPTable);
        document.add(pdfPTable);
        document.add(pdfPTable);
        document.add(pdfPTable);
        document.add(pdfPTable);
        document.add(pdfPTable);
        document.add(pdfPTable);
        document.add(pdfPTable);
        document.add(pdfPTable);
        document.add(pdfPTable);

        document.left(200f);
         document.add(new Paragraph("                                                              Hello world, " +
       	"this is a test pdf file."));
        document.add(new Paragraph("Hello world, " +
       	"this is a test pdf file."));
        document.add(new Paragraph("Hello world, " +
       	"this is a test pdf file."));
        document.add(new Paragraph("Hello world, " +
       	"this is a test pdf file."));
 
        //Close document and outputStream.
        document.close();
        outputStream.close();
 
        System.out.println("Pdf created successfully.");
    } catch (Exception e) {
	e.printStackTrace();
    }
  }
}