package xyz.epoch.wallettracker.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.epoch.wallettracker.APIClient.RestClientService;
import xyz.epoch.wallettracker.DAO.TransactionDAOImpl;
import xyz.epoch.wallettracker.Model.TransactionDTO;
import xyz.epoch.wallettracker.Model.WalletDTO;
import xyz.epoch.wallettracker.error.NoNewTransactionException;

import java.util.Arrays;
import java.util.List;

@Service
public class TxnService {

    @Autowired
    RestClientService restClientService;

    @Autowired
    TransactionDAOImpl transactionDAOImpl;

    public List<TransactionDTO> getTransactionToCurrentBlock(WalletDTO walletDTO)
    {
        TransactionDTO [] transactionDTOS = restClientService.getWalletAccountDetails(walletDTO.getAddress(),
            walletDTO.getTrackedBlockNo(),Integer.parseInt(restClientService.getCurrentBlockNumber(walletDTO.getChain())),
            walletDTO.getChain());

        if(transactionDTOS.length >0)
        {
            for (TransactionDTO transactionDTO:transactionDTOS)
            {
                transactionDTO.setWalletId(walletDTO.getWalletId());

            }
            return Arrays.asList(transactionDTOS);
        }else throw new NoNewTransactionException("No new transaction recorded");

    }

    public void SaveTransaction(List<TransactionDTO> transactionDTOS)
    {
        for (TransactionDTO txn: transactionDTOS) {
            transactionDAOImpl.SaveTransaction(txn);
        }
    }

    public List<TransactionDTO> GetAllTransactionbyWalletID(WalletDTO walletDTO)
    {
        return  transactionDAOImpl.getAllTransactionByWallet(walletDTO.getWalletId(), walletDTO.getTrackedBlockNo());
    }
}
