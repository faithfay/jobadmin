package job.admin.controller;

import job.admin.bean.TenlongBean;
import job.admin.service.TenlongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@Controller
public class TenlongAPIController {

    @Autowired
    private TenlongService tenlongService;

    //接收傳來的JSON物件
    //將HTTP狀態設為200
    @RequestMapping(value="/api/tenlong/first",consumes = "application/json")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public void first(@RequestBody List<TenlongBean> tenlongBeanList){
        tenlongService.save(tenlongBeanList);
    }

    @RequestMapping(value="/api/tenlong/save",consumes = "application/json")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public void save(@RequestBody List<TenlongBean> tenlongBeanList){
        tenlongService.save(tenlongBeanList);
    }
}
