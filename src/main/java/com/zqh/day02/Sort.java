package com.zqh.day02;

public class Sort {
    public static void main(String[] args) {

        /*
        选择排序：一次比较，第一个元素和剩下的所有元素以此比较选出最值

        冒泡排序：相邻元素比较，如何符合条件就替换,
        每次循环，相邻2个元素比较，大的往后靠，比较到最后，最大值落到底部
        然后继续第二次循环比较，比较次数少了最后一位
         */
        int[] arr = {9, 8, 7, 5, 3, 3, 2, 1};
        bubbleSort(arr);
        printArray(arr);
        int index = getIndex(arr, 17);
        System.out.println("======================================");
        System.out.println(index != -1 ? index : "数组中不存在该数值！");
    }

    private static void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i != arr.length - 1) {
                System.out.print(",");
            } else {
                System.out.print("]");
            }
        }
        System.out.println();
    }

    /*
    冒泡排序，最值以此从底部或顶部冒出
     */
    private static void bubbleSort(int[] arr) {
        //{9, 8, 7, 5, 3, 3, 2, 1}
        for (int i = 0; i < arr.length - 1; i++) {  //比较循环次数 数组长度-1
            //一次从第一个数开始相邻比较，大数落后
            for (int j = 0; j < arr.length - 1 - i; j++) {  //-1避免下表越界   -i是为了减少比较的次数
                if (arr[j] < arr[j + 1]) {   //考虑y+1的值不能超过数组长度-1
                    /*int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;*/
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    /*
    交换数组的2个下标值
     */
    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }


    /**
     * 在数组中查找第一次等于目的值得下标！
     *
     * @param arr 被查询的数组
     * @param key 查找的数值
     * @return 如果找到，返回数组中的下标，否则返回-1
     */

    public static int getIndex(int[] arr, int key) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key)
                return i;
        }
        return -1;
    }
}
