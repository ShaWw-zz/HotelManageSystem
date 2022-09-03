package bean;

public class Room {
    private int roomnum;
    private String username;
    private String password;
    private String type;
    private int price;

    public Room(int roomnum, String type, int price) {
        this.roomnum = roomnum;
        this.type = type;
        this.price = price;
    }

    public Room(int roomnum, String username, String type, int price) {
        this.roomnum = roomnum;
        this.username = username;
        this.type = type;
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }


    @Override
    public String toString() {
        return "Room{" +
                "roomnum=" + roomnum +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", type='" + type + '\'' +
                ", price=" + price +
                '}';
    }




    public Room(String type) {
        this.type = type;
    }

    public String getUsername() {

        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Room(String name, String password) {
        this.username = name;
        this.password = password;
    }


    public Room() {
    }

    public Room(int roomnum, String name, String password) {
        this.roomnum = roomnum;
        this.username = name;
        this.password = password;
    }

    public Room(int roomnum, String username, String password, String type, int price) {
        this.roomnum = roomnum;
        this.username = username;
        this.password = password;
        this.type = type;
        this.price = price;
    }

    /**
     * 获取
     * @return roomnum
     */
    public int getRoomnum() {
        return roomnum;
    }

    /**
     * 设置
     * @param roomnum
     */
    public void setRoomnum(int roomnum) {
        this.roomnum = roomnum;
    }

    /**
     * 获取
     * @return name
     */
    public String getName() {
        return username;
    }

    /**
     * 设置
     * @param name
     */
    public void setName(String name) {
        this.username = name;
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

}
