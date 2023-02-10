package priorityQueueAndHeap;

import java.util.ArrayList;

public class EfficientConstructorforPriorityQueue {
	public static class PriorityQueue{
	    ArrayList<Integer> data;

	    public PriorityQueue(int []arr) {
	      data = new ArrayList<>();
	      
	      for(int val:arr) {
	    	  data.add(val);
	      }
	      
	      for(int i=data.size()/2-1;i>=0;i--) {
	    	  downheapify(i);
	      }
	      
	    }

	    public void add(int val) {
	      data.add(val);
	      upheapify(data.size() - 1);
	    }

	    private void upheapify(int idx) {
	      if (idx == 0)return;

	      int pidx = (idx - 1) / 2;
 
	      if (data.get(idx) < data.get(pidx)) {
	        swap(idx, pidx);
	        upheapify(pidx);
	      }
	    }

	    private void swap(int i, int j) {
	      int ith = data.get(i);
	      int jth = data.get(j);
	      data.set(i, jth);
	      data.set(j, ith);
	    }

	    public int remove() {
	      if (this.size() == 0) {
	        System.out.println("Underflow");
	        return -1;
	      }
	      swap(0, data.size() - 1);
	      int val = data.remove(data.size() - 1);
	      downheapify(0);
	      return val;
	    }
	    private void downheapify(int pidx) {
	      int mini = pidx;

	      int lidx = 2 * pidx + 1;
	      if (lidx < data.size() && data.get(lidx) < data.get(mini)) {
	        mini = lidx;
	      }
	      int ridx = 2 * pidx + 2;
	      if (ridx < data.size() && data.get(ridx) < data.get(mini)) {
	        mini = ridx;
	      }

	      if (mini != pidx) {
	        swap(mini, pidx);
	        downheapify(mini);
	      }

	    }

	    public int peek() {
	      if (this.size() == 0) {
	        System.out.println("Underflow");
	        return -1;
	      }
	      return data.get(0);
	    }

	    public int size() {
	      return data.size();

	    }
	  }
	public static void main(String[] args) {
		int []arr= {10,2,17,3,18,9,22};
		PriorityQueue pq=new PriorityQueue(arr);
		
		while(pq.size()>0) {
			System.out.println(pq.remove());
		}
		
	}
}
