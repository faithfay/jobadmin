package job.admin.controller;

import job.admin.bean.GoldBean;
import job.admin.service.GoldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/api/gold")
@Controller
public class GoldAPIController {

    @Autowired
    private GoldService goldService;

    //得到月份下所有日期的資料
    @ResponseBody
    @RequestMapping(value = "/monthdetail/{monthDetail}")
    public List<GoldBean> monthDetail(@PathVariable String monthDetail){

        return goldService.getMonthDetail(monthDetail);
    }

    //得到該年所有月份
    @ResponseBody
    @RequestMapping(value = "/month/{yy}")
    public List<String> month(@PathVariable Integer yy){

        return goldService.getMonth(String.valueOf(yy));
    }

    //最低買進排行
    @ResponseBody
    @RequestMapping(value = "/buytop")
    public List<GoldBean> topBuy(){

        return goldService.queryBuyTop();
    }

    //最高賣出排行
    @ResponseBody
    @RequestMapping(value = "/selltop")
    public List<GoldBean> topSell(){

        return goldService.querySellTop();
    }

    //提供給爬蟲用的API,新增或更新DB資料
    @ResponseBody
    @RequestMapping("/save/{buy}/{sell}")
    public Map<String,String> save(@PathVariable Integer buy,@PathVariable Integer sell){
        String chkdate = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
        String chktime = new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime());
        Map<String,String> data = new HashMap<String, String>();
        data.put("buy",String.valueOf(buy));
        data.put("sell",String.valueOf(sell));
        data.put("checkdate",chkdate);
        data.put("checktime",chktime);

        List<GoldBean> lists = goldService.getCurrentData(chkdate);
        //當有資料做更新,不然新增
        if(lists.size() > 0){
            //buy,sell有變動才更新
            if(!data.get("buy").equals(lists.get(0).getBuy()) ||
                    !data.get("sell").equals(lists.get(0).getSell())){
                goldService.update(data);
            }
        }else{
            goldService.save(data);
        }
        return data;
    }
}
