package com.uah.gestion_de_practicas.handlers;

import java.util.ArrayList;
import java.util.List;

import com.itextpdf.text.Element;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPTable;
import com.uah.gestion_de_practicas.model.Company;
import com.uah.gestion_de_practicas.model.Offer;
import com.uah.gestion_de_practicas.model.Practice;
import com.uah.gestion_de_practicas.model.Student;

public class UserReportHandler extends PDFHandler {

    private final Student user;
    private final List<Practice> completedPractices;
    
    public UserReportHandler(Student user, List<Practice> completedPractices) {
        super("Informe de practicas del alumno");
        this.user = user;
        this.completedPractices = completedPractices;
    }

    @Override
    public List<Element> setPdfContent() {
        List<Element> content = new ArrayList<>();

        // Add titles previous to user information
        content.add(new Phrase("Informe de practicas de " + user.getFirstName() + " " + user.getLastName()+"\n", this.titleFont));
        content.add(new Phrase("Informacion del usuario", this.subtitleFont));

        // Add user information table
        content.add(setProfileInformation(user));

        // Add titles previous to completed practices
        content.add(new Phrase("Practicas realizadas \n", this.subtitleFont));

        // Add completed practices list
        content.addAll(setPracticesList(completedPractices));

        return content;
    }

    public PdfPTable setProfileInformation(Student user){
        // Table definition and setting up
        PdfPTable profileInformation = new PdfPTable(2);
        profileInformation.setTotalWidth(527);
        profileInformation.setLockedWidth(true);
        profileInformation.getDefaultCell().setFixedHeight(20);
        profileInformation.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
        profileInformation.getDefaultCell().setVerticalAlignment(Element.ALIGN_MIDDLE);
        
        // Table content
        profileInformation.addCell("Nombre Completo");
        profileInformation.addCell(user.getFirstName() + " " + user.getLastName());
        profileInformation.addCell("Grado universitario");
        profileInformation.addCell(user.getDegree());
        profileInformation.addCell("Universidad");
        profileInformation.addCell("Universidad de Alcala de Henares");
        profileInformation.addCell("DNI/NIE");
        profileInformation.addCell(user.getNif());
        profileInformation.addCell("Email");
        profileInformation.addCell(user.getEmail());
        profileInformation.addCell("Telefono");
        profileInformation.addCell(user.getPhone());
        profileInformation.addCell("Fecha de nacimiento");
        profileInformation.addCell(user.getBirth_date().toString());
        profileInformation.addCell("Horas de practicas realizadas");
        profileInformation.addCell(user.getTotal_hours().toString());
        profileInformation.addCell("Nota media del expediente");
        profileInformation.addCell(user.getExp_note().toString());        

        return profileInformation;
    }

    public List<Element> setPracticesList(List<Practice> practices){
        List<Element> practiceList = new ArrayList<>();

        for (Practice practice : practices) {
            Offer offer = practice.getOffer();
            Company company = offer.getCompany();

            // Practice title
            practiceList.add(new Phrase(company.getName() + " - " + offer.getPosition()+"\n", this.subsubtitleFont));
            practiceList.add(new Phrase("Oferta de practicas: "+offer.getDescription()+"\n", this.textFont));
            practiceList.add(new Phrase("Duracion de practicas:  " + offer.getWeeks()+" semanas, de "+practice.getStart_date().toString()+" a "+ practice.getEnd_date().toString() + "\n", this.textFont));

        }

        return practiceList;
    }
    
}
