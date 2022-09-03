package dao.impl;

import bean.People;
import bean.User;
import util.Dbutil;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PeopleDaoImpl {
    public static void main(String[] args) {
        People people=new People(4,"hh","1122");
        new PeopleDaoImpl().insert(people);
    }

    public void insert(People people) {
        String sql="insert into people (id,name,password) values (?,?,?)";
        Connection conn=null;
        //PreparedStatement ps=null;
        try {

            conn=Dbutil.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,people.getId());
            ps.setString(2,people.getName());
            ps.setString(3,people.getPassword());

            ps.execute();
            Dbutil.closeAll(null,ps,conn);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void update(int id,String name,String password) {
        String sql="insert  into people set id=?,name=?,password=?";
        try {
            Connection conn=Dbutil.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1,id);
            ps.setString(2,name);
            ps.setString(3,password);

            ps.executeUpdate();

            Dbutil.closeAll(null,ps,conn);

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
