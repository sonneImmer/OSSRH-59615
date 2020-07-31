package com.ustb.shellchain.object.formatters;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.internal.LinkedTreeMap;
import com.ustb.shellchain.object.PeerInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2018/7/11 0011.
 */
public class PeerInfoFormatter {
    public final static PeerInfo formatPeerInfo(Object objectPeerInfo) {
        PeerInfo peerInfo = new PeerInfo();

        if (objectPeerInfo != null && LinkedTreeMap.class.isInstance(objectPeerInfo)) {
            GsonBuilder builder = new GsonBuilder();
            Gson gson = builder.create();

            String jsonValue = gson.toJson(objectPeerInfo);
            peerInfo = gson.fromJson(jsonValue, PeerInfo.class);
        }

        return peerInfo;
    }


    public final static List<PeerInfo> formatPeerInfoList(List<Object> objectPeerInfos) {
        List<PeerInfo> peerInfos = new ArrayList<PeerInfo>();

        if (objectPeerInfos != null) {
            for (Object objectPeerInfo : objectPeerInfos) {
                peerInfos.add(formatPeerInfo(objectPeerInfo));
            }
        }
        return peerInfos;
    }
}
