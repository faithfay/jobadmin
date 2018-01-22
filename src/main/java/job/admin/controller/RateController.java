package job.admin.controller;

import job.admin.service.RateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RateController {

    @Autowired
    private RateService rateService;

    //外幣匯率
    @RequestMapping(value = "/rate")
    public String rate(Model mod){

        //顯示所有幣別
        mod.addAttribute("rname",rateService.getRateName());
        return "rate";
    }
}
