package com.jxzj.external.data.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class InputStreamDemo {
    public static void main(String[] args) {
        InputStreamDemo.test3ByByte();
    }

    public static void test2ByReader() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(new File("./img/pingan.cookies.txt")));
            String str = new String();
            while ((str = br.readLine()) != null) {
                System.out.println(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void test3ByByte() {
        try {
            BufferedInputStream bi = new BufferedInputStream(new FileInputStream(new File("./img/pingan.cookies.txt")));
            byte[] b = new byte[1024];
            int end = 0;
            while ((end = bi.read(b)) != -1) {
                System.out.println(new String(b));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void test1() {
        Scanner scanner = new Scanner(System.in);
        String nextLine = scanner.nextLine();
        try {
            FileInputStream fileInputStream = new FileInputStream("F:\\tempFile\\face\\2.jpg");
            BufferedInputStream bis = new BufferedInputStream(fileInputStream);
            byte[] buf = new byte[1024];
            int len = 0;
            while ((len = bis.read(buf)) != -1) {
                System.out.println(new String(buf, 0, len));
            }
            BufferedOutputStream bufferedOutputStream =
                new BufferedOutputStream(new FileOutputStream(new String(buf, 0, len)));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        scanner.close();
    }
}
