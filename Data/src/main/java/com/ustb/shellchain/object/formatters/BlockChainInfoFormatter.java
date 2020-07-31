package com.ustb.shellchain.object.formatters;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.internal.LinkedTreeMap;
import com.ustb.shellchain.object.BlockChainInfo;

/**
 * Created by admin on 2018/7/31 0031.
 */
public class BlockChainInfoFormatter {

    public final static BlockChainInfo formatPeerInfo(Object objectPeerInfo) {
        BlockChainInfo peerInfo = new BlockChainInfo();

        if (objectPeerInfo != null && LinkedTreeMap.class.isInstance(objectPeerInfo)) {
            GsonBuilder builder = new GsonBuilder();
            Gson gson = builder.create();
            String jsonValue = gson.toJson(objectPeerInfo);
            peerInfo = gson.fromJson(jsonValue, BlockChainInfo.class);
        }

        return peerInfo;
    }
}
