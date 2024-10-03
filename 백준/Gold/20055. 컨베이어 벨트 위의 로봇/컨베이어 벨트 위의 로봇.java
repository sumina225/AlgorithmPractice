import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static int k;
	static int[] nums;
	static boolean[] robot;
	static int zero;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        nums = new int[n*2];
        robot = new boolean[n*2];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n*2; i++) {
        	nums[i] = Integer.parseInt(st.nextToken());
        }
        
        int time = 0;
        while(true) {
        	time++;
        	move();
        	
        	
        	
        	if(nums[0] > 0 && !robot[0]) {
        		robot[0] = true;
        		nums[0]--;
        		if(nums[0] == 0) {
        			zero++;
        		}
        	}
        	
        	if(zero >= k) {
        		break;
        	}
        	
        }
        System.out.println(time);
        
        
        
    }
    
    static void move() {
    	int last = nums[2*n-1];
    	
    	
    	for(int i = 2*n-1; i> 0; i--) {
    		nums[i] = nums[i-1];
    		robot[i] = robot[i-1];
    	}
    	
    	nums[0] = last;
    	robot[0] = false;
    	
    	robot[n-1] = false;
    	
    	for(int i = n-1; i>= 1; i--) {
    		if(!robot[i] && robot[i-1] && nums[i] > 0) {
    			robot[i] = true;
    			robot[i-1] = false;
    			nums[i]--;
    			if(nums[i] == 0) zero++;
    		}
    	}
    }
}
