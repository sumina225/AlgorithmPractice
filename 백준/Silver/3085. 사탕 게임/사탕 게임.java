import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[][] nums = new char[n][n];
        for(int i = 0; i < n; i++) {
        	String s = br.readLine();
        	nums[i] = s.toCharArray();
        }
        
        int max = 0;
        for(int i = 0; i < n; i++) {
        	for(int j = 0; j < n; j++) {
        		if(j+1 < n) {
        			char temp = nums[i][j];
        			nums[i][j] = nums[i][j+1];
        			nums[i][j+1] = temp;
        			int candy = 1;
        			for(int k = 0; k < n; k++) {
        				int count = 1;
        				for(int l = 1; l < n; l++) {
        					if(nums[k][l] == nums[k][l-1]) {
        						count++;
        					}else {
        						candy = Math.max(candy, count);
        						count = 1;
        					}
        				}
        				candy = Math.max(candy, count);
        			}
        			
        			for(int l = 0; l < n; l++) {
        				int count = 1;
        				for(int k = 1; k < n; k++) {
        					if(nums[k][l] == nums[k-1][l]) {
        						count++;
        					}else {
        						candy = Math.max(candy, count);
        						count = 1;
        					}
        				}
        				candy = Math.max(candy, count);
        			}
        			max = Math.max(max, candy);
        			temp = nums[i][j];
        			nums[i][j] = nums[i][j+1];
        			nums[i][j+1] = temp;
        		}
        		if(i+1 < n) {
        			char temp = nums[i][j];
        			nums[i][j] = nums[i+1][j];
        			nums[i+1][j] = temp;
        			int candy = 1;
        			for(int k = 0; k < n; k++) {
        				int count = 1;
        				for(int l = 1; l < n; l++) {
        					if(nums[k][l] == nums[k][l-1]) {
        						count++;
        					}else {
        						candy = Math.max(candy, count);
        						count = 1;
        					}
        				}
        				candy = Math.max(candy, count);
        			}
        			
        			for(int l = 0; l < n; l++) {
        				int count = 1;
        				for(int k = 1; k < n; k++) {
        					if(nums[k][l] == nums[k-1][l]) {
        						count++;
        					}else {
        						candy = Math.max(candy, count);
        						count = 1;
        					}
        				}
        				candy = Math.max(candy, count);
        			}
        			max = Math.max(max, candy);
        			temp = nums[i][j];
        			nums[i][j] = nums[i+1][j];
        			nums[i+1][j] = temp;
        		}
        	}
        }
        System.out.println(max);
        
    }
}
