package util;



import util.Dbutil;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcTemplate<T> {


    /*public static void main(String[] args) {
        Car car = new JdbcTemplate().findByNameAndPwd("法拉利","意大利");
        System.out.println(car.toString());
    }


   public Car findByNameAndPwd(String name, String place){
        Car car=null;
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        //sql=select * from supercar where name=name and=
        try {
            conn=Dbutil.getConnection();
            String sql="select id,name,place from supercar where name=? and place=?";
            ps=conn.prepareStatement(sql);
            ps.setString(1,name);
            ps.setString(2,place);
            System.out.println(sql);
            rs= ps.executeQuery();
            while (rs.next()){
                car = new Car();
                car.setId(rs.getInt(1));
                car.setName(rs.getString(2));
                car.setPlace(rs.getString(3));
            }
            Dbutil.closeAll(rs,ps,conn);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
       return car;
    }
*/

    void update(String sql,Object...objects){
        Connection conn=null;
        PreparedStatement ps=null;

        try {
           conn=Dbutil.getConnection();
            ps=conn.prepareStatement(sql);
            for (int i = 0; i < objects.length; i++) {
                ps.setObject(i+1,objects[i]);
            }
            ps.executeUpdate();
            Dbutil.closeAll(null,ps,conn);

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    void insert(String sql,Object...objects){
        Connection conn=null;
        PreparedStatement ps=null;

        try {
           conn= Dbutil.getConnection();

            ps=conn.prepareStatement(sql);
            //String sql="insert into carplaytime(id,name,place,playtime) values(null,?,?,?)";
            for (int i = 0; i < objects.length; i++) {
                ps.setObject((i+1),objects[i]);

            }


            ps.execute();
            Dbutil.closeAll(null,ps,conn);

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
