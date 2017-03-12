package com.mcs.search;

import com.mcs.sort.Constant;

/**
 * @author mochangsheng
 * @version 1.0
 * @title 类的名称
 * @description 该类的主要功能描述
 * @created 2017/3/12 0012
 * @changeRecord [修改记录] <br/>
 */
public class OrderSearch extends Search{

    public static void main(String[] args) {
        OrderSearch orderSearch = new OrderSearch();
        int target = 10;
        int searchIndex = orderSearch.search(null, target);

        if (searchIndex != -1) {
            System.out.println(target + " found in " + searchIndex);
        } else {
            System.out.println(target + " no found");
        }
    }

    @Override
    public int search(int[] array, int target) {

        if (array == null) {
            System.out.println("array is null");
            return -1;
        }

        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                return i;
            }
        }
        return -1;
    }
}
