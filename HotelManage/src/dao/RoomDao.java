package dao;

import bean.Room;

import java.util.List;

public interface RoomDao {
    void update(int roomnum,String username,String password);
    void deleteByroomnum(int roomnum);
    Room findByroomnum(int roomnum);
    void updateBytype(String type,String username,String password);
    Room findBytype(String type);
    List findByusername(String username);
    List<Room> queryAllByNP(String username,String password);

    void updateByPrice(int roomnum,String type,int price);

    int findprice(String type);

    void roomout(int roomnum,String username,String password);
    List<Room> queryAll();
    void cancelbook(int roomnum);

    List<Room> lookroom();


}
