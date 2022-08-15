package xyz.epoch.wallettracker.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class APIListResponseModel {

    private int status ;
    private String message;
    private TransactionDTO[] result;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public TransactionDTO[] getResult() {
        return result;
    }

    public void setResult(TransactionDTO[] result) {
        this.result = result;
    }
}
