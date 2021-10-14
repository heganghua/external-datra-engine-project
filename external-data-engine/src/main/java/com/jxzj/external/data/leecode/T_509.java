package com.jxzj.external.data.leecode;

import com.alibaba.dubbo.common.io.Bytes;

public class T_509 {

    public static void main(String[] args) {
        // System.out.println(fib(5));
        // System.out.println(fib2(5));
        // System.out.println(fib3(5));
        // System.out.println(tib(0));

        int b = 456;

        byte c = (byte)b;
        System.out.println(c);

        // 字节码测试
        // String a = "abcd123";
        int v = 123456789;
        Long str = 123456L;
        byte byteValue = str.byteValue();
        byte[] long2bytes = Bytes.long2bytes(str);
        System.out.println(byteValue);
        // byte[] bytes = a.getBytes();
        // for (int i = 0; i < bytes.length; i++) {
        // System.out.println(bytes[i]);
        // }
        // byte[] int2bytes = Bytes.int2bytes(v);
        int byteArrayToInt = byteArrayToInt(long2bytes);
        // System.out.println(byteArrayToInt);
    }

    public final static int byteArrayToInt(byte[] b) {
        int value = 0;
        if (b == null) {
            return value;
        }
        for (int i = 0; i < b.length; i++) {
            int temp = b[i] & 0xFF;
            value = value * 256;
            value = value + temp;
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
