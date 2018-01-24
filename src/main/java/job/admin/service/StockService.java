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


    public void saveStock(StockBean stockList){

        stockDao.saveStock(stockList);
    }

}
