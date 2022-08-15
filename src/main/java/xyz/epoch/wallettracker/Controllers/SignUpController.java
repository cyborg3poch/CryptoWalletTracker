package xyz.epoch.wallettracker.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import xyz.epoch.wallettracker.Model.UserDTO;
import xyz.epoch.wallettracker.error.UserAlreadyExistException;

import javax.validation.Valid;

@Controller
public class SignUpController extends BaseController {



    @GetMapping("/signup")
    public String SignUp(@ModelAttribute("UserReg")UserDTO userDTO )
    {
        return "signup";
    }

    @PostMapping("/signup-process")
    public String ProcessSignup(@Valid @ModelAttribute("UserReg")UserDTO userDTO , BindingResult result)
    {

        if (!result.hasErrors()) {
            try {
                if (userService.RegisterUser(userDTO) > 0) {
                    return "redirect:login?RegisterSuccess";
                }
            }
            catch (UserAlreadyExistException ex)
            {
                return "redirect:login?emailAlreadyExists";
            }
            catch (RuntimeException ex )
            {
                return "redirect:login?registrationError";

            }

        }
        return "signup";


    }
}
