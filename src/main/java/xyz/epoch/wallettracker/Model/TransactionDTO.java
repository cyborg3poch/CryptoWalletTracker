package xyz.epoch.wallettracker.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.math.BigInteger;

@JsonIgnoreProperties(ignoreUnknown = true)
public  class TransactionDTO {
    private int tid ;

    private String TransactionType ;

    public String getTransactionType() {
        return TransactionType;
    }

    private long blockNumber ;
    private String hash ;
    private long timeStamp;
    private String from;
    private String to ;
    private BigInteger value ;
    private BigInteger gas;
    private int walletId ;

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public long getBlockNumber() {
        return blockNumber;
    }

    public void setBlockNumber(long blockNumber) {
        this.blockNumber = blockNumber;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public BigInteger getValue() {
        return value;
    }

    public void setValue(BigInteger value) {
        this.value = value;
    }

    public BigInteger getGas() {
        return gas;
    }

    public void setGas(BigInteger gas) {
        this.gas = gas;
    }

    public int getWalletId() {
        return walletId;
    }

    public void setWalletId(int walletId) {
        this.walletId = walletId;
    }

    @Override
    public String toString() {
        return "TransactionDTO{" +
                "tid=" + tid +
                ", blockNumber=" + blockNumber +
                ", hash='" + hash + '\'' +
                ", timeStamp=" + timeStamp +
                ", from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", value=" + value +
                ", gas=" + gas +
                ", walletId=" + walletId +
                '}';
    }
}
