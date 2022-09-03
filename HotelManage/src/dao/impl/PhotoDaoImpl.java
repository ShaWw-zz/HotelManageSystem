package dao.impl;

import bean.PhotoMessage;
import bean.User;
import dao.PhotoDao;
import util.Dbutil;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PhotoDaoImpl implements PhotoDao {

    public static void main(String[] args) {

        /*for (Object s:new PhotoDaoImpl().findAllpath()
             ) {
            System.out.println(s);
        }*/
        new PhotoDaoImpl().deleteByNP("111","111");

    }

/**
 * 添加photo对象
 * @since: jdk8
 * @param: [photoplace, username, password]
 * @return: void
 * @author: Shaw
 * @date: 2022/8/24
 */
    @Override
    public void add(String photoplace, String username, String password) {
        Connection conn=null;
        String sql="insert into h_photo(photo,username,password) values (?,?,?)";
        try {
            conn=Dbutil.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,photoplace);
            ps.setString(2,username);
            ps.setString(3,password);

            ps.execute();
            Dbutil.closeAll(null,ps,conn);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 查询全部
     * @since: jdk8
     * @param: []
     * @return: java.util.List<bean.PhotoMessage>
     * @author: Shaw
     * @date: 2022/8/24
     */
    @Override
    public List<PhotoMessage> queryAll() {
        List<PhotoMessage> list=new ArrayList<>();;
        String sql="select * from h_photo";
        Connection conn = null;
        try {
            conn = Dbutil.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()){
            PhotoMessage photoMessage=new PhotoMessage();
            photoMessage.setPhoto(rs.getString(1));
            photoMessage.setUsername(rs.getString(2));
            photoMessage.setPassword(rs.getString(3));
            list.add(photoMessage);


        }
            Dbutil.closeAll(rs, ps, conn);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return list;
    }

    /**
     * 通过名字和密码删除
     * @since: jdk8
     * @param: [username, password]
     * @return: void
     * @author: Shaw
     * @date: 2022/8/24
     */
    @Override
    public void deleteByNP(String username, String password) {
        String sql="delete from h_photo where username=? and password=?";
        Connection conn = null;
        try {
            conn = Dbutil.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1,username);
        ps.setString(2,password);
        ps.execute();
        Dbutil.closeAll(null,ps,conn);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 查询全部的path地址
     * @since: jdk8
     * @param: []
     * @return: java.util.List
     * @author: Shaw
     * @date: 2022/8/24
     */
    @Override
    public List findAllpath() {
        List list=new ArrayList();
        String sql="select photo from h_photo";
        Connection conn = null;
        try {
            conn = Dbutil.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()){

            list.add(rs.getString(1));

        }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
}
