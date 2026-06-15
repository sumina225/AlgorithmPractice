import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int count = 0;
        for(int i = 0; i <= n; i++){
            if(i % 2 != 0 && i % 3 != 0 && i % 5 != 0){
                count++;
            }
        }
        System.out.println(count);
    }
}