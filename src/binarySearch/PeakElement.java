package binarySearch;
/*
 * Peak element in Array
Problem Statement: Given an array, find a peak element
(print anyone, if many are found). 
A peak element is one such that it is either greater than or equal to its 
neighbours. For the first and last element, 
it is enough to look at its only one neighbour.

return idx of the peak element
 */
import java.util.*;
public class PeakElement {
	public static void main(String[] args) {
		  Scanner sc=new Scanner(System.in);
		  int n=sc.nextInt();
		  int []arr=new int[n];
		  for(int i=0;i<arr.length;i++) {
			  arr[i]=sc.nextInt();
		  }
		  System.out.println(Peak(arr));
		  

	}
	public static int Peak(int []nums) {
    int low = 0;
    int high = nums.length - 1;
    int ans = -1;
    while (low <= high) {
        int mid = low + (high - low) / 2;
        if ((mid == 0 || nums[mid] > nums[mid - 1]) && (mid == nums.length - 1 || nums[mid] > nums[mid + 1])) {
            ans = mid;
            return ans;
        } else {
            if (mid > 0 && nums[mid - 1] > nums[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
    }
    return ans;
	}
}
