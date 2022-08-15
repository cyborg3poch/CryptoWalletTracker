package xyz.epoch.wallettracker.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseBody;
import xyz.epoch.wallettracker.Model.WalletDTO;

import javax.validation.Valid;
import java.security.Principal;

@Controller
public class HomeController extends BaseController {


    @GetMapping({"/dashboard"})
    public String dashboard(Principal principal , @ModelAttribute("walletDto") WalletDTO walletDTO , BindingResult result)
    {
       return "dashboard";
    }

    @GetMapping({"/"})
    public String index()
    {
        return "redirect:dashboard";
    }



}
