package com.ustb.shellchain.object;

/**
 * Created by admin on 2018/7/11 0011.
 */
public class PeerInfo {

    int id;
    String addr;
    String addrlocal;
    Long lastsend;
    Long lasteecv;
    Long conntime;
    Long bytessent;
    Long bytesrecv;
    Float pingtime;
    String handshake;
    String handshakelocal;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getAddrlocal() {
        return addrlocal;
    }

    public void setAddrlocal(String addrlocal) {
        this.addrlocal = addrlocal;
    }

    public Long getLastsend() {
        return lastsend;
    }

    public void setLastsend(Long lastsend) {
        this.lastsend = lastsend;
    }

    public Long getLasteecv() {
        return lasteecv;
    }

    public void setLasteecv(Long lasteecv) {
        this.lasteecv = lasteecv;
    }

    public Long getConntime() {
        return conntime;
    }

    public void setConntime(Long conntime) {
        this.conntime = conntime;
    }

    public Long getBytessent() {
        return bytessent;
    }

    public void setBytessent(Long bytessent) {
        this.bytessent = bytessent;
    }

    public Long getBytesrecv() {
        return bytesrecv;
    }

    public void setBytesrecv(Long bytesrecv) {
        this.bytesrecv = bytesrecv;
    }

    public Float getPingtime() {
        return pingtime;
    }

    public void setPingtime(Float pingtime) {
        this.pingtime = pingtime;
    }

    public String getHandshake() {
        return handshake;
    }

    public void setHandshake(String handshake) {
        this.handshake = handshake;
    }

    public String getHandshakelocal() {
        return handshakelocal;
    }

    public void setHandshakelocal(String handshakelocal) {
        this.handshakelocal = handshakelocal;
    }
}
