package job.admin.controller;

import job.admin.bean.RateBean;
import job.admin.service.RateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.*;

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

    @ResponseBody
    //{xxx:.+} 意思是說網址有. ,因為傳網址有小數點 用這樣讓他認得
    @RequestMapping("/rate/save/{name}/{rate:.+}")
    public Map<String,String> save(@PathVariable String name, @PathVariable Float rate){
        String chkdate = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
        String chktime = new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime());
        Map<String,String> data = new HashMap<String, String>();
        data.put("rate_name",name);
        data.put("rate",String.valueOf(rate));
        data.put("checkdate",chkdate);
        data.put("checktime",chktime);

        List<RateBean> lists = rateService.getCurrentData(name,chkdate);
        //查到比數並且數值不同就更新
        if(lists.size() > 0){
            if(!data.get("rate").equals(lists.get(0).getRate())){
                rateService.update(data);
            }
        }else{
            //新增
            rateService.save(data);
        }
        return data;
    }
}
