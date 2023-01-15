package heap;

import java.util.*;

public class Kthlargest_SmallestElement {

	public static void main(String[] args) {
		 Scanner sc=new Scanner(System.in);
		   int n=sc.nextInt();
		   int []arr=new int[n];
		   for(int i=0;i<arr.length;i++) {
			   arr[i]=sc.nextInt();
		    }
		   int k=sc.nextInt();
//		   Input:
//		   6
//		   1 7 2 9 3 4
//		   3
		  
		   
		   int v1=kthLargestElement(arr,k);
		   System.out.println(v1);
		   int v2=kthSmallestElement(arr,k);
		   System.out.println(v2);
//        output:
//		   4
//		   3

	}

	private static int kthLargestElement(int[] arr,int k) {
	// when require the largest use min priorityQueue
	   PriorityQueue<Integer>pq=new PriorityQueue<>();
	   for(int el:arr) {
		   pq.add(el);
		   if(pq.size()>k)pq.poll();
	   }
	   return pq.peek();
	   
	}

	private static int kthSmallestElement(int[] arr,int k) {
		// when require the smallest use max priorityQueue
		 PriorityQueue<Integer>pq=new PriorityQueue<>(Collections.reverseOrder());
		   for(int el:arr) {
			   pq.add(el);
			   if(pq.size()>k)pq.poll();
		   }
		   return pq.peek();
	}

}
