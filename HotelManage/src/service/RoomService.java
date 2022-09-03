package service;

import bean.Room;

import java.util.List;

public interface RoomService {
    void update(int roomnum,String username,String password);
    //void deleteByroomnum(int roomnum);
    Room findByroomnum(int roomnum);
    void updateBytype(String type,String username,String password);
    Room findBytype(String type);
    List<Room> findByusername(String username);
    List<Room> queryAllByNP(String username,String password);
    List<Room> queryAll();

    void updateByPrice(int roomnum,String type,int price);
    int findprice(String type);
    void roomout(int roomnum,String username,String password);

    void cancelbook(int roomnum);
}
