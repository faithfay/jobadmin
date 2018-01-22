package job.admin.service;

import job.admin.bean.VieshowBean;
import job.admin.dao.VieshowDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class VieshowService{

    @Autowired
    private VieshowDao vieshowDao;


    public void saveOrUpdate(VieshowBean vieshowBeanList){

            vieshowDao.saveOrUpdate(vieshowBeanList);
    }

    //顯示並查詢當月上映電影
    public List<VieshowBean> queryMove(String checkdate,String mname){

        return vieshowDao.queryMove(checkdate,mname);
    }
}
