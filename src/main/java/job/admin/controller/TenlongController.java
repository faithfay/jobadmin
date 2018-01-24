package job.admin.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import job.admin.bean.TenlongBean;
import job.admin.service.TenlongService;
import job.admin.util.JobUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequestMapping("/tenlong")
@Controller
public class TenlongController {

    @Autowired
    private TenlongService tenlongService;
    @Autowired
    private JobUtil jobUtil;

    //透過spring 外部設定檔的設定利用@Value抓到參數檔的值
    @Value("${page.size}")
    private Integer pgsize;

    //偽天瓏圖案顯示
    @RequestMapping("/image/{alias}")
    public String tenlong(Model model,@PathVariable String alias){

        model.addAttribute("hotalias",alias);
        return "tenlong";
    }

    //偽天瓏清單顯示
    @RequestMapping(value = "/list/{catelog}")
    public String tenlongList(Model model, @PathVariable String catelog, @RequestParam(defaultValue = "1") Integer pg, @RequestParam(required = false) String qs){
        List<TenlongBean> lists;

        if(qs != null && !"".equals(qs)){
            //查詢前設定開始頁,每頁幾頁
            PageHelper.startPage(pg,pgsize);
            //去查詢
            lists = tenlongService.queryBook(catelog,jobUtil.regStr(qs));
            model.addAttribute("qs",qs);
        }else{
            //查詢前設定開始頁,每頁幾頁
            PageHelper.startPage(pg,pgsize);
            lists = tenlongService.queryByCatelog(catelog);
        }
        //將分頁好的結果集返回頁面
        PageInfo<TenlongBean> pages = new PageInfo<TenlongBean>(lists,5);

        model.addAttribute("tenlongs",pages);
        model.addAttribute("hotalias",catelog);

        return "tenlonglist";
    }
}

