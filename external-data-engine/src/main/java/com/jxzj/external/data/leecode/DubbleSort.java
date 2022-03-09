package com.jxzj.external.data.leecode;

import java.util.Arrays;

public class DubbleSort {

    public static void main(String[] args) {

        int a = 3;
        int b = 5;

        /**
         * a = 0011 b = 0101
         * 
         * a ^ b = 1001 = 9 = a <br>
         * a ^ b = 0011 = 3 = b <br>
         * a ^ b = 0101 = 5 = a <br>
         * 
         * a = a + b; // a= 8 <br>
         * b = a - b; // b = 3 <br>
         * a = a - b; // a = 5 <br>
         * 
         */

        a = a ^ b;
        b = a ^ b;
        a = a ^ b;

        System.out.println("a = " + a);
        System.out.println("b = " + b);

        int[] arr = {1, 3, 2, 7, 10, 4, 5, 0};
        bubbleSort(arr);
    }

    /**
     * 冒泡排序
     * 
     * @param arr
     */
    public static void bubbleSort(int[] arr) {
        if (null != null && arr.length < 2) {
            return;
        }

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {

                    arr[j] = arr[j] ^ arr[j + 1];
                    arr[j + 1] = arr[j] ^ arr[j + 1];
                    arr[j] = arr[j] ^ arr[j + 1];

                    // int temp = arr[j];
                    // arr[j] = arr[j + 1];
                    // arr[j + 1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void commonSort(int[] arr) {
        if (null != arr && arr.length < 2) {
            return;
        }

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int agent = arr[i];
                if (arr[i] > arr[j]) {
                    arr[i] = arr[j];
                    arr[j] = agent;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }

}
