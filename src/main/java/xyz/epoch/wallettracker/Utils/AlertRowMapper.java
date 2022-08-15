package xyz.epoch.wallettracker.Utils;

import org.springframework.jdbc.core.RowMapper;
import xyz.epoch.wallettracker.Model.AlertDTO;
import xyz.epoch.wallettracker.Model.UserDTO;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AlertRowMapper implements RowMapper<AlertDTO> {
    @Override
    public AlertDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
        AlertDTO alertDTO = new AlertDTO();

        alertDTO.setId(rs.getInt("aid"));
        alertDTO.setExpired(rs.getBoolean("isExpired"));
        alertDTO.setMessage(rs.getString("message"));
        alertDTO.setUserID(rs.getInt("userId"));


        return alertDTO;
    }
}
