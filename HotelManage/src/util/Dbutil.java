package util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class Dbutil {



    static {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    public  static Connection getConnection () throws SQLException, IOException {
        InputStream resourceAsStream =Dbutil.class.getClassLoader().getResourceAsStream("db.properties");
        Properties properties=new Properties();
        properties.load(resourceAsStream);

        String url=properties.getProperty("url");
        String username=properties.getProperty("username");
        String password=properties.getProperty("password");
        return DriverManager.getConnection(url,username,password);
    }

    public static void closeAll(ResultSet rs, Statement statement, Connection connection){

        if (rs !=null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }}
        if (statement!=null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (connection!=null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }


}
