package job.admin.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JobUtil {

    public String regStr(String str){
        String queryStr;
        String regEx = "[`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]";
        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher = pattern.matcher(str);
        queryStr = matcher.replaceAll("").replaceAll(" ","");
        System.out.println("queryStr>>>>>"+queryStr);
        return queryStr;
    }
}
