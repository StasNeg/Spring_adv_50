package beans.web.soap;

import beans.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import xml.models.beans.user_web.GetUserRequest;
import xml.models.beans.user_web.GetUserResponse;
import static beans.web.soap.Converter.toUser;

@Endpoint
public class UserEndpoint {
    public static final String NAMESPACE_URI = "http://beans.models.xml/user-web";

    private UserService userService;

    @Autowired
    public UserEndpoint(UserService userService) {
        this.userService = userService;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getUserRequest")
    @ResponsePayload
    public GetUserResponse getUserByEmail(@RequestPayload GetUserRequest request) {
        GetUserResponse response = new GetUserResponse();
        beans.models.User fromApi = userService.getUserByEmail(request.getUserEmail());
        response.setUser(toUser(fromApi));
        return response;
    }
}
