package com.wxy.frame.rpc.common.util;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.dyuproject.protostuff.LinkedBuffer;
import com.dyuproject.protostuff.ProtostuffIOUtil;
import com.dyuproject.protostuff.Schema;
import com.dyuproject.protostuff.runtime.RuntimeSchema;
import com.wxy.frame.rpc.common.exception.SerializationException;
import org.objenesis.Objenesis;
import org.objenesis.ObjenesisStd;

/**
 * 序列化工具类（基于 Protostuff 实现）
 * Created by yoyoo on 17-6-10.
 */
public class SerializationUtil {
    private static Map<Class<?>, Schema<?>> cachedSchema = new ConcurrentHashMap<>();
    private static Objenesis objenesis = new ObjenesisStd(true);

    public static <T> byte[] serialize(T obj){
        Class<T> cls = (Class<T>) obj.getClass();
        LinkedBuffer buffer = LinkedBuffer.allocate(LinkedBuffer.DEFAULT_BUFFER_SIZE);
        try{
            Schema<T> schema = getSchema(cls);
            return ProtostuffIOUtil.toByteArray(obj,schema,buffer);
        }catch (Exception e){
            throw new SerializationException(SerializationException.SEARIALIZE,e);
        }finally {
            buffer.clear();
        }
    }
    public static <T>T deserialize(byte[] data,Class<T> cls){
        try{
            T message = objenesis.newInstance(cls);
            Schema<T> schema = getSchema(cls);
            ProtostuffIOUtil.mergeFrom(data, message, schema);

            return message;
        }catch (Exception e){
            throw new SerializationException(SerializationException.DESERIALIZE,e);
        }

    }
    private static <T> Schema<T> getSchema(Class<T> cls){
        Schema<T> schema = (Schema<T>)cachedSchema.get(cls);
        if (schema == null){
            schema = RuntimeSchema.createFrom(cls);
            cachedSchema.put(cls,schema);
        }
        return schema;
    }
}
