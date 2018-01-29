package job.admin.dao;

import job.admin.bean.StockGroupBean;

import java.util.List;

public interface StockGroupDao {

    void saveGroup(StockGroupBean stockGroupBean);

    List<StockGroupBean> queryGroup();

}
