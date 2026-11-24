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
        String compare = "UCPC";
        int index = 0;
        for(int i=0;i<s.length();i++) {
            if(index == 4) break;
            if(s.charAt(i) == compare.charAt(index)) {
                index++;

            }
        }
        if(index == 4) {
            System.out.println("I love UCPC");
        } else {
            System.out.println("I hate UCPC");
        }
    }
}