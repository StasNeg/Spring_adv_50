package beans.services;

import beans.models.User;
import beans.models.UserAccount;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Dmytro_Babichev
 * Date: 2/3/2016
 * Time: 11:22 AM
 */
public interface UserAccountService {

    UserAccount createOrUpdate(User user, UserAccount userAccount);

    void remove(UserAccount userAccount);

    UserAccount getById(long id);

    UserAccount getUserAccountByUser(User user);

    List<UserAccount> getAll();
}
