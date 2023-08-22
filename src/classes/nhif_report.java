/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author
 */
public class nhif_report {

    
    String name;
        String pin;
    String tagline;
    String address;
    String email;
   Connection con;
    PreparedStatement pst;
    Statement st;
    ResultSet rs;

    private Object ImageDataFactory;
    private Object pdfWriter;

    class MyFooter extends PdfPageEventHelper {

        Font ffont = new Font(Font.FontFamily.HELVETICA, 10, Font.NORMAL);

        @Override
        public void onEndPage(PdfWriter writer, Document document) {
            PdfContentByte cb = writer.getDirectContent();
            Date today = new Date();
            SimpleDateFormat www = new SimpleDateFormat("hh:mm a dd/MM/yyyy");
            String ret_date = (www.format(today));
            Phrase footer = new Phrase("" + ret_date, ffont);

            ColumnText.showTextAligned(cb, Element.ALIGN_CENTER,
                    footer,
                    (document.right() - document.left()) / 2 + document.leftMargin(),
                    document.bottom() - 10, 0);
        }
    }

    public class PDFEventListener extends PdfPageEventHelper {

        @Override

        public void onEndPage(PdfWriter writer, Document document) {

            PdfContentByte canvas = writer.getDirectContentUnder();

            Phrase watermark = new Phrase(name, new Font(Font.FontFamily.TIMES_ROMAN, 190, Font.NORMAL, BaseColor.LIGHT_GRAY));

            ColumnText.showTextAligned(canvas, Element.ALIGN_CENTER, watermark, 337, 500, 45);

        }
    }

