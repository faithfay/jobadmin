package job.admin.controller;

import job.admin.bean.VieshowBean;
import job.admin.service.VieshowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/vieshow")
@RestController
public class VieshowAPIController {

    @Autowired
    VieshowService vieshowService;

    //將爬文好的資料存到DB,新增或更新
    @PostMapping(value="/save",consumes = "application/json")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public void news(@RequestBody List<VieshowBean> vieshowBeanList){
        for(VieshowBean vieshowBean:vieshowBeanList){
            vieshowService.saveOrUpdate(vieshowBean);
        }
    }

}
