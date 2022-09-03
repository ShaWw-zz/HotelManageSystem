package dao;

import bean.PhotoMessage;

import java.util.List;

public interface PhotoDao {
    void add(String photoplace,String username,String password);
    List<PhotoMessage>queryAll();
    void deleteByNP(String username,String password);
    List findAllpath();

}
