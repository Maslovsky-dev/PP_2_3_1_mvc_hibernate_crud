package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {
   void add(User user);
   User userById(Long id);
   List<User> listUsers();
   void update(User user);
   void delete(Long id);


   }
