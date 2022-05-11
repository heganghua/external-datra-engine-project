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
        InputStreamDemo.test1();
    }

    public static void test2ByReader() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(new File("./img/pingan.cookies.txt")));
            String str = null;
            String s = null;
            while ((s = br.readLine()) != null) {
                str += s;
            }
            System.out.println(str);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void test3ByByte() {
        try {
            BufferedInputStream bi = new BufferedInputStream(new FileInputStream(new File("./img/pingan.cookies.txt")));
            byte[] b = new byte[1024];
            int end = 0;
            String st = new String();
            while ((end = bi.read(b)) != -1) {
                st += new String(b);
            }
            System.out.println(st);
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
            FileInputStream fileInputStream = new FileInputStream("F:\\tempFile\\2.jpg");
            BufferedInputStream bis = new BufferedInputStream(fileInputStream);
            byte[] buf = new byte[1024];
            int len = 0;
            BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream("f:/tempFile/4.jpg"));
            while ((len = bis.read(buf)) != -1) {
                System.out.println(new String(buf));
                out.write(buf);
            }
            fileInputStream.close();
            bis.close();
            out.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        scanner.close();
    }
}
