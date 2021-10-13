package com.jxzj.external.data.netty;

import java.io.File;
import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NIOFileChannel_02 {

    public static void main(String[] args) throws Exception {

        File file = new File("D://file01.txt");
        FileInputStream fileInputStream = new FileInputStream(file);
        FileChannel channel = fileInputStream.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocate((int)file.length());
        channel.read(byteBuffer);

        // System.out.println(byteBuffer.toString());
        System.out.println(new String(byteBuffer.array()));
        fileInputStream.close();

    }

}
