package job.admin.dao;

import job.admin.bean.StockBean;
import job.admin.bean.StockGroupBean;

import java.util.List;

public interface StockDao {

    void saveGroup(StockGroupBean stockGroupBean);
    void saveStock(StockBean stockBean);

    List<StockGroupBean> queryGroup();

}
