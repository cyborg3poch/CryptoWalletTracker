package xyz.epoch.wallettracker.DAO;

import xyz.epoch.wallettracker.Model.WalletDTO;

import java.util.List;

public interface IWalletDAO {

int AddWalletToWatchlist(WalletDTO walletDTO);
int RemoveWalletFromWatchlist(int WalletID);
int updateWalletDetails(WalletDTO walletDTO);
int getTrackedBlockNo(int WalletID);

List<WalletDTO> getWalletById(int id);

List<WalletDTO> getWalletByAddressUserEmail(WalletDTO walletDTO);

List<WalletDTO> getAllTrackedWallets();

}
