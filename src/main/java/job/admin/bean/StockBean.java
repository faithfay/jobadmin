package job.admin.bean;

import java.io.Serializable;

public class StockBean implements Serializable{

    private Integer pkid;
    private Integer gpkid;
    private Integer stockPrice;

    @Override
    public String toString() {
        return "StockBean{" +
                "pkid=" + pkid +
                ", gpkid=" + gpkid +
                ", stockPrice=" + stockPrice +
                '}';
    }

    public Integer getPkid() {
        return pkid;
    }

    public void setPkid(Integer pkid) {
        this.pkid = pkid;
    }

    public Integer getGpkid() {
        return gpkid;
    }

    public void setGpkid(Integer gpkid) {
        this.gpkid = gpkid;
    }

    public Integer getStockPrice() {
        return stockPrice;
    }

    public void setStockPrice(Integer stockPrice) {
        this.stockPrice = stockPrice;
    }
}
