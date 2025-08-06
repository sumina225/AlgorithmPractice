import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Integer[] nums = new Integer[N];
        int count = 0;
        int answer = 0;
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            nums[i] = Integer.parseInt(st.nextToken()) - Integer.parseInt(st.nextToken());
            if(nums[i] >= 0){
                count++;
            }
        }
        Arrays.sort(nums,Collections.reverseOrder());
        while(count < K){
            if(nums[count] + answer >= 0){
                count++;
                continue;
            }
            answer = - nums[count];
            count++;
        }
        System.out.println(answer);
    }
}