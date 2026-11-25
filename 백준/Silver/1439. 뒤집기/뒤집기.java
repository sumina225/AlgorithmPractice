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
        int[] count = new int[2];
        char prev = s.charAt(0);
        count[prev - '0']++;
        boolean b = false;
        for(int i = 1; i < s.length(); i++) {
            if(prev != s.charAt(i)){
                count[s.charAt(i) - '0']++;
                prev = s.charAt(i);
                b = true;
            }
        }
        if(b){
            System.out.println(Math.min(count[0], count[1]));
        } else {
            System.out.println(0);
        }


    }
}