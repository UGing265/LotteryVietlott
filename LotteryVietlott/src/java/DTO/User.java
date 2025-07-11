package DTO;

import java.time.LocalDateTime;

/**
 *
 * @author HP
 */
public class User {
    private String userID;
    private String userName;
    private String password;
    private LocalDateTime registerAt;

    public User(String userID, String userName, String password, LocalDateTime registerAt) {
        this.userID = userID;
        this.userName = userName;
        this.password = password;
        this.registerAt = registerAt;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getRegisterAt() {
        return registerAt;
    }

    public void setRegisterAt(LocalDateTime registerAt) {
        this.registerAt = registerAt;
    }

    
    
}
