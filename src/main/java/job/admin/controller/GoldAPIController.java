package job.admin.controller;

import job.admin.bean.GoldBean;
import job.admin.service.GoldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class GoldAPIController {

    @Autowired
    private GoldService goldService;

    //月份所有資料
    @ResponseBody
    @RequestMapping(value = "/json/gold/month/{monthDetail}")
    public List<GoldBean> monthDetail(@PathVariable String monthDetail){
        return goldService.getMonthDetail(monthDetail);
    }

    //得到月份
    @ResponseBody
    @RequestMapping(value = "/json/gold/{yy}")
    public List<String> month(@PathVariable Integer yy){
        return goldService.getGoldMonth(String.valueOf(yy));
    }

    //最低買進排行
    @ResponseBody
    @RequestMapping(value = "/json/gold/topbuy")
    public List<GoldBean> topBuy(){
        return goldService.getBuyTop();
    }

    //最高賣出排行
    @ResponseBody
    @RequestMapping(value = "/json/gold/topsell")
    public List<GoldBean> topSell(){
        return goldService.getSellTop();
    }
}
