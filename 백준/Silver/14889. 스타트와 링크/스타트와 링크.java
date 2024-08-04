import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static int[][] nums;
	static boolean[] visited;
	static int min = Integer.MAX_VALUE;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        nums = new int[n][n];
        visited = new boolean[n];
        
        for(int i = 0; i < n; i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j = 0; j < n; j++) {
        		nums[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        findDiff(0, 0);
        
        System.out.println(min);
    }
    
    public static void findDiff(int idx, int count) {
    	if(count == n/2) {
    		cal();
    		return;
    	}
    	if(idx >= n) return;
    	
    	visited[idx] = true;
    	findDiff(idx+1,count+1);
    	
    	visited[idx] = false;
    	findDiff(idx+1,count);
    }
    
    public static void cal() {
    	int team1 = 0;
    	int team2 = 0;
    	
    	for(int i = 0; i < n; i++) {
    		for(int j = 0; j < n; j++) {
    			if(visited[i] && visited[j]) {
    				team1 += nums[i][j];
    			}else if(!visited[i] && !visited[j]) {
    				team2 += nums[i][j];
    			}
    		}
    	}
    	int diff = Math.abs(team1-team2);
    	min = Math.min(min, diff);
    }
}