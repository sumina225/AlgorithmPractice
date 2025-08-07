import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int b = Integer.parseInt(br.readLine());
        String[] lows = new String[b];
        String[] highs = new String[b];
        for(int i = 0; i < b; i++){
            lows[i] = br.readLine();
        }
        for(int i = 0; i < b; i++){
            highs[i] = br.readLine();
        }

        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++){
            String data = br.readLine();
            int high = 0;
            int low = 0;
            for(int j = 0; j < b; j++){
                String temp = data;
                while(temp.length() >= lows[j].length() && temp.contains(lows[j])){
                    low++;
                    temp = temp.substring(temp.indexOf(lows[j])+1);
                }
            }
            for(int j = 0; j < b; j++){
                String temp = data;
                while(temp.length() >= highs[j].length() && temp.contains(highs[j])){
                    high++;
                    temp = temp.substring(temp.indexOf(highs[j])+1);
                }
            }
            if(high > low){
                sb.append("LOW").append(" ").append(high-low).append("\n");
            }else if(high == low){
                sb.append("GOOD").append("\n");
            }else{
                sb.append("HIGH").append(" ").append(low-high).append("\n");
            }
        }
        System.out.println(sb);

    }
}
