package com.uah.gestion_de_practicas.handlers;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.uah.gestion_de_practicas.model.Practice;

public class PracticeAssignmentHandler extends PDFHandler {

    private final List<Practice> assignment;
    private final String assignationPath = "/tmp/assignation.pdf";

    public PracticeAssignmentHandler(List<Practice> assignment) {
        super("Asignacion de practicas");
        this.assignment = assignment;
    }

    public PracticeAssignmentHandler(){
        super("Asignacion de practicas");
        this.assignment = null;
    }

    @Override
    public List<Element> setPdfContent() {
        List<Element> content = new ArrayList<>();

        Date now = new Date();
        content.add(new Phrase("Asignación de prácticas "+ this.dateFormatter.format(now), titleFont));
        
        content.add(setAssignmentTable(this.assignment));

        return content;
    }

    public PdfPTable setAssignmentTable(List<Practice> practices){
        // Table setting up
        PdfPTable assignment = new PdfPTable(4);
        assignment.setTotalWidth(527);
        assignment.setLockedWidth(true);
        assignment.getDefaultCell().setFixedHeight(20);
        assignment.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
        assignment.getDefaultCell().setVerticalAlignment(Element.ALIGN_MIDDLE);

        // Table header
        assignment.setHeaderRows(1);
        assignment.addCell("Nombre de Alumno");
        assignment.addCell("Nombre de Empresa");
        assignment.addCell("Practica");
        assignment.addCell("Fecha de Inicio");

        // Table content
        for (Practice practice : practices) {
            assignment.addCell(practice.getStudent().getFirst_name() + " " + practice.getStudent().getLast_name());
            assignment.addCell(practice.getOffer().getCompany().getName());
            assignment.addCell(practice.getOffer().getPosition());
            assignment.addCell(this.dateFormatter.format(practice.getStart_date()));
        }

        return assignment;
    }

    private void copy(InputStream is, OutputStream os) throws IOException
    {
        byte[] buffer = new byte[8192];
        int bytesRead;

        while ((bytesRead = is.read(buffer)) != -1) {
            os.write(buffer, 0, bytesRead);
        }
    }

    public void downloadPdf(HttpServletResponse response) {
        try(FileInputStream input_stream = new FileInputStream(this.assignationPath)){
            this.copy(input_stream, response.getOutputStream());
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void generatePDF() {
        try(FileOutputStream output_stream = new FileOutputStream(this.assignationPath)){ 
            super.generatePDF(output_stream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
