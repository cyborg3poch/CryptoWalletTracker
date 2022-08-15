package xyz.epoch.wallettracker.Model;

import xyz.epoch.wallettracker.Validation.ValidWalletAddress;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.List;


public class WalletDTO {

    protected int walletId;

    @NotNull
    @Pattern(regexp = "^0x[0-9a-fA-F]{40}$",message = "Invalid Wallet Address")
    protected String address  ;
    protected String ENS_name ;
    protected String chain ;
    protected List<TokenDTO> walletTokenList ;
    protected List<TransactionDTO> txnList ;
    protected int UserId ;
    protected boolean onWatchList ;
    protected long trackedBlockNo ;

    public int getWalletId() {
        return walletId;
    }

    public void setWalletId(int walletId) {
        this.walletId = walletId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getENS_name() {
        return ENS_name;
    }

    public void setENS_name(String ENS_name) {
        this.ENS_name = ENS_name;
    }

    public String getChain() {
        return chain;
    }

    public void setChain(String chain) {
        this.chain = chain;
    }

    public List<TokenDTO> getWalletTokenList() {
        return walletTokenList;
    }

    public void setWalletTokenList(List<TokenDTO> walletTokenList) {
        this.walletTokenList = walletTokenList;
    }

    public List<TransactionDTO> getTxnList() {
        return txnList;
    }

    public void setTxnList(List<TransactionDTO> txnList) {
        this.txnList = txnList;
    }

    public int getUserId() {
        return UserId;
    }

    public void setUserId(int userId) {
        UserId = userId;
    }

    public boolean getOnWatchList() {
        return onWatchList;
    }

    public void setOnWatchList(boolean onWatchList) {
        this.onWatchList = onWatchList;
    }

    public long getTrackedBlockNo() {
        return trackedBlockNo;
    }

    public void setTrackedBlockNo(long trackedBlockNo) {
        this.trackedBlockNo = trackedBlockNo;
    }
}
