import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int gender = Integer.parseInt(br.readLine());
        int age = Integer.parseInt(br.readLine());

        if(gender == 0){
            if(age >= 19){
                System.out.println("MAN");
            } else {
                System.out.println("BOY");
            }
        } else {
            if(age >= 19){
                System.out.println("WOMAN");
            } else {
                System.out.println("GIRL");
            }
        }
    }
}