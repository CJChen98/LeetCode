package problems;

import java.math.BigInteger;

public class Test {

    public static void main(String[] args) {
//        int[] a = new int[100];
//        int z = 0;
//        for (int i = 0; i < 100; i++) {
//            a[i] = z;
//            z += 2;
//        }
//        int res = binarySearch(a, 0, a.length, 0);
//        System.out.println(a.length);
//        System.out.println(res);
//        int[] a = {1, 5, 2, 10, 3, 4, 0};
//        int[] b = quickSort(a, 0, a.length - 1);
//
//        for (int value : b) {
//            System.out.println(value);
//        }

        int a = 1;
        int b = 2;
        System.out.println(a | b);
    }

    //二分查找
    public static int binarySearch(int[] a, int min, int max, int target) {
        if (min > max) return -1;
        int mid = min + (max - min) / 2;
        if (a[mid] > target) return binarySearch(a, min, mid - 1, target);
        if (a[mid] < target) return binarySearch(a, mid + 1, max, target);
        return mid + 1;
    }

    //快速排序
    public static int[] quickSort(int[] a, int left, int right) {
        if (left < right) {
            int partitionIndex = partitionIndex(a, left, right);
            quickSort(a, left, partitionIndex - 1);
            quickSort(a, partitionIndex + 1, right);
        }
        return a;
    }

    private static int partitionIndex(int[] a, int left, int right) {
        int index = left + 1;
        for (int i = index; i <= right; i++) {
            if (a[i] < a[left]) {
                swap(a, i, index);
                index++;
            }
        }
        swap(a, left, index - 1);
        return index - 1;
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[j];
        a[j] = a[i];
        a[i] = temp;
    }

}
