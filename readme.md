## for execute :
- mvn clean install
- upload .jar file to Tomcat
## implemented:
- index page with functionality
    - getUserByEmail(FreeMarker page), getUsersByName(PDF view)
    - getEventsByName(PDFView), getAllEvents (PDFView)
    - download file with JSON (example you can find in ROOT_DIRECTORY\test.json, and you can create and test JSON via test.beans.web.dto.ObjectMapperTest)
- implemented ControllerAware class for Exception handling.

