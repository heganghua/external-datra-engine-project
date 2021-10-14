package com.jxzj.external.data.netty;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;

public class NIOFileChannel_07 {

    public static void main(String[] args) throws IOException {

        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();

        InetSocketAddress inetSocketAddress = new InetSocketAddress(8000);
        // 将端口绑定到socket
        serverSocketChannel.socket().bind(inetSocketAddress);

    }
}
