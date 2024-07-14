import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		if(n == 1) {
			return;
		}
		int div = 2;
		while(n != 1) {
			if(n% div == 0) {
				n/= div;
				System.out.println(div);
			}
			else {
				div++;
			}
		}
	}
}
