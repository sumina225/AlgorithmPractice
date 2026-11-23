import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int[] nums = new int[3];
            for(int j = 0; j < 3; j++){
                nums[j] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(nums);
            sb.append("Scenario #").append(i+1).append(":\n").append(Math.pow(nums[0],2) + Math.pow(nums[1],2) == Math.pow(nums[2],2) ? "yes" : "no").append("\n\n");
        }
        System.out.println(sb);
    }
}
