package xyz.epoch.wallettracker.Model;

public class CovalentAPIResponseModel {
    private CovalentAPITxnDTO data ;

    @Override
    public String toString() {
        return "CovalentAPIResponseModel{" +
                "data=" + data +
                '}';
    }

    public CovalentAPITxnDTO getData() {
        return data;
    }

    public void setData(CovalentAPITxnDTO data) {
        this.data = data;
    }
}
