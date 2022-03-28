package com.jxzj.external.data.leecode;

import java.util.Arrays;
import java.util.Random;

public class QuickSort {
    public static void main(String[] args) {

        int[] array = new Random().ints(10, 0, 50).toArray();
        System.out.println(Arrays.toString(array));
        quickSort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }

    private static void quickSort(int[] arr, int low, int high) {

        // 基准数
        int i = low, j = high;
        int tmp = arr[i];
        if (low < high) {
            while (i != j) {
                while (j > i && arr[j] >= tmp) {
                    j--;
                }
                arr[i] = arr[j];
                while (j > i && arr[i] <= tmp) {
                    i++;
                }
                arr[j] = arr[i];
            }
            arr[i] = tmp;
            quickSort(arr, low, i - 1);
            quickSort(arr, i + 1, high);
        }
    }

}
