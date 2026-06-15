import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int[][] nums1 = new int[3][3];
        int[][] nums2 = new int[3][3];
        for(int i = 0; i < 3; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 3; j++){
                nums1[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        String s = br.readLine();
        for(int i = 0; i < 3; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 3; j++){
                nums2[i][j] = Integer.parseInt(st.nextToken());
                sb.append(nums1[i][j]  * nums2[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}