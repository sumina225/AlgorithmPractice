import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[] num = new int[n*n];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                num[i*n+j] = Integer.parseInt(st.nextToken());
            }
        }
        Arrays.sort(num);
        System.out.println(num[num.length-n]);
    }
}
