import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String a = st.nextToken();
        String b = st.nextToken();
        char[] aCharArray = a.toCharArray();
        char[] bCharArray = b.toCharArray();

        for(int i = 0; i < aCharArray.length; i++) {
            if(aCharArray[i] == '6') {
                aCharArray[i] = '5';
            }
        }
        for(int i = 0; i < bCharArray.length; i++) {
            if(bCharArray[i] == '6') {
                bCharArray[i] = '5';
            }
        }
        int[] answer = new int[2];
        answer[0] = Integer.parseInt(new String(aCharArray)) + Integer.parseInt(new String(bCharArray));

        for(int i = 0; i < aCharArray.length; i++) {
            if(aCharArray[i] == '5') {
                aCharArray[i] = '6';
            }
        }
        for(int i = 0; i < bCharArray.length; i++) {
            if(bCharArray[i] == '5') {
                bCharArray[i] = '6';
            }
        }
        answer[1] = Integer.parseInt(new String(aCharArray)) + Integer.parseInt(new String(bCharArray));
        System.out.println(answer[0] + " " + answer[1]);
    }
}