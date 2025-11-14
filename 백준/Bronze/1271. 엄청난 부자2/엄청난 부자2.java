import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        BigInteger n = new BigInteger(st.nextToken());  // 최백준 조교가 가진 돈
        BigInteger m = new BigInteger(st.nextToken());  // 생명체 수

        BigInteger share = n.divide(m);  // 1명당 받을 돈
        BigInteger remain = n.remainder(m); // 나머지

        System.out.println(share);
        System.out.println(remain);
    }
}
