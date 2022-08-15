package xyz.epoch.wallettracker.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import xyz.epoch.wallettracker.Model.WalletDTO;
import xyz.epoch.wallettracker.Utils.WalletRowMapper;

import java.util.List;

@Repository
public class WalletDAOImpl implements IWalletDAO {


    @Autowired
    private JdbcTemplate jdbcTemplate ;

    @Override
    public int AddWalletToWatchlist(WalletDTO walletDTO) {
        String sql = "INSERT INTO wallets" +
                "(walletAddress, ensName, chain, userId, onWatchlist, trackedBlockNo)" +
                "VALUES (?,?,?,?,?,?)";

        Object [] args = {walletDTO.getAddress() , walletDTO.getENS_name() ,
                walletDTO.getChain(),walletDTO.getUserId() , walletDTO.getOnWatchList() , walletDTO.getTrackedBlockNo()};

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
    public int RemoveWalletFromWatchlist(int WalletID) {
        return 0;
    }

    @Override
    public int updateWalletDetails(WalletDTO walletDTO) {
        String sql = "UPDATE wallets SET  walletAddress = ? ," +
                " ensName = ?  ," +
                "chain = ?  ," +
                "userId = ?  ," +
                "onWatchlist = ?  ," +
                "trackedBlockNo = ?  WHERE wid = ? ; " ;


        Object [] args = {walletDTO.getAddress() , walletDTO.getENS_name() , walletDTO.getChain(),
                walletDTO.getUserId() , walletDTO.getOnWatchList() , walletDTO.getTrackedBlockNo(),
                 walletDTO.getWalletId()};

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
    public int getTrackedBlockNo(int WalletID) {
        return 0;
    }

    @Override
    public List<WalletDTO> getWalletById(int id) {
        String sql = "select * from wallets where wid = ?";

        Object [] args = {id};

        List<WalletDTO> wallets = null;
        try{

            wallets = jdbcTemplate.query(sql ,new WalletRowMapper() ,args );

        }   catch (Exception ex)
        {
            ex.getMessage();
        }

        return  wallets ;
    }

    @Override
    public List<WalletDTO> getWalletByAddressUserEmail(WalletDTO walletDTO) {
       String sql = "select * from wallets where walletAddress = ? and userId = ?";
        Object [] args = {walletDTO.getAddress() , walletDTO.getUserId()};

        List<WalletDTO> wallets = null;
        try{

            wallets = jdbcTemplate.query(sql ,new WalletRowMapper() ,args );

        }   catch (Exception ex)
        {
            ex.getMessage();
        }

        return  wallets ;

    }

    @Override
    public List<WalletDTO> getAllTrackedWallets() {
        String sql = "select * from wallets where onWatchlist = 1";


        List<WalletDTO> wallets = null;
        try{

            wallets = jdbcTemplate.query(sql ,new WalletRowMapper() );

        }   catch (Exception ex)
        {
            ex.getMessage();
        }

        return  wallets ;
    }


}
