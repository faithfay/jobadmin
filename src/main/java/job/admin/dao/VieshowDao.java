package job.admin.dao;

import job.admin.bean.VieshowBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface VieshowDao {

    void saveOfUpdate(VieshowBean vieshowBeanList);

    List<VieshowBean> queryMove(@Param("checkdate") String checkdate,@Param("mname") String mname);
}
