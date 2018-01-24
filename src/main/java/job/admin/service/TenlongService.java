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

    public void checkBook(TenlongBean tenlongBean) {

        tenlongDao.checkBook(tenlongBean);
    }

    public List<TenlongBean> queryByCatelog(String catelog) {

        return tenlongDao.queryByCatelog(catelog);
    }

    public List<TenlongBean> queryBook(String catelog, String queryStr) {

        return tenlongDao.queryBook(catelog,queryStr);
    }
}
