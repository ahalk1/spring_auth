package edu.rit.auth.data;

public class Users {
    private String userId;
    private String username;
    private String userEmail;
    private String userPassword;
    private UserType type;
    private String[] userPermissions;

    public Users() {
    }
    public Users(String userId, String username, String userEmail, String userPassword, UserType type, String[] userPermissions ) {
        this.userId = userId;
        this.username = username;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.type = type;
        this.userPermissions = userPermissions;
    }
    public String getUserId() { return userId;}

    public void setUserId(String userId) { this.userId = userId;}

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public UserType getType() {
        return type;
    }

    public void setType(UserType type) {
        this.type = type;
    }

    public String[] getUserPermissions() {
        return userPermissions;
    }

    public void setUserPermissions(String[] userPermissions) {
        this.userPermissions = userPermissions;
    }
}
