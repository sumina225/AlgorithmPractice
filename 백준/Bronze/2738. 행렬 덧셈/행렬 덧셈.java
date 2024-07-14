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
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][] A = new int[n][m];
		for(int i = 0; i < n; i++) {
			input = br.readLine();
			st = new StringTokenizer(input);
			for(int j = 0; j < m; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i = 0; i < n; i++) {
			input = br.readLine();
			st = new StringTokenizer(input);
			for(int j = 0; j < m; j++) {
				A[i][j] += Integer.parseInt(st.nextToken());
			}
		}
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				System.out.print(A[i][j] + " ");
			}
			System.out.println();
		}
		
		
	}
}

