/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ics;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfReader;

import java.io.IOException;

public class GetPdfPageSize {

    public static void main(String[] args) {
        String pdfFilePath = "E:\\pdf/sample.pdf"; // Replace with the path to your PDF file

        try {
            PdfReader reader = new PdfReader(pdfFilePath);
            Rectangle pageSize = reader.getPageSize(1); // Get the size of the first page

            System.out.println("PDF Width: " + pageSize.getWidth() + " units, Height: " + pageSize.getHeight() + " units");

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
