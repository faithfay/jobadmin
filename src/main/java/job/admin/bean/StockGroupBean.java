package job.admin.bean;

import java.io.Serializable;

public class StockGroupBean implements Serializable {

    private Integer pkid;
    private String stockCategory;
    private String stockName;
    private String stockNumber;
    private Integer totalCount;

    @Override
    public String toString() {
        return "StockGroupBean{" +
                "pkid=" + pkid +
                ", stockCategory='" + stockCategory + '\'' +
                ", stockName='" + stockName + '\'' +
                ", stockNumber='" + stockNumber + '\'' +
                ", totalCount=" + totalCount +
                '}';
    }

    public Integer getPkid() {
        return pkid;
    }

    public void setPkid(Integer pkid) {
        this.pkid = pkid;
    }

    public String getStockCategory() {
        return stockCategory;
    }

    public void setStockCategory(String stockCategory) {
        this.stockCategory = stockCategory;
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

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }
}
