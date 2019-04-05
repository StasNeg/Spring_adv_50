package beans.daos.mocks;

import beans.daos.db.UserDAOImpl;
import beans.models.User;
import beans.models.UserAccount;
import beans.services.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Dmytro_Babichev
 * Date: 06/2/16
 * Time: 2:41 PM
 */

public class UserDAOMock extends UserDAOImpl {

    private final List<User> users;

    @Autowired
    private UserAccountService userAccountDAO;

    public UserDAOMock(List<User> users) {
        this.users = users;
    }

    public void init() {
        cleanup();
        users.forEach(this::create);
    }

    public void cleanup() {
        getAll().forEach(this::delete);
    }

    @Override
    public User create(User user) {
        user = super.create(user);
        userAccountDAO.createOrUpdate(user, new UserAccount(user, 3000));
        return user;
    }

    @Override
    public void delete(User user) {
        UserAccount account = userAccountDAO.getUserAccountByUser(user);
        userAccountDAO.remove(account);
        super.delete(user);
    }
}
