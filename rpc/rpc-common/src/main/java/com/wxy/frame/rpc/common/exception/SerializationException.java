package com.wxy.frame.rpc.common.exception;

/**
 * Created by yoyoo on 17-6-10.
 */
public class SerializationException extends RuntimeException{
    public static final String SEARIALIZE  = "searialize";
    public static final String DESERIALIZE = "deserialize";
    private String serializationOpt = null;
    public SerializationException(){
        super();
        serializationOpt = SEARIALIZE;
    }
    public SerializationException(String serializationOpt){
        super();
        this.serializationOpt = serializationOpt;
    }
    public SerializationException(String serializationOpt,String errorMsg){
        super(errorMsg);
        this.serializationOpt = serializationOpt;
    }
    public SerializationException(String serializationOpt,Throwable cause){
        super(cause);
        this.serializationOpt = serializationOpt;
    }
    public SerializationException(String serializationOpt,String errorMsg,Throwable cause){
        super(errorMsg,cause);
        this.serializationOpt = serializationOpt;
    }
}
