package xyz.epoch.wallettracker.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import xyz.epoch.wallettracker.Model.TransactionDTO;
import xyz.epoch.wallettracker.Model.WalletDTO;
import xyz.epoch.wallettracker.Utils.TransactionRowMapper;
import xyz.epoch.wallettracker.Utils.WalletRowMapper;

import java.util.List;

@Repository
public class TransactionDAOImpl implements ITransactionDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate ;

    @Override
    public int SaveTransaction(TransactionDTO transactionDTO) {
        String sql = "INSERT INTO transactions" +
                "(transaction_hash, block_no, timestamp, sender, reciever, value, gas_used, walletID)" +
                "VALUES (?,?,?,?,?,?,?,?)";

        Object [] args = {transactionDTO.getHash() , transactionDTO.getBlockNumber(), transactionDTO.getTimeStamp(),
        transactionDTO.getFrom(),transactionDTO.getTo(),transactionDTO.getValue(),transactionDTO.getGas(),
            transactionDTO.getWalletId()};

        int rows = 0;
        try{
            rows = jdbcTemplate.update(sql,args);
        }
        catch (Exception ex )
        {
            throw ex ;
        }
        return rows ;
    }

    @Override
    public List<TransactionDTO> getAllTransaction() {
        return null;
    }

    @Override
    public List<TransactionDTO> getAllTransactionByWallet(int walletId ,long trackedBlockNo )
    {
        String sql = "select * from transactions where walletID = ? and block_no >= ? ";

        Object [] args = {walletId , trackedBlockNo};
        List<TransactionDTO> transactionDTOList = null;
        try{

            transactionDTOList = jdbcTemplate.query(sql ,new TransactionRowMapper() , args );

        }   catch (Exception ex)
        {
            System.out.println(ex.getMessage());

        }

        return  transactionDTOList ;
    }


}
