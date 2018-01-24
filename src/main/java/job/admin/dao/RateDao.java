package job.admin.dao;

import job.admin.bean.RateBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface RateDao {
    //得到年份資料
    List<String> getYear();
    //得到該年所有月份
    List<String> getMonth(@Param(value = "yyyy") String yyyy);
    //得到幣別名稱
    List<String> getRateName();
    //得到該月份下所有資料
    List<RateBean> getMonthDetail(@Param(value = "rate_name") String rate_name,@Param(value = "monthDetail") String monthDetail);
    //該匯率低價排行
    List<RateBean> queryLowPriceTop(@Param(value = "rate_name") String rate_name);
    //查詢現在日期資料
    List<RateBean> getCurrentData(@Param(value = "rate_name") String rate_name,@Param(value = "checkdate") String checkdate);
    //新增
    void save(Map<String,String> data);
    //更新
    void update(Map<String,String> data);
}
