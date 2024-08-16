import java.io.*;
import java.util.*;


class Main{
	public static int[][] nums;
	
	public static int[] dy = {0,1,1};
	public static int[] dx = {1,1,0};
	public static int result = 0;
	public static int n;
	
    public static void main(String args[]) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        nums = new int[n][n];
        for(int i = 0; i < n; i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j = 0; j < n; j++) {
        		nums[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        pipe(1,0,0);
        
        System.out.println(result);
    }
    
    public static void pipe(int x,int y, int dir) {
    	if(x == n-1 && y == n-1) {
    		result++;
    		return;
    	}
    	int cnt = -1;
    	while(cnt <= 1) {
    		if(dir + cnt >= 0 && dir + cnt < 3) {
    			int nx = x + dx[dir+cnt];
    			int ny = y + dy[dir+cnt];
    			if(nx >= 0 && ny >= 0 && nx < n && ny < n) {
    				if(dir+cnt == 1) {
    					if(nums[ny-1][nx] != 1 && nums[ny][nx-1] != 1 && nums[ny][nx] != 1) {
    						pipe(nx,ny,dir+cnt);
    					}
    				}else {
    					if(nums[ny][nx] != 1) {
    						pipe(nx,ny,dir+cnt);
    					}
    				}
    			}
    		}
    		cnt++;
    	}
    	
    }
    
    
}