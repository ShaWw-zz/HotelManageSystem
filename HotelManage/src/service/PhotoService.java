package service;

import bean.PhotoMessage;

import java.util.List;

public interface PhotoService {
    void add(String photoplace,String username,String password);
    List<PhotoMessage> queryAll();
    void deleteByNP(String username,String password);
    List<String> findAllpath();
}
