package job.admin.controller;

import job.admin.service.GoldService;
import job.admin.service.RateService;
import job.admin.service.TenlongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class JobAdminController {

    @Autowired
    private GoldService goldService;
    @Autowired
    private RateService rateService;
    @Autowired
    private TenlongService tenlongService;

    //首頁
    @RequestMapping("/")
    public String index(){
        return "list";
    }

    //黃金存摺
    @RequestMapping("/gold")
    public String gold(Model mod){
        //預設傳送資料庫有哪些年
        mod.addAttribute("dyear",goldService.getGoldYear());
        return "gold";
    }

    //外幣匯率
    @RequestMapping(value = "/rate")
    public String rate(Model mod){
        mod.addAttribute("rname",rateService.getRateName());
        return "rate";
    }

    //偽天瓏排行
    @RequestMapping(value = "/tenlonghot/{alias}")
    public String tenlong(Model model,@PathVariable String alias){

        if(alias != null && !"".equals(alias)){
            model.addAttribute("hotalias",alias);
        }else{
            model.addAttribute("hotalias","zhtop");
        }
        return "tenlonghot";
    }
}

