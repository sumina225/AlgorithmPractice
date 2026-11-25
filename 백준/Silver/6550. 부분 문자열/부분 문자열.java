import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = "";
        while((s = br.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(s);
            String a = st.nextToken();
            String b = st.nextToken();
            int index = 0;
            for(int i = 0; i < b.length(); i++) {
                if(index == a.length()) {
                    break;
                } else {
                    if(a.charAt(index) == b.charAt(i)) {
                        index++;
                    }
                }
            }
            if(index == a.length()) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }

        }
    }
}