package job.admin.bean;

import java.io.Serializable;

public class VieshowBean implements Serializable {
    private int pkid;
    private String movename;
    private String img;
    private String url;
    private String checkdate;
    private int totalcount; //count(*)用

    @Override
    public String toString() {
        return "VieshowBean{" +
                "pkid=" + pkid +
                ", movename='" + movename + '\'' +
                ", img='" + img + '\'' +
                ", url='" + url + '\'' +
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

    public String getMovename() {
        return movename;
    }

    public void setMovename(String movename) {
        this.movename = movename;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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
