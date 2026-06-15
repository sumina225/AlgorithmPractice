import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for(int i = 5; i <= 17; i++){
            sb.append(i).append(" ");
        }
        System.out.println(sb.toString());
    }
}