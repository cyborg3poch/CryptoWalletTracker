package xyz.epoch.wallettracker.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import xyz.epoch.wallettracker.Model.AlertDTO;
import xyz.epoch.wallettracker.Model.TransactionDTO;
import xyz.epoch.wallettracker.Model.WalletDTO;
import xyz.epoch.wallettracker.error.NoNewTransactionException;

import java.util.List;

@Service
public class SchedularService {

    @Autowired
    WalletService walletService ;

    @Autowired
    TxnService txnService ;

    @Autowired
    AlertService alertService;

    @Autowired
    EmailService emailService;

    // JOB 1
    //GetAllWalletAddress every 5 min
    //Get and Save Transaction for each wallet 5 min
    // Push Transaction msg to Alert system

    @Scheduled(fixedDelay = 15000, initialDelay = 10000)
    public void PushAlertsJob()
    {
        List<WalletDTO> wallets  = walletService.GetAllWallets();

        System.out.println("Push Alerts JOB running");
        //For Each Wallet Getting list of trxns and saving alerts for them
        for (WalletDTO wallet:wallets)
        {
            try
            {

                List<TransactionDTO> transactionDTOS = txnService.getTransactionToCurrentBlock(wallet);
                txnService.SaveTransaction(transactionDTOS);
                List<TransactionDTO> savedTransactions = txnService.GetAllTransactionbyWalletID(wallet);

                walletService.UpdateTrackedBlockNo(wallet,walletService.getLatestBlockNo(wallet));

                List<AlertDTO> alerts = alertService.getAllAlertsForWallet(savedTransactions , wallet);
                alertService.SaveAllAlerts(alerts);
            }
            catch (NoNewTransactionException ex)
            {
                System.out.println("No new transaction recorded on wallet address" + wallet.getAddress());
            }
            catch (RuntimeException exception)
            {
                System.out.println("Something went wrong"+ exception.getMessage());
            }
        }
    }



    //JOB 2
    //Pull all Alerts and Send Email/telegram
    //perform delete query after last mail
    public void NotifyAlerts()
    {

    }

}
