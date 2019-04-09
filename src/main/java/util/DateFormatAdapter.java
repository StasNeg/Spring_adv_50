package util;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.Temporal;

public class DateFormatAdapter extends XmlAdapter<String, Temporal> {

    //Marshal converting Java to XML
    @Override
    public String marshal(Temporal date) throws Exception {
        return date.toString();
    }

    //UnMarshal converting XML to Java
    @Override
    public Temporal unmarshal(String date) throws Exception {

        return LocalDateTime.parse(date);
    }

}