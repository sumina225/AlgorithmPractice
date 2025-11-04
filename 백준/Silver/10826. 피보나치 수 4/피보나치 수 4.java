import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        if(n == 0){
            System.out.println(0);
            return;
        }
        BigInteger[] nums = new BigInteger[n+1];
        nums[0] = BigInteger.ZERO;
        nums[1] = BigInteger.ONE;
        for(int i = 2; i <= n; i++){
            nums[i] = nums[i-1].add(nums[i-2]);
        }
        System.out.println(nums[n]);
    }
}
