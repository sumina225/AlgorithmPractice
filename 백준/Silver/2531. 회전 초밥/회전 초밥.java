import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int[] nums = new int[n];
        for(int i = 0; i < n; i++){
            nums[i] = Integer.parseInt(br.readLine());
        }
        int left = 0;
        int right = k-1;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < k; i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i],map.get(nums[i])+1);
            }else{
                map.put(nums[i],1);
            }
        }
        int answer = 0;
        if(map.containsKey(c)){
            answer = map.size();
        }else{
            answer = map.size()+1;
        }
        int total = answer;
        while(left < n-1){
            if(map.get(nums[left]) == 1){
                map.remove(nums[left]);
            }else{
                map.put(nums[left],map.get(nums[left])-1);
            }
            left++;
            right = (right+1) % n;
            if(map.containsKey(nums[right])){
                map.put(nums[right],map.get(nums[right])+1);
            }else{
                map.put(nums[right],1);
            }
            if(map.containsKey(c)){
                total = map.size();
            }else{
                total = map.size()+1;
            }
            if(answer < total){
                answer = total;
            }
        }

        System.out.println(answer);

    }
}
