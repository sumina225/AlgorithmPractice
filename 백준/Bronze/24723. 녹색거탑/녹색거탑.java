import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        //1-> 2 2->4 3->
        int n = Integer.parseInt(br.readLine());
        int result = (int)Math.pow(2,n);
        System.out.println(result);
    }
}
