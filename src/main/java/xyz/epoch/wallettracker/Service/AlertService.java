package xyz.epoch.wallettracker.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.epoch.wallettracker.DAO.AlertDAOImpl;
import xyz.epoch.wallettracker.Model.AlertDTO;
import xyz.epoch.wallettracker.Model.TransactionDTO;
import xyz.epoch.wallettracker.Model.WalletDTO;
import xyz.epoch.wallettracker.error.NoNewTransactionException;

import java.util.ArrayList;
import java.util.List;

@Service
public class AlertService {

    @Autowired
    AlertDAOImpl alertDAOImpl ;
    public List<AlertDTO> getAllAlertsForWallet(List<TransactionDTO> transactionDTOS , WalletDTO wallet)
    {
        List<AlertDTO> alerts = new ArrayList<AlertDTO>();
        if(transactionDTOS.size() > 0)
        {
            for (TransactionDTO txn: transactionDTOS)
            {
                AlertDTO alert = new AlertDTO();
                alert.setUserID(wallet.getUserId());
                alert.setMessage(" New txn alert from Wallet "+txn.getFrom()+" to " + txn.getTo() + " Value " + txn.getValue() +" on "+ wallet.getChain());
                alerts.add(alert);
            }
            return alerts;
        }else throw new NoNewTransactionException("No new alerts as there are no transactions");

    }

    public void SaveAllAlerts(List<AlertDTO> alertDTOS)
    {
        for (AlertDTO alert: alertDTOS)
        {
            alertDAOImpl.AddAlert(alert);
        }
    }

}
