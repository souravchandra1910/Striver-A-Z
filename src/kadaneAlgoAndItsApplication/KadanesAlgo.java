package kadaneAlgoAndItsApplication;

import java.util.Scanner;

public class KadanesAlgo {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		  int n=sc.nextInt();
		  int []arr=new int[n];
		  for(int i=0;i<arr.length;i++) {
			  arr[i]=sc.nextInt();
		  }
		  System.out.println(Kadane(arr));
	}

	private static int Kadane(int[] nums) {
		 int csum=nums[0];
	        int osum=nums[0];
	        for(int i=1;i<nums.length;i++){
	            if(csum>0){
	                csum+=nums[i];
	            }else{
	                csum=nums[i];
	            }
	            if(csum>osum){
	                osum=csum;
	            }
	        }
	        return osum;
	}

}
//[-2,1,-3,4,-1,2,1,-5,4
