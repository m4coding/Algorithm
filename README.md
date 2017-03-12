# 排序算法分析

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


## 插入排序

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

## 选择排序

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


## 交换排序

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

- 快速排序

基本思想：选择一个基准元素，通常选择第一个元素或者最后一个元素，通过一趟扫描，将待排序分成两部分，一部分比基准元素小，一部分大于等于基准元素，此时基准元素在其排好序后的正确位置，然后再用同样的方法递归地划分剩下的两部分。

实现：（从小到大）

	//开始排序
	public void sort(int[] array) {
        if (array == null || array.length == 0) {
            System.out.println(Constant.ERROR_ARRAY_EMPTY);
            return;
        }
        quickSort(array, 0, array.length-1);
        traverse(array);
    }

	//将数组分成两部分
    private int getMiddle(int[] array, int low, int high) {
        int temp = array[low];//数组的第一个作为中轴

        while (low < high) {

            while (low < high && temp <= array[high]) {
                high--;
            }
            array[low] = array[high];//比中轴小的记录移到低端

            while (low < high && temp >= array[low]) {
                low++;
            }
            array[high] = array[low];//比中轴大的记录移到高端

            //System.out.println(String.format(Locale.US,"===getMiddle low==%d,high==%d", low, high));
        }

        array[low] = temp;

        return low;//返回中轴的位置
    }

	//递归调用
    private void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int middle = getMiddle(array, low, high);
            quickSort(array, low, middle-1);
            quickSort(array, middle+1, high);
        }
    }


## 归并排序

基本思想：归并排序法是将两个（或两个以上）有序表合并成一个新的有序表，即把待排序序列分成若干个序列，每个子序列是有序的。然后再把有序子序列合并成整体有序序列。


## 基数排序

基本思想：将所有待比较数值（正整数）统一为同样的数位长度，数位较短的数前面补零。然后，从最低位开始，依次进行一次排序。这样从最低位排序一直到最高位排序完成以后，数列就变成一个有序序列。



## 各种算法的复杂度

![](http://i.imgur.com/iq0bZpP.jpg)

基数排序的时间复杂度可看为O(n)

大小比较：
O(1) < O(logn) < O(n) < O(nlogn) < O(n^2) < O(n^3) < O(2^n) < O(n!) < O(n^n)



## 参考

a) [http://blog.csdn.net/qy1387/article/details/7752973](http://blog.csdn.net/qy1387/article/details/7752973)

b) [http://www.cnblogs.com/0201zcr/p/4764705.html](http://www.cnblogs.com/0201zcr/p/4764705.html)

c) [http://www.jianshu.com/p/8c915179fd02](http://www.jianshu.com/p/8c915179fd02)

# 查找算法分析

**查找算法一般常见的有两种，一种是顺序查找（也叫线性查找）；一种是二分法查找（也叫折半查找）**

（1）顺序查找（线性查找）

**原理：**顺序查找就是从数组的起始位置a[0]开始依次比较数组中的每一个值直到找到目标值，
当然也有可能循环遍历了数组中所有值也没找到目标值。

**时间复杂度：**查找成功时的平均查找长度为：（假设每个数据元素的概率相等） ASL = 1/n(1+2+3+…+n) = (n+1)/2 ;

当查找不成功时，需要n+1次比较，时间复杂度为O(n);所以，顺序查找的时间复杂度为**O(n)**。

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


（2）二分法查找（折半查找）

**原理：**是一种在**有序数组**中查找某一特定元素的搜索算法。 搜索过程从数组的中间元素开始，
如果中间元素正好是要查找的元素，则搜索过程结束；如果某一特定元素大于或者小于中间元素，
则在数组大于或小于中间元素的 那一半中查找，而且跟开始一样从中间元素开始比较。如果在某
一步骤数组为空，则代表找不到。这种搜索算法每一次比较都使搜索范围缩小一半。

说明：元素必须是有序的，如果是无序的则要先进行排序操作。

**时间复杂度：**最坏情况下，关键词比较次数为log2(n+1)，且期望时间复杂度为**O(logn)**；

    //非递归实现
    public int search(int[] array, int target) {

        if (array == null) {
            System.out.println("array is null");
            return -1;
        }

        int from =  0;
        int to = array.length - 1;

        while (from <= to) {
            int mid = (from + to) / 2;
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


## 参考

[查找算法的Java实现](http://www.jianshu.com/p/b07c69a91535)

[七大查找算法](http://www.cnblogs.com/maybe2030/p/4715035.html)
