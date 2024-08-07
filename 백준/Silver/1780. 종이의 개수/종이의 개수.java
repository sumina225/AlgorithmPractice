import java.io.*;
import java.util.*;

public class Main {
	static int[] result = new int[3];
	static int[][] nums;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		nums = new int[n][n];
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				nums[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		cut(0,0,n);
		for(int i : result) {
			System.out.println(i);
		}
		
	}
	
	static void cut(int x, int y, int size) {
		if(isSame(x,y,size)) {
			switch(nums[x][y]) {
			case -1 :
				result[0]++;
				break;
			case 0 :
				result[1]++;
				break;
			case 1 :
				result[2]++;
				break;
			}
			return;
		}
		int newSize = size/3;
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				cut(x+i*newSize,y +j*newSize,newSize);
			}
		}
	}
	
	static boolean isSame(int x, int y, int size) {
		for(int i = x; i < x+size; i++) {
			for(int j = y; j < y+size; j++) {
				if(nums[i][j] != nums[x][y]) {
					return false;
				}
			}
		}
		return true;
	}
	
}
