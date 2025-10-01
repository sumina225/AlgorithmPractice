import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        String s = br.readLine();
        int num = 0;
        int index = 0;
        while(index < s.length()){
            num++;
            String temp = Integer.toString(num);
            for(int i = 0; i < temp.length(); i++){
                if(s.charAt(index) == temp.charAt(i)){
                    index++;
                    if(index >= s.length()) break;
                }
            }
        }
        System.out.println(num);
    }
}
