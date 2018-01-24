package job.admin.controller;

import job.admin.service.GoldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GoldController {

    @Autowired
    private GoldService goldService;

    //黃金存摺
    @RequestMapping("/gold")
    public String gold(Model mod){

        //預設顯示所有年份
        mod.addAttribute("dyear",goldService.getYear());
        return "gold";
    }
}
