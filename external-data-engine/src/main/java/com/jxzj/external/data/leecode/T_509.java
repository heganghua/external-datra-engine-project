package com.jxzj.external.data.leecode;

import com.alibaba.dubbo.common.io.Bytes;

public class T_509 {

    public static void main(String[] args) {
        // System.out.println(fib(5));
        // System.out.println(fib2(5));
        // System.out.println(fib3(5));
        // System.out.println(tib(0));

        // 字节码测试
        String a = "abc";
        int v = 1024;

        byte[] int2bytes = Bytes.int2bytes(v);

        int byteArrayToInt = byteArrayToInt(int2bytes);
        // System.out.println(byteArrayToInt);
    }

    public final static int byteArrayToInt(byte[] b) {
        int value = 0;
        if (b == null) {
            return value;
        }
        for (int i = 0; i < b.length; i++) {
            int temp = b[i] & 0xFF;
            // System.out.println(temp);
            value = value * 256;
            // System.out.println(value);
            value = value + temp;
            System.out.println(value);
        }
        return value;
    }

    /**
     * 泰波拉切数列
     * 
     * @param n
     * @return
     */
    public static int fib2(int n) {

        int dp[] = new int[n + 1];
        dp[1] = dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static int fib(int n) {
        if (n < 2) {
            return n;
        }
        int p = 0, q = 0, r = 1;
        for (int i = 2; i <= n; ++i) {
            p = q;
            q = r;
            r = p + q;
        }
        return r;
    }

    public static int tib(int n) {

        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 1;
        }

        int[] df = new int[n + 1];
        // int [] df = {0, 1,1 };

        df[0] = 0;
        df[1] = 1;
        df[2] = 1;

        for (int i = 3; i <= n; i++) {
            df[i] = df[i - 1] + df[i - 2] + df[i - 3];
        }
        return df[n];

    }

    public static int fib3(int n) {

        if (n == 1 || n == 2) {
            return n;
        }

        int prev = 1, curr = 1, sum = 0;
        for (int i = 3; i <= n; i++) {
            sum = prev + curr;
            prev = curr;
            curr = sum;
        }
        return sum;
    }

}
