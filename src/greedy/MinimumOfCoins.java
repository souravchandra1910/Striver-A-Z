package greedy;

/*Given an infinite supply of each denomination of Indian currency
{ 1, 2, 5, 10, 20, 50, 100, 200, 500, 2000 } and a target value N.
//Find the minimum number of coins and/or notes needed to make the
change for Rs N. You must return the list containing the value of coins
required. 
*/
import java.util.*;

public class MinimumOfCoins {
	static List<Integer> minPartition(int n)
    {
		//greedily chose the maximum valued coin/note
       int cnt=0;
       int []arr={ 1, 2, 5, 10, 20, 50, 100, 200, 500, 2000 };
       List<Integer>al=new ArrayList<>();
       int i=arr.length-1;
       while(n>0){
           if(n>=arr[i]){
               while(n>=arr[i]){
                 n-=arr[i];  
                 al.add(arr[i]);
               }
           }else{
               i--;
           }
       }
       return al;
        
    }
}
