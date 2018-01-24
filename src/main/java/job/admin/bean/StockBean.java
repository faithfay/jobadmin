package job.admin.bean;

import java.io.Serializable;

public class StockBean implements Serializable{

    private Integer pkid;
    private Integer gpkid;
    private String stockName;
    private String stockNumber;
    private StockGroupBean stockGroupBean;

    @Override
    public String toString() {
        return "StockBean{" +
                "pkid=" + pkid +
                ", gpkid=" + gpkid +
                ", stockName='" + stockName + '\'' +
                ", stockNumber='" + stockNumber + '\'' +
                ", stockGroupBean=" + stockGroupBean +
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

    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    public String getStockNumber() {
        return stockNumber;
    }

    public void setStockNumber(String stockNumber) {
        this.stockNumber = stockNumber;
    }

    public StockGroupBean getStockGroupBean() {
        return stockGroupBean;
    }

    public void setStockGroupBean(StockGroupBean stockGroupBean) {
        this.stockGroupBean = stockGroupBean;
    }
}
