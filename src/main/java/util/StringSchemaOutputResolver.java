package util;


import javax.xml.bind.SchemaOutputResolver;
import javax.xml.transform.Result;
import javax.xml.transform.stream.StreamResult;
import java.io.IOException;
import java.io.StringWriter;

public class StringSchemaOutputResolver extends SchemaOutputResolver {

    private final StringWriter stringWriter = new StringWriter();

    @Override
    public Result createOutput(String namespaceURI, String suggestedFileName) throws IOException {
        StreamResult result = new StreamResult(stringWriter);
        result.setSystemId(suggestedFileName);
        return result;
    }

    public String getSchema() {
        return stringWriter.toString();
    }
}