import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		String input = br.readLine();
		st = new StringTokenizer(input);
		String a = st.nextToken();
		String b = st.nextToken();
		int[] A = new int[3];
		int[] B = new int[3];
		for(int i = 0; i < 3; i++) {
			A[i] = a.charAt(i) - '0';
			B[i] = b.charAt(i) - '0';
		}
		for(int i = 0; i <= 1; i++) {
			int temp = A[i];
			A[i] = A[2-i];
			A[2-i] = temp;
			
			temp = B[i];
			B[i] = B[2-i];
			B[2-i] = temp;
		}
		int numA = 100*A[0] + 10*A[1] + A[2];
		int numB = 100*B[0] + 10*B[1] + B[2];
		if(numA > numB) System.out.println(numA);
		else System.out.println(numB);
	}
}
