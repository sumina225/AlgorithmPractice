import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        long x = Integer.parseInt(st.nextToken());
        long y = Integer.parseInt(st.nextToken());
        long z = (y*100)/x;
        long low = 1;
        long high = 1000000000;
        long answer = -1;
        long mid = 0;
        while(low <= high){
            mid = (low + high) / 2;
            if(((y+mid)*100)/(x+mid) > z){
                answer = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        System.out.println(answer);
    }
}
