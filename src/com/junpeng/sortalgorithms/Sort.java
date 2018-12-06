/**
 * @Project algorithms
 * @Author Junpeng Wang
 * @Date Dec 3, 2018
 * @Copyright 2018 Junpeng Wang. All rights reserved.
 */
package com.junpeng.sortalgorithms;

import java.util.Arrays;

/**
 * @author Junpeng Wang
 *
 */
public final class Sort {

	// Print Array
	public static <T> void printArray(T[] arr) {
		System.out.println(Arrays.toString(arr));
	}

	// Swap Elements
	public static <T extends Comparable<T>> void swap(T[] arr, int i, int j) {
		T temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	// Bubble Sort
	public static <T extends Comparable<T>> void bubbleSort(T[] arr) {
		int len = arr.length;

		while (len > 0) {
			for (int i = 0; i < len - 1; i++) {
				if (arr[i].compareTo(arr[i + 1]) > 0) {
					swap(arr, i, i + 1);
				}
			}
			len--;
		}
	}

	// Selection Sort
	public static <T extends Comparable<T>> void selectionSort(T[] arr) {
		int len = arr.length;
		int min_idx;

		for (int i = 0; i < len; i++) {
			min_idx = i;
			for (int j = i + 1; j < len; j++) {
				if (arr[min_idx].compareTo(arr[j]) > 0) {
					min_idx = j;
				}
			}
			swap(arr, i, min_idx);
		}
	}

	// Insertion Sort
	public static <T extends Comparable<T>> void insertionSort(T[] arr) {
		int len = arr.length;

		for (int i = 1; i < len; i++) {
			for (int j = i; j >= 1 && arr[j].compareTo(arr[j - 1]) < 0; j--) {
				swap(arr, j, j - 1);
			}
		}
	}

	// Quick Sort
	public static <T extends Comparable<T>> void quickSort(T[] arr, int low_idx, int high_idx) {
		int low = low_idx, high = high_idx;
		T flag;

		if (low < high) {
			flag = arr[low];
			while (low != high) {
				while (high > low && arr[high].compareTo(flag) >= 0)
					high--;
				arr[low] = arr[high];
				while (low < high && arr[low].compareTo(flag) <= 0)
					low++;
				arr[high] = arr[low];
			}
			arr[low] = flag;

			quickSort(arr, low_idx, low - 1);
			quickSort(arr, low + 1, high_idx);
		}
	}

	// Shell Sort
	public static <T extends Comparable<T>> void shellSort(T[] arr) {
		int len = arr.length;
		int gap = 1;

		// Dynamically define the gap
		while (gap < len / 3) {
			gap = gap * 3 + 1;
		}

		while (gap >= 1) {
			for (int i = gap; i < len; i++) {
				for (int j = i; j >= gap && arr[j].compareTo(arr[j - gap]) < 0; j -= gap) {
					swap(arr, j, j - gap);
				}
			}
			gap = gap / 3;
		}
	}

	// Merge Sort
	public static <T extends Comparable<T>> void mergeSort(T[] arr, int left_idx, int right_idx, T[] temp_arr) {
		if (left_idx < right_idx) {
			int mid = (left_idx + right_idx) / 2;
			mergeSort(arr, left_idx, mid, temp_arr);
			mergeSort(arr, mid + 1, right_idx, temp_arr);
			merge(arr, left_idx, mid, right_idx, temp_arr);
		}

	}

	public static <T extends Comparable<T>> void merge(T[] arr, int left_idx, int mid, int right_idx, T[] temp_arr) {
		int l = left_idx, r = mid + 1, i = 0;

		while (l <= mid && r <= right_idx) {
			if (arr[l].compareTo(arr[r]) < 0) {
				temp_arr[i++] = arr[l++];
			} else {
				temp_arr[i++] = arr[r++];
			}
		}

		while (l <= mid) {
			temp_arr[i++] = arr[l++];
		}

		while (r <= right_idx) {
			temp_arr[i++] = arr[r++];
		}

		i = 0;
		while (left_idx <= right_idx) {
			arr[left_idx++] = temp_arr[i++];
		}
	}
}
