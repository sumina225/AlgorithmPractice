import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        String s = br.readLine();
        for(int i = 0; i < 8; i++){
            sb.append(s);
        }
        System.out.println(sb.toString());
    }
}