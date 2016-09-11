package org.zut.pbai.helpers;

import java.io.*;
import java.util.Map;


import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.stereotype.Service;
import org.zut.pbai.model.Bilet;
import org.zut.pbai.model.Uzytkownik;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;

/**
 * Created by Vadim on 2016-09-10.
 */
@Service
public class PDFCreator{


    //metoda tylko dla wysylania biletu
    public void createPdfWithBilet(Bilet bilet, Uzytkownik uzytkownik) {

        String smtpHost = "smtp.gmail.com"; //replace this with a valid host
        int smtpPort = 587; //replace this with a valid port

        String sender = "pbai2016zut@gmail.com"; //replace this with a valid sender email address
        String password = "pbai2016zut!"; //replace this with a valid sender email address
        String recipient = uzytkownik.getEmail(); //replace this with a valid recipient email address
        String content = "Zostal kupiony bilet. W zalaczniku pdf z biletem"; //this will be the text of the email
        String subject = "Bilet do kina w postaci PDF"; //this will be the subject of the email

        Properties properties = new Properties();
        properties.put("mail.smtp.host", smtpHost);
        properties.put("mail.smtp.port", smtpPort);
        properties.put("mail.smtp.password", password);
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.socketFactory.port", "587");
        properties.put("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        //  Session session = Session.getDefaultInstance(properties, null);

        Session session = Session.getDefaultInstance(properties,
                new Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(
                                "pbai2016zut@gmail.com", "pbai2016zut!");
                    }
                });
        ByteArrayOutputStream outputStream = null;
        try {
            //construct the text body part
            MimeBodyPart textBodyPart = new MimeBodyPart();
            textBodyPart.setText(content);

            //now write the PDF content to the output stream
            outputStream = new ByteArrayOutputStream();
            writePdf(outputStream,bilet, uzytkownik);
            byte[] bytes = outputStream.toByteArray();

            //construct the pdf body part
            DataSource dataSource = new ByteArrayDataSource(bytes, "application/pdf");
            MimeBodyPart pdfBodyPart = new MimeBodyPart();
            pdfBodyPart.setDataHandler(new DataHandler(dataSource));
            pdfBodyPart.setFileName("Bilet " + uzytkownik.getImie());

            //construct the mime multi part
            MimeMultipart mimeMultipart = new MimeMultipart();
            mimeMultipart.addBodyPart(textBodyPart);
            mimeMultipart.addBodyPart(pdfBodyPart);

            //create the sender/recipient addresses
            InternetAddress iaSender = new InternetAddress(sender);
            InternetAddress iaRecipient = new InternetAddress(recipient);

            //construct the mime message
            MimeMessage mimeMessage = new MimeMessage(session);
            mimeMessage.setSender(iaSender);
            mimeMessage.setSubject(subject);
            mimeMessage.setRecipient(Message.RecipientType.TO, iaRecipient);
            mimeMessage.setContent(mimeMultipart);

            //send off the email
            Transport.send(mimeMessage);

            System.out.println("sent from " + sender +
                    ", to " + recipient +
                    "; server = " + smtpHost + ", port = " + smtpPort);
        } catch(Exception ex) {
            ex.printStackTrace();
        } finally {
            //clean off
            if(null != outputStream) {
                try { outputStream.close(); outputStream = null; }
                catch(Exception ex) { }
            }
        }



    }


    public void writePdf(OutputStream outputStream, Bilet bilet, Uzytkownik uzytkownik) throws Exception {
        Document document = new Document();
        PdfWriter.getInstance(document, outputStream);

        document.open();

        document.addTitle("Bilet PDF");
        document.addSubject("Bilet email PDF");
        document.addKeywords("iText, email");
        document.addAuthor("pbai2016");
        document.addCreator("pbai2016");

        Paragraph paragraph = new Paragraph();
        paragraph.add(new Chunk("Dzien dobry! " + uzytkownik.getImie() + uzytkownik.getNazwisko()));
        paragraph.add(new Chunk("Zostal Kupiony bilet na film! " + bilet.getFilm().getTytul() ));
        paragraph.add(new Chunk("Seans " + bilet.getSeans().getData() ));


        document.add(paragraph);

        document.close();
    }

}
