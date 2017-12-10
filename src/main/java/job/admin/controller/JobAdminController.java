package job.admin.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import job.admin.bean.TenlongBean;
import job.admin.service.GoldService;
import job.admin.service.RateService;
import job.admin.service.TenlongService;
import job.admin.util.JobUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;


@Controller
public class JobAdminController {

    @Autowired
    private GoldService goldService;
    @Autowired
    private RateService rateService;
    @Autowired
    private TenlongService tenlongService;
    @Autowired
    private JobUtil jobUtil;

    //透過spring 外部設定檔的設定利用@Value抓到參數檔的值
    @Value("${tenlong.page.size}")
    private Integer pgsize;

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

    //偽天瓏圖案顯示
    @RequestMapping("/tenlong/{alias}")
    public String tenlong(Model model,@PathVariable String alias){

        model.addAttribute("hotalias",alias);

        return "tenlong";
    }

    //偽天瓏清單顯示
    @RequestMapping(value = "/tenlonglist/{catelog}")
    public String tenlongList(Model model, @PathVariable String catelog, @RequestParam(defaultValue = "1") Integer pg,@RequestParam(required = false) String qs){
        List<TenlongBean> lists;

        if(qs != null && !"".equals(qs)){
            //查詢前設定開始頁,每頁幾頁
            PageHelper.startPage(pg,pgsize-5);
            //去查詢
            lists = tenlongService.queryBook(catelog,jobUtil.regStr(qs));
        }else{
            //查詢前設定開始頁,每頁幾頁
            PageHelper.startPage(pg,pgsize-5);
            lists = tenlongService.list(catelog);
        }
        //將分頁好的結果集返回頁面
        PageInfo<TenlongBean> pages = new PageInfo<TenlongBean>(lists,5);

        model.addAttribute("tenlongs",pages);
        model.addAttribute("hotalias",catelog);
        //如果有查詢就返回
        model.addAttribute("qs",qs);
        return "tenlonglist";
    }

}

