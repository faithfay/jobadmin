package job.admin.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import job.admin.bean.VieshowBean;
import job.admin.service.VieshowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequestMapping("/vieshow")
@Controller
public class VieshowController {

    //透過spring 外部設定檔的設定利用@Value抓到參數檔的值
    @Value("${page.size}")
    private Integer pgsize;

    @Autowired
    private VieshowService vieshowService;

    @RequestMapping("/list")
    public String list(Model model,@RequestParam(defaultValue = "1") Integer pg, @RequestParam(required = false) String mname){

        //查詢前設定開始頁,每頁幾頁
        PageHelper.startPage(pg,pgsize);

        List<VieshowBean> vieshowList = vieshowService.queryMove(mname);

        PageInfo<VieshowBean> pageInfo = new PageInfo<VieshowBean>(vieshowList,5);

        model.addAttribute("movielist",pageInfo);

        return "vieshow";
    }
}
