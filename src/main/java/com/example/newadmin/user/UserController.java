package com.example.newadmin.user;

import com.example.newadmin.user.User;
import com.example.newadmin.user.UserNotFoundException;
import com.example.newadmin.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class UserController {



    @Autowired private UserService serv;


    @GetMapping("/admin")
    public String showUserList(Model model, String keyword){
        List<User> listUsers = serv.listAll();
        model.addAttribute("userList", listUsers);

//        if(keyword != null) {
//            model.addAttribute("findusers", serv.findbyKeyWord(keyword));
//        }
//        else{
//            model.addAttribute("findusers", serv.listAll());
//        }

        return "admin";
    }


    @GetMapping("/admin/new")

    public String addNewUser(Model model){

        model.addAttribute("user", new User());
        model.addAttribute("pageTitle","Add New User");
        return "adduser";
    }

    @PostMapping("/admin/save")
    public String saveUser(User user, RedirectAttributes ar){
        serv.save(user);
        ar.addFlashAttribute("message", " New User has been saved!");
        return "redirect:/admin";

    }

    @GetMapping("/admin/edit/{id}")
    public String showEditForm(@PathVariable("id") Integer id, Model model, RedirectAttributes ar){
        try {
            User user = serv.get(id);
            model.addAttribute("user", user);
            model.addAttribute("pageTitle","Edit User (ID  No : " + id + ")");
            return "adduser";
        } catch (UserNotFoundException e) {
            ar.addFlashAttribute("message", e.getMessage());
            return "redirect:/admin";


        }


    }
    @GetMapping("/admin/delete/{id}")
    public String deleteUser(@PathVariable("id") Integer id, RedirectAttributes ar){
        try {
            serv.delete(id);
            ar.addFlashAttribute("message", "The user ID No : " + id + " has been deleted.");
        } catch (UserNotFoundException e) {
            ar.addFlashAttribute("message", e.getMessage() );

        }
        return "redirect:/admin";
    }

}
