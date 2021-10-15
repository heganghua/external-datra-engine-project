package com.jxzj.external.data.netty;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;

/**
 * MappedByteBuffer 实现堆外内存的拷贝
 * 
 * @author heganghua
 * @date 2021/10/13
 */
public class NIOFileChannel_06 {

    public static void main(String[] args) throws IOException {

        RandomAccessFile randomAccessFile = new RandomAccessFile("D://file01.txt", "rw");

        FileChannel channel = randomAccessFile.getChannel();

        MappedByteBuffer map = channel.map(MapMode.READ_WRITE, 0, 52);

        map.put(0, (byte)'b');
        map.put(51, (byte)'G');

        randomAccessFile.close();

    }

}
