import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int h = Integer.parseInt(br.readLine()) * 100;
        int w = Integer.parseInt(br.readLine()) * 100;
        int answer = Math.min(h, w) / 2;
        System.out.println(answer);

    }
}
