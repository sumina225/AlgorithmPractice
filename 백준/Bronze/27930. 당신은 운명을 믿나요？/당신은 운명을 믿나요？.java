import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String s1 = "KOREA";
        String s2 = "YONSEI";
        int idx1 = 0;
        int idx2 = 0;
        for(int i = 0; i < s.length(); i++) {
            if(idx1 == s1.length()) {
                System.out.println(s1);
                break;
            }else if(idx2 == s2.length()) {
                System.out.println(s2);
                break;
            }
            if(s.charAt(i) == s1.charAt(idx1)) {
                idx1++;
            }
            if(s.charAt(i) == s2.charAt(idx2)) {
                idx2++;
            }
        }
    }
}