import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        String a = st.nextToken();
        String b = st.nextToken();
        if(a.length() > b.length()){
            System.out.println(a + " " + a.length());
        } else if(a.length() < b.length()) {
            System.out.println(b + " " + b.length());
        } else {
            System.out.println("same");
        }
    }
}