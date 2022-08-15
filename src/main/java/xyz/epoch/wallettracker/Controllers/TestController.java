package xyz.epoch.wallettracker.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;
import xyz.epoch.wallettracker.APIClient.RestClientService;

@Controller
public class TestController {

    @Autowired
    private RestClientService restClientService ;

   // @GetMapping("/test")
    @ResponseBody
    private String testController()
    {

        String currentBlock = restClientService.getCurrentBlockNumber("ETH");

       /* TransactionDTO[] transactionDTOS =  restClientService.getWalletAccountDetails("0x687aeda127fd2bd4f374c73e3724bf9b7c7a6b9c",0 , Integer.parseInt("999999999"));

        for(int i =0; i < transactionDTOS.length;i++)
        {
            System.out.println(transactionDTOS[i]);
        }*/

        System.out.println(currentBlock);

        return "success";
    }
}
