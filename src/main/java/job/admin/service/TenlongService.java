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

    public void first(List<TenlongBean> tenlongBeanList){

        tenlongDao.first(tenlongBeanList);
    }

    public void save(TenlongBean tenlongBean) {

    }

    public void save(List<TenlongBean> tenlongBeanList){
        for(TenlongBean tenlongBean:tenlongBeanList){
            tenlongDao.save(tenlongBean);
        }
    }

    public void delAll(TenlongBean tenlongBean){

        tenlongDao.delAll(tenlongBean);
    }

    public List<TenlongBean> list(String catelog) {

        return tenlongDao.list(catelog);
    }
}
