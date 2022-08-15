package xyz.epoch.wallettracker.Controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import xyz.epoch.wallettracker.Service.UserService;

import java.security.Principal;

@Controller
public class BaseController {

    @Autowired
    UserService userService ;


}
