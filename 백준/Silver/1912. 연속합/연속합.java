import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int answer = Integer.MIN_VALUE;
        int cur = 0;
        for(int i = 0; i < n; i++){
            int num = Integer.parseInt(st.nextToken());
            cur = Math.max(cur+num,num);
            if(answer < cur){
                answer = cur;
            }
        }
        System.out.println(answer);

    }
}

