package job.admin.service;

import job.admin.bean.VieshowBean;
import job.admin.dao.VieshowDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VieshowService {

    @Autowired
    private VieshowDao vieshowDao;


    public void saveOfUpdate(VieshowBean vieshowBeanList){

            vieshowDao.saveOfUpdate(vieshowBeanList);
    }

    public List<VieshowBean> queryMove(String checkdate){

        return vieshowDao.queryMove(checkdate);
    }
}
