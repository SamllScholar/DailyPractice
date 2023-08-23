package com.smallscholar.algorithm;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/8/14 14:49
 * @describe 六大算法: 按照从小到大的顺序排序
 */
public class Sort {

    public static void main(String[] args) {
        int[] arr = {1, 4, 3, 6, 2, 7, 4, 6, 5, 9};
        // 冒泡排序
        // bubbleSort(arr); √

        // 选择排序
        // selectSort(arr); √

        // 插入排序
        // insertSort(arr); √

        int left = 0;
        int right = arr.length - 1;
        // 归并排序
        // mergeSort(arr, left, right); √

        // 快速排序
        // quickSort(arr, left, right);

        // 堆排序
        heapSort(arr);
        System.out.println(arr);
    }

    public static void heapSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        for (int i = arr.length - 1; i >= 0; i--) {
            while (arr[i] < arr[(i - 1) / 2]) {
                swap(arr, i, (i - 1) / 2);
                i = (i - 1) / 2;
            }
        }
    }

    /**
     * 快速排序
     *
     * @param arr   待排序的数组
     * @param left  数组的左边界
     * @param right 数组的右边界
     */
    public static void quickSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int par = doPartition(arr, left, right);
        quickSort(arr, left, par - 1);
        quickSort(arr, par + 1, right);
    }

    public static int doPartition(int[] arr, int left, int right) {
        int mid = (right + left) >> 1;
        swap(arr, left, mid);
        int temp = arr[mid];

        while (left < right) {
            while (left < right && arr[right] >= temp) {
                right--;
            }
            if (left < right) {
                arr[left++] = arr[right];
            }
            while (left < right && arr[left] < temp) {
                left++;
            }
            if (left < right) {
                arr[right--] = arr[left];
            }
        }
        arr[left] = temp;

        return left;
    }

    /**
     * 归并排序
     *
     * @param arr   需要排序的数组
     * @param left  数组的左边界
     * @param right 数组的右边界
     */
    public static void mergeSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = (right + left) >> 1;

        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);

        merge(arr, left, right, mid);
    }

    public static void merge(int[] arr, int left, int right, int mid) {
        int[] temp = new int[right - left + 1];
        int idx1 = left;
        int idx2 = mid + 1;
        int i = 0;

        while (idx1 <= mid && idx2 <= right) {
            temp[i++] = arr[idx1] < arr[idx2] ? arr[idx1++] : arr[idx2++];
        }
        while (idx1 <= mid) {
            temp[i++] = arr[idx1++];
        }
        while (idx2 <= right) {
            temp[i++] = arr[idx2++];
        }

        for (int j = left; j <= right; j++) {
            arr[j] = temp[j - left];
        }
    }

    /**
     * 插入排序
     *
     * @param arr 需要排序的数组
     */
    public static void insertSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        for (int i = 1; i < arr.length - 1; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                } else {
                    break;
                }
            }
        }
    }

    /**
     * 选择排序
     *
     * @param arr 需要排序的数组
     */
    public static void selectSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        for (int i = 0; i < arr.length - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < arr.length; j++) {
                minIdx = arr[minIdx] > arr[j] ? j : minIdx;
            }
            swap(arr, minIdx, i);
        }
    }

    /**
     * 冒泡排序
     *
     * @param arr 需要排序的数组
     */
    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = arr.length - 1; i >= 1; i--) {
            boolean flag = true;
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                    flag = false;
                }
            }
            if (flag) {
                break;
            }
        }
    }

    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

}
