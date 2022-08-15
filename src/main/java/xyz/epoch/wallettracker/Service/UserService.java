package xyz.epoch.wallettracker.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import xyz.epoch.wallettracker.DAO.UserDAOImpl;
import xyz.epoch.wallettracker.Model.UserDTO;
import xyz.epoch.wallettracker.error.UserAlreadyExistException;
import xyz.epoch.wallettracker.error.UserNotFoundException;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserDAOImpl userDAOimpl ;

    @Autowired
    PasswordEncoder passwordEncoder;

    public int RegisterUser(UserDTO userDTO) throws UserAlreadyExistException
    {
        if(userDAOimpl.getUserByemail(userDTO.getEmail()).size() >0)
        {
            throw new UserAlreadyExistException("This email is already is use by other user");
        }

        userDTO.setRole("USER");
        userDTO.setPassword(passwordEncoder.encode(userDTO.getPassword()));


        return userDAOimpl.AddUser(userDTO);
    }

    public  List<UserDTO> getUserByEmail(String email) throws UserNotFoundException
    {

        if(userDAOimpl.getUserByemail(email).size()>0)
        {
            return userDAOimpl.getUserByemail(email);
        }else
        {
            throw new UserNotFoundException("User not found");
        }
    }



}
