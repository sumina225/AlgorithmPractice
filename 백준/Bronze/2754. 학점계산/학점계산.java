import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        float f = 0;
        switch(s){
            case "A+":
                f = 4.3f;
                break;
            case "A0":
                f = 4.0f;
                break;
            case "A-":
                f = 3.7f;
                break;
            case "B+":
                f = 3.3f;
                break;
            case "B0":
                f = 3.0f;
                break;
            case "B-":
                f = 2.7f;
                break;
            case "C+":
                f = 2.3f;
                break;
            case "C0":
                f = 2.0f;
                break;
            case "C-":
                f = 1.7f;
                break;
            case "D+":
                f = 1.3f;
                break;
            case "D0":
                f = 1.0f;
                break;
            case "D-":
                f = 0.7f;
                break;
            case "F":
                f = 0.0f;
                break;

        }
        System.out.printf("%.1f",f);
    }
}
