package bean;

import java.util.Date;

public class User {
    private int id;
    private String name;
    private String password;
    private Date createTime;
    private String email;
    private String phone;

    public User(String name, String password, Date createTime,String email,String phone) {
        this.name = name;
        this.password = password;
        this.createTime = createTime;
        this.email=email;
        this.phone=phone;
    }
    public User(String name, String password, String email,String phone) {
        this.name = name;
        this.password = password;
        this.email=email;
        this.phone=phone;
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


    public User() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", createTime=" + createTime +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
