package beans.xml;

import org.junit.Before;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

public class DefMessageProvider {

    private XsdSchema schema;

    @Before
    public void init() {
        this.schema = new SimpleXsdSchema(new ClassPathResource("event_user.xsd"));
    }

    @Test
    public void definitionTest(){
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("UserPort");
        wsdl11Definition.setLocationUri("/ws");
        wsdl11Definition.setTargetNamespace("http://beans.models.xml/user-web.service");
        wsdl11Definition.setSchema(schema);



    }
}



