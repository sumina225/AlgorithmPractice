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
            sb.append("Case #").append(i+1).append(": ");
            Arrays.sort(nums);
            if(nums[0] + nums[1] <= nums[2]){
                sb.append("invalid!\n");
                continue;
            }
            if(nums[0] == nums[1] && nums[1] == nums[2]){
                sb.append("equilateral\n");
            } else if(nums[0] == nums[1] || nums[1] == nums[2] || nums[0] == nums[2]){
                sb.append("isosceles\n");
            } else {
                sb.append("scalene\n");
            }
        }
        System.out.println(sb);

    }
}
