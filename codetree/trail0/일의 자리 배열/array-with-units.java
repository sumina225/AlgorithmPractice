import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int[] nums = new int[10];
        nums[0] = Integer.parseInt(st.nextToken());
        nums[1] = Integer.parseInt(st.nextToken());
        sb.append(nums[0]).append(" ").append(nums[1]).append(" ");
        for(int i = 2; i < 10; i++){
            nums[i] = (nums[i-2] + nums[i-1]) % 10;
            sb.append(nums[i]).append(" ");
        }
        System.out.println(sb.toString());
    }
}