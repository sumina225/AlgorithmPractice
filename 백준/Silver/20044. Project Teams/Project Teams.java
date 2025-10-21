import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] nums = new int[2*n];
        for(int i = 0; i < 2*n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){
            int sum = nums[i] + nums[2*n-i-1];
            if(min > sum){
                min = sum;
            }
        }
        System.out.println(min);
    }
}
