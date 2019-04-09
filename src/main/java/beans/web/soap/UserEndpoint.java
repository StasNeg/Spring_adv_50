package beans.web.soap;

import beans.models.User;
import beans.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class UserEndpoint {
    private static final String NAMESPACE_URI = "http://beans.models.xml/user-web.service";

    private UserService userService;

    @Autowired
    public UserEndpoint(UserService userService) {
        this.userService = userService;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getUserRequest")
    @ResponsePayload
    public xml.models.beans.user_web.User getUser(@RequestPayload xml.models.beans.user_web.User request){
        User user = userService.getUserByEmail(request.getEmail());
        xml.models.beans.user_web.User result = new xml.models.beans.user_web.User();
        result.setId(user.getId());
        result.setEmail(user.getEmail());
        return result;
    }
}
