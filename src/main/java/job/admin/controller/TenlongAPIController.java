package job.admin.controller;

import job.admin.bean.TenlongBean;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@Controller
public class TenlongAPIController {

    //接收傳來的JSON物件
    //將HTTP狀態設為200
    @RequestMapping(value="/tenlong",consumes = "application/json")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public void test(@RequestBody List<TenlongBean> tenlongBeanList){
            //新增到資料庫
//        for(TenlongBean tenlongBean:tenlongBeanList){
//            System.out.println(tenlongBean.toString());
//        }
    }
}
