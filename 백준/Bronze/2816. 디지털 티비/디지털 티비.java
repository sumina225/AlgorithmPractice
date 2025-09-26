import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int n = Integer.parseInt(br.readLine());
        List<String> channels = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            channels.add(br.readLine());
        }
        
        int currentPos = 0; // 화살표 현재 위치
        
        // 1. KBS1을 첫 번째로 이동
        int kbs1Pos = channels.indexOf("KBS1");
        
        // 화살표를 KBS1 위치로 이동
        while (currentPos < kbs1Pos) {
            sb.append("1");
            currentPos++;
        }
        
        // KBS1을 맨 위로 이동
        while (currentPos > 0) {
            sb.append("4");
            Collections.swap(channels, currentPos, currentPos - 1);
            currentPos--;
        }
        
        // 2. KBS2를 두 번째로 이동
        int kbs2Pos = channels.indexOf("KBS2");
        
        // 화살표를 KBS2 위치로 이동
        while (currentPos < kbs2Pos) {
            sb.append("1");
            currentPos++;
        }
        
        // KBS2를 두 번째 위치로 이동 (1번 위치까지만)
        while (currentPos > 1) {
            sb.append("4");
            Collections.swap(channels, currentPos, currentPos - 1);
            currentPos--;
        }
        
        System.out.println(sb.toString());
        
        br.close();
    }
}