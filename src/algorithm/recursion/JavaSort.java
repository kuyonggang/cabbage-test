/**
 * 
 */
package algorithm.recursion;
/**
 * 类名称：JavaSort<br>
 * 类描述：<br>
 * 创建时间：2020年1月3日下午6:34:32<br>
 *
 * @author YoungerKu
 * @version	1.0.0
*/
public class JavaSort {

    public static void main(String[] args) {
        int a[] = { 10, 1, 8, 20, 9, 67, 73, 91 };
        //  bubbleSort(a);
        //      
        //  insertSort(a);
        //      
        //  selectSort(a);
        
        quickSort(a);
        System.out.println("快速排序结果：");
        for (int k = 0; k < a.length; k++) {
            System.out.print(a[k] + " ");
        }
        System.out.println();
    }

    /**
     * 插入排序
     * @param a
     */
    public static void insertSort(int[] a) {
        int i, j, insertNote;// 要插入的数据
        for (i = 1; i < a.length; i++) {// 从数组的第二个元素开始循环将数组中的元素插入
            insertNote = a[i];// 设置数组中的第2个元素为第一次循环要插入的数据
            j = i - 1;
            while (j >= 0 && insertNote < a[j]) {
                a[j + 1] = a[j];// 如果要插入的元素小于第j个元素,就将第j个元素向后移动
                j--;
            }
            a[j + 1] = insertNote;// 直到要插入的元素不小于第j个元素,将insertNote插入到数组中
        }
        System.out.println("插入排序结果：");
        for (int k = 0; k < a.length; k++) {
            System.out.print(a[k] + " ");
        }
        System.out.println();
    }
    
    /**
     * 冒泡排序最好时间复杂度为O(n),即数组本身是正序；最差时间复杂度为O(n*n)
     * @param array
     */
    public static void bubbleSort(int []array){
        for (int i = 0; i < array.length - 1; i++){
            for (int j = 0; j < array.length - 1 - i; j++){
                if (array[j] > array[j + 1]) {
                    int t = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = t;
                }
            }
        }
        System.out.println("冒泡排序结果：");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
    
    /**
     * 选择排序算法
     * @param arr
     */
    public static void selectSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int index;// 定义下标
        for (int i = 0; i < arr.length; i++) {
            index = i;// 初始下标为i
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[index]) {
                    index = j;
                }
            }
            if (index != i) {
                int temp = arr[index];
                arr[index] = arr[i];
                arr[i] = temp;
            }
        }
        
        System.out.println("选择排序结果：");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    
    /**
     * 快速排序
     * @param a
     * @param low
     * @param hight
     */
    public static void sort(int a[], int low, int hight) {
        int i, j, index;
        if (low > hight) {
            return;
        }
        i = low;
        j = hight;
        index = a[i]; // 用子表的第一个记录做基准
        while (i < j) { // 从表的两端交替向中间扫描
            while (i < j && a[j] >= index)
                j--;
            if (i < j)
                a[i++] = a[j];// 用比基准小的记录替换低位记录
            while (i < j && a[i] < index)
                i++;
            if (i < j) // 用比基准大的记录替换高位记录
                a[j--] = a[i];
        }
        a[i] = index;// 将基准数值替换回 a[i]
        sort(a, low, i - 1); // 对低子表进行递归排序
        sort(a, i + 1, hight); // 对高子表进行递归排序
    }
    public static void quickSort(int a[]) {
        sort(a, 0, a.length - 1);
    }

}
