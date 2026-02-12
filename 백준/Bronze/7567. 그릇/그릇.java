import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        char c = s.charAt(0);
        int answer = 10;
        for(int i = 1; i < s.length(); i++){
            if(c == s.charAt(i)){
                answer += 5;
            }else{
                answer += 10;
                c = s.charAt(i);
            }

        }
        System.out.println(answer);
    }
}
