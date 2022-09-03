package dao.impl;

import bean.Room;
import bean.User;
import dao.RoomDao;
import util.Dbutil;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RoomDaoImpl  implements RoomDao {
    public static void main(String[] args) {
       // new RoomDaoImpl().update(1802,"hao","123456");
        //new RoomDaoImpl().deleteByroomnum(1802);
       // System.out.println(new RoomDaoImpl().findByroomnum(1801).toString());
        //new RoomDaoImpl().updateBytype("情侣间","guo","123456");
        //System.out.println(new RoomDaoImpl().findBytype("情侣间").toString());
        //System.out.println(new RoomDaoImpl().findByusername("shaw"));
       /* List<Room> list=new RoomDaoImpl().queryAllByNP("shaw","123456");
        Room room = list.get(1);
        System.out.println(room);*/
        /*for (Room r:list
             ) {
            System.out.println(r);
        }*/

       // new RoomDaoImpl().updateByPrice(1801,"双人标间",299);
       // System.out.println(new RoomDaoImpl().findprice("双人标间"));
        /*Room r = new RoomDaoImpl().findBytype("情侣间");
        if (r.getName().equals("")){
        System.out.println("you房间");}else {
            System.out.println("no");
        }*/
        /*Room room=new RoomDaoImpl().findBytype("情侣间");

        System.out.println(room.getUsername());*/
        //new  RoomDaoImpl().roomout(1802,"shaw","123456");
       // new RoomDaoImpl().roomout(1802,"shaw","123456");
        for (Room r:new  RoomDaoImpl().lookroom()
             ) {
            System.out.println(r);
        }



    }

    /**
     * 通过房间号、用户名、密码去更新数据
     * @since: jdk8
     * @param: [roomnum, username, password]
     * @return: void
     * @author: Shaw
     * @date: 2022/8/24
     */
    @Override
    public void update(int roomnum,String username, String password) {
        Connection conn=null;
        PreparedStatement ps=null;
        String sql="update h_room set username=? , password=? where roomnum=?";
        try {
             conn = Dbutil.getConnection();
             ps = conn.prepareStatement(sql);
            System.out.println(sql);
            ps.setString(1,username);
            ps.setString(2,password);
            ps.setInt(3,roomnum);
            //System.out.println("修改成功(*￣︶￣)");
            ps.executeUpdate();
            System.out.println("修改成功(*￣︶￣)");
            Dbutil.closeAll(null,ps,conn);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    /**
     * 通过房间号删除信息
     * @since: jdk8
     * @param: [roomnum]
     * @return: void
     * @author: Shaw
     * @date: 2022/8/24
     */
    @Override
    public void deleteByroomnum(int roomnum) {
        String sql="delete from h_room where roomnum=?";
        try {
            Connection conn = Dbutil.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,roomnum);
            ps.execute();
            Dbutil.closeAll(null,ps,conn);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * 通过房间号查询room对象
     * @since: jdk8
     * @param: [roomnum]
     * @return: bean.Room
     * @author: Shaw
     * @date: 2022/8/24
     */
    @Override
    public Room findByroomnum(int roomnum) {
        Room room=null;
        try {
            Connection conn = Dbutil.getConnection();

            String sql="select * from h_room where roomnum=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,roomnum);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                //创建对象
                room = new Room();
                //注入数据
               room.setRoomnum(rs.getInt(1));
               room.setName(rs.getString(2));
               room.setPassword(rs.getString(3));
               room.setType(rs.getString(4));
               room.setPrice(rs.getInt(5));

            }
            Dbutil.closeAll(rs, ps, conn);

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return room;
    }

    /**
     * 方法描述
     * @since: 通过[type, username, password]去更新数据
     * @param: [type, username, password]
     * @return: void
     * @author: Shaw
     * @date: 2022/8/24
     */
    @Override
    public void updateBytype(String type,String username,String password) {
        Connection conn=null;
        PreparedStatement ps=null;
        String sql="update h_room set username=? , password=? where type=?";
        try {
            conn = Dbutil.getConnection();
            ps = conn.prepareStatement(sql);
            System.out.println(sql);
            ps.setString(1,username);
            ps.setString(2,password);
            ps.setString(3,type);
            //System.out.println("修改成功(*￣︶￣)");
            ps.executeUpdate();
            System.out.println("修改成功(*￣︶￣)");
            Dbutil.closeAll(null,ps,conn);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    /**通过类型去查询数据
     * 方法描述
     * @since: jdk8
     * @param: [type]
     * @return: bean.Room
     * @author: Shaw
     * @date: 2022/8/24
     */
    @Override
    public Room findBytype(String type) {
        Room room=null;
        Connection conn=null;
        PreparedStatement ps=null;
        String sql="select * from h_room where type=?";
        try {
            conn = Dbutil.getConnection();
            ps=conn.prepareStatement(sql);
            ps.setString(1,type);
            ResultSet rs=ps.executeQuery();

            if(rs.next()) {
                room = new Room();
                //注入数据
                room.setRoomnum(rs.getInt(1));
                room.setName(rs.getString(2));
                room.setPassword(rs.getString(3));
                room.setType(rs.getString(4));

            }
            Dbutil.closeAll(rs, ps, conn);

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return room;
    }
/**
 * 通过用户名去查询数据
 * @since: jdk8
 * @param: [username]
 * @return: java.util.List
 * @author: Shaw
 * @date: 2022/8/24
 */
    @Override
    public List findByusername(String username) {
        List roomList = new ArrayList<>();
        Connection conn=null;
        PreparedStatement ps=null;
        String sql="select roomnum from h_room where username=?";
        try {
             conn = Dbutil.getConnection();
             ps=conn.prepareStatement(sql);
             ps.setString(1,username);
            ResultSet rs = ps.executeQuery();
           while ( rs.next()){

                String s=rs.getString(1);
                roomList.add(s);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return roomList;
    }
/**
 * 通过[username, password]去查询返回集合
 * @since: jdk8
 * @param: [username, password]
 * @return: java.util.List<bean.Room>
 * @author: Shaw
 * @date: 2022/8/24
 */
    @Override
    public List<Room> queryAllByNP(String username, String password) {
        List<Room> roomList=new ArrayList<>();
        String sql = "select * from h_room where username=? and password=? ";

        try {
            Connection conn = Dbutil.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,username);
            ps.setString(2,password);
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                Room room=new Room();
                room.setRoomnum(rs.getInt(1));
                room.setUsername(rs.getString(2));
                room.setPassword(rs.getString(3));
                room.setType(rs.getString(4));
                room.setPrice(rs.getInt(5));
                roomList.add(room);
            }
        } catch (SQLException e) {

        } catch (IOException e) {
            e.printStackTrace();
        }

        return roomList;
    }
    /**
     * 通过[roomnum, type, price]更新数据
     * @since: jdk8
     * @param: [roomnum, type, price]
     * @return: void
     * @author: Shaw
     * @date: 2022/8/24
     */

    @Override
    public void updateByPrice(int roomnum, String type,int price) {
        Connection conn=null;
        PreparedStatement ps=null;
        String sql="update h_room set price=? where roomnum=? and type=? ";
        try {
            conn = Dbutil.getConnection();
        ps = conn.prepareStatement(sql);
        System.out.println(sql);
        ps.setInt(2,roomnum);
        ps.setString(3,type);
        ps.setInt(1,price);
        ps.executeUpdate();
        Dbutil.closeAll(null,ps,conn);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    /**
     * 通过类型查询数据
     * @since: jdk8
     * @param: [type]
     * @return: int
     * @author: Shaw
     * @date: 2022/8/24
     */

    @Override
    public int findprice(String type) {
        int price=0;
        String sql="select price from h_room where type=?";
        Connection conn=null;
        PreparedStatement ps=null;
        try {
            conn=Dbutil.getConnection();
            ps=conn.prepareStatement(sql);
            ps.setString(1,type);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                price=rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return price;
    }
/**
 * 通过[roomnum, username, password]退房
 * @since: jdk8
 * @param: [roomnum, username, password]
 * @return: void
 * @author: Shaw
 * @date: 2022/8/24
 */
    @Override
    public void roomout(int roomnum, String username, String password) {
     String sql="update h_room set username='未预订' ,password='' where roomnum=? and username=? and password=? ";
        Connection conn=null;
        PreparedStatement ps=null;

        try {
            conn=Dbutil.getConnection();
            ps=conn.prepareStatement(sql);
            ps.setInt(1,roomnum);
            ps.setString(2,username);
            ps.setString(3,password);

            ps.executeUpdate();
            Dbutil.closeAll(null,ps,conn);

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
/**
 * 查询所有
 * @since: jdk8
 * @param: []
 * @return: java.util.List<bean.Room>
 * @author: Shaw
 * @date: 2022/8/24
 */
    @Override
    public List<Room> queryAll() {
        List<Room> roomList = new ArrayList<>();
        String sql = "select * from h_room ";
        try {
            Connection conn = Dbutil.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                //创建对象
                Room room=new Room();
                //注入数据
                room.setRoomnum(rs.getInt("roomnum"));
                room.setUsername(rs.getString("username"));
                room.setPassword(rs.getString("password"));
                room.setType(rs.getString("type"));
                room.setPrice(rs.getInt("price"));
                roomList.add(room);
            }
            Dbutil.closeAll(rs, ps, conn);

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return roomList;
    }

    /**
     * 修改房间状态
     * @since: jdk8
     * @param: [roomnum]
     * @return: void
     * @author: Shaw
     * @date: 2022/8/24
     */
    @Override
    public void cancelbook(int roomnum) {
        String sql="update h_room set username='未预订',password='' where roomnum=?";
                //String sql="update h_user set password=?,email=?,phone=? where id=?";
        try {
            Connection conn = Dbutil.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,roomnum);
            ps.executeUpdate();
            Dbutil.closeAll(null,ps,conn);

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    @Override
    public List<Room> lookroom() {
        List<Room> roomList = new ArrayList<>();
        String sql = "select roomnum,type,price from h_room where username='未预订' ";

        Connection conn = null;
        try {
            conn = Dbutil.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        while (rs.next()){
            //创建对象
            Room room=new Room();

            //注入数据
            room.setRoomnum(rs.getInt("roomnum"));
           // room.setUsername(rs.getString("username"));
            room.setType(rs.getString("type"));
            room.setPrice(rs.getInt("price"));
            roomList.add(room);
        }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }



        return roomList;
    }


}
