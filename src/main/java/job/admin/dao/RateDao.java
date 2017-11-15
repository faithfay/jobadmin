package job.admin.dao;

import job.admin.bean.RateBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface RateDao {
    List<String> getYear();
    List<String> getMonth(@Param(value = "yyyy") String yyyy);
    List<String> getRateName();
    List<RateBean> getMonthDetail(@Param(value = "rate_name") String rate_name,@Param(value = "monthDetail") String monthDetail);
    List<RateBean> getLowPriceTop(@Param(value = "rate_name") String rate_name);

    List<RateBean> getCurrentData(String checkdate);
    void save(Map<String,String> data);
    void update(Map<String,String> data);
}
