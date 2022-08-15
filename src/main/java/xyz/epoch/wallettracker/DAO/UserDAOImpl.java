package xyz.epoch.wallettracker.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import xyz.epoch.wallettracker.Model.UserDTO;
import xyz.epoch.wallettracker.Utils.UserRowMapper;
import xyz.epoch.wallettracker.error.UserAlreadyExistException;

import java.util.List;

@Repository
public class UserDAOImpl implements IUserDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate ;


    @Override
    public int AddUser(UserDTO userDTO) {


        String sql = "INSERT INTO users" +
                "(password , email , phone , enabled , role ,firstname , lastname)" +
                "VALUES (?,?,?,?,?,?,?)";

        Object [] args = {userDTO.getPassword() , userDTO.getEmail() ,
                userDTO.getPhone(),1, userDTO.getRole(),userDTO.getFirstname(),userDTO.getLastname()};

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
    public int UpdateUser(UserDTO userDTO) {
        return 0;
    }

    @Override
    public List<UserDTO> getUser(int id) {
        return null;
    }

    @Override
    public List<UserDTO> getAllUser() {
        String ssql = "select * from users";

        List<UserDTO> users = null;
        try{

          users =   jdbcTemplate.query(ssql , new UserRowMapper());

        }   catch (Exception ex)
        {
            ex.getMessage();
        }

        return  users ;
    }

    @Override
    public List<UserDTO> getUserByemail(String email) {

        String ssql = "select * from users where email = ?";

        Object [] args = {email};

        List<UserDTO> users = null;
        try{

            users = jdbcTemplate.query(ssql ,new UserRowMapper() ,args );

        }   catch (Exception ex)
        {
            ex.getMessage();
        }

        return  users ;
    }


}
