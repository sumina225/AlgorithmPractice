import java.io.*;
import java.util.*;

public class Main {

    static boolean[] visited;
    static int n;
    static int k;
    static int[] nums;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        nums = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }
        visited = new boolean[n];
        answer = 0;
        func(0,500);
        System.out.println(answer);
    }

    static void func(int day,int total){
        if(total < 500) return;
        if(day >= n){
            answer++;
        }
        for(int i = 0; i < n; i++){
            if(!visited[i]){
                visited[i] = true;
                func(day+1,total - k + nums[i]);
                visited[i] = false;
            }
        }
    }

}
