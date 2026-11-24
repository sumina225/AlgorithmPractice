import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int ans = 0;
        for(int i = 0; i < s.length(); i++) {
            if(ans % 5 == 0 && s.charAt(i) == 'K') {
                ans++;
            }else if(ans % 5 == 1 && s.charAt(i) == 'O') {
                ans++;
            }else if(ans % 5 == 2 && s.charAt(i) == 'R') {
                ans++;
            } else if(ans % 5 == 3 && s.charAt(i) == 'E') {
                ans++;
            } else if(ans % 5 == 4 && s.charAt(i) == 'A') {
                ans++;
            }
        }
        System.out.println(ans);

    }
}