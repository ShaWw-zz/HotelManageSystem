package service.impl;

import bean.Room;
import dao.RoomDao;
import dao.impl.RoomDaoImpl;
import service.RoomService;

import java.util.List;

public class RoomServiceImpl implements RoomService {

    public static void main(String[] args) {

        for (Object r:new RoomDaoImpl().queryAllByNP("shaw","123456")
             ) {
            System.out.println(r);
        }
    }
    private RoomDao roomDao = new RoomDaoImpl();
    @Override
    public void update(int roomnum, String username, String password) {
        roomDao.update(roomnum,username,password);
    }


    @Override
    public Room findByroomnum(int roomnum) {
        return roomDao.findByroomnum(roomnum);
    }

    @Override
    public void updateBytype(String type, String username, String password) {
        roomDao.updateBytype(type,username,password);
    }

    @Override
    public Room findBytype(String type) {
        return roomDao.findBytype(type);
    }

    @Override
    public List<Room> findByusername(String username) {
        return roomDao.findByusername(username);
    }

    @Override
    public List<Room> queryAllByNP(String username, String password) {
        return roomDao.queryAllByNP(username,password);
    }

    @Override
    public List<Room> queryAll() {
        return roomDao.queryAll();
    }

    @Override
    public void updateByPrice(int roomnum, String type, int price) {
        roomDao.updateByPrice(roomnum,type,price);
    }

    @Override
    public int findprice(String type) {
        return roomDao.findprice(type);
    }

    @Override
    public void roomout(int roomnum, String username, String password) {
        roomDao.roomout(roomnum,username,password);
    }

    @Override
    public void cancelbook(int roomnum) {
        roomDao.cancelbook(roomnum);
    }


}
