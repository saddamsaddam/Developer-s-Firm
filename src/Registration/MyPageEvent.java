/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Registration;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfWriter;

public class MyPageEvent extends PdfPageEventHelper {
    private final Font pageNumberFont = new Font(Font.FontFamily.HELVETICA, 10, Font.NORMAL);

    @Override
    public void onEndPage(PdfWriter writer, Document document) {
        int pageNumber = writer.getPageNumber();
        String pageNumberText = "Page " + pageNumber;

        PdfContentByte cb = writer.getDirectContent();
        Phrase pageNumberPhrase = new Phrase(pageNumberText, pageNumberFont);

        // Calculate x and y coordinates for the page number
        float x = document.left() + 10;
        float y = document.bottom() - 10;

        // Write the page number to the document footer
        ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, pageNumberPhrase, x, y, 0);
    }
}