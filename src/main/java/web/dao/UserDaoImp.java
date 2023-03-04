package web.dao;

import web.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

   @Autowired
   private SessionFactory sessionFactory;

   @Override
   public void add(User user) {
      sessionFactory.getCurrentSession().save(user);
   }

   @Override
   public User userById(Long id) {
      TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User where id = :id");
      query.setParameter("id",id);
      return query.getSingleResult();
   }

   @Override
   @SuppressWarnings("unchecked")
   public List<User> listUsers() {
      TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User");
      return query.getResultList();
   }

   @Override
   public void update(Long id, User user) {
      Query query = sessionFactory.getCurrentSession().
              createQuery("update User set firstName = :nameParam, lastName = :lastNameParam," +
              "email = :emailParam where id = :idParam");
      query.setParameter("nameParam",user.getFirstName());
      query.setParameter("lastNameParam",user.getLastName());
      query.setParameter("emailParam",user.getEmail());
      query.setParameter("idParam",id);
      int result = query.executeUpdate();
   }

}
