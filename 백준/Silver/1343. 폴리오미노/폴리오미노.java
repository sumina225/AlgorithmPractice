import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == 'X'){
                count++;
            } else {
                if(count % 2 == 1){
                    System.out.println(-1);
                    return;
                }else{
                    for(int j = 0; j < count / 4; j++){
                        sb.append("AAAA");
                    }
                    if(count % 4 != 0){
                        sb.append("BB");
                    }
                }
                sb.append(".");
                count = 0;
            }
        }
        if(count % 2 == 1){
            System.out.println(-1);
            return;
        }else{
            for(int j = 0; j < count / 4; j++){
                sb.append("AAAA");
            }
            if(count % 4 != 0){
                sb.append("BB");
            }
        }
        System.out.println(sb);


    }
}