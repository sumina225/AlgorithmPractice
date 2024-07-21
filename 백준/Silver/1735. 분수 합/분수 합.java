import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		st = new StringTokenizer(br.readLine());
		int[] a = new int[2];
		for(int i = 0; i < 2; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		int[] b = new int[2];
		for(int i = 0; i < 2; i++) {
			b[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = Math.min(a[1], b[1]); i <= a[1]*b[1]; i++) {
			if(i % a[1] == 0 && i % b[1] == 0) {
				a[0] *= i/a[1];
				a[1] = i;
				b[0] *= i/b[1];
				b[1] = i;
				break;
			}
		}
		int[] result = {a[0]+b[0],a[1]};
		for(int i = 2; i <= result[0]; i++) {
			if(result[0] % i == 0 && result[1] % i == 0) {
				result[0] /= i;
				result[1] /= i;
				i--;
			}
		}
		bw.write(result[0] + " " + result[1]);
		
		
		
		br.close();
		bw.flush();
		bw.close();
	}
}
