package beans.web.views;


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
public class PDFUserPage extends AbstractPdfView {
    @Override
    protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer, HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map<String, Object> usersMap = (Map<String, Object>) model.get("modelUser");
        String header = (String)usersMap.get("header");
        Paragraph paragraph = new Paragraph();
        paragraph.setAlignment("Center");
        paragraph.add(header);
        List<User> users = (List<User>)usersMap.get("user");
        Table table = new Table(4);
        table.setAlignment("Center");
        table.setTableFitsPage(true);
        table.addCell("UserId");
        table.addCell("UserName");
        table.addCell("UserBirthDay");
        table.addCell("UserEmail");

        for (User user : users) {
            table.addCell(String.valueOf(user.getId()));
            table.addCell(user.getName());
            table.addCell(user.getBirthday().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
            table.addCell(user.getEmail());
        }
        document.add(paragraph);
        document.add(table);
    }
}
