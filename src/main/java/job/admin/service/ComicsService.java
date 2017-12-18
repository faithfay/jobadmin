package job.admin.service;

import org.springframework.stereotype.Service;

@Service
public class ComicsService {



    public String popomhImgUrl(String imgUrl){

        String imgHandle = imgUrl.substring(imgUrl.length() - 1);
        String encodeStr = "abcdefghijklmnopqrstuvwxyz";
        int encodeHandle = encodeStr.indexOf(imgHandle) + 1;
        String imgEncode = imgUrl.substring(imgUrl.length() - encodeHandle - 12,imgUrl.length() - encodeHandle - 1);
        String imgSpilFirst = imgEncode.substring(0,imgEncode.length() - 1);
        String imgSpilLast = imgEncode.substring(imgEncode.length() - 1);
        String[] tmpStr = null;
        imgUrl = imgUrl.substring(0,imgUrl.length() - encodeHandle - 12);

        for(int i=0;i<imgSpilFirst.length();i++){
            imgUrl = imgUrl.replace(imgSpilFirst.substring(i,i + 1),String.valueOf(i));
        }
        tmpStr = imgUrl.split(imgSpilLast);

        imgUrl = "";

        for(String str:tmpStr){
            int tmpInt = Integer.valueOf(str);
            imgUrl += new Character((char)tmpInt).toString();
        }
        System.out.println(imgUrl);
        return imgUrl;
    }
}
