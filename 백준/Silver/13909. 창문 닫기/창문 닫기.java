import java.io.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine().trim()); // N ≤ 2,100,000,000
        long answer = (long)Math.sqrt(n);              // ⌊√N⌋
        System.out.println(answer);
    }
}
