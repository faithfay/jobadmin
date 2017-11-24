package job.admin.bean;

public class TenlongBean {
    private int pkid;
    private String bookname;
    private String sell;
    private String imgurl;
    private String bookurl;
    private String checkdate;

    @Override
    public String toString() {
        return "TenlongBean{" +
                "pkid=" + pkid +
                ", bookname='" + bookname + '\'' +
                ", sell='" + sell + '\'' +
                ", imgurl='" + imgurl + '\'' +
                ", bookurl='" + bookurl + '\'' +
                ", checkdate='" + checkdate + '\'' +
                '}';
    }

    public int getPkid() {
        return pkid;
    }

    public void setPkid(int pkid) {
        this.pkid = pkid;
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
}
