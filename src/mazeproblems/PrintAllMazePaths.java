package mazeproblems;

import java.util.*;

public class PrintAllMazePaths {

	public static void main(String[] args) {
		List<String>al=new ArrayList<>();
		List<List<String>>ans=new ArrayList<>();
		printAllPaths(al,0,0,2,2,ans);
		for(List<String>a:ans)System.out.println(a);
	}

	private static void printAllPaths(List<String> al, int sr, int sc, int dr, int dc, List<List<String>> ans) {
		if(sr>dr || sc>dc)return;
		if(sr==dr && sc==dc) {
			List<String>temp=new ArrayList<>(al);
			ans.add(temp);
			return;
		}
		al.add("D");//push_back() in c++
		printAllPaths(al,sr+1,sc,dr,dc,ans);
		al.remove(al.size()-1);// pop_back();  in c++
		al.add("R");
		printAllPaths(al,sr,sc+1,dr,dc,ans);
		al.remove(al.size()-1);	
	}

}
