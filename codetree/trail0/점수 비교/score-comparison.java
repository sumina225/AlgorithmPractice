import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int aMath = Integer.parseInt(st.nextToken());
        int aEng = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        int bMath = Integer.parseInt(st.nextToken());
        int bEng = Integer.parseInt(st.nextToken());

        if(aMath > bMath && aEng > bEng){
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}