package hiber.controller;

import hiber.entities.User;
import hiber.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping(value = "/users")
    public String users() {
       userService.saveUser(new User("pspsp", "erse"));
       return "users";
   }
}
