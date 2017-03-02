package com.mcs.sort;


/**
 * @author mochangsheng
 * @version 1.0
 * @description 插入排序
 * @created 2017/2/17
 * @changeRecord [修改记录] <br/>
 */
public class InsertSort extends Sort {

    public static void main(String[] arg) {
        System.out.println("InsertSort!!!");

        InsertSort insertSort = new InsertSort();
        insertSort.sort(Constant.TEST_ARRAY);
        insertSort.sort(Constant.TEST_ARRAY_2);
        insertSort.sort(Constant.TEST_ARRAY_3);
    }

    @Override
    public void sort(int[] array) {
        if (array == null || array.length == 0) {
            System.out.println(Constant.ERROR_ARRAY_EMPTY);
            return;
        }

        int temp = 0;
        for (int i = 1; i < array.length; i++) {
            temp = array[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (temp < array[j]) {
                    array[j+1] = array[j];
                } else {
                    break;
                }
            }

            array[j+1] = temp;
        }

        traverse(array);
    }
}
