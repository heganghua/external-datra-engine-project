package com.jxzj.external.data.netty;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

/**
 * 通过transferFrom复制通道实现图的拷贝
 * 
 * @author heganghua
 * @date 2021/10/12
 */
public class NIOFileChannel_04 {

    public static void main(String[] args) throws IOException {

        FileInputStream fileInputStream = new FileInputStream("D:\\DownloadFile\\a.jpg");
        FileChannel InChannel = fileInputStream.getChannel();

        FileOutputStream fileOutputStream = new FileOutputStream("D:\\DownloadFile\\b.jpg");
        FileChannel OutChannel = fileOutputStream.getChannel();

        OutChannel.transferFrom(InChannel, 0, InChannel.size());

        OutChannel.close();
        InChannel.close();
        fileInputStream.close();
        fileOutputStream.close();
    }
}
