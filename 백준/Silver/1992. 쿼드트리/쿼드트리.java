import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static String result = "";
	public static int[][] nums;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		nums = new int[n][n];
		for(int i = 0; i < n; i++) {
			String s = br.readLine();
			for(int j = 0; j < n; j++) {
				nums[i][j] = Integer.parseInt(Character.toString(s.charAt(j)));
			}
		}
		
		cut(0,0,n);
		System.out.println(result);
		
	}
	
	public static void cut(int x, int y, int size) {
		if(isSame(x,y,size)) {
			result += Integer.toString(nums[x][y]);
			return;
		}
		int newSize = size/2;
		for(int i = 0; i < 2; i++) {
			for(int j = 0; j < 2; j++) {
				if(i == 0 && j == 0) result+="(";
				cut(x+newSize*i, y+newSize*j,newSize);
				if(i == 1 && j == 1) result+=")";
			}
		}
	}
	
	public static boolean isSame(int x, int y, int size) {
		for(int i = x; i < x+ size; i++) {
			for(int j = y; j < y+size; j++) {
				if(nums[i][j] != nums[x][y]) return false;
			}
		}
		
		
		return true;
	}
}