import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		int[] nums = {1,1,2,2,2,8};
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		for(int i = 0; i < n; i++) {
			for(int j = 1; j < n-i; j++) {
				System.out.print(" ");
			}
			for(int j = 0; j < 1+2*i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		for(int i = n-2; i >= 0; i--) {
			for(int j = 1; j < n-i; j++) {
				System.out.print(" ");
			}
			for(int j = 0; j < 1+2*i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
				
	}
}

