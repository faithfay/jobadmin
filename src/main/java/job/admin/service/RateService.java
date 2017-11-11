package job.admin.service;

import job.admin.bean.RateBean;
import job.admin.dao.RateDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RateService {

    @Autowired
    private RateDao rateDao;

    public List<String> getYear() {
        return rateDao.getYear();
    }

    public List<String> getMonth(String yyyy) {
        return rateDao.getMonth(yyyy);
    }

    public List<RateBean> getMonthDetail(String rate_name,String monthDetail) {
        return rateDao.getMonthDetail(rate_name,monthDetail);
    }

    public List<RateBean> getLowPriceTop(String rate_name) {
        return rateDao.getLowPriceTop(rate_name);
    }

    public List<String> getRateName(){
        return rateDao.getRateName();
    }

}