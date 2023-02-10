package priorityQueueAndHeap;

import java.util.*;

public class GenericHeap {
	@SuppressWarnings("unchecked")
	public static class PriorityQueue<T> {
		ArrayList<T> data;
		Comparator comp;

		public PriorityQueue() {
			data = new ArrayList<>();
			this.comp = null;
		}

		public PriorityQueue(Comparator comp) {
			data = new ArrayList<>();
			this.comp = comp;
		}

		public void add(T val) {
			data.add(val);
			upheapify(data.size() - 1);
		}

		private void upheapify(int idx) {
			if (idx == 0)
				return;

			int pidx = (idx - 1) / 2;

			if (isSmaller(idx, pidx)) {
				swap(idx, pidx);
				upheapify(pidx);
			}
		}

		private boolean isSmaller(int idx, int pidx) {
			if (comp == null) {
				Comparable ith = (Comparable) data.get(idx);
				Comparable jth = (Comparable) data.get(pidx);
				return ith.compareTo(jth) < 0;
			} else {
				T ith = data.get(idx);
				T jth = data.get(pidx);
				if (comp.compare(ith, jth) < 0)
					return true;
				else
					return false;
			}
		}

		private void swap(int i, int j) {
			T ith = data.get(i);
			T jth = data.get(j);
			data.set(i, jth);
			data.set(j, ith);
		}

		public T remove() {
			if (this.size() == 0) {
				System.out.println("Underflow");
				return null;
			}
			swap(0, data.size() - 1);
			T val = data.remove(data.size() - 1);
			downheapify(0);
			return val;
		}

		private void downheapify(int pidx) {
			int mini = pidx;

			int lidx = 2 * pidx + 1;
			if (lidx < data.size() && isSmaller(lidx, mini) == true) {
				mini = lidx;
			}
			int ridx = 2 * pidx + 2;
			if (ridx < data.size() && isSmaller(ridx, mini) == true) {
				mini = ridx;
			}

			if (mini != pidx) {
				swap(mini, pidx);
				downheapify(mini);
			}

		}

		public T peek() {
			if (this.size() == 0) {
				System.out.println("Underflow");
				return null;
			}
			return data.get(0);
		}

		public int size() {
			return data.size();

		}
	}

	static class StudentWt implements Comparator<Student> {

		@Override
		public int compare(Student s1, Student s2) {
			return s1.wt - s2.wt;
		}

	}

	static class Student implements Comparable<Student> {
		int rno;
		int marks;
		int wt;

		public Student(int rno, int marks, int wt) {
			this.rno = rno;
			this.marks = marks;
			this.wt = wt;
		}

		@Override
		public int compareTo(Student o) {
			return this.marks - o.marks;

		}

		public String toString() {
			return "Rollno= " + this.rno + " , " + "Marks= " + this.marks + " , " + "wt= " + this.wt;
		}

	}

	public static void main(String[] args) {

		PriorityQueue<Student> pq = new PriorityQueue(new StudentWt());
		pq.add(new Student(13, 98, 55));
		pq.add(new Student(2, 38, 105));
		pq.add(new Student(9, 88, 65));
		pq.add(new Student(89, 58, 45));
		pq.add(new Student(100, 68, 65));

		while (pq.size() > 0) {
			System.out.println(pq.remove());
		}

	}
}