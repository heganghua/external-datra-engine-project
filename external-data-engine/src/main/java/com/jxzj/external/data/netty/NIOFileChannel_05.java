package com.jxzj.external.data.netty;

import java.nio.ByteBuffer;

public class NIOFileChannel_05 {
    public static void main(String[] args) {

        ByteBuffer byteBuffer = ByteBuffer.allocate(64);

        byteBuffer.putInt(1);
        byteBuffer.putInt(2);
        byteBuffer.flip();

        byte b = byteBuffer.get();
        System.out.println((int)b);

    }
}
