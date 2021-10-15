package com.jxzj.external.data.netty;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Arrays;

public class NIOFileChannel_07 {

    public static void main(String[] args) throws IOException {

        // 定义一个Socket端口
        InetSocketAddress inetSocketAddress = new InetSocketAddress(8000);
        ServerSocketChannel open = ServerSocketChannel.open();
        // 将端口绑定到socket
        open.socket().bind(inetSocketAddress);

        ByteBuffer[] byteBuffers = new ByteBuffer[2];
        byteBuffers[0] = ByteBuffer.allocate(5);
        byteBuffers[1] = ByteBuffer.allocate(3);

        SocketChannel socketChannel = open.accept();
        // 假定从客户端接受八个字节得数据
        final int MASSAGE_LENGTH = 8;

        while (true) {

            // 已经读取字节长度
            int byteRead = 0;
            // 从客户端读入数据到内存
            while (byteRead < MASSAGE_LENGTH) {
                long read = socketChannel.read(byteBuffers);
                byteRead += read;
                System.out.println("累计读取数据长度：" + byteRead);
                // 流打印， 查看当前buffer得limint、postion
                Arrays.asList(byteBuffers).stream()
                    .map(buffer -> "Postion: " + buffer.position() + "limint: " + buffer.limit())
                    .forEach(System.out::print);
                // Arrays.asList(byteBuffers).stream().forEach(buffer -> {
                // System.out.println("Postion: " + buffer.position() + "limint: " + buffer.limit());
                // });
            }

            // 反转buffers
            Arrays.asList(byteBuffers).stream().forEach(buffer -> buffer.flip());

            // 从内存写入到控制台

            int byteWirte = 0;
            while (byteWirte < MASSAGE_LENGTH) {

            }

        }

    }
}
