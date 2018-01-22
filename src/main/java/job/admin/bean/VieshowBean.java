package job.admin.bean;

import java.io.Serializable;

public class VieshowBean implements Serializable {
    private int pkid;
    private String mname;
    private String mimg;
    private String murl;
    private String checkdate;
    private int totalcount; //count(*)用

    @Override
    public String toString() {
        return "VieshowBean{" +
                "pkid=" + pkid +
                ", mname='" + mname + '\'' +
                ", mimg='" + mimg + '\'' +
                ", murl='" + murl + '\'' +
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

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public String getMimg() {
        return mimg;
    }

    public void setMimg(String mimg) {
        this.mimg = mimg;
    }

    public String getMurl() {
        return murl;
    }

    public void setMurl(String murl) {
        this.murl = murl;
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
