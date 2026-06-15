import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 9; i >= 0; i--){
            sb.append(st.nextToken().charAt(0));
        }
        System.out.println(sb.reverse());
    }
}