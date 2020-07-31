package com.ustb.shellchain.object;

import java.util.Map;

/**
 * Created by lenovo on 2018/8/5.
 */
public class TransactionObject extends TransactionRawDetail {
    String id;
    Map<String,Object> creator;
    String video_hash;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Map<String, Object> getCreator() {
        return creator;
    }

    public void setCreator(Map<String, Object> creator) {
        this.creator = creator;
    }

    public String getVideo_hash() {
        return video_hash;
    }

    public void setVideo_hash(String video_hash) {
        this.video_hash = video_hash;
    }
}
