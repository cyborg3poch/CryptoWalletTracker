package xyz.epoch.wallettracker.Utils;

import org.springframework.jdbc.core.RowMapper;
import xyz.epoch.wallettracker.Model.UserDTO;
import xyz.epoch.wallettracker.Model.WalletDTO;

import java.sql.ResultSet;
import java.sql.SQLException;

public class WalletRowMapper implements RowMapper<WalletDTO> {
    @Override
    public WalletDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
        WalletDTO walletDTO = new WalletDTO();


        walletDTO.setWalletId(rs.getInt("wid"));
        walletDTO.setAddress(rs.getString("walletAddress"));
        walletDTO.setENS_name(rs.getString("ensName"));
        walletDTO.setChain(rs.getString("chain"));
        walletDTO.setUserId(rs.getInt("userId"));
        walletDTO.setOnWatchList(rs.getBoolean("onWatchlist"));
        walletDTO.setTrackedBlockNo(rs.getInt("trackedBlockNo"));

        return walletDTO;
    }
}
