package job.admin.service;

import job.admin.bean.GoldBean;
import job.admin.dao.GoldDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class GoldService {

    @Autowired
    private GoldDao goldDao;

    public void saveOrUpdate(Map<String,String> data){

        goldDao.saveOrUpdate(data);
    }

    //得到該月份下所有日期的資料
    public List<GoldBean> getMonthDetail(String monthDetail){

        return goldDao.getMonthDetail(monthDetail);
    }

    //查詢條件過濾checkdate得到所有年
    public List<String> getYear(){

        return goldDao.getYear();
    }

    //帶入年分查資料庫該年分所有有資料的月份
    public List<String> getMonth(String yyyy){

        return goldDao.getMonth(yyyy);
    }

    //買進最低價排行
    public List<GoldBean> queryBuyTop(){

        return goldDao.queryBuyTop();
    }

    //賣出最高價排行
    public List<GoldBean> querySellTop(){

        return goldDao.querySellTop();
    }

    //新增
    public void save(Map<String,String> data){

        goldDao.save(data);
    }

    //更新
    public void update(Map<String,String> data){

        goldDao.update(data);
    }

    //得到目前日期資料
    public List<GoldBean> getCurrentData(String checkdate){

        return goldDao.getCurrentData(checkdate);
    }
}
