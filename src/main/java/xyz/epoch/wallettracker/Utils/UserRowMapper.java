package xyz.epoch.wallettracker.Utils;

import org.springframework.jdbc.core.RowMapper;
import xyz.epoch.wallettracker.Model.UserDTO;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper<UserDTO> {

    @Override
    public UserDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
        UserDTO userDTO = new UserDTO();


        userDTO.setId(rs.getInt("id"));
        userDTO.setFirstname(rs.getString("firstname"));
        userDTO.setLastname(rs.getString("lastname"));
        userDTO.setEmail(rs.getString("email"));
        userDTO.setPhone(rs.getString("phone"));
        userDTO.setPassword(rs.getString("password"));
        userDTO.setRole(rs.getString("role"));
        userDTO.setChatId(rs.getLong("chatId"));

        return userDTO;
    }
}
