package heap;

import java.util.*;

public class KmostFrequentElements {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int []arr=new int[n];
		for(int i=0;i<arr.length;i++) {
			arr[i]=sc.nextInt();
		}
		int k=sc.nextInt();
	   List<Integer>al=KmostFrequentElements(arr,k);
	   System.out.println(al);
	}

	private static List<Integer> KmostFrequentElements(int[] arr,int k) {
		//1st step: Count freq of all elements
		
		HashMap<Integer,Integer>hm=new HashMap<>();
		for(int val:arr) {
			hm.put(val,hm.getOrDefault(val,0)+1);
		}
		System.out.println(hm);
		 // store them in all freqs in an priorityqueue (priorityqueue will sort
        //		                                          on the basis of freq)
		
		PriorityQueue<Integer>pq=new PriorityQueue<>((a,b)->hm.get(a)-hm.get(b));
		for(int key:hm.keySet()) {
		   pq.add(key);
		   if(pq.size()>k) {
				   pq.poll();
			   }
		   }
	    List<Integer>al=new ArrayList<>();
	    while(pq.size()>0) {
	    	al.add(pq.poll());
	    }
	    return al;
		
	}
}

//2 3
//3 4
//1 4
