package beans.xml;

import beans.models.Auditorium;
import beans.models.Event;
import beans.models.User;
import org.junit.Before;
import org.junit.Test;
import util.StringSchemaOutputResolver;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;


public class MarshallingJavaToXMLJaxbTest {

    private Auditorium testHall1 = new Auditorium(1, "Test auditorium", 15, Arrays.asList(1, 2, 3, 4, 5));
    private Auditorium testHall2 = new Auditorium(1, "Test auditorium", 15, Arrays.asList(1, 2, 3, 4, 5));
    private Event event = new Event("Test event", beans.models.Rate.HIGH, 124.0, 124, java.time.LocalDateTime.of(2016, 2, 6, 14, 45, 0),
            testHall1);
    private Event event1 = new Event("Test event", beans.models.Rate.HIGH, 124.0, 124, java.time.LocalDateTime.of(2016, 2, 6, 14, 45, 0),
            testHall1);

    private CreatedForXsd test;
    @Before
    public void init() {
        test = new CreatedForXsd(Arrays.asList(event,event1));
    }

    @Test
    public void marshalingTest() throws JAXBException, IOException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Event.class, User.class,CreatedForXsd.class);
        StringSchemaOutputResolver schemaOutputResolver = new StringSchemaOutputResolver();
        jaxbContext.generateSchema(schemaOutputResolver);
        Files.write(Paths.get("test.xsd"), schemaOutputResolver.getSchema().getBytes());
    }

}
