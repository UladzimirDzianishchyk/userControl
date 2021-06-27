package com.noyna.userControl.resource;


import com.noyna.userControl.entity.User;
import com.noyna.userControl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping(path = "/new")
    public String getRegistrationPage(Model model){

        model.addAttribute("newUser", new User());
        return "new";
    }

    @PostMapping(path = "/new")
    //    @PreAuthorize("hasRole('Role_ADMIN')")
    public String postRegistrationUser(@ModelAttribute("newUser") User user) {
            userService.addUser(user);

        return "redirect:/user";

    }

    @GetMapping(path = "/login")
    public String getAuthorization(Model model){
        return "login";
    }

    @GetMapping
    public String showAll(Model model) {
        model.addAttribute("allUser", userService.getAllUser());
        return "users";
    }

    @GetMapping(path = "/{id}/edit")
    public String showUser(@PathVariable long id, Model model) {
        model.addAttribute("user", userService.findById(id));
        return "edit";
    }

    @PostMapping(path = "/{id}/edit")
    public String showUser(@ModelAttribute("user") User user) {
        userService.addUser(user);
        return "redirect:/user";
    }

}
