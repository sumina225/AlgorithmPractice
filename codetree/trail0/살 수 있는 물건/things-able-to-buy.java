import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        if(n >= 3000){
            System.out.println("book");
        } else if(n >= 1000){
            System.out.println("mask");
        } else {
            System.out.println("no");
        }
    }
}