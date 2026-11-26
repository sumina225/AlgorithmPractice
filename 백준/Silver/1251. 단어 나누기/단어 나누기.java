import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int n = s.length();
        String ans = null;

        for(int i = 1; i < n - 1; i++){
            for(int j = i + 1; j < n; j++){
                String s1 = new StringBuilder(s.substring(0, i)).reverse().toString();
                String s2 = new StringBuilder(s.substring(i, j)).reverse().toString();
                String s3 = new StringBuilder(s.substring(j)).reverse().toString();

                String result = s1 + s2 + s3;

                if(ans == null || result.compareTo(ans) < 0){
                    ans = result;
                }
            }
        }

        System.out.println(ans);
    }
}