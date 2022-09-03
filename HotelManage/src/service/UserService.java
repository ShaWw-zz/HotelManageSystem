package service;

import bean.User;

import java.util.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;

public interface UserService {

    User login(String username, String password);
    void register(User user);
    User findById(int id);
    void update(User user);
    void deleteById(int id);
    String findByNEP(String name,String email,String phone);
    List<User> queryAll();
    void deteleByAll(int id,String name,String password);
    List<User> findbydate (Timestamp timestamp);
    List<User> findByTime(String oldDate, String newDate);
    List<User> findByName(String name);

    void update(int id,String password,String email,String phone );
    User findByNameAndPwd(String name, String password);



    /**
     * 获取总共有多少页
     * @return
     */
    int getTotalPage(User employee);

    /**
     * 员工分页查询
     * @param
     * @param pageSize
     * @return
     */
    List<User> page(Integer currentPage, Integer pageSize, User employee);

    /**
     * 根据ID删除
     * @param id
     * @return
     */




}
