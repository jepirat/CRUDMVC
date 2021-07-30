package hiber.DAO;

import hiber.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {
    @Autowired
    EntityManager entityManager;

    public UserDAOImpl() {
    }

    @Override
    public User getUser() {
        return null;
    }

    @Override
    public List<User> getAllUsers() {
        return null;
    }

   @Transactional
   @Override
   public void saveUser(User user) {
      entityManager.persist(user);
    }


}
