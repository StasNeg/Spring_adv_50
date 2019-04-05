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
public class TestUserServiceConfiguration {

    @Bean
    public User testUser1() {
        return new User(0, "dmitriy.vbabichev@gmail.com", "Dmytro Babichev", java.time.LocalDate.of(1992, 4, 29));
    }

    @Bean
    public User testUser2() {
        return new User(1, "laory@yandex.ru", "Dmytro Babichev", java.time.LocalDate.of(1992, 4, 29));
    }

    @Bean
    public UserDAOMock userDAO() {
        return new UserDAOMock(Arrays.asList(testUser1(), testUser2()));
    }

    @Bean(name = "testUserServiceImpl")
    public UserService userServiceImpl() {
        return new UserServiceImpl(userDAO());
    }
    @Bean
    public UserAccountDAO userAccountDAO() {
        return new UserAccountDaoImpl();
    }


    @Bean(name = "testUserAccountServiceImpl")
    public UserAccountService userAccountServiceImpl() {
        return new UserAccountServiceImpl(userAccountDAO());
    }
}
