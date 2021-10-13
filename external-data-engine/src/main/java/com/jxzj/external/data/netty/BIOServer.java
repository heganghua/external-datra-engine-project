package com.jxzj.external.data.netty;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BIOServer {

    public static void main(String[] args) throws IOException {

        ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();

        ServerSocket serverSocket = new ServerSocket(6666);
        System.out.println("服务端启动了。。。。。。");

        while (true) {
            Socket accept = serverSocket.accept();
            System.out.println("连接到一个客户端。。。。");

            newCachedThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    handle(accept);
                }
            });
        }

    }

    public static void handle(Socket socket) {

        System.out.println("ID: " + Thread.currentThread().getId() + "Name: " + Thread.currentThread().getName());

        IntBuffer allocate = IntBuffer.allocate(5);
        ByteBuffer allocate2 = ByteBuffer.allocate(1024);

        try {
            byte[] b = new byte[1024];
            InputStream inputStream = socket.getInputStream();
            int end = 0;
            while ((end = inputStream.read(b)) != -1) {
                System.out
                    .println("ID: " + Thread.currentThread().getId() + "Name: " + Thread.currentThread().getName());
                System.out.println(new String(b, 0, end));
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("连接关闭");
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}
