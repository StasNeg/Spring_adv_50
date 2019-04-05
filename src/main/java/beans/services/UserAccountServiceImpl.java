package beans.services;

import beans.daos.UserAccountDAO;
import beans.models.User;
import beans.models.UserAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Dmytro_Babichev
 * Date: 2/1/2016
 * Time: 7:30 PM
 */
@Service
@Transactional
public class UserAccountServiceImpl implements UserAccountService {

    private final UserAccountDAO userDAO;

    @Autowired
    public UserAccountServiceImpl(@Qualifier("userAccountDAO") UserAccountDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public UserAccount createOrUpdate(User user, UserAccount userAccount) {
        return userDAO.createOrUpdate(user, userAccount);
    }

    @Override
    public void remove(UserAccount userAccount) {
        userDAO.delete(userAccount);

    }

    @Override
    public UserAccount getById(long id) {
        return userDAO.get(id);
    }

    @Override
    public UserAccount getUserAccountByUser(User user) {
        return userDAO.get(user);
    }

    @Override
    public List<UserAccount> getAll() {
        return userDAO.getAll();
    }
}
