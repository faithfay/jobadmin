package job.admin.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import job.admin.bean.TenlongBean;
import job.admin.service.TenlongService;
import job.admin.util.JobUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/tenlong")
@RestController
public class TenlongAPIController {

    //透過spring 外部設定檔的設定利用@Value抓到參數檔的值
    @Value("${page.size}")
    private Integer pgsize;

    @Autowired
    private TenlongService tenlongService;

    @Autowired
    private JobUtil jobUtil;

    //檢查是要更新還是新增
    //將HTTP狀態設為200
    @PostMapping(value="/chkbook",consumes = "application/json")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public void saveOfUpdate(@RequestBody TenlongBean tenlongBean){

        tenlongService.checkBook(tenlongBean);
    }

    //接收傳來的JSON物件並存到DB
    //將HTTP狀態設為200
    @PostMapping(value="/save",consumes = "application/json")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public void save(@RequestBody List<TenlongBean> tenlongBeanList){
        //將爬蟲傳來的資料存到DB
        tenlongService.save(tenlongBeanList);
    }

    //顯示
    @GetMapping("/lists/{catelog}")
    public PageInfo<TenlongBean> lists(@PathVariable String catelog, @RequestParam(defaultValue = "1") Integer pg){

        //查詢前設定開始頁,每頁幾頁
        PageHelper.startPage(pg,pgsize);
        //去查詢
        List<TenlongBean> lists = tenlongService.queryByCatelog(catelog);
        //將分頁好的結果集返回頁面
        PageInfo<TenlongBean> pages = new PageInfo<TenlongBean>(lists,10);
        return pages;
    }

    @GetMapping("/query/{catelog}")
    public PageInfo<TenlongBean> queryBook(@PathVariable String catelog,@RequestParam(defaultValue = "") String qs, @RequestParam(defaultValue = "1") Integer pg){
        String queryStr = null;
        if(qs != null && !"".equals(qs)){
            queryStr = jobUtil.regStr(qs);
        }

        PageHelper.startPage(pg,pgsize);
        //去查詢
        List<TenlongBean> lists = tenlongService.queryBook(catelog,queryStr);
        //將分頁好的結果集返回頁面,查詢頁次總數10筆
        PageInfo<TenlongBean> pages = new PageInfo<TenlongBean>(lists,10);
        return pages;
    }
}
