package com.mcs;

/**
 * @author mochangsheng
 * @version 1.0
 * @description 冒泡排序
 * @created 2017/2/17
 * @changeRecord [修改记录] <br/>
 */

public class BubbleSort extends Sort {

    public static void  main(String[] arg) {


        System.out.println("bubbleSort!!!");
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.sort(Constant.TEST_ARRAY);
        bubbleSort.sort(Constant.TEST_ARRAY_2);
        bubbleSort.sort(Constant.TEST_ARRAY_3);
    }

    @Override
    public void sort(int[] array) {
        if (array == null || array.length == 0) {
            System.out.println(Constant.ERROR_ARRAY_EMPTY);
            return;
        }

        for (int i=0; i < array.length; i++) { //排序的指定位置
            for (int j=0; j < array.length-i-1; j++) { //排序后的范围
                if (array[j] > array[j+1]) {
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }

        traverse(array);
    }
}
