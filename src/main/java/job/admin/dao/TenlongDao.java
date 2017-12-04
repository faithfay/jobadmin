package job.admin.dao;

import job.admin.bean.TenlongBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TenlongDao {

    void first(List<TenlongBean> tenlongBeanList);

    void save(TenlongBean tenlongBean);

    void delAll(TenlongBean tenlongBean);

    List<TenlongBean> list(@Param(value = "catelog") String catelog);
}
