package greedy;
//At a lemonade stand, each lemonade costs $5.
//Customers are standing in a queue to buy from you and order one at a time
//(in the order specified by bills). 
//Each customer will only buy one lemonade and pay with 
//either a $5, $10, or $20 bill. 
//You must provide the correct change to each customer
//so that the net transaction is that the customer pays $5.
//
//Note that you do not have any change in hand at first.
//
//Given an integer array bills where bills[i] is the bill the ith 
//customer pays, return true if you can provide every customer with 
//		the correct change, or false otherwise.
//
// 
//
//Example 1:
//
//Input: bills = [5,5,5,10,20]
//Output: true
//Explanation: 
//From the first 3 customers, we collect three $5 bills in order.
//From the fourth customer, we collect a $10 bill and give back a $5.

public class LemonadeExchange {
	  public boolean lemonadeChange(int[] arr) {
	        int c5 = 0, c10 = 0;
	        for (int i = 0; i < arr.length; i++) {
	            if (arr[i] == 5) {
	                c5++;
	            } else if (arr[i] == 10) {
	                if (c5 == 0) return false; else {
	                    c5--;
	                    c10++;
	                }
	            } else if (arr[i] == 20) {
	                if (c5 >= 1 && c10 >= 1) {
	                    c5--;
	                    c10--;
	                } else if (c5 >= 3) {
	                    c5 -= 3;
	                } else {
	                    return false;
	                }
	            }
	        }
	        return true;
	    }
	}

