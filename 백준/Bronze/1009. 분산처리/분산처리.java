import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int base = a % 10;
            int result;

            switch (base) {
                case 0: result = 10; break;
                case 1: result = 1; break;
                case 2: {
                    int[] arr = {2, 4, 8, 6};
                    result = arr[(b - 1) % 4];
                    break;
                }
                case 3: {
                    int[] arr = {3, 9, 7, 1};
                    result = arr[(b - 1) % 4];
                    break;
                }
                case 4: {
                    int[] arr = {4, 6};
                    result = arr[(b - 1) % 2];
                    break;
                }
                case 5: result = 5; break;
                case 6: result = 6; break;
                case 7: {
                    int[] arr = {7, 9, 3, 1};
                    result = arr[(b - 1) % 4];
                    break;
                }
                case 8: {
                    int[] arr = {8, 4, 2, 6};
                    result = arr[(b - 1) % 4];
                    break;
                }
                case 9: {
                    int[] arr = {9, 1};
                    result = arr[(b - 1) % 2];
                    break;
                }
                default: result = 10;
            }

            System.out.println(result);
        }
    }
}
