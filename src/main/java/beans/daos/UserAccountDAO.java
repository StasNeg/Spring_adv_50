package beans.daos;

import beans.models.User;
import beans.models.UserAccount;

import java.util.List;
import java.util.Objects;

/**
 * Created with IntelliJ IDEA.
 * User: Dmytro_Babichev
 * Date: 2/2/2016
 * Time: 11:38 AM
 */
public interface UserAccountDAO {

    UserAccount createOrUpdate(User user, UserAccount userAcount);

    void delete(UserAccount userAccount);

    UserAccount get(long id);

    UserAccount get(User user);

    List<UserAccount> getAll();

    static void validateUser(User user) {
        if (Objects.isNull(user)) {
            throw new NullPointerException("User is [null]");
        }
        if (Objects.isNull(user.getEmail())) {
            throw new NullPointerException("User email is [null]");
        }
    }

    static void validateUserAccount(UserAccount userAccount) {
        if (Objects.isNull(userAccount)) {
            throw new NullPointerException("UserAccount is [null]");
        }
    }
}
