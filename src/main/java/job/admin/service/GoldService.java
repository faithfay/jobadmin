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

    public List<GoldBean> getMonthDetail(String monthDetail){
        return goldDao.getMonthDetail(monthDetail);
    }
    //查詢條件過濾checkdate得到所有年
    public List<String> getGoldYear(){
        return goldDao.getYear();
    }
    //帶入年分查資料庫該年分所有有資料的月份
    public List<String> getGoldMonth(String yyyy){
        return goldDao.getMonth(yyyy);
    }
    //買進最低價排行
    public List<GoldBean> getBuyTop(){
        return goldDao.getBuyTop();
    }
    //賣出最高價排行
    public List<GoldBean> getSellTop(){
        return goldDao.getSellTop();
    }
    //網頁爬到的資料存到DB
    public void save(Map<String,String> data){
        goldDao.save(data);
    }
    //爬到的資料做更新
    public void update(Map<String,String> data){
        goldDao.update(data);
    }
    //判斷有沒有今天的資料
    public List<GoldBean> count(String checkdate){
        return goldDao.count(checkdate);
    }
}
