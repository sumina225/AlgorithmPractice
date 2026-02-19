import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int l = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        int[] nums = new int[5];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 5; i++){
            nums[i] = Integer.parseInt(st.nextToken()) - l*p;
            sb.append(nums[i]).append(" ");
        }
        System.out.println(sb.toString());

    }
}
