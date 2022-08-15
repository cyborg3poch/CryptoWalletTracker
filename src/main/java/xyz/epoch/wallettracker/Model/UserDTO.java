package xyz.epoch.wallettracker.Model;

import xyz.epoch.wallettracker.Validation.PasswordMatches;

import javax.validation.constraints.*;
import java.util.List;


public class UserDTO  {


    private int id ;

    @NotBlank(message = "Name can't be blank")
    @NotNull(message = "Should not be null")
    private String firstname ;


    private String lastname ;


    @NotBlank(message = "password can't be blank")
    @NotNull(message = "password should not be null")
    @Size(min = 1)
    private String password ;

    @NotNull(message = "password can't be blank")
    @Size(min = 1)
    @PasswordMatches
    private String matchingPassword;

    @Email(message = "Please provide a valid email ID")
    private String email;

    @Size(min = 10, max = 17, message = "Number should have at least 10 or less than 17 digits")
    private String phone ;

    @AssertTrue(message = "Please agree to terms & Conditions")
    private boolean TosCheck ;

    private List<WalletDTO> walletWatchList ;

   private String role ;

   private long chatId ;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean getTosCheck() {
        return TosCheck;
    }

    public void setTosCheck(boolean tosCheck) {
        TosCheck = tosCheck;
    }

    public List<WalletDTO> getWalletWatchList() {
        return walletWatchList;
    }

    public void setWalletWatchList(List<WalletDTO> walletWatchList) {
        this.walletWatchList = walletWatchList;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getMatchingPassword() {
        return matchingPassword;
    }

    public void setMatchingPassword(String matchingPassword) {
        this.matchingPassword = matchingPassword;
    }

    public long getChatId() {
        return chatId;
    }

    public void setChatId(long chatId) {
        this.chatId = chatId;
    }
}
