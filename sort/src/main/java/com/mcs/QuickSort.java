package com.mcs;


/**
 * @author mochangsheng
 * @version 1.0
 * @description 该类的主要功能描述
 * @created 2017/2/17
 * @changeRecord [修改记录] <br/>
 */

public class QuickSort extends Sort {

    public static void main(String[] arg) {

        System.out.println("QuickSort!!!");
        QuickSort quickSort = new QuickSort();
        quickSort.sort(Constant.TEST_ARRAY);
        quickSort.sort(Constant.TEST_ARRAY_2);
        quickSort.sort(Constant.TEST_ARRAY_3);
    }

    @Override
    public void sort(int[] array) {
        if (array == null || array.length == 0) {
            System.out.println(Constant.ERROR_ARRAY_EMPTY);
            return;
        }
        quickSort(array, 0, array.length-1);
        traverse(array);
    }

    private int getMiddle(int[] array, int low, int high) {
        int temp = array[low];//数组的第一个作为中轴

        while (low < high) {

            while (low < high && temp <= array[high]) {
                high--;
            }
            array[low] = array[high];//比中轴小的记录移到低端

            while (low < high && temp >= array[low]) {
                low++;
            }
            array[high] = array[low];//比中轴大的记录移到高端

            //System.out.println(String.format(Locale.US,"===getMiddle low==%d,high==%d", low, high));
        }

        array[low] = temp;

        return low;//返回中轴的位置
    }

    private void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int middle = getMiddle(array, low, high);
            quickSort(array, low, middle-1);
            quickSort(array, middle+1, high);
        }
    }
}
