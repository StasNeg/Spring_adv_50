## for execute :
- mvn clean install
- upload .war file to Tomcat
## implemented:
- index page with functionality
    - getUserByEmail(FreeMarker page), getUsersByName(PDF view)
    - getEventsByName(PDFView), getAllEvents (PDFView)
    - download file with JSON (example you can find in ROOT_DIRECTORY\test.json, and you can create and test JSON via test.beans.web.dto.ObjectMapperTest)
- implemented ControllerAware class for Exception handling.
## for Assignment 3 implemented:
- UserAccount, UserAccountDAO, UserAccountService
- created Hibernate relations to UserAccount class
- add new logic into BookingService.bookTicket
    - test if user have enough money
    - withdraw and book ticket
- add and fix test classes according to new functionality   
