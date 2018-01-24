package job.admin.dao;

import job.admin.bean.VieshowBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface VieshowDao {

    //新增或更新資料
    void saveOrUpdate(VieshowBean vieshowBeanList);

    //查詢電影
    List<VieshowBean> queryMove(@Param("mname") String mname);
}
