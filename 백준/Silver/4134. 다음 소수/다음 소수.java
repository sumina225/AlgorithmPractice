import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for(int tc = 0; tc < t; tc++){
            long n = Long.parseLong(br.readLine());
            while(true){
                boolean isPossible = true;
                if(n == 2){
                    sb.append(2).append("\n");
                    break;
                }
                if(n % 2 ==0 || n <= 1){
                    n++;
                    continue;
                }
                for(long i = 2; i*i <= n; i++){
                    if(n % i == 0){
                        isPossible = false;
                        break;
                    }
                }
                if(isPossible){
                    sb.append(n).append("\n");
                    break;
                }else{
                    n++;
                }
            }
        }
        System.out.println(sb.toString());
    }
}
