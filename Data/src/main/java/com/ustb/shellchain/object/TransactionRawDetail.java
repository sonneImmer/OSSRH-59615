package com.ustb.shellchain.object;

/**
 * Created by admin on 2018/7/12 0012.
 */
public class TransactionRawDetail extends TransactionRAW {
    long blocktime;
    long time;
    int confirmations;
    String blockhash;

    public long getBlocktime() {
        return blocktime;
    }

    public void setBlocktime(long blocktime) {
        this.blocktime = blocktime;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public int getConfirmations() {
        return confirmations;
    }

    public void setConfirmations(int confirmations) {
        this.confirmations = confirmations;
    }

    public String getBlockhash() {
        return blockhash;
    }

    public void setBlockhash(String blockhash) {
        this.blockhash = blockhash;
    }
}
