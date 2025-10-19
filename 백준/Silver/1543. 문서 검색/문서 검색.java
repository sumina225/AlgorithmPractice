import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String find = br.readLine();
        int answer = 0;
        while(s.contains(find)){
            s = s.substring(s.indexOf(find) + find.length());
            answer++;
        }
        System.out.println(answer);
    }
}