package job.admin.dao;

import job.admin.bean.GoldBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface GoldDao {

    List<String> getYear();
    List<String> getMonth(@Param(value = "yyyy")String yyyy);
    List<GoldBean> getMonthDetail(@Param(value = "monthDetail")String monthDetail);
    List<GoldBean> getBuyTop();
    List<GoldBean> getSellTop();
    void save(Map<String,String> data);
    void update(Map<String,String> data);
    Integer count(@Param(value = "checkdate")String checkdate);
}
