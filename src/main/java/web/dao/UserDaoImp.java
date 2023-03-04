package web.dao;

import web.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

   @PersistenceContext
   private EntityManager entityManager;

   @Override
   public void add(User user) {
      entityManager.persist(user);
   }


   @Override
   public List<User> listUsers() {
      TypedQuery<User> query = entityManager.createQuery("from User", User.class);
      return query.getResultList();
   }
   @Override
   public User userById(Long id) {
      TypedQuery<User> query = entityManager.createQuery("from User where id = :id", User.class);
      query.setParameter("id",id);
      return query.getSingleResult();
   }
   @Override
   public void update(Long id, User user) {
      Query query = entityManager.
              createQuery("update User set firstName = :nameParam, lastName = :lastNameParam," +
              "email = :emailParam where id = :idParam");
      query.setParameter("nameParam",user.getFirstName());
      query.setParameter("lastNameParam",user.getLastName());
      query.setParameter("emailParam",user.getEmail());
      query.setParameter("idParam",id);
      query.executeUpdate();
   }

   @Override
   public void delete(Long id) {
      Query query =  entityManager.
              createQuery("delete User where id = :idParam");
      query.setParameter("idParam", id);
      query.executeUpdate();
   }

}
