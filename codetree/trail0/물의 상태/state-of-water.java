import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        if(n < 0) {
            System.out.println("ice");
        } else if (n >= 0 && n < 100){
            System.out.println("water");
        } else {
            System.out.println("vapor");
        }
    }
}