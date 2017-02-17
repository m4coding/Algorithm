#排序算法分析

排序算法一般分为8种：

- 插入排序：

	a）直接插入排序

	b）希尔排序 (最小增量排序)

- 选择排序：

	a）简单选择排序

	b）堆排序

- 交换排序

	a）冒泡排序

	b）快速排序

- 归并排序

- 基数排序


##插入排序

- 直接插入排序 

   基本思想：在要排序的一组数中，假设前面n-1 (n>=2)个数已经是排好顺序的，现在要把第n个数插到前面的有序数中，使得这n个数也是排好顺序的。如此反复循环，直到全部排好顺序。

   实现：（从小到大）

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

- 希尔排序（最小增量排序）

基本思想：先将要排序一组数按某个增量d（一般为n/2，n为要排序的个数）分成若干组，每组中记录的下标相差d，对每组中全部元素进行直接插入排序，然后再用一个较小的增量（d/2）对它进行分组，在每组中再进行直接插入排序。当增量减到1时，进行直接插入排序后，排序完成。

实现：（从小到大）

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

##选择排序

- 简单选择排序

基本思想：在要排序的一组数中，选出最小的一个数与第一位置的数交换；然后在剩下的数当中再找最小的数与第二个位置的数交换，如此循环到倒数第二个和最后一个数比较为止。

实现：（从小到大）

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

- 堆排序

[http://www.cnblogs.com/mengdd/archive/2012/11/30/2796845.html](http://www.cnblogs.com/mengdd/archive/2012/11/30/2796845.html)


##交换排序

- 冒泡排序

基本思想：在要排序的一组数中，对当前还未排好序的范围内的全部数，自上而下对相邻的两个数依次进行比较和调整，让较大的数往下沉，较小的往上冒。即：每当两相邻的数比较后发现它们的排序与排序要求相反时，就将它们互换。

实现：（从小到大）

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