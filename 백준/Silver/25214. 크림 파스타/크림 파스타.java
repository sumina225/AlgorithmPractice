import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] nums = new int[n];
        for(int i = 0; i < n; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }
        int min = nums[0];
        int maxDiff = 0;
        for(int i = 0; i < n; i++){
            maxDiff = Math.max(maxDiff,nums[i]-min);
            min = Math.min(min,nums[i]);
            sb.append(maxDiff).append(" ");
        }
        System.out.println(sb.toString());
    }
}