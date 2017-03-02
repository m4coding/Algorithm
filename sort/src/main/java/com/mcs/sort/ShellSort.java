package com.mcs.sort;

/**
 * @author mochangsheng
 * @version 1.0
 * @description 希尔排序（最小增量排序）
 * @created 2017/2/16
 * @changeRecord [修改记录] <br/>
 */

public class ShellSort extends Sort {

    public static void main(String[] arg) {
        System.out.println("ShellSort!!!");
        ShellSort shellSort = new ShellSort();
        shellSort.sort(Constant.TEST_ARRAY);
        shellSort.sort(Constant.TEST_ARRAY_2);
        shellSort.sort(Constant.TEST_ARRAY_3);
    }


    @Override
    public void sort(int[] array) {

        if (array == null || array.length == 0) {
            System.out.println(Constant.ERROR_ARRAY_EMPTY);
            return;
        }

        double d1 = array.length;
        int temp = 0;

        while(true) {
            d1 = d1 / 2; //每次取一半
            int increment = (int) d1;

            //等为0时跳出循环
            if (increment == 0) {
                break;
            }

            for (int x = 0; x < increment; x++) {
                for (int i = x+increment; i < array.length; i+=increment) {
                    int j = i - increment;
                    temp = array[i];
                    for (; j >= 0; j -= increment) {
                        if (array[j] > temp) {
                            array[j+increment] = array[j];
                        } else {
                            break;//当不成立时，记得跳出循环
                        }
                    }

                    array[j+increment]=temp;
                }
            }
        }

        traverse(array);
    }
}
