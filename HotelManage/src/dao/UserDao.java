package dao;

import bean.User;

import java.util.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;

public interface UserDao {
    void insert(User user);
    List<User> findbydate (Timestamp timestamp);
    void update(int id,String password,String email,String phone );
    void deteleById(int id);
    void deteleByAll(int id,String name,String password);
    String findByNEP(String name,String email,String phone);
    User findByNameAndPwd(String name, String password);
    User findById(int id);
    //查询所有的记录（如果记录很多，数据库效率，java效率，没有用一页只有20条，没必要查询1000）
    List<User> queryAll();

    //分页： 指定查询的记录数，指定查询第几页 ，只要查询这些记录就行。
    //user会用输入查询条件  where ... order by ... limit (pageIndex-1)*pageSize, pageSize
    List<User> queryPage(User user, int pageSize, int pageIndex);
    List<User> findByTime(String oldDate, String newDate);
    List<User> findByName(String name);
    boolean check(String neam);



     int count(User user);
    /**
     * 获取总共有多少页
     * @return
     */
    int getTotalPage(UserDao employee);

    /**
     * 员工分页查询
     * @param
     * @param pageSize
     * @return
     */
    List<User> page(Integer currentPage, Integer pageSize, User user);



    /**
     * 保存或者更新
     * @param
     * @return
     */
    boolean saveOrUpdate(User user);


}
