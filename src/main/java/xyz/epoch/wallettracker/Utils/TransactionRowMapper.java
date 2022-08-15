package xyz.epoch.wallettracker.Utils;

import org.springframework.jdbc.core.RowMapper;
import xyz.epoch.wallettracker.Model.AlertDTO;
import xyz.epoch.wallettracker.Model.TransactionDTO;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TransactionRowMapper implements RowMapper<TransactionDTO> {

    @Override
    public TransactionDTO mapRow(ResultSet rs, int rowNum) throws SQLException {

        TransactionDTO transactionDTO = new TransactionDTO();

        transactionDTO.setTid(rs.getInt("tid"));
        transactionDTO.setBlockNumber(rs.getLong("block_no"));
        transactionDTO.setWalletId(rs.getInt("walletID"));
        transactionDTO.setFrom(rs.getString("sender"));
        transactionDTO.setTo(rs.getString("reciever"));
        transactionDTO.setGas((rs.getBigDecimal("gas_used")).toBigInteger());
        transactionDTO.setHash(rs.getString("transaction_hash"));
        transactionDTO.setValue((rs.getBigDecimal("value")).toBigInteger());
        transactionDTO.setTimeStamp(rs.getLong("timestamp"));



        return transactionDTO;
    }
}
