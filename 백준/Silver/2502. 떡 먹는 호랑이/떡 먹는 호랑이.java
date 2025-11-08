import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] a = new int[d+1];
        int[] b = new int[d+1];
        a[1] = 1;
        b[1] = 0;
        a[2] = 0;
        b[2] = 1;

        for(int i = 3; i <= d; i++){
            a[i] = a[i-1] + a[i-2];
            b[i] = b[i-1] + b[i-2];
        }

        for(int i = 1; i <= k; i++){
            int num = k - a[d]*i;
            if(num % b[d] == 0){
                int j = num / b[d];
                if(i <= j){
                    System.out.println(i);
                    System.out.println(j);
                    break;
                }
            }
        }
    }
}
