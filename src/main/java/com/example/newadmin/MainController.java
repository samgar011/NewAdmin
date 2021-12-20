package com.example.newadmin;

import com.example.newadmin.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@Controller
class MainController {

    @GetMapping("/")
    public String SeeAdminPage(){

       return "admin";
   }

}
