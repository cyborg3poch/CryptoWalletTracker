package xyz.epoch.wallettracker.DAO;

import xyz.epoch.wallettracker.Model.UserDTO;

import java.util.List;

public interface IUserDAO {
    int AddUser(UserDTO userDTO);

    int UpdateUser(UserDTO userDTO);
    List<UserDTO> getUser(int id );
    List<UserDTO>  getAllUser();

    List<UserDTO> getUserByemail(String email);


}
