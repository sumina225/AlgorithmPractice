import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        cute : while(true){
            String s = br.readLine();
            if(s.equals("end")) break;
            boolean aeiou = false;
            char prev = s.charAt(0);
            int ja = 0;
            int mo = 0;
            if(prev == 'a' || prev == 'e' || prev == 'i' || prev == 'o' || prev == 'u'){
                aeiou = true;
                mo = 1;
            }else{
                ja = 1;
            }

            for(int i = 1; i < s.length(); i++){
                char c = s.charAt(i);
                if(c == prev){
                    if(prev == 'o' || prev == 'e'){

                    }else{
                        sb.append("<").append(s).append("> is not acceptable.").append("\n");
                        continue cute;
                    }

                }
                if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'){
                    aeiou = true;
                    ja = 0;
                    mo++;
                    prev = c;
                }else{
                   mo = 0;
                   ja++;
                   prev = c;
                }
                if(ja >= 3 || mo >= 3){
                    sb.append("<").append(s).append("> is not acceptable.").append("\n");
                    continue cute;
                }
            }
            if(aeiou){
                sb.append("<").append(s).append("> is acceptable.").append("\n");
            }else{
                sb.append("<").append(s).append("> is not acceptable.").append("\n");
            }
        }
        System.out.println(sb);
    }
}
