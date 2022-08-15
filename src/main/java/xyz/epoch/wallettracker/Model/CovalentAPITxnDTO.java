package xyz.epoch.wallettracker.Model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Arrays;


@JsonIgnoreProperties(ignoreUnknown = true)
public class CovalentAPITxnDTO {
    private String address ;
    private String updated_at ;
    private String next_update_at ;
    private String quote_currency ;
    private int chain_id ;
    private TxnDTO[] items ;
    private boolean error ;
    private String error_message ;
    private String has_more ;


    @Override
    public String toString() {
        return "CovalentAPITxnDTO{" +
                "address='" + address + '\'' +
                ", updated_at='" + updated_at + '\'' +
                ", next_update_at='" + next_update_at + '\'' +
                ", quote_currency='" + quote_currency + '\'' +
                ", chain_id=" + chain_id +
                ", items=" + Arrays.toString(items) +
                ", error=" + error +
                ", error_message='" + error_message + '\'' +
                ", has_more='" + has_more + '\'' +
                '}';
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public String getNext_update_at() {
        return next_update_at;
    }

    public void setNext_update_at(String next_update_at) {
        this.next_update_at = next_update_at;
    }

    public String getQuote_currency() {
        return quote_currency;
    }

    public void setQuote_currency(String quote_currency) {
        this.quote_currency = quote_currency;
    }

    public int getChain_id() {
        return chain_id;
    }

    public void setChain_id(int chain_id) {
        this.chain_id = chain_id;
    }

    public TxnDTO[] getItems() {
        return items;
    }

    public void setItems(TxnDTO[] items) {
        this.items = items;
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public String getError_message() {
        return error_message;
    }

    public void setError_message(String error_message) {
        this.error_message = error_message;
    }

    public String getHas_more() {
        return has_more;
    }

    public void setHas_more(String has_more) {
        this.has_more = has_more;
    }
}
