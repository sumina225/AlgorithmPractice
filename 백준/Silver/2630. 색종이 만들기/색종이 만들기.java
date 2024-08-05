import java.io.*;
import java.util.*;

public class Main {
	public static int blue = 0;
	public static int white = 0;
	public static int[][] nums;
	
    public static void main(String[] args) throws IOException {
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
    	
    	System.out.println(white);
    	System.out.println(blue);
    	
    }
    
    public static void cut(int x, int y, int size) {
    	if(isSame(x,y,size)) {
    		if(nums[x][y] == 0) {
    			white++;
    		}else {
    			blue++;
    		}
    		return;
    	}
    	int newSize = size/2;
    	for(int i = 0; i < 2; i++) {
    		for(int j = 0; j < 2; j++) {
    			cut(x+i*newSize, y+j*newSize,newSize);
    		}
    	}
    }
    
    public static boolean isSame(int x, int y, int size) {
    	for(int i = x; i < x+size; i++) {
    		for(int j = y; j < y+size; j++) {
    			if(nums[x][y] != nums[i][j])
    				return false;
    		}
    	}
    	return true;
    }
       
}