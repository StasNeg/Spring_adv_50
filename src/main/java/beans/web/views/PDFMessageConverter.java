package beans.web.views;

import beans.models.Ticket;
import beans.web.dto.Tickets;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.PdfWriter;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.time.format.DateTimeFormatter;

public class PDFMessageConverter<T extends Tickets> extends AbstractHttpMessageConverter<T> {


    @Override
    public boolean canRead(Class<?> clazz, MediaType mediaType) {

        return false;
    }

    @Override
    protected boolean supports(Class<?> clazz) {
        System.out.println("FileName: " + clazz.getSimpleName());
        System.out.println(Tickets.class.isAssignableFrom(clazz));
        return Tickets.class.isAssignableFrom(clazz);
    }

    @Override
    protected T readInternal(Class<? extends T> clazz, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
        return null;
    }

    public PDFMessageConverter() {
        super(new MediaType("application", "pdf"));
    }


    @Override
    protected void writeInternal(T tickets, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
        OutputStream outputStream = outputMessage.getBody();
        try {
            outputStream.write(createDocument(tickets).toByteArray());
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        outputStream.close();
    }

    private ByteArrayOutputStream createDocument(T tickets) throws DocumentException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        Document document = new Document();
        PdfWriter.getInstance(document, byteArrayOutputStream);
        document.open();
        Paragraph paragraph = new Paragraph();
        paragraph.setAlignment("Center");
        Table table = new Table(5);
        table.setAlignment("Center");
        table.setTableFitsPage(true);
        table.addCell("Ticket seats");
        table.addCell("Ticket Date");
        table.addCell("Ticket Place");
        table.addCell("Ticket Price");
        table.addCell("Ticket Event Name");
        for (Ticket ticket : tickets.getTickets()) {
            table.addCell(ticket.getSeats());
            table.addCell(ticket.getDateTime().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm")));
            table.addCell(ticket.getEvent().getAuditorium().getName());
            table.addCell(Double.toString(ticket.getEvent().getBasePrice()));
            table.addCell(ticket.getEvent().getName());
        }
        document.add(paragraph);
        document.add(table);
        document.close();
        return byteArrayOutputStream;
    }

}