    public void generate() {

        //connect to db
        try {
            String dbname = "ems";
            String pass = "password";
            String username = "root";
            String Url = "jdbc:mysql://localhost:3306/";
            String Drivers = "com.mysql.jdbc.Driver";

            Class.forName(Drivers);
            con = DriverManager.getConnection(Url + dbname, username, pass);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Connection to database unsuccesful", "Alert", 1);
            System.exit(0);
        }

        PdfPCell table_cell;
        try {
            PdfWriter writer;
            /* Step-2: Initialize PDF documents - logical objects */
            Document my_pdf_report = new Document();
            PdfWriter pdf = PdfWriter.getInstance(my_pdf_report, new FileOutputStream("C:\\employee_Management_System\\" + "employee_nhif_report.pdf"));

            // Writer.setPageEvent(new PDFEventListener());
            my_pdf_report.open();

            new MyFooter().onEndPage(pdf, my_pdf_report);

            // new report_generate.PDFEventListener().onEndPage(pdf, my_pdf_report);
            float[] pointColumnWidths = {450F, 500F, 350F, 900F, 400F, 400F};

            PdfPTable my_report_table = new PdfPTable(pointColumnWidths);

            Paragraph titl = new Paragraph(name, FontFactory.getFont(FontFactory.TIMES, 14, Font.BOLD, BaseColor.BLACK));
            titl.setAlignment(Element.ALIGN_CENTER);
            my_pdf_report.add(titl);

            Paragraph titl1x = new Paragraph(tagline, FontFactory.getFont(FontFactory.TIMES, 10, Font.BOLD, BaseColor.BLACK));
            titl1x.setAlignment(Element.ALIGN_CENTER);
            my_pdf_report.add(titl1x);

            Paragraph titl13 = new Paragraph(address, FontFactory.getFont(FontFactory.TIMES, 10, Font.BOLD, BaseColor.BLACK));
            titl13.setAlignment(Element.ALIGN_CENTER);
            my_pdf_report.add(titl13);

            Paragraph titl1e = new Paragraph(email, FontFactory.getFont(FontFactory.TIMES, 10, Font.BOLD, BaseColor.BLACK));
            titl1e.setAlignment(Element.ALIGN_CENTER);
            my_pdf_report.add(titl1e);
            
             Paragraph titl1ed = new Paragraph("KRA Pin: "+pin, FontFactory.getFont(FontFactory.TIMES, 10, Font.BOLD, BaseColor.BLACK));
            titl1e.setAlignment(Element.ALIGN_LEFT);
            my_pdf_report.add(titl1ed);

            Paragraph titl1 = new Paragraph("NHIF Report", FontFactory.getFont(FontFactory.TIMES, 12, Font.BOLD, BaseColor.BLACK));
            titl1.setAlignment(Element.ALIGN_CENTER);
            my_pdf_report.add(titl1);

            Paragraph titl4 = new Paragraph("_________________________________________________________________________________", FontFactory.getFont(FontFactory.HELVETICA, 14, Font.BOLD, BaseColor.BLACK));
            titl4.setAlignment(Element.ALIGN_CENTER);
            my_pdf_report.add(titl4);

            String t1 = "Employee No:";
            table_cell = new PdfPCell(new Phrase(t1, FontFactory.getFont(FontFactory.HELVETICA, 9, Font.BOLD)));
            // table_cell.setColspan(6);
            table_cell.setBackgroundColor(BaseColor.PINK);
            table_cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            my_report_table.addCell(table_cell);

            String t2 = "Name";
            table_cell = new PdfPCell(new Phrase(t2, FontFactory.getFont(FontFactory.HELVETICA, 9, Font.BOLD)));
            table_cell.setBackgroundColor(BaseColor.PINK);
            table_cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            my_report_table.addCell(table_cell);
          

            String t4 = "ID Number";
            table_cell = new PdfPCell(new Phrase(t4, FontFactory.getFont(FontFactory.HELVETICA, 9, Font.BOLD)));
            table_cell.setBackgroundColor(BaseColor.PINK);
            table_cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            my_report_table.addCell(table_cell);

            String t5 = "Job";
            table_cell = new PdfPCell(new Phrase(t5, FontFactory.getFont(FontFactory.HELVETICA, 9, Font.BOLD)));
            table_cell.setBackgroundColor(BaseColor.PINK);
            table_cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            my_report_table.addCell(table_cell);
           
           
            String t7 = "NHIF Number";
            table_cell = new PdfPCell(new Phrase(t7, FontFactory.getFont(FontFactory.HELVETICA, 9, Font.BOLD)));
            table_cell.setBackgroundColor(BaseColor.PINK);
            table_cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            my_report_table.addCell(table_cell);
            
            String t8 = "Amount";
            table_cell = new PdfPCell(new Phrase(t8, FontFactory.getFont(FontFactory.HELVETICA, 9, Font.BOLD)));
            table_cell.setBackgroundColor(BaseColor.PINK);
            table_cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            my_report_table.addCell(table_cell);

            //fetch data from the database
            String sql = "SELECT * FROM employee";
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {

                String emp_id = rs.getString("employee_number");
                String named = rs.getString("name");
                 String id = rs.getString("id_number");
                String dep_pos = rs.getString("department")+" - "+rs.getString("position");               
                String acc_no = rs.getString("nhif_number");
                String gross = rs.getString("gross_income");

                table_cell = new PdfPCell(new Phrase(emp_id, FontFactory.getFont(FontFactory.HELVETICA, 8, Font.BOLD)));
                table_cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                my_report_table.addCell(table_cell);

                table_cell = new PdfPCell(new Phrase(named, FontFactory.getFont(FontFactory.HELVETICA, 8, Font.BOLD)));
                //table_cell.setBackgroundColor(BaseColor.GRAY);
                table_cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                my_report_table.addCell(table_cell);

                table_cell = new PdfPCell(new Phrase(id, FontFactory.getFont(FontFactory.HELVETICA, 8, Font.BOLD)));
                //table_cell.setBackgroundColor(BaseColor.GRAY);
                table_cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                my_report_table.addCell(table_cell);

                table_cell = new PdfPCell(new Phrase(dep_pos, FontFactory.getFont(FontFactory.HELVETICA, 8, Font.BOLD)));
                table_cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                my_report_table.addCell(table_cell);

                table_cell = new PdfPCell(new Phrase(acc_no, FontFactory.getFont(FontFactory.HELVETICA, 8, Font.BOLD)));
                table_cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                my_report_table.addCell(table_cell);
                
                int x=0;
                int y=Integer.parseInt(gross);
                if(y<=6000){
                    x=150;
            }else if(y>6000){
            x=1700;
            }
                table_cell = new PdfPCell(new Phrase(""+x, FontFactory.getFont(FontFactory.HELVETICA, 8, Font.BOLD)));
                table_cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                my_report_table.addCell(table_cell);

            }

            my_pdf_report.add(my_report_table);

            //conn.close();
            my_pdf_report.close();
            // my_pdf_report.open();
            JOptionPane.showMessageDialog(null, "Report Generated Succesfully");
            if (Desktop.isDesktopSupported()) {
                try {
                    File myFile = new File("C:\\employee_Management_System\\employee_nhif_report.pdf");
                    Desktop.getDesktop().open(myFile);
                } catch (IOException ex) {
                }
            }
            //my_pdf_report.open();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }

   

}
