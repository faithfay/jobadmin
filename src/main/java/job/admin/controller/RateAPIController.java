package job.admin.controller;

import job.admin.bean.RateBean;
import job.admin.service.RateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class RateAPIController {

    @Autowired
    private RateService rateService;

    //得到該年所有月份
    @ResponseBody
    @RequestMapping(value = "/json/rate/{yy}")
    public List<String> year(@PathVariable Integer yy){
        return rateService.getMonth(String.valueOf(yy));
    }

    //月份所有資料
    @ResponseBody
    @RequestMapping(value = "/json/rate/month/{rateName}/{monthDetail}")
    public List<RateBean> monthDetail(@PathVariable String rateName,@PathVariable String monthDetail){
        return rateService.getMonthDetail(rateName,monthDetail);
    }

    //列出外幣名稱
    @ResponseBody
    @RequestMapping(value = "/json/rate/name")
    public List<String> name(){
        return rateService.getRateName();
    }

    @ResponseBody
    @RequestMapping(value = "/json/rate/top")
    public List<RateBean> top(@RequestParam(value = "rn",defaultValue = "") String name){
        if ("".equals(name)){
            return rateService.getLowPriceTop("日圓");
        }else{
            return rateService.getLowPriceTop(name);
        }
    }
}
