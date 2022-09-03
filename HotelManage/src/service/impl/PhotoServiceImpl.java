package service.impl;

import bean.PhotoMessage;
import dao.PhotoDao;
import dao.RoomDao;
import dao.impl.PhotoDaoImpl;
import dao.impl.RoomDaoImpl;
import service.PhotoService;

import java.util.List;

public class PhotoServiceImpl implements PhotoService {




    private PhotoDao photoDao = new PhotoDaoImpl();
    @Override
    public void add(String photoplace, String username, String password) {
        photoDao.add(photoplace,username,password);
    }

    @Override
    public List<PhotoMessage> queryAll() {
        return photoDao.queryAll();
    }

    @Override
    public void deleteByNP(String username, String password) {
        photoDao.deleteByNP(username,password);
    }

    @Override
    public List<String> findAllpath() {
        return photoDao.findAllpath();
    }
}
