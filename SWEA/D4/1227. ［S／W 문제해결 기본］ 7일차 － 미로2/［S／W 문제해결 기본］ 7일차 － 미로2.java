import java.io.*;
import java.util.*;


class Solution
{
	public static int[][] nums = new int[100][100];
	public static boolean isPossible;
	public static int[] dy = {0,0,-1,1};
	public static int[] dx = {-1,1,0,0};
	public static boolean[][] visited;
	
    public static void main(String args[]) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        for(int test_case = 1; test_case <= 10; test_case++) {
        	int t = Integer.parseInt(br.readLine());
        	isPossible = false;
        	visited = new boolean[100][100];
        	int x = -1;
        	int y = -1;
        	for(int i = 0; i < 100; i++) {
        		String s = br.readLine();
        		for(int j = 0; j < 100; j++) {
        			nums[i][j] = s.charAt(j)-'0';
        			if(nums[i][j] == 2) {
        				x = j;
        				y = i;
        			}
        		}
        	}
        	DFS(x,y);
        	if(isPossible) {
        		System.out.println("#" + t + " 1");
        	}else {
        		System.out.println("#" + t + " 0");
        	}
        	
        }
    }
    
    public static void DFS(int x, int y) {
    	visited[y][x] = true;
    	if(nums[y][x] == 3) {
    		isPossible = true;
    		return;
    	}
    	for(int i = 0; i < 4; i++) {
    		int nx = x+dx[i];
    		int ny = y+dy[i];
    		if(nx >= 0 && nx < 100 && ny >= 0 && ny < 100 && !visited[ny][nx] && nums[ny][nx] != 1) {
    			DFS(nx,ny);
    		}
    	}
    }
}