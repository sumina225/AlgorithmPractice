import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        if(n == 0) {
            System.out.println("NO");
            return;
        }
        long[] nums = new long[20];
        nums[0] = 1;
        for(int i = 1; i < nums.length; i++){
            nums[i] = nums[i-1] * i;
        }
        for(int i = 19; i >= 0; i--){
            if(n == 0) break;
            if(nums[i] <= n){
                n -= nums[i];
            }
        }
        if(n == 0){
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}