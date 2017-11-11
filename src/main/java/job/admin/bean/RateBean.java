package job.admin.bean;

import java.io.Serializable;

public class RateBean implements Serializable{
    private int pkid;
    private String rate_name;
    private String rate;
    private String checkdate;
    private String checktime;

    @Override
    public String toString() {
        return "RateBean{" +
                "pkid=" + pkid +
                ", rate_name='" + rate_name + '\'' +
                ", rate='" + rate + '\'' +
                ", checkdate='" + checkdate + '\'' +
                ", checktime='" + checktime + '\'' +
                '}';
    }

    public int getPkid() {
        return pkid;
    }

    public void setPkid(int pkid) {
        this.pkid = pkid;
    }

    public String getRate_name() {
        return rate_name;
    }

    public void setRate_name(String rate_name) {
        this.rate_name = rate_name;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getCheckdate() {
        return checkdate;
    }

    public void setCheckdate(String checkdate) {
        this.checkdate = checkdate;
    }

    public String getChecktime() {
        return checktime;
    }

    public void setChecktime(String checktime) {
        this.checktime = checktime;
    }
}
