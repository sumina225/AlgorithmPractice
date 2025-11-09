import java.io.*;

public class Main {
    static int fibCount(int n) {
        if (n == 1 || n == 2) return 1;
        else return fibCount(n - 1) + fibCount(n - 2);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        int code1 = fibCount(n); // 코드1 횟수
        int code2 = n - 2;       // 코드2 횟수
        
        System.out.println(code1 + " " + code2);
    }
}
