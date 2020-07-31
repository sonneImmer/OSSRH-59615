package com.ustb.dao;

import com.ustb.bean.ChainParam;
import com.ustb.util.ChainType;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
import com.ustb.shellchain.command.ShellChainCommand;

import javax.annotation.PostConstruct;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by admin on 2018/7/3 0003.
 */
//@Repository
public class ShellChainConnection {

    //@Autowired
    //private ChainParamMapper chainParamMapper;

    private ReentrantReadWriteLock subjectLock = new ReentrantReadWriteLock();
    private ReentrantReadWriteLock objectLock = new ReentrantReadWriteLock();

    private ShellChainCommand subjectCommand;
    private ShellChainCommand objectCommand;

    private  ChainParam subjectParam;
    private  ChainParam objectParam;

//    private static ThreadLocal<ShellChainCommand> subjectCommand = new ThreadLocal<ShellChainCommand>();
//
//    private static ThreadLocal<ShellChainCommand> objectCommand = new ThreadLocal<ShellChainCommand>();
//
//    private static ThreadLocal<ShellChainCommand> tortCommend = new ThreadLocal<ShellChainCommand>();

    @PostConstruct
    private void initialize(){
        ChainParam subjectParam = new ChainParam();
        ChainParam objectParam = new ChainParam();
        this.subjectParam= subjectParam;
        this.objectParam=objectParam;
        if(subjectParam!=null && subjectCommand==null){
            this.subjectCommand = new ShellChainCommand(subjectParam);
        }
        if(objectParam!=null && objectCommand==null){
            this.objectCommand = new ShellChainCommand(objectParam);
        }
    }


    public  ShellChainCommand getSubjectCommand() {
        subjectLock.readLock().lock();
        try {
            return subjectCommand;
        }finally {
            subjectLock.readLock().unlock();
        }

//        if(this.subjectCommand.get()==null){
//            ShellChainCommand shellChainCommand=new ShellChainCommand(subjectParam);
//            this.subjectCommand.set(shellChainCommand);
//            return shellChainCommand;
//        }else {
//            return this.subjectCommand.get();
//        }
    }

    public void setSubjectCommand(ShellChainCommand subjectCommand) {
        subjectLock.writeLock().lock();
        try{
            this.subjectCommand = subjectCommand;
        }finally {
            subjectLock.writeLock().unlock();
        }
    }

    public ShellChainCommand getObjectCommand() {
        objectLock.readLock().lock();
        try {
            return objectCommand;
        }finally {
            objectLock.readLock().unlock();
        }
    }

    public void setObjectCommand(ShellChainCommand objectCommand) {
        objectLock.writeLock().lock();
        try {
            this.objectCommand = objectCommand;
        }finally {
            objectLock.writeLock().unlock();
        }
    }

    public boolean addNewCommand(ChainParam chainParam){
        switch (ChainType.getChainType(chainParam.getChainType())){
            case SUBJECT:{
                if(this.subjectCommand==null){
                    this.subjectCommand = new ShellChainCommand(chainParam);
                    return true;
                }else {
                    return false;
                }
            }
            case OBJECT:{
                if(this.objectCommand==null){
                    this.objectCommand = new ShellChainCommand(chainParam);
                    return true;
                }else {
                    return false;
                }
            }
            default:return false;

        }
    }

    public String getMainAddress(ChainType chainType){
        switch (chainType){
            case SUBJECT:return this.subjectParam.getMainAddress();
            case OBJECT:return this.objectParam.getMainAddress();
            default:return null;
        }
    }
}
