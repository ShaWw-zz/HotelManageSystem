package service.impl;

import bean.User;
import dao.UserDao;
import dao.impl.UserDaoImpl;
import service.UserService;
import common.Costant;

import java.util.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;

public class UserServiceImpl implements UserService {

    public static void main(String[] args) {
        UserServiceImpl userService=new UserServiceImpl();
       // userService.login("admin","123456");
        /*String admin = userService.findByNEP("xiao", "123456", "123456");
        System.out.println(admin);*/
        User user=new User();
        //userService.getTotalPage()
        //System.out.println(userService.page(1, 3, null));
        //System.out.println(userService.findbydate(("2022-8-2")));
    }

    private UserDao userdao = new UserDaoImpl();

    @Override
    public User login(String username, String password) {

        //1. 查找是否存在
        //2. 进行登录信息的记录（insert)

        return userdao.findByNameAndPwd(username, password);
    }

    @Override
    public void register(User user) {
        userdao.insert(user);
    }

    @Override
    public User findById(int id) {
        return null;
    }

    @Override
    public void update(User user) {

    }

    @Override
    public void deleteById(int id) {
        userdao.deteleById(id);
    }

    @Override
    public String findByNEP(String name, String email, String phone) {
        String s=userdao.findByNEP(name,email,phone);
       return  s;
    }

    @Override
    public List<User> queryAll() {
        return userdao.queryAll();
    }

    @Override
    public void deteleByAll(int id, String name, String password) {
        userdao.deteleByAll(id,name,password);
    }

    @Override
    public List<User> findbydate(Timestamp timestamp) {
       return userdao.findbydate(timestamp);
    }

    @Override
    public List<User> findByTime(String oldDate, String newDate) {
        return userdao.findByTime(oldDate,newDate);
    }

    @Override
    public List<User> findByName(String name) {
        return userdao.findByName(name);
    }

    @Override
    public void update(int id, String password, String email, String phone) {
        userdao.update(id,password,email,phone);
    }

    @Override
    public User findByNameAndPwd(String name, String password) {
       return userdao.findByNameAndPwd(name,password);
    }


    @Override
    public int getTotalPage(User user) {
        int c = userdao.count(user);

        //如果是0条 那么返回1
        if(c == 0){
            return 1;
        }

        //根据总数据量统计一共多少页数据
        return c % Costant.PAGE_SIZE == 0 ? c / Costant.PAGE_SIZE:c / Costant.PAGE_SIZE +1;
    }

    @Override
    public List<User> page(Integer currentPage, Integer pageSize, User employee) {
       return userdao.page(currentPage,pageSize,null);
    }
}
