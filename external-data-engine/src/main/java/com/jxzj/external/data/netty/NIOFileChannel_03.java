package com.jxzj.external.data.netty;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 利用Channel和Buffer实现文件拷贝
 * 
 * @author heganghua
 * @date 2021/10/12
 */
public class NIOFileChannel_03 {
    public static void main(String[] args) throws IOException {

        FileInputStream fileInputStream = new FileInputStream("D://file01.txt");
        FileChannel InChannel = fileInputStream.getChannel();

        FileOutputStream fileOutputStream = new FileOutputStream("D://file02.txt");
        FileChannel OutChannel = fileOutputStream.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocate(512);
        while (true) {
            byteBuffer.clear();
            int read = InChannel.read(byteBuffer);

            if (-1 == read) {
                break;
            }
            byteBuffer.flip();
            OutChannel.write(byteBuffer);
        }

        fileInputStream.close();
        fileOutputStream.close();
    }

}
