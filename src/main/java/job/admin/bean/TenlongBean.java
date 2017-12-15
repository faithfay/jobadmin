package job.admin.bean;

import java.io.Serializable;

public class TenlongBean implements Serializable {
    private int pkid;
    private String catelogs;
    private String bookname;
    private String sell;
    private String imgurl;
    private String bookurl;
    private String checkdate;
    private int totalcount; //count(*)用

    @Override
    public String toString() {
        return "TenlongBean{" +
                "pkid=" + pkid +
                ", catelogs='" + catelogs + '\'' +
                ", bookname='" + bookname + '\'' +
                ", sell='" + sell + '\'' +
                ", imgurl='" + imgurl + '\'' +
                ", bookurl='" + bookurl + '\'' +
                ", checkdate='" + checkdate + '\'' +
                ", totalcount=" + totalcount +
                '}';
    }

    public int getPkid() {
        return pkid;
    }

    public void setPkid(int pkid) {
        this.pkid = pkid;
    }

    public String getCatelogs() {
        return catelogs;
    }

    public void setCatelogs(String catelogs) {
        this.catelogs = catelogs;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public String getSell() {
        return sell;
    }

    public void setSell(String sell) {
        this.sell = sell;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

    public String getBookurl() {
        return bookurl;
    }

    public void setBookurl(String bookurl) {
        this.bookurl = bookurl;
    }

    public String getCheckdate() {
        return checkdate;
    }

    public void setCheckdate(String checkdate) {
        this.checkdate = checkdate;
    }

    public int getTotalcount() {
        return totalcount;
    }

    public void setTotalcount(int totalcount) {
        this.totalcount = totalcount;
    }
}
