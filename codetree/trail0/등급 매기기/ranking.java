import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        if(n >= 90){
            System.out.println("A");
        } else if(n >= 80){
            System.out.println("B");
        } else if(n >= 70){
            System.out.println("C");
        } else if(n >=  60) {
            System.out.println("D");
        } else {
            System.out.println("F");
        }
    }
}