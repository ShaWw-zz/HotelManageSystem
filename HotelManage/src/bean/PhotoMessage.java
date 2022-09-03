package bean;

import java.sql.Blob;

public class PhotoMessage  {
private String photo;
private String username;
private  String password;

    public PhotoMessage() {
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public PhotoMessage(String photo, String username, String password) {
        this.photo = photo;
        this.username = username;
        this.password = password;

    }



    /**
     * 获取
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 获取
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    public String toString() {
        return "PhotoMessage{photo = " + photo + ", username = " + username + ", password = " + password + "}";
    }
}
