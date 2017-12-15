package job.admin.dao;

import job.admin.bean.TenlongBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TenlongDao {

    void save(List<TenlongBean> tenlongBean);

    void checkBook(TenlongBean tenlongBean);

    List<TenlongBean> list(@Param(value = "catelog") String catelog);

    List<TenlongBean> queryBook(@Param(value = "catelog") String catelog,@Param(value = "queryStr") String queryStr);
}
