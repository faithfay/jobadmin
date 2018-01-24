package job.admin.service;

import job.admin.bean.StockBean;
import job.admin.bean.StockGroupBean;
import job.admin.dao.StockDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockService {

    @Autowired
    private StockDao stockDao;

    public void saveStock(StockBean stockBean){

        stockDao.saveStock(stockBean);
    }

    //股票分類新增或更新
    public void saveGroup(StockGroupBean stockGroupList){

        stockDao.saveGroup(stockGroupList);
    }

    //查詢是否有資料
    public List<StockGroupBean> queryGroup(){

        return stockDao.queryGroup();
    }

}
