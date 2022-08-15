package xyz.epoch.wallettracker.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import xyz.epoch.wallettracker.APIClient.RestClientService;
import xyz.epoch.wallettracker.Model.UserDTO;
import xyz.epoch.wallettracker.Model.WalletDTO;
import xyz.epoch.wallettracker.Service.WalletService;
import xyz.epoch.wallettracker.error.WalletAlreadyOnWatchlistException;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@Controller
public class WalletController extends BaseController {


    @Autowired
    WalletService walletService;

    @Autowired
    RestClientService restClientService;

    @GetMapping("/addWallet")
    public String AddWallet(@ModelAttribute("walletDto") WalletDTO walletDTO , BindingResult result)
    {
    return  "addWallet";
    }

    @PostMapping("/track-wallet")
    public String AddWalletToWatchlist(Principal principal , @ModelAttribute("walletDto") @Valid WalletDTO walletDTO , BindingResult result)
    {
        if(!result.hasErrors())
        {
            try
            {
                List<UserDTO> users = userService.getUserByEmail(principal.getName());
                walletDTO.setUserId(users.get(0).getId());
                walletDTO.setOnWatchList(true);
                walletDTO.setTrackedBlockNo(Integer.parseInt(restClientService.getCurrentBlockNumber(walletDTO.getChain())));
                walletService.AddNewWalletToWatchlist(walletDTO);
            }
            catch (WalletAlreadyOnWatchlistException ex )
            {
                return  "redirect:addWallet?ExistingWallet";
            }
            catch (RuntimeException exception)
            {
                return  "redirect:addWallet?RuntimeError";
            }

        }

        return "addWallet";

    }

}
