package algorithm.sort;

import java.util.Arrays;

public class BubbleSort {

	public static void main(String []args){
		int []arr ={1,4,2,7,9,8,3,6};
		bubbleSort(arr);
		System.out.println(Arrays.toString(arr));
	}
	
	/**
	 * @param arr
	 */
	public static void bubbleSort(int[] arr) {
		for (int i = 0; i < arr.length-1; i++) {
			boolean flag = true;
			for (int j = 0; j < arr.length-1-i; j++) {
				if (arr[j] > arr[j + 1]) {
					swap(arr,j,j+1);
					flag = false;
				}
			}
			if (flag) {
				break;
			}
		}
	}

	public static void swap(int []arr,int a,int b){
		arr[a] = arr[a]+arr[b];
		arr[b] = arr[a]-arr[b];
		arr[a] = arr[a]-arr[b];
	}

}
