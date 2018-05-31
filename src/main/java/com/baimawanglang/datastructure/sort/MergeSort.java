package com.baimawanglang.datastructure.sort;

import java.util.Arrays;
import java.util.List;

public class MergeSort {

    public static void main(String[] args) {
        int[] arr1 = {1,2,3};
        List<int[]> list = Arrays.asList(arr1);
        list.remove(2);
        System.out.println();

        int[] arr = {6,1,4,2,0,6,8,7,9,6};
        int[] sort = sort(arr, 0, arr.length - 1);
        for (int i : sort) {
            System.out.print(i + " ");
        }
    }

    public static int[] sort(int[] target, int low, int high) {
        int mid = (low + high)/2;
        if(low < high) {
            sort(target, low, mid);
            sort(target, mid + 1, high);
            merge(target, low, mid, high);
        }
        return target;
    }

    private static void merge(int[] target, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];
        int point = 0;
        int p1 = low;
        int p2 = mid + 1;

        //两侧均存在数据
        while(p1 <= mid && p2 <= high) {
            if (target[p1] < target[p2]) {
                temp[point++] = target[p1++];
            } else {
                temp[point++] = target[p2++];
            }
        }

        //单侧存在数据
        while (p1 <= mid) {
            temp[point++] = target[p1++];
        }

        while (p2 <= high) {
            temp[point++] = target[p2++];
        }

        //临时数据回写到原数组
        for (int i = 0; i < temp.length ; i++) {
            target[i + low] = temp[i];
        }

    }
}


