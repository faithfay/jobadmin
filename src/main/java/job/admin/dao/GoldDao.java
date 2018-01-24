package job.admin.dao;

import job.admin.bean.GoldBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface GoldDao {

    //得到年份資料
    List<String> getYear();
    //得到該年下的所有月份
    List<String> getMonth(@Param(value = "yyyy")String yyyy);
    //得到該月份下所有日期的詳細資料
    List<GoldBean> getMonthDetail(@Param(value = "monthDetail")String monthDetail);
    //得到目前日期資料
    List<GoldBean> getCurrentData(@Param(value = "checkdate")String checkdate);
    //查詢最低買進
    List<GoldBean> queryBuyTop();
    //查詢最高賣出
    List<GoldBean> querySellTop();
    //存入資料
    void save(Map<String,String> data);
    //更新
    void update(Map<String,String> data);
    //更新或修改
    void saveOrUpdate(Map<String,String> data);

}
