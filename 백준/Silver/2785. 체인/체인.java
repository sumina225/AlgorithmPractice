import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] nums = new int[n];
        for(int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums);
        int cnt = 0;
        int sum = 0;
        for(int i = 0; i < n; i++){
            cnt = n-i-1;
            sum += nums[i];
            if(sum >= cnt) break;
        }
        System.out.println(cnt);

    }
}
