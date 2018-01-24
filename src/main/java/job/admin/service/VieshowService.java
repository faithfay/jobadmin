package job.admin.service;

import job.admin.bean.VieshowBean;
import job.admin.dao.VieshowDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VieshowService{

    @Autowired
    private VieshowDao vieshowDao;

    //新增或更新資料
    public void saveOrUpdate(VieshowBean vieshowBeanList){

            vieshowDao.saveOrUpdate(vieshowBeanList);
    }

    //查詢電影
    public List<VieshowBean> queryMove(String mname){

        return vieshowDao.queryMove(mname);
    }
}
