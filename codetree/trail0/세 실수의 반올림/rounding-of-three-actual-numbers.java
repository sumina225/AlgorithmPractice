import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        float a = Float.parseFloat(br.readLine());
        float b = Float.parseFloat(br.readLine());
        float c = Float.parseFloat(br.readLine());

        System.out.printf("%.3f\n%.3f\n%.3f", a, b, c);
    }
}