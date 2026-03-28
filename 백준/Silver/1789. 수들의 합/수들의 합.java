import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long s = Long.parseLong(br.readLine());
        long sum = 0;
        long n = 0;

        while (sum + (n + 1) <= s) {
            n++;
            sum += n;
        }

        System.out.println(n);
    }
}