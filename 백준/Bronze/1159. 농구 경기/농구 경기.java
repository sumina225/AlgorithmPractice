import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[26];
        for(int i = 0; i < n; i++){
            String s = br.readLine();
            int num = s.charAt(0)-'a';
            nums[num]++;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 26; i++){
            if(nums[i] >= 5){
                char c = (char)('a' + i);
                sb.append(c);
            }
        }
        if(sb.toString().equals("")){
            sb.append("PREDAJA");
        }
        System.out.println(sb.toString());
    }
}