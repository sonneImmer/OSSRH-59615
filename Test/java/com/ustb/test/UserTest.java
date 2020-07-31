package com.ustb.test;

import com.ustb.util.HttpRequestUtils;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserTest {

    public static void main(String args[]){
        Map<String,Object> params=new HashMap<String, Object>();
        String[] access_token={"f4dcf9a399e3848a26da8dd4916d3dbf3cde5910c04ea4e16a648358e5c4c408"};
        String[] name={"周志远"};
        String[] idCard={"0000000"};
        Integer[] type={0};
        for(int i=0;i<access_token.length;i++){
            params.put("access_token",access_token[i]);
            System.out.println("access_token:"+access_token[i]);
            for(int j=0;j<name.length;j++){
                params.put("name",name[j]);
                System.out.println("name:"+name[j]);
                for(int k=0;k<100;k++){
                    params.put("idCard",idCard[0]+k);
                    System.out.println("idCard:"+idCard[0]);
                    for(int l=0;l<type.length;l++){
                        params.put("type",type[l]);
                        System.out.println("type:"+type[l]);
                        String result= HttpRequestUtils.post("http://127.0.0.1:8080/user/regist.do",params);
                        System.out.println(result);
                    }
                }
            }
        }

    }

    @Test
    public void testUserquery(){
        Map<String,Object> params=new HashMap<String, Object>();
        String[] access_token={"7ba8763733dd2c430ef718466b825d6a15a56184fe77f8227643f9e358c96e25"};
        String[] user_id={"","4a4eb3c7be1dc441860d71558a1a5cc8","cb5904b2874a45829fe231565bd2c2cb5904b2874a45829fe231565bd2c2cb5904b2874a45829fe231565bd2c2cb5904b2874a45829fe231565bd2c2cb5904b2874a45829fe231565bd2c2cb5904b2874a45829fe231565bd2c2cb5904b2874a45829fe231565bd2c2cb5904b2874a45829fe231565bd2c2cb5904b2874a45829fe231565bd2c2cb5904b2874a45829fe231565bd2c2","123123123"};
        for(int i=0;i<access_token.length;i++){
            params.put("access_token",access_token[i]);
            System.out.println("access_token:"+access_token[i]);
            for(int j=0;j<user_id.length;j++){
                params.put("user_id",user_id[j]);
                System.out.println("user_id:"+user_id[j]);
                String result= HttpRequestUtils.post("http://127.0.0.1:8080/user/queryofuser.do",params);
                System.out.println(result);
            }
        }
    }

}
