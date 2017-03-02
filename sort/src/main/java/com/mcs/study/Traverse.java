package com.mcs.study;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author mochangsheng
 * @version 1.0
 * @description 该类的主要功能描述
 * @created 2017/3/1
 * @changeRecord [修改记录] <br/>
 */

public class Traverse {

    public static void main(String[] arg) {
        Traverse traverse = new Traverse();
        ArrayList<String> list = new ArrayList<>();
        list.add("aa");
        list.add("bb");
        list.add("cc");
        list.add("dd");
        list.add("ee");
        list.add("ff");
        traverse.randomTraverse(list);

        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(1);
        list2.add(2);
        list2.add(3);
        list2.add(4);
        list2.add(5);
        list2.add(6);
        traverse.randomTraverse(list2);
    }

    //泛型方法   T为类型形参   随机遍历集合
    public <T> void randomTraverse(List<T> list) {
        if (null == list || list.size() == 0) {
            System.out.println("list is empty");
            return;
        }

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i) + "; ");
        }

        ArrayList<T> results = new ArrayList<>();
        //Random的构造参数，种子数只是随机算法的起源数字，和生成的随机数字的区间无关
        Random random = new Random();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            //限定生成数的大小的区间在list.size()以内
            int randomIndex = random.nextInt(list.size());
            results.add(list.get(randomIndex));
            list.remove(randomIndex);
        }

        System.out.println("Random Access begin:");

        for (int i = 0; i < results.size(); i++) {
            System.out.println(results.get(i) + "; ");
        }
    }
}
