package job.admin.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import job.admin.bean.TenlongBean;
import job.admin.service.TenlongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TenlongAPIController {

    //透過spring 外部設定檔的設定利用@Value抓到參數檔的值
    @Value("${tenlong.page.size}")
    private Integer pgsize;

    @Autowired
    private TenlongService tenlongService;

    //接收傳來的JSON物件並存到DB
    //將HTTP狀態設為200
    @PostMapping(value="/api/tenlong/save",consumes = "application/json")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public void save(@RequestBody List<TenlongBean> tenlongBeanList){
        //將爬蟲傳來的資料存到DB
        tenlongService.save(tenlongBeanList);
    }

    //顯示
    @GetMapping("/api/tenlong/lists/{catelog}")
    public PageInfo<TenlongBean> lists(Model model, @PathVariable String catelog, @RequestParam(defaultValue = "1") Integer pg){

        //查詢前設定開始頁,每頁幾頁
        PageHelper.startPage(pg,pgsize);
        //去查詢
        List<TenlongBean> lists = tenlongService.hotList(catelog);
        //將分頁好的結果集返回頁面
        PageInfo<TenlongBean> pages = new PageInfo<TenlongBean>(lists,pgsize);

        return pages;
    }
}
