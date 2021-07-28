package web.controller;

import DAO.UserDAOImpl;
import entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

//@Controller
//public class UsersController {
//    @Autowired
//    UserDAOImpl userDAO;
//
//    @GetMapping(value = "/users")
//    public String saveUser() {
//      userDAO.saveUser(new User("гена", "иванов"));
//       return "users";
//    }
//}
