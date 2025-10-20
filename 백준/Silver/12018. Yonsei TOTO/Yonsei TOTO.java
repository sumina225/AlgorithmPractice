import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] nums = new int[n];
        // 마일리지 같으면 성준이 우선순위
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());

            int[] temp = new int[p];
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < p; j++){
                temp[j] = Integer.parseInt(st.nextToken());
            }
            if(p < l){
                nums[i] = 1;
                continue;
            }
            Arrays.sort(temp);
            nums[i] = temp[p-l];
        }
        Arrays.sort(nums);
        int sum = 0;
        int count = 0;
        for(int i = 0; i < n; i++){
            sum += nums[i];
            if(sum <= m){
                count++;
            }else{
                break;
            }
        }
        System.out.println(count);
    }
}