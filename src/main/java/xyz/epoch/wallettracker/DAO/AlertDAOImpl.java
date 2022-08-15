package xyz.epoch.wallettracker.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import xyz.epoch.wallettracker.Model.AlertDTO;

import java.util.List;

@Repository
public class AlertDAOImpl implements IAlertDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate ;

    @Override
    public int AddAlert(AlertDTO alertDTO) {
        String sql = "INSERT INTO alerts" +
                "(isExpired, message, userId)" +
                "VALUES (?,?,?)";

        Object [] args = {alertDTO.isExpired() ,alertDTO.getMessage(),alertDTO.getUserID()};

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
    public int DeleteAlerts() {
        return 0;
    }

    @Override
    public List<AlertDTO> getAllAlerts() {
        return null;
    }
}
