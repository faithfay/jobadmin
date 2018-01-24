package job.admin.bean;

import java.io.Serializable;

public class StockGroupBean implements Serializable {

    private Integer pkid;
    private String stockCategory;

    @Override
    public String toString() {
        return "StockGroupBean{" +
                "pkid=" + pkid +
                ", stockCategory='" + stockCategory + '\'' +
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
}
