import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        n = 1000-n;
        int answer = 0;
        answer += n / 500;
        n = n%500;
        answer += n / 100;
        n = n%100;
        answer += n / 50;
        n = n%50;
        answer += n / 10;
        n = n%10;
        answer += n / 5;
        n = n%5;
        answer += n / 1;
        System.out.println(answer);
    }
}