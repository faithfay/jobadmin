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

    public List<TenlongBean> list(String catelog) {

        return tenlongDao.list(catelog);
    }
}
