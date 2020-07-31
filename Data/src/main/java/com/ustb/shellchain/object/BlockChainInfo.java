package com.ustb.shellchain.object;

/**
 * Created by admin on 2018/7/31 0031.
 */
public class BlockChainInfo {
    String chainname;
    String description;
    Integer setupblocks;
    Boolean reindex;
    Integer blocks;
    String bestblockhash;
    Integer protocolversion;
    Float difficulty;
    Integer connections;

    public String getChainname() {
        return chainname;
    }

    public void setChainname(String chainname) {
        this.chainname = chainname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getSetupblocks() {
        return setupblocks;
    }

    public void setSetupblocks(Integer setupblocks) {
        this.setupblocks = setupblocks;
    }

    public Boolean getReindex() {
        return reindex;
    }

    public void setReindex(Boolean reindex) {
        this.reindex = reindex;
    }

    public Integer getBlocks() {
        return blocks;
    }

    public void setBlocks(Integer blocks) {
        this.blocks = blocks;
    }

    public String getBestblockhash() {
        return bestblockhash;
    }

    public void setBestblockhash(String bestblockhash) {
        this.bestblockhash = bestblockhash;
    }

    public Float getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Float difficulty) {
        this.difficulty = difficulty;
    }

    public Integer getConnections() {
        return connections;
    }

    public void setConnections(Integer connections) {
        this.connections = connections;
    }

    public Integer getProtocolversion() {
        return protocolversion;
    }

    public void setProtocolversion(Integer protocolversion) {
        this.protocolversion = protocolversion;
    }
}
