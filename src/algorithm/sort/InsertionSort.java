package algorithm.sort; /**
 * @ProjectName my-algorithms
 * @FileName InsertionSort.java
 * @PackageName:demo.sort
 * @author YoungerKu
 * @date 2017��10��26������4:21:23
 * @since 1.0.0
 * @Copyright (c) 2017,GS ###@unisguard.com All Rights Reserved.
 */

import java.util.Arrays;

/**
 * ��������
 *
 * @author YoungerKu
 * @date 2017��10��26�� ����4:21:23
 * @since 1.0.0
 */
public class InsertionSort {

	public static void main(String[] args) {
		int []arr ={1,4,2,7,9,8,3,6};
		insertionSort(arr);
		System.out.println(Arrays.toString(arr));
	}

	/**
	 * ��������
	 *
	 * @param arr
	 */
	public static void insertionSort(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			int j = i;
			while (j > 0 && arr[j] < arr[j - 1]) {
				swap(arr,j,j-1);
				j--;
			}
		}
	}

	/**
	 * ��������Ԫ��
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
