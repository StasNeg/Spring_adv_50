package beans.configuration;

import beans.daos.UserAccountDAO;
import beans.daos.db.UserAccountDaoImpl;
import beans.daos.mocks.UserDAOMock;
import beans.models.User;
import beans.services.UserAccountService;
import beans.services.UserAccountServiceImpl;
import beans.services.UserService;
import beans.services.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: Dmytro_Babichev
 * Date: 2/12/2016
 * Time: 1:36 PM
 */
@Configuration
public class TestUserAccountServiceConfiguration {

//
//    @Bean
//    public UserAccountDAO userAccountDAO() {
//        return new UserAccountDaoImpl();
//    }
//
//
//    @Bean(name = "testUserAccountServiceImpl")
//    public UserAccountService userServiceImpl() {
//        return new UserAccountServiceImpl(userAccountDAO());
//    }
}
