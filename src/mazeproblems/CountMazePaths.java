package mazeproblems;

public class CountMazePaths {

	public static void main(String[] args) {
		System.out.println(count(0,0,2,2));

	}

	private static int count(int sr, int sc, int dr, int dc) {
		if(sr>dr || sc>dc)return 0;
		
		if(sr==dr && sc==dc)return 1;
		
		int left=count(sr+1,sc,dr,dc);
		int right=count(sr,sc+1,dr,dc);
		
		return left+right;
	}

}
