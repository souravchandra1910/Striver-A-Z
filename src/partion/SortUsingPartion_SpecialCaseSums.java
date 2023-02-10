package partion;

import java.util.*;

public class SortUsingPartion_SpecialCaseSums {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		// sort 0 and 1
//		System.out.println("Printing the Array before sorting ");
//		display(arr);
//		sort01(arr);
//		System.out.println("Printing the Array after sorting ");
//		display(arr);
//
//		// seperate odd and even (odd first)
//
//		System.out.println("Printing the Array before separation ");
//		display(arr);
//		separateOdd_Even(arr);
//		System.out.println("Printing the Array after separation ");
//		display(arr);
//
//		// separate -ve and +ve
//
//		System.out.println("Printing the Array before separation ");
//		display(arr);
//		separateneg_pos(arr);
//		System.out.println("Printing the Array after separation ");
//		display(arr);

		// Dutch National Flag algo

		System.out.println("Printing the Array before separation ");
		display(arr);
		sort012(arr);
		System.out.println("Printing the Array after separation ");
		display(arr);
	}

	private static void sort01(int[] arr) {
		// 1 0 1 1 0 1
		// 0 0 1 1 1 1
		int i = 0;
		int j = 0;
		while (i < arr.length) {
			if (arr[i] == 1) {
				i++;
			} else {
				swap(arr, i, j);
				i++;
				j++;
			}
		}

		// Time Complexity :O(N)

		// space complexity : O(1) no extra space is used
	}

	private static void separateOdd_Even(int[] arr) {
		// 2 3 5 6 8 1
		// 3 5 1 6 8 2
		int i = 0;
		int j = 0;
		while (i < arr.length) {
			if (arr[i] % 2 == 0) {
				i++;
			} else {
				swap(arr, i, j);
				i++;
				j++;
			}
		}
		// Time Complexity :O(N)
		// space complexity : O(1) no extra space is used
	}

	private static void separateneg_pos(int[] arr) {
		// -2 3 4 -1 0 -6 (input)
		// -2 -1 -6 3 0 4 (output)
		int i = 0;
		int j = 0;
		while (i < arr.length) {
			if (arr[i] >= 0) {
				i++;
			} else {
				swap(arr, i, j);
				i++;
				j++;
			}
		}
		// Time Complexity :O(N)
		// space complexity : O(1) no extra space is used
	}

	private static void sort012(int[] arr) {
		// 2 0 1 1 0 2
		// 0 0 1 1 2 2
		
		
		// 0 1 2 0 2 1
		//  low high
		//    mid
		int low = 0, mid = 0, high = arr.length - 1;
		while (mid <= high) {
			if (arr[mid] == 0) {
				swap(arr, low, mid);
				low++;
				mid++;
			} else if (arr[mid] == 1) {
				mid++;
			} else {
				swap(arr, mid, high);
				high--;
			}
		}
		// Time Complexity :O(N) (Three Pointer approach)
		// space complexity : O(1) no extra space is used
	}

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	// Arrays.stream(arr).forEach(e->System.out.print(e+" "));printing array using
	// streams

	private static void display(int[] arr) {
		for (int val : arr)
			System.out.print(val + " ");
		System.out.println();

	}
}
