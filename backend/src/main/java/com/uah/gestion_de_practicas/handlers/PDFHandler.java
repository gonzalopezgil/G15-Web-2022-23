package com.uah.gestion_de_practicas.handlers;

import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfWriter;

public class PDFHandler extends PdfPageEventHelper {
    // Definition of fonts
    final Font titleFont = new Font(Font.FontFamily.HELVETICA, 18, Font.BOLD);
    final Font subtitleFont = new Font(Font.FontFamily.HELVETICA, 16, Font.BOLD);
    final Font subsubtitleFont = new Font(Font.FontFamily.HELVETICA, 14, Font.BOLD);
    final Font textFont = new Font(Font.FontFamily.HELVETICA, 11, Font.NORMAL);

    final SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
    
    private final String title;
    private final String creationDate;

    public PDFHandler(String title) {
        this.title = title;
        this.creationDate = this.dateFormatter.format(new Date());
    }

    public void generatePDF(OutputStream output_stream) {
        try {
            Document document = new Document(PageSize.A4, 34, 20, 100, 50);
            PdfWriter.getInstance(document, output_stream).setPageEvent(this);

            document.open();

            for (Element element : setPdfContent()) {
                document.add(element);
            }

            document.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onStartPage(PdfWriter writer, Document document) {

        PdfPTable header = new PdfPTable(2);
        header.setTotalWidth(527);
        header.setLockedWidth(true);
        header.getDefaultCell().setFixedHeight(30);
        header.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
        header.getDefaultCell().setVerticalAlignment(Element.ALIGN_MIDDLE);
        header.getDefaultCell().setBackgroundColor(new BaseColor(0, 62, 243));

        Font white = new Font(Font.FontFamily.HELVETICA, 12, Font.NORMAL, BaseColor.WHITE);
        // Title cell definition
        Phrase title_phrase = new Phrase(this.title, white);
        header.addCell(title_phrase);

        // Logo cell definition
        Phrase company_phrase = new Phrase("Gestion de Practicas UAH", white);
        header.addCell(company_phrase);

        // Add header to document
        header.writeSelectedRows(0, -1, 34, 803, writer.getDirectContent());

        try {
            //TODO: Exclude backend folder from filename
            Image logo = Image.getInstance("backend/src/main/resources/static/images/logo.png");
            logo.scaleToFit(30, 30);
            logo.setAbsolutePosition(530, 776);
            writer.getDirectContent().addImage(logo);
        } catch (Exception e) {}
    }

    @Override
    public void onEndPage(PdfWriter writer, Document document) {
        PdfPTable footer = new PdfPTable(3);
        footer.setTotalWidth(527);
        footer.setLockedWidth(true);
        footer.getDefaultCell().setFixedHeight(20);
        footer.getDefaultCell().setBorder(0);
        footer.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
        footer.addCell("Universidad de Alcala");
        footer.addCell(this.creationDate);
        footer.addCell("Pagina " + document.getPageNumber());
        footer.writeSelectedRows(0, -1, 34, 50, writer.getDirectContent());
    }

    public List<Element> setHeader(){
        List<Element> elements = new ArrayList<>();
        return elements;
    }
    
    public List<Element> setPdfContent(){
        List<Element> elements = new ArrayList<>();
        elements.add(new Paragraph("Hello World!"));
        return elements;
    }

}
