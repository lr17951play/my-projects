package com.lirui.demo.algorithm;

import java.util.Arrays;

public class SortDemo {

    static class Sorter {

        private int[] arr;

        Sorter (int[] arr) {
            this.arr = arr;
        }
        /**
         * 选择排序法
         * */
        public int[] selectSort(boolean asc){
            int[] target = Arrays.copyOf(arr, arr.length);
            int index, tmp;
            for (int i = 0; i < target.length; i++) {
                index = i;
                for (int j = i + 1; j < target.length; j ++) {
                    if (asc) {
                        if (target[index] > target[j]) {
                            index = j;
                        }
                    } else {
                        if (target[index] < target[j]) {
                            index = j;
                        }
                    }
                }
                tmp = target[index];
                target[index] = target[i];
                target[i] = tmp;
            }
            return target;
        }

        /**
         * 冒泡排序法
         * */
        public int[] bubbleSort(boolean asc){
            int[] target = Arrays.copyOf(arr, arr.length);
            int tmp;
            for (int i = 0; i < target.length - 1; i ++) {
                for (int j = 0; j < target.length - 1 - i; j ++) {
                    if (asc) {
                        if (target[j] > target[j + 1]) {
                            tmp = target[j];
                            target[j] = target[j + 1];
                            target[j + 1] = tmp;
                        }
                    } else {
                        if (target[j] < target[j + 1]) {
                            tmp = target[j];
                            target[j] = target[j + 1];
                            target[j + 1] = tmp;
                        }
                    }
                }
            }
            return target;
        }

        public int[] insertSort(boolean asc){
            int[] target = Arrays.copyOf(arr, arr.length);
            int j, insert;
            for (int i = 1; i < target.length; i ++) {
                j = i - 1;
                insert = target[i];
                if (asc) {
                    for (; j >= 0 && target[j] > insert; j --) {
                        target[j + 1] = target[j];
                    }
                } else {
                    for (; j >= 0 && target[j] < insert; j --) {
                        target[j + 1] = target[j];
                    }
                }
                target[j + 1] = insert;
            }
            return target;
        }

        public int[] mergeSort(boolean asc) {
            int[] target = Arrays.copyOf(arr, arr.length);
            split(target, 0, arr.length - 1);
            return target;
        }

        private void split(int[] target, int start, int end) {
            if (start < end) {
                int mid = start + (end - start) / 2;
                split(target, start, mid);
                split(target, mid + 1, end);
                merge(target, start, end, mid);
            }
        }

        private void merge(int[] target, int start, int end, int mid) {
            int[] temp = new int[end - start + 1];
            for (int k = start; k <= end; k++) {
                temp[k - start] = target[k];
            }
            int s = start, m = mid + 1;
            for (int k = start; k <= end; k++) {
                if (s > mid) {
                    target[k] = temp[m ++ - start];
                } else if (m > end) {
                    target[k] = temp[s ++ - start];
                } else if (temp[s - start] <= temp[m - start]) {
                    target[k] = temp[s ++ - start];
                } else {
                    target[k] = temp[m ++ - start];
                }
            }
        }

        public int[] quickSort(boolean asc){
            int[] target = Arrays.copyOf(arr, arr.length);
            quickPartition(target, 0, target.length - 1);
            return target;
        }

        private void quickPartition(int[] arr, int start, int end) {
            if (start < end) {
                if (end - start == 1 && arr[start] == arr[end]) {
                    start ++;
                    end ++;
                }
                int pivot = partition(arr, start, end);
                quickPartition(arr, start, pivot);
                quickPartition(arr, pivot + 1, end);
            }
        }

        private int partition(int[] arr, int start, int end) {
            int pivot = arr[start];
            int s = start, e = end, tmp;
            while (true) {
                while (s <= e) {
                    if (arr[s] > pivot) {
                        break;
                    }
                    s ++;
                }
                while (e >= s) {
                    if (arr[e] < pivot) {
                        break;
                    }
                    e --;
                }
                if (s >= e) {
                    break;
                } else {
                    tmp = arr[s];
                    arr[s] = arr[e];
                    arr[e] = tmp;
                }
            }
            arr[start] = arr[e];
            arr[e] = pivot;
            return e;
        }

        public int[] countSort(int[] arr) {
            if(arr == null || arr.length < 2) {
                return arr;
            }
            int n = arr.length;
            int min = arr[0];
            int max = arr[0];
            // 寻找数组的最大值与最小值
            for (int i = 1; i < n; i++) {
                if(max < arr[i]) {
                    max = arr[i];
                }
                if(min > arr[i]) {
                    min = arr[i];
                }
            }
            int d = max - min + 1;
            //创建大小为max的临时数组
            int[] temp = new int[d];
            //统计元素i出现的次数
            for (int i = 0; i < n; i++) {
                temp[arr[i] - min]++;
            }
            int k = 0;
            //把临时数组统计好的数据汇总到原数组
            for (int i = 0; i < d; i++) {
                // temp[i] 的值表示元素 i 出现的次数
                for (int j = temp[i]; j > 0; j--) {
                    arr[k++] = i + min;
                }
            }
            return arr;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,2,14,5,3,66,23,12,53,22,66,75,89,54,43,23,56,86,24,34,57};
        Sorter sorter = new Sorter(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        System.out.println("select: " + Arrays.toString(sorter.selectSort(true)));
        System.out.println("bubble: " + Arrays.toString(sorter.bubbleSort(false)));
        System.out.println("insert: " + Arrays.toString(sorter.insertSort(true)));
        System.out.println("merge: " + Arrays.toString(sorter.mergeSort(true)));
        System.out.println("quick: " + Arrays.toString(sorter.quickSort(true)));
        int[] arr2 = {1,1,4,2,3,5,3,4,3,5,7,4,6,8,9,7,4,3,6,4,3,2,2,6,6,8,9,5,4,6,3,3,5,6,8,7,6,4,3,4,6,7,5,3,1,1,2,5};
        System.out.println("count: " + Arrays.toString(sorter.countSort(arr2)));
    }
}
