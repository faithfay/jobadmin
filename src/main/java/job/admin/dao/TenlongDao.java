package job.admin.dao;

import job.admin.bean.TenlongBean;

import java.util.List;

public interface TenlongDao {

    void first(List<TenlongBean> tenlongBeanList);

    void save(TenlongBean tenlongBean);

    void delAll(TenlongBean tenlongBean);

    List<TenlongBean> list();
}
