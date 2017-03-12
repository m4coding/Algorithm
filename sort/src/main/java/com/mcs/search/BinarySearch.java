package com.mcs.search;

import com.mcs.sort.Constant;

/**
 * @author mochangsheng
 * @version 1.0
 * @title 类的名称
 * @description 二分法查找（查找数组默认是升序的有序数组）
 * @created 2017/3/12 0012
 * @changeRecord [修改记录] <br/>
 */
public class BinarySearch extends Search {

    public static void main(String[] args)  {
        BinarySearch binarySearch = new BinarySearch();
        //二分法查找的前提是，数组必须是有序的
        int[] array = {2,5,6,7,56,68,70,100,120,600,900};
        int target = 6;
        //int searchIndex = binarySearch.search(array, target);
        int searchIndex = binarySearch.recursionSearch(array, 0, array.length - 1, target);

        if (searchIndex != -1) {
            System.out.println(target + " found in " + searchIndex);
        } else {
            System.out.println(target + " no found");
        }
    }

    //非递归实现
    @Override
    public int search(int[] array, int target) {

        if (array == null) {
            System.out.println("array is null");
            return -1;
        }

        int from =  0;
        int to = array.length - 1;

        while (from <= to) {
            int mid = (from + to) / 2;
            //System.out.println("out mid==" + mid);
            if (target > array[mid]) {
                from = mid + 1;
            } else if (target < array[mid]) {
                to = mid - 1;
            } else {
                return mid;
            }
        }

        return -1;
    }

    //递归实现
    public int recursionSearch(int[] array, int from, int to, int target) {

        if (from <= to) {
            int mid = (from + to) / 2;
            if (target > array[mid]) {
                return mid = recursionSearch(array, mid + 1, to, target);
            } else if (target < array[mid]) {
                return mid = recursionSearch(array, from, mid - 1, target);
            } else {
                return mid;
            }
        }

        return -1;
    }
}
