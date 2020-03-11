package algorithm.sort;

import java.util.Arrays;

/**
 * @author YoungerKu
 * @since 1.0.0
 */
public class SelectSort {

	public static void main(String[] args) {
		int[] arr ={1,4,2,7,9,8,3,6};
		selectSort(arr);
		System.out.println(Arrays.toString(arr));
	}
	
	/**
	 * @param arr
	 */
	public static void selectSort(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			int min = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] < arr[min]) {
					min = j;
				}
			}
			if (min != i) {
				swap(arr,min,i);
			}
		}
	}

	/**
	 * @param arr
	 * @param a
	 * @param b
	 */
	public static void swap(int []arr,int a,int b){
		arr[a] = arr[a]+arr[b];
		arr[b] = arr[a]-arr[b];
		arr[a] = arr[a]-arr[b];
	}
}
