package arrayEasy;

import java.util.Arrays;
import java.util.Scanner;

public class ImageRotate {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int [][]arr=new int[n][n];
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++){
			arr[i][j]=sc.nextInt();
		    }
		}
		
		ImageRotate(arr,n);
		for(int []a:arr) {
			System.out.println(Arrays.toString(a));
		}

	}

	private static void ImageRotate(int[][] arr,int n) {
	    
		//1st step is to calculate the transpose
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<i;j++) {
				int temp=arr[i][j];
				arr[i][j]=arr[j][i];
				arr[j][i]=temp;
			}
		}
		
		// row-wise swap
		
		for(int i=0;i<n;i++) {
			int low=0;
			int high=arr[i].length-1;
			while(low<high) {
				int temp=arr[i][low];
				arr[i][low]=arr[i][high];
				arr[i][high]=temp;
				low++;
				high--;
			}
		}
		
	}
}
