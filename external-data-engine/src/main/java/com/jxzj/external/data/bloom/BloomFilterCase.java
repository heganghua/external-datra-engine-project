package com.jxzj.external.data.bloom;

import java.util.BitSet;

public class BloomFilterCase {

    // 长度为10亿的比特位
    private static final int DEFAULT_SIZE = 256 << 10;

    // 为了降低错误率，使用加法hash算法，所以定义一个8个元素的质数数组
    private static final int[] sends = {3, 5, 7, 11, 13, 31, 37, 61};

    private static HashFunction[] functions = new HashFunction[sends.length];

    private static BitSet bitset = new BitSet(DEFAULT_SIZE);

    public static void add(String value) {
        if (null != value) {
            for (HashFunction f : functions) {
                bitset.set(f.hash(value), true);
            }
        }
    }

    public static boolean contains(String value) {
        if (null == value) {
            return false;
        }

        boolean ret = true;
        for (HashFunction f : functions) {
            ret = bitset.get(f.hash(value));
            if (!ret) {
                break;
            }
        }
        return ret;
    }

    public static void main(String[] args) {

        for (int i = 0; i < sends.length; i++) {
            functions[i] = new HashFunction(DEFAULT_SIZE, sends[i]);
        }

        for (int i = 0; i < DEFAULT_SIZE; i++) {
            add(String.valueOf(i));
        }

        String id = "123456789";
        add(id);

        System.out.println(contains(id));
        System.out.println(" " + contains("234567890"));
        String string = bitset.toString();
        System.out.println(string);

    }

    static class HashFunction {

        private int size;
        private int seed;

        public HashFunction(int size, int seed) {
            super();
            this.size = size;
            this.seed = seed;
        }

        public int hash(String value) {
            int result = 0;
            int length = value.length();
            for (int i = 0; i < length; i++) {
                result = seed * result + value.charAt(i);
            }
            int r = (size - 1) & result;
            return (size - 1) & result;
        }

    }

}
