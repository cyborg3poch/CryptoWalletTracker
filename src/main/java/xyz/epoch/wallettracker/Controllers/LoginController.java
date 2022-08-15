package xyz.epoch.wallettracker.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import xyz.epoch.wallettracker.Model.UserDTO;

@Controller
public class LoginController {

    @GetMapping({"/login"})
    public  String login(@ModelAttribute("UserReg") UserDTO userdto)
    {
        return "login";
    }

    @RequestMapping("/login-process")
    public String  processUserLogin(@ModelAttribute("UserReg") UserDTO userdto)
    {
        return  "dashboard";
    }


}
