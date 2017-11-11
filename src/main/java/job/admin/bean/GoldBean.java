package job.admin.bean;

import java.io.Serializable;

public class GoldBean implements Serializable {

    private int pkid;
    private String buy;
    private String sell;
    private String checkDate;
    private String checkTime;

    @Override
    public String toString() {
        return "GoldBean{" +
                "pkid=" + pkid +
                ", buy='" + buy + '\'' +
                ", sell='" + sell + '\'' +
                ", checkDate='" + checkDate + '\'' +
                ", checkTime='" + checkTime + '\'' +
                '}';
    }

    public int getPkid() {
        return pkid;
    }

    public void setPkid(int pkid) {
        this.pkid = pkid;
    }

    public String getBuy() {
        return buy;
    }

    public void setBuy(String buy) {
        this.buy = buy;
    }

    public String getSell() {
        return sell;
    }

    public void setSell(String sell) {
        this.sell = sell;
    }

    public String getCheckDate() {
        return checkDate;
    }

    public void setCheckDate(String checkDate) {
        this.checkDate = checkDate;
    }

    public String getCheckTime() {
        return checkTime;
    }

    public void setCheckTime(String checkTime) {
        this.checkTime = checkTime;
    }
}
