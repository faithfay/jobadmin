package job.admin.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ComicsAPIController {


    //http://www.popomh.com
    //泡泡漫畫,因為圖是亂數組合,抓亂數回來重組成圖的網址
    //來源有兩個

    //http://165.94201314.net/dm04/
    //http://124.94201314.net/dm04/
    //http://dmeden.net/
    //http://164.94201314.net/dm10/
    //http://100.94201314.net/dm10/
    @GetMapping("/api/comics/popo/imgurl")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public void getPoPo(){

    }
}
