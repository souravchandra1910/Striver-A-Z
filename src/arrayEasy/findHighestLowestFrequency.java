package arrayEasy;

import java.util.*;

public class findHighestLowestFrequency {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int []arr=new int[n];
		for(int i=0;i<n;i++) {
			arr[i]=sc.nextInt();
		}
		findHighestLowestFrequency(arr);
	}

	private static void findHighestLowestFrequency(int[] arr) {
      HashMap<Integer,Integer>hm=new HashMap<>();
      for(int val:arr) {
    	  hm.put(val,hm.getOrDefault(val,0)+1);
      }
      int lowest_freq=Integer.MAX_VALUE,highest_freq=Integer.MIN_VALUE;
      int lowest_freq_el=arr[0],highest_freq_el=arr[0];
      for(int key:hm.keySet()) {
    	 if(lowest_freq>hm.get(key)) {
    		 lowest_freq=hm.get(key);
    		 lowest_freq_el=key;
    	 }
    	 if(highest_freq<hm.get(key)) {
    		 highest_freq=hm.get(key);
    		 highest_freq_el=key;
    	 }
      }
      System.out.println(lowest_freq_el+" its freq "+lowest_freq);
      System.out.println(highest_freq_el+" its freq "+highest_freq);
	}

}
