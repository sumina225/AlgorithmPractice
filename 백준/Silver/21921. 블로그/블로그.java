import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int[] nums = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }
        int max = 0;
        int count = 0;
        int sum = 0;
        for(int i = 0; i < x; i++){
            sum += nums[i];
        }
        if(sum > 0){
            max = sum;
            count = 1;
        }
        int index = 0;
        for(int i = x; i < n; i++){
            sum -= nums[index];
            sum += nums[i];
            index++;
            if(max < sum){
                max = sum;
                count = 1;
            }else if(max == sum){
                count++;
            }
        }
        if(max == 0){
            System.out.println("SAD");
        }else{
            System.out.println(max);
            System.out.println(count);
        }

    }
}
