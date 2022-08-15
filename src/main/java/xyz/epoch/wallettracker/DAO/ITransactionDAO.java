package xyz.epoch.wallettracker.DAO;

import xyz.epoch.wallettracker.Model.TransactionDTO;

import java.util.List;

public interface ITransactionDAO {

     int SaveTransaction(TransactionDTO transactionDTO);
     List<TransactionDTO> getAllTransaction();
     List<TransactionDTO> getAllTransactionByWallet(int walletId,long trackedBlockNo);

}
