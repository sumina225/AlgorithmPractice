import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        String s = br.readLine();
        char[] cs = s.toCharArray();

        cs[1] = 'a';
        cs[cs.length-2] = 'a';
        System.out.println(String.valueOf(cs));

    }
}