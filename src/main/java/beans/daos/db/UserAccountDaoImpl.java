package beans.daos.db;

import beans.daos.AbstractDAO;
import beans.daos.UserAccountDAO;
import beans.models.User;
import beans.models.UserAccount;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value = "userAccountDAO")
public class UserAccountDaoImpl extends AbstractDAO implements UserAccountDAO {


    @Override
    public UserAccount createOrUpdate(User user, UserAccount userAccount) {
        UserAccountDAO.validateUser(user);
        UserAccountDAO.validateUserAccount(userAccount);
        UserAccount current = get(user);
        if (current == null) {
            userAccount.setUser(user);
            userAccount.withId((Long) getCurrentSession().save(userAccount));
        } else if(userAccount.getId() == current.getId()){
            getCurrentSession().merge(userAccount);
        } else
            throw new NullPointerException(String.format("Can't create or edit userAccount with id = %s and userId %s",userAccount.getId(),user.getId()));
        return userAccount;
    }

    @Override
    public void delete(UserAccount userAccount) {
        UserAccountDAO.validateUserAccount(userAccount);
        getCurrentSession().delete(userAccount);
    }

    @Override
    public UserAccount get(long id) {
        return getCurrentSession().get(UserAccount.class, id);
    }

    @Override
    public UserAccount get(User user) {
        Query query = getCurrentSession().createQuery("select ua from UserAccount ua where ua.user = :user");
        query.setParameter("user", user);
        return (UserAccount) query.uniqueResult();
    }

    @Override
    public List<UserAccount> getAll() {
        return ((List<UserAccount>) createBlankCriteria(UserAccount.class).list());
    }
}
