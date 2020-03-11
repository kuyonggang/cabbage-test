/*
 */
package algorithm.sort.quick;

import java.util.Random;

/**
 * ��TestQuickSort.java��ʵ��������TODO ��ʵ������ 
 * @author Younger 2019��1��9�� ����9:48:56
 */
public class TestQuickSort {

    /**
     * @param args
     */
    public static void main(String[] args) {
        long[] arr = new long[10];
        for (int i = 0; i < 10; i++) {
            long e = (long) (new Random().nextDouble()*100);
            arr[i] = e;
        }
        QuickSort.displayArr(arr);
        QuickSort.sort(arr, 0, arr.length-1);
        QuickSort.displayArr(arr);
    }

}
