package com.mcs;

/**
 * @author mochangsheng
 * @version 1.0
 * @description 该类的主要功能描述
 * @created 2017/2/16
 * @changeRecord [修改记录] <br/>
 */

public class SelectSort extends Sort {

    public static void main(String[] arg) {
        System.out.println("SelectSort!!!");

        SelectSort selectSort = new SelectSort();
        selectSort.sort(Constant.TEST_ARRAY);
        selectSort.sort(Constant.TEST_ARRAY_2);
        selectSort.sort(Constant.TEST_ARRAY_3);

        Object object1 = new Object();
        Object object2 = object1;

        System.out.println("object1 == object2 is " + (object1 == (object2)));
    }


    @Override
    public void sort(int[] array) {
        if (array == null || array.length == 0) {
            System.out.println(Constant.ERROR_ARRAY_EMPTY);
            return;
        }

        int position = 0;
        for (int i = 0; i < array.length; i++) {
            int temp = array[i];
            position = i;
            for (int j = i+1; j < array.length; j++) {
                if (array[j] < temp) {
                    temp = array[j];
                    position = j;
                }
            }

            array[position] = array[i];
            array[i] = temp;
        }

        traverse(array);
    }
}
