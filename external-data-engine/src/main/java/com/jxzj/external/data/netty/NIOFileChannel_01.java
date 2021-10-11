package com.jxzj.external.data.netty;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NIOFileChannel_01 {

    public static void main(String[] args) {

        String str = "Hello Word!";

        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        byteBuffer.put(str.getBytes());
        // 翻转，从写到读
        byteBuffer.flip();

        try {
            FileOutputStream fileOutputStream = new FileOutputStream("d:\\file01.txt");
            // 根据文件流得到一个channel
            FileChannel channel = fileOutputStream.getChannel();
            channel.write(byteBuffer);
            fileOutputStream.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
