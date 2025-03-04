import java.io.*;
import java.util.*;

public class Solution {
    static ArrayList<Integer> list;
    static StringBuilder sb;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        for(int tc = 1; tc <= 10; tc++){
            list = new ArrayList<>();
            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<n; i++) {
                list.add(Integer.parseInt(st.nextToken()));
            }
            int q = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<q; i++) {
                char cmd = st.nextToken().charAt(0);
                int x = Integer.parseInt(st.nextToken());
                func(cmd, x);
            }
            sb.append("#"+tc);
            for(int i =0; i<10; i++) {
                sb.append(" " + list.get(i));
            }
            sb.append("\n");

        }
        System.out.println(sb);

    }

    private static void func(char cmd, int x) {
        int y;
        switch(cmd){
            case 'I':
                y = Integer.parseInt(st.nextToken());
                for(int i=0, insertIdx = x; i<y; i++, insertIdx++) {
                    list.add(insertIdx, Integer.parseInt(st.nextToken()));
                }
                break;
            case 'D':
                y = Integer.parseInt(st.nextToken());
                for(int i=0; i<y; i++)
                    list.remove(x);
                break;

            case 'A':
                for(int i=0; i<x; i++) {
                    list.add(Integer.parseInt(st.nextToken()));
                }
                break;
        }
    }
}