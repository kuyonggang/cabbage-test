/*
 */
package algorithm.sort.quick;
/**
 * ��QuickSort.java��ʵ��������TODO ��ʵ������ 
 * @author Younger 2019��1��9�� ����9:48:36
 */
public class QuickSort {

    public static int partition(long[] arr,int left,int right,long point) {
        int leftPtr = left -1;
        int rightPtr = right;
        while(true) {
            while(leftPtr < rightPtr && arr[++leftPtr] < point);
            while(rightPtr > leftPtr && arr[--rightPtr] > point);
            if(rightPtr <= leftPtr) {
                break;
            }else {
                long tmp = arr[rightPtr];
                arr[rightPtr] = arr[leftPtr];
                arr[leftPtr] = tmp;
            }
        }
        long tmp = arr[right];
        arr[right] = arr[leftPtr];
        arr[leftPtr] = tmp;
        return leftPtr;
    }
    
    public static void displayArr(long[] arr) {
        System.out.print("[");
        for (long l : arr) {
            System.out.print(l+" ");
        }
        System.out.println("]");
    }
    
    public static void sort(long[] arr,int left,int right) {
        if(right - left <= 0) {
            return;
        }
        long point = arr[right];
        int pointPos = partition(arr, left, right, point);
        sort(arr, left, pointPos-1);
        sort(arr, pointPos+1, right);
    }
}
