package beans.services;

import beans.configuration.AppConfiguration;
import beans.configuration.TestUserAccountServiceConfiguration;
import beans.configuration.TestUserServiceConfiguration;
import beans.configuration.db.DataSourceConfiguration;
import beans.configuration.db.DbSessionFactory;
import beans.daos.UserAccountDAO;
import beans.daos.db.UserAccountDaoImpl;
import beans.daos.mocks.UserDAOMock;
import beans.models.User;
import beans.models.UserAccount;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import static beans.models.Roles.REGISTERED_USER;
import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

/**
 * Created with IntelliJ IDEA.
 * User: Dmytro_Babichev
 * Date: 06/2/16
 * Time: 8:02 PM
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfiguration.class, DataSourceConfiguration.class, DbSessionFactory.class,
        TestUserServiceConfiguration.class})
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class UserAccountServiceImplTest {

    @Autowired
    private ConfigurableApplicationContext applicationContext;

    @Autowired
    @Value("#{testUserServiceImpl}")
    private UserService userService;

    @Autowired
    @Value("#{testUserAccountServiceImpl}")
    private UserAccountService userAccountService;

    @Autowired
    private UserDAOMock userDAOMock;

    @Autowired
    private UserAccountDAO userAccountDAOMock;

    @Before
    public void init() {
        userDAOMock.init();
    }

    @After
    public void cleanup() {
        userDAOMock.cleanup();
    }

    @Test
    public void testRegister() throws Exception {
        UserAccount userAccount = userAccountService.getUserAccountByUser((User) applicationContext.getBean("testUser1"));
        Assert.assertEquals("Must be equals", 1, userAccount.getId());
    }

}
