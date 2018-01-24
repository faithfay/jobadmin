package job.admin.controller;

import job.admin.bean.StockBean;
import job.admin.bean.StockGroupBean;
import job.admin.service.StockGroupService;
import job.admin.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/stock")
@RestController
public class StockApiController {


    @Autowired
    private StockGroupService stockGroupService;

    //新增股票
    @PostMapping(value="/save/stock",consumes = "application/json")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public void stockSave(@RequestBody List<StockBean> stockBeanList){
        for(StockBean StockBean:stockBeanList){
            System.out.println(StockBean);
        }
    }

    //新增股票分類
    @PostMapping(value="/save/group",consumes = "application/json")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public void grpSave(@RequestBody List<StockGroupBean> stockGroupList){

        List<StockGroupBean> datas = stockGroupService.queryGroup();

        //判斷DB跟爬到的群組名稱進行比對,没比到就新增
        for(StockGroupBean stockGroupBean:stockGroupList){
            boolean tag = false;
            for(StockGroupBean dbStockGroupBean:datas){
                if(dbStockGroupBean.getStockCategory().equals(stockGroupBean.getStockCategory())){
                    tag = true;
                    break;
                }
            }
            if(!tag){
                stockGroupService.saveGroup(stockGroupBean);
            }
        }
    }
}
