package com.mcs.sort;

/**
 * @author mochangsheng
 * @version 1.0
 * @description 该类的主要功能描述
 * @created 2017/2/16
 * @changeRecord [修改记录] <br/>
 */

public abstract class Sort {


    public abstract void sort(int[] array);

    public void traverse(int[] array) {
        if (array == null || array.length == 0) {
            System.out.println(Constant.ERROR_ARRAY_EMPTY);
            return;
        }

        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }

        System.out.println("travers end!!!");
    }
}
