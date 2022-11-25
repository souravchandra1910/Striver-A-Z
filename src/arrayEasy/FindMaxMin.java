package arrayEasy;

import java.util.Arrays;
import java.util.Scanner;

public class FindMaxMin {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int []arr=new int[n];
		for(int i=0;i<n;i++) {
			arr[i]=sc.nextInt();
		}
		traversal(arr);
		sorting(arr);
		divideAndConquor(0,n-1,arr);
		System.out.println(min+" "+max);
	}
     static int max=-1,min=-1;
	private static void divideAndConquor(int low,int high,int[] arr) {
		if(low==high) {
			min=max=arr[low];
		}
		else if((low+1)==high) {
			min=Math.min(arr[low],arr[high]);
			max=Math.max(arr[low], arr[high]);
		}else {
			int mid=low+(high-low)/2;
			divideAndConquor(low,mid,arr);
		    int min1=min,max1=max;
		    divideAndConquor(mid+1,high,arr);
		    min=Math.min(min,min1);
		    max=Math.max(max, max1);
		}
	}

	private static void sorting(int[] arr) {
		if(arr.length==0) {
			System.out.println(-1+" "+-1);
		}
		Arrays.sort(arr);
		System.out.println(arr[0]+"  "+arr[arr.length-1]);
		
	}

	private static void traversal(int[] arr) {
		if(arr.length==0) {
			System.out.println(-1+" "+-1);
		}
		int max=arr[0],min=arr[0];
		for(int i=0;i<arr.length;i++) {
			max=Math.max(max,arr[i]);
			min=Math.min(min,arr[i]);
		}
		System.out.println(min+" "+max);
	}

}
