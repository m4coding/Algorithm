package com.mcs;

import java.util.Arrays;

/**
 * @author mochangsheng
 * @version 1.0
 * @description 归并排序
 * @created 2017/2/20
 * @changeRecord [修改记录] <br/>
 */

public class MergerSort extends Sort {

    public static void main(String[] arg) {

        MergerSort mergerSort = new MergerSort();
        mergerSort.sort(Constant.TEST_ARRAY);
    }

    @Override
    public void sort(int[] array) {
        if (array == null || array.length == 0) {
            System.out.println(Constant.ERROR_ARRAY_EMPTY);
            return;
        }

        tmpSort(array, 0, array.length - 1);

        traverse(array);
    }

    private void tmpSort(int[] data, int left, int right) {

        if(left < right){
            //找出中间索引
            int center = (left + right)/2;
            //对左边数组进行递归
            tmpSort(data,left,center);
            //对右边数组进行递归
            tmpSort(data,center+1,right);
            //合并
            merge(data,left,center,right);
        }

    }

    private void merge(int[] data, int low, int center, int high) {

        int [] tmpArr = new int[data.length];
        int upIndex = center + 1;
        //third记录临时数组的索引
        int third = low;
        int tmp = low;
        while(low <= center && upIndex <= high){
            //从两个数组(up数组，down数组)中取出最小的放入临时数组
            if(data[low] <= data[upIndex]){
                tmpArr[third++] = data[low++];
            }else{
                tmpArr[third++] = data[upIndex++];
            }

        }

        //剩余部分依次放入临时数组
        while(upIndex <= high){
            tmpArr[third++] = data[upIndex++];
        }

        while(low <= center){
            tmpArr[third++] = data[low++];
        }

        //将临时数组中的内容复制回原数组
        while(tmp <= high){
            data[tmp] = tmpArr[tmp++];
        }

        System.out.println(Arrays.toString(data));
    }
}
