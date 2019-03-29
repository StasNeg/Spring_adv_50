package beans.web.views;

import beans.models.Event;
import beans.models.User;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.PdfWriter;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

@Component
public class PDFEventPage extends AbstractPdfView {
    @Override
    protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer, HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map<String, Object> usersMap = (Map<String, Object>) model.get("modelEvent");
        String header = (String)usersMap.get("header");
        Paragraph paragraph = new Paragraph();
        paragraph.setAlignment("Center");
        paragraph.add(header);
        List<Event> events = (List<Event>)usersMap.get("event");
        Table table = new Table(4);
        table.setAlignment("Center");
        table.setTableFitsPage(true);
        table.addCell("Event Name");
        table.addCell("Event Date");
        table.addCell("Event Place");
        table.addCell("Event Price");

        for (Event event : events) {
            table.addCell(event.getName());
            table.addCell(event.getDateTime().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm")));
            table.addCell(event.getAuditorium().getName());
            table.addCell(Double.toString(event.getBasePrice()));
        }
        document.add(paragraph);
        document.add(table);
    }
}
