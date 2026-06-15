import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int y = Integer.parseInt(br.readLine());
        if(y % 4 == 0 && !(y % 100 == 0 && y % 400 != 0)) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }
}