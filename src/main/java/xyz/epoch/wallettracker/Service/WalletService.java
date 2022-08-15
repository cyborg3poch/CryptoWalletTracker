package xyz.epoch.wallettracker.Service;

import org.apache.taglibs.standard.tag.common.xml.ParseSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.epoch.wallettracker.APIClient.RestClientService;
import xyz.epoch.wallettracker.DAO.WalletDAOImpl;
import xyz.epoch.wallettracker.Model.WalletDTO;
import xyz.epoch.wallettracker.error.WalletAlreadyOnWatchlistException;

import java.util.List;

@Service
public class WalletService {

    @Autowired
    WalletDAOImpl walletDAOimpl ;

    @Autowired
    RestClientService restClientService;

    public int AddNewWalletToWatchlist(WalletDTO walletDTO) throws WalletAlreadyOnWatchlistException
    {
        if(walletDAOimpl.getWalletByAddressUserEmail(walletDTO).size()>0)
        {
            throw  new WalletAlreadyOnWatchlistException("Wallet is already being tracked!");
        }

     return  walletDAOimpl.AddWalletToWatchlist(walletDTO);
    }

    public List<WalletDTO> GetAllWallets()
    {
    return walletDAOimpl.getAllTrackedWallets();
    }

    public int UpdateTrackedBlockNo(WalletDTO walletDTO , long trackedBlockNo)
    {
        walletDTO.setTrackedBlockNo(trackedBlockNo);
       return walletDAOimpl.updateWalletDetails(walletDTO);
    }


    public long getLatestBlockNo(WalletDTO walletDTO)
    {
        String blockNo = restClientService.getCurrentBlockNumber(walletDTO.getChain());
        return Integer.parseInt(blockNo);
    }

}
