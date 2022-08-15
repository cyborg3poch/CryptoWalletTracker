package xyz.epoch.wallettracker.authProviders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import xyz.epoch.wallettracker.DAO.UserDAOImpl;
import xyz.epoch.wallettracker.Model.UserDTO;

import java.util.ArrayList;
import java.util.List;

@Component
public class CustomFormAuthProvider implements AuthenticationProvider {


    @Autowired
    UserDAOImpl userDAOimpl ;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
       String email = authentication.getPrincipal().toString();
       String password= authentication.getCredentials().toString();

        List<UserDTO> user = userDAOimpl.getUserByemail(email);
        if(user.size()>0)
        {
            boolean passwordMatch = passwordEncoder.matches(password,user.get(0).getPassword());

            if(!passwordMatch)
            {
                throw new BadCredentialsException("Invalid username/ password");
            }

            String role = user.get(0).getRole();

            ArrayList<GrantedAuthority> authorityArrayList = new ArrayList<GrantedAuthority>();
            SimpleGrantedAuthority userRoles = new SimpleGrantedAuthority(role);

            return new UsernamePasswordAuthenticationToken(email,password,authorityArrayList);
        }
        else
        {
            throw new AuthenticationCredentialsNotFoundException("Account not found ! Try registering!!");
        }


    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
