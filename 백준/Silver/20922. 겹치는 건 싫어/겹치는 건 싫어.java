import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int answer = 0;
        int first = 0;
        int last = 0;
        int[] count = new int[100001];
        int[] nums = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }
        int total = 0;
        while(last < n){
            if(count[nums[last]] + 1 <= k){
                count[nums[last]]++;
                last++;
                total++;
                answer = Math.max(answer,total);
            }else{
                count[nums[first]]--;
                first++;
                total--;
            }
        }
        System.out.println(answer);
    }
}
