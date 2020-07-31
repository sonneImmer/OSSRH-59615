package com.ustb.dao;

import com.google.gson.internal.LinkedHashTreeMap;
import com.ustb.shellchain.command.ShellChainException;
import com.ustb.util.ChainType;
import org.apache.commons.codec.digest.DigestUtils;
//import org.apache.commons.codec.digest.DigestUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * Created by lenovo on 2018/11/10.
 */
//@Repository
public class UserChainDao {

    //@Autowired
    private ShellChainConnection shellChainConnection;

    public Map<String,String> addUser(Map<String,Object> att) throws Exception {
        try {
            //获取主体链主地址
            String subjectMainAddress=shellChainConnection.getMainAddress(ChainType.SUBJECT);
            if(subjectMainAddress==null || subjectMainAddress.equals("")){
                subjectMainAddress="*";
            }
            //请求主体链创建用户实体
            Map<String,String> result=shellChainConnection.getSubjectCommand().getAddressCommand().createEntity(3,subjectMainAddress);
            shellChainConnection.getSubjectCommand().removeAddressCommand();

            if(result!=null){
                //在主体链上发布用户
                String txId=shellChainConnection.getSubjectCommand().getIssueCommand().issueEntityFrom(subjectMainAddress,result.get("address").toString(),"3"
                        , DigestUtils.md5Hex((String)att.get("account")),result.get("privkey").toString(),"******",att);
                shellChainConnection.getSubjectCommand().removeIssueCommand();
                if(txId!=null){
                    result.put("issue_tx_id",txId);
                    result.put("chain_id",shellChainConnection.getSubjectCommand().getChainId().toString());
                }else {
                    return null;
                }
                return result;
            }
        } catch (ShellChainException e) {
            throw new Exception("Server Internal error");
        }
        return null;
    }

    public Map<String, String> updateUser(Map<String, Object> att) throws Exception {
        Map<String, String> result = new LinkedHashTreeMap<>();
        try {
            // 获取主体链主地址
            String subjectMainAddress = shellChainConnection.getMainAddress(ChainType.SUBJECT);
            if (subjectMainAddress == null || subjectMainAddress.equals("")) subjectMainAddress = "*";

            // 在主体链更新用户
            String txId = (String)shellChainConnection
                    .getSubjectCommand().getIssueCommand().sendCustom(subjectMainAddress, 0, att);
            shellChainConnection
                    .getSubjectCommand().removeIssueCommand();
            if(txId != null) {
                for(Map.Entry<String, Object> entry:att.entrySet()) {
                    if (String.class.isInstance(entry.getValue()))
                        result.put(entry.getKey(), (String)entry.getValue());
                }
                result.put("issue_tx_id", txId);
                result.put("chain_id", shellChainConnection
                        .getSubjectCommand().getChainId().toString());
            }
        } catch (ShellChainException e) {
            e.printStackTrace();
            throw new Exception("Subject Chain Internal Error");
        }
        return result;
    }

    public Map<String,String> getInfo() throws Exception{
        Map<String,String> result = new LinkedHashTreeMap<>();
        try{
            //获取主体链地址
            String subjetMainAddres = (String)shellChainConnection.getMainAddress(ChainType.SUBJECT);
            if (subjetMainAddres == null || subjetMainAddres.equals(""))subjetMainAddres="*";

            //在主体链请求信息
            String Info = (String) shellChainConnection
                    .getSubjectCommand().getIssueCommand().getInfo();
            shellChainConnection
                    .getSubjectCommand().removeIssueCommand();
            result.put("Info", Info);


        }catch (ShellChainException e){
            e.printStackTrace();
            throw new Exception("Subject Chain Internal Error");
        }

        return result;
    }

}
