import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int[][] nums = new int[3][3];
        for(int i = 0; i < 3; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 3; j++){
                nums[i][j] = Integer.parseInt(st.nextToken()) * 3;
                sb.append(nums[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}