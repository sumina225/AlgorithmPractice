import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        int[] nums = new int[t];
        int maxN = 0;
        for(int i = 0; i < t; i++){
            nums[i] = Integer.parseInt(br.readLine());
            if(nums[i] > maxN) maxN = nums[i];
        }
        boolean[] isPrime = new boolean[maxN+1];
        Arrays.fill(isPrime,true);
        isPrime[0] = false;
        isPrime[1] = false;
        for(int i = 4; i < maxN; i++){
            for(int j = 2; j*j <= i; j++){
                if(i % j == 0){
                    isPrime[i] = false;
                    break;
                }
            }
        }
        for(int i = 0; i < t; i++){
            int num = nums[i];
            int answer = 0;
            for(int j = 2; j <= num/2; j++){
                if(isPrime[j] && isPrime[num-j]){
                    answer++;
                }
            }
            sb.append(answer).append("\n");
        }
        System.out.println(sb.toString());
    }
}