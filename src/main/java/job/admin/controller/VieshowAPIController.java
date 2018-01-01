package job.admin.controller;

import job.admin.bean.VieshowBean;
import job.admin.service.VieshowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class VieshowAPIController {

    @Autowired
    VieshowService vieshowService;

    @PostMapping(value="/api/vieshow/news",consumes = "application/json")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public void news(@RequestBody List<VieshowBean> vieshowBeanList){
        for(VieshowBean vieshowBean:vieshowBeanList){
            vieshowService.saveOfUpdate(vieshowBean);
        }
    }

}
