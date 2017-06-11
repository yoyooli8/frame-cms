package com.wxy.frame.rpc.common.codec;

import com.wxy.frame.rpc.common.util.SerializationUtil;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

/**
 * RPC 解码器
 * Created by yoyoo on 17-6-10.
 */
public class RpcDecoder extends ByteToMessageDecoder {
    private Class<?> genericClass;
    public RpcDecoder(Class<?> genericClass){
        this.genericClass = genericClass;
    }
    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        if (in.readableBytes() < 4) {
            return;
        }
        in.markReaderIndex();
        int dataLength = in.readInt();//数据域长度
        if (in.readableBytes() < dataLength) {
            in.resetReaderIndex();
            return;
        }

        byte[] data = new byte[dataLength];
        in.readBytes(data);

        out.add(SerializationUtil.deserialize(data, genericClass));//反序列化数据
    }
}
