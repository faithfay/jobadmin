package job.admin.service;

import job.admin.bean.TenlongBean;
import job.admin.dao.TenlongDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TenlongService implements TenlongDao{

    @Autowired
    private TenlongDao tenlongDao;

    public void save(List<TenlongBean> tenlongBeanList){
        tenlongDao.save(tenlongBeanList);
    }

    public List<TenlongBean> hotList(String catelog) {

        return tenlongDao.hotList(catelog);
    }

    public List<TenlongBean> queryBook(String catelog, String queryStr) {

        return tenlongDao.queryBook(catelog,queryStr);
    }
}
