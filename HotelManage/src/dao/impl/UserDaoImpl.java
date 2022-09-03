package dao.impl;

import bean.User;

import dao.UserDao;
import sun.security.util.Password;
import util.Dbutil;
import util.JdbcTemplate;
import util.StringUtil;
import util.TimeUtil;

import java.io.IOException;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class UserDaoImpl  implements UserDao {

    public static void main(String[] args) throws
            ParseException {

       /* User user=new User("qwe","11122","1221","aaaaa");
        new  UserDaoImpl().insert(user);*/

       /* String username = "admin";
        String password = "123456";
        System.out.println(new UserDaoImpl().findByNameAndPwd(username, password));
*/

      /*  System.out.println(new UserDaoImpl().findById(1));

        List<User> userList = new UserDaoImpl().queryAll();
        for(User user : userList) {
        System.out.println(user);
    }*/
      //User user=new User();

       /* List<User> userList= new UserDaoImpl().page(1, 20, user);

        for (User x:userList
             ) {
            System.out.println(x);
        }*/
       /* List<User> userList=new UserDaoImpl().queryAll();
        System.out.println(new UserDaoImpl().count(user));*/
        //System.out.println(new UserDaoImpl().page(1, 20, null));
        /*for (User x:new UserDaoImpl().page(1, 20, null)
                ) {
            System.out.println(x);
        }*/

       /* SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        String s = "2022-08-18 15:51:30";
        java.util.Date d = sdf.parse(s);

        Timestamp time = new Timestamp(d.getTime());

        List<User> userList= new UserDaoImpl().findbydate(time);
        for (User user2:userList
             ) {
            System.out.println(user2);
        }*/
             String t1="2022-8-1";
             String t2="2022-8-3";
       // System.out.println(new UserDaoImpl().findByTime(t1, t2));
        //System.out.println(new Date().getTime());

       // System.out.println(new UserDaoImpl().findByName("admin"));
        new UserDaoImpl().update(3,"111","111","111");

    }





    /**
     * 方法描述:添加用户
     * @since: jdk8
     * @param: [user]
     * @return: void
     * @author: Shaw
     * @date: 2022/8/24
     */
    @Override
    public void insert(User user) {
    String sql="insert into h_user (id,name,password,createTime,email,phone) values (null,?,?,now(),?,?)";
    Connection conn=null;
    //PreparedStatement ps=null;
        try {

            conn=Dbutil.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,user.getName());
            ps.setString(2,user.getPassword());
           // ps.setDate(3, new java.sql.Date(date.getTime()));
            ps.setString(3,user.getEmail());
            ps.setString(4,user.getPhone());
            ps.execute();
            Dbutil.closeAll(null,ps,conn);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
/**
 * 方法描述:通过时间查询用户
 * @since: jdk8
 * @param: [timestamp]
 * @return: java.util.List<bean.User>
 * @author: Shaw
 * @date: 2022/8/24
 */
    @Override
    public List<User> findbydate(Timestamp timestamp) {

        List<User> userList = new ArrayList<>();
        String sql="select * from h_user where createTime =?";
        Connection conn=null;
        try {
            conn=Dbutil.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setTimestamp(1, timestamp);
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                //创建对象
                User user  = new User();
                //注入数据
                user.setId(rs.getInt(1));
                user.setName(rs.getString(2));
                user.setPassword(rs.getString(3));
                user.setCreateTime(new Date(rs.getTimestamp(4).getTime()));
                user.setEmail(rs.getString(5));
                user.setPhone(rs.getString(6));
                userList.add(user);
            }
            Dbutil.closeAll(rs, ps, conn);



        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return userList;
    }

    /**
     * 方法描述:通过[id, password, email, phone]去更新数据
     * @since: jdk8
     * @param: [id, password, email, phone]
     * @return: void
     * @author: Shaw
     * @date: 2022/8/24
     */


    @Override
    public void update(int id,String password,String email,String phone) {
        String sql="update h_user set password=?,email=?,phone=? where id=?";
        try {
            Connection conn=Dbutil.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1,password);
            ps.setString(2,email);
            ps.setString(3,phone);
            ps.setInt(4,id);
            ps.executeUpdate();

            Dbutil.closeAll(null,ps,conn);

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
/**
 * 方法描述:通过id去删除信息
 * @since: jdk8
 * @param: [id]
 * @return: void
 * @author: Shaw
 * @date: 2022/8/24
 */
    @Override
    public void deteleById(int id) {
        String sql="delete from h_user where id=?";
        try {
            Connection conn = Dbutil.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,id);
            ps.execute();
            Dbutil.closeAll(null,ps,conn);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    /**
     * 方法描述:通过[id, name, password]去删除信息
     * @since: jdk8
     * @param: [id, name, password]
     * @return: void
     * @author: Shaw
     * @date: 2022/8/24
     */
    public void deteleByAll(int id, String name, String password) {
        String sql="delete from h_user where id=? and name=? and password=? ";
        try {
            Connection conn = Dbutil.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,id);
            ps.setString(2,name);
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
     * 方法描述:通过[name, email, phone]查询+
     * @since: jdk8
     * @param: [name, email, phone]
     * @return: java.lang.String
     * @author: Shaw
     * @date: 2022/8/24
     */
    @Override
    public String findByNEP(String name, String email, String phone) {
        String password="";
        String sql="select password from h_user where name=? and email=? and phone=?";

        Connection conn=null;
        try {
            conn=Dbutil.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1,name);
            ps.setString(2,email);
            ps.setString(3,phone);
            ResultSet rs=ps.executeQuery();
            while (rs.next()){

                //注入数据
                password=rs.getString(1);

            }
            Dbutil.closeAll(rs, ps, conn);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return password ;
    }

    @Override
    public User findByNameAndPwd(String name, String password) {

        String sql = "select * from h_user where name = ? and password = ?";
        User user = null;
        try {
            Connection conn = null;
            try {
                conn = Dbutil.getConnection();
            } catch (IOException e) {
                e.printStackTrace();
            }
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();

            if(rs.next()) {
                //创建对象
                user = new User();
                //注入数据
                user.setId(rs.getInt(1));
                user.setName(rs.getString(2));
                user.setPassword(rs.getString(3));
                user.setCreateTime(new Date(rs.getTimestamp(4).getTime()));
                user.setEmail(rs.getString(5));
                user.setPhone(rs.getString(6));
            }
            Dbutil.closeAll(rs, ps, conn);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }

    @Override
    public User findById(int id) {
        User user=null;
        try {
            Connection conn = Dbutil.getConnection();

            String sql="select * from h_user where id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                //创建对象
                user = new User();
                //注入数据
                user.setId(rs.getInt(1));
                user.setName(rs.getString(2));
                user.setPassword(rs.getString(3));
                user.setCreateTime(new Date(rs.getTimestamp(4).getTime()));
                user.setEmail(rs.getString(5));
                user.setPhone(rs.getString(6));
            }
            Dbutil.closeAll(rs, ps, conn);


        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public List<User> queryAll() {
        List<User> userList = new ArrayList<>();
        String sql = "select * from h_user ";
        try {
            Connection conn = Dbutil.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                //创建对象
                User user  = new User();
                //注入数据
                user.setId(rs.getInt(1));
                user.setName(rs.getString(2));
                user.setPassword(rs.getString(3));
                user.setCreateTime(new Date(rs.getTimestamp(4).getTime()));
                user.setEmail(rs.getString(5));
                user.setPhone(rs.getString(6));
                userList.add(user);
            }
            Dbutil.closeAll(rs, ps, conn);

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return userList;
    }

    @Override
    public List<User> queryPage(User user, int pageSize, int pageIndex) {
        return null;
    }

    @Override
    public List<User> findByTime(String oldDate, String newDate) {
        List<User> list = new ArrayList();
        List<User> list1=queryAll();
        for (User u:list1) {
            if (TimeUtil.dateToLong(u.getCreateTime())>= TimeUtil.stringToLong(oldDate)
                    &&TimeUtil.dateToLong(u.getCreateTime())<= TimeUtil.stringToLong(newDate)
                    ){
                list.add(u);
            }
        }

        return list;
    }

    @Override
    public List<User> findByName(String name) {
        List<User> list = new ArrayList();
        String sql = "select * from h_user  where name=?";
        Connection conn = null;
        try {
            conn = Dbutil.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1,name);
        ResultSet rs = ps.executeQuery();

        while (rs.next()){
            //创建对象
            User user  = new User();
            //注入数据
            user.setId(rs.getInt(1));
            user.setName(rs.getString(2));
            user.setPassword(rs.getString(3));
            user.setCreateTime(new Date(rs.getTimestamp(4).getTime()));
            user.setEmail(rs.getString(5));
            user.setPhone(rs.getString(6));
            list.add(user);

        }
            Dbutil.closeAll(rs, ps, conn);

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return list;
    }

    @Override
    public boolean check(String name) {
        boolean flag=false;
        List<User> byName = findByName(name);
        if (byName.size()==0){
            return true;
        }else {

            return false;
        }
    }

    @Override
    public int getTotalPage(UserDao employee) {
        return 0;
    }



    /**
     -- select * from t_employee limit (current - 1) * pageSize,pageSize
     -- m:从0开始的位置
     -- n:返回多少条
     -- pageSize 每页10条
     -- 第一页
     select * from t_employee limit (1 -1 ) * 10,10
     -- 第二页
     select * from t_employee limit (2 -1 ) * 10,10
     -- 第三页
     select * from t_employee limit (3 - 1) * 10,10
     * @param
     * @param pageSize 每页多少条数据
     * @return
     */

    public List<User> page(Integer currentPage, Integer pageSize, User user) {

        try{
            //获得连接
            Connection conn = null;
            try {
                conn = Dbutil.getConnection();
            } catch (IOException e) {
                e.printStackTrace();
            }

            //拼装SQL语句
            StringBuilder sql = new StringBuilder();
            sql.append(" select * from h_user where 1=1 ");
            //动态添加查询参数
          /*  if(user!=null && StringUtil.StringUtils.isNotBlank(user.getName())){
                sql.append(" and name =  '"+user.getName()+"' ");
            }
            if(user != null && StringUtil.StringUtils.isNotBlank(user.getPassword())){
                sql.append(" and password '"+user.getPassword()+"' ");
            }
            if(user != null && StringUtil.StringUtils.isNotBlank(String.valueOf(user.getCreateTime()))){
                sql.append(" and CreateTime < '"+user.getCreateTime()+"' ");
            }*/

            sql.append("  limit ?,? ");

            //获得预编译执行
            PreparedStatement stmt = conn.prepareStatement(sql.toString());

            //设置参数
            stmt.setInt(1,(currentPage - 1) * pageSize);
            stmt.setInt(2,pageSize);
            //执行Query
            ResultSet rs = stmt.executeQuery();

            //用来接收返回值
            List<User> emps = new ArrayList<>();

            //判断是否有下一行
            while(rs.next()){
                //每一次创建一个新的Employee
                User emp = new User();
                emp.setId(rs.getInt("id"));
                emp.setName(rs.getString("name"));
                emp.setPassword(rs.getString("password"));
                emp.setCreateTime(new Date(rs.getTimestamp("createTime").getTime()));
                emp.setEmail(rs.getString("email"));
                emp.setPhone(rs.getString("phone"));
                //添加到List集合中
                emps.add(emp);

            }
            return emps;

        }catch (SQLException e){
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }
    public int count(User user) {

        try {
            //获得连接
            Connection conn = null;
            try {
                conn = Dbutil.getConnection();
            } catch (IOException e) {
                e.printStackTrace();
            }

            //拼装SQL语句
            StringBuilder sql = new StringBuilder();
            sql.append(" select count(*) as c from h_user where 1=1 ");

            //获得预编译执行
            PreparedStatement stmt = conn.prepareStatement(sql.toString());

            //设置参数

            //执行Query
            ResultSet rs = stmt.executeQuery();

            //用来接收返回值
            int c = 0;
            //判断是否有下一行
            while (rs.next()) {
                c = rs.getInt("c");
            }

            return c;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }

    }



    @Override
    public boolean saveOrUpdate(User user) {
        return false;
    }




}
