import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int num = 0;
        int n = Integer.parseInt(br.readLine());
        for(int i = 1; i <= 100; i++){
            num += i;
            if(num >= n){
                System.out.println(i);
                break;
            }
        }
    }
}