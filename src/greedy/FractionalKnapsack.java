package greedy;

import java.util.Arrays;

class Item implements Comparable<Item>{
	int cost,wt;
	Item(int cost,int wt){
		this.cost=cost;
		this.wt=wt;
	}
	@Override
	public int compareTo(Item o) {
		 double r1=(double)(this.cost/this.wt);
		 double r2=(double)(o.cost/o.wt);
		 if(r1<r2) {
			 return 1;
		 }else if(r1==r2) {
			 return 0;
		 }else
			 return -1;
	}
}

public class FractionalKnapsack {
	public static void main(String[] args) {
	 int n = 3, weight = 50;
	 Item arr[] = {new Item (100,20),new Item(60,10),new Item(120,30)};
	 double ans = fractionalKnapsack(weight, arr, n);
	 System.out.println("The maximum value is "+ans);	
	}
	private static double fractionalKnapsack(int weight, Item [] arr, int n) {
	  Arrays.sort(arr);
	  double netProfit=0.0;
	  double rwt=weight;
	  double []solutionVector=new double[n];
	  for(int i=0;i<n;i++) {
		  if(rwt>=arr[i].wt) {
			  solutionVector[i]=1.0;
			  rwt-=arr[i].wt;
			  netProfit+=arr[i].cost;
			  System.out.println(netProfit+" "+i+" "+rwt);
			  
		  }else {
			  netProfit+=((double)(arr[i].cost*1.0/arr[i].wt*1.0))*(double)(rwt);
			  solutionVector[i]=(rwt*1.0/arr[i].wt);
			  break;
		  }
	  }
	  System.out.println(Arrays.toString(solutionVector));
	  return netProfit;
	}
}
