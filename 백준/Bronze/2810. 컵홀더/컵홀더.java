import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        int count = 0;
        for(int i = 0; i < s.length(); i++){
            count++;
            if(s.charAt(i) == 'L'){
                i++;
            }
        }
        System.out.println(Math.min(n,count+1));
    }
}