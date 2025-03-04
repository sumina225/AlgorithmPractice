import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());
        int total = (1 << 10) - 1;
        for(int t = 1; t <= testCase; t++){
            int n = Integer.parseInt(br.readLine());
            int visited = 0;
            int count = 0;
            for(count = 1;;count++){
                char[] arr = String.valueOf(n*count).toCharArray();
                for(char c : arr){
                    int num = c - '0';
                    visited = visited | (1 << num);
                }
                if(visited == total) break;
            }
            sb.append("#").append(t).append(" ").append(n*count).append("\n");
        }
        System.out.println(sb);
    }
}