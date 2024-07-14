import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][] nums = new int[100][100];
		for(int i = 0; i < 100; i++) {
			for(int j = 0; j < 100; j++) {
				nums[i][j] = 0;
			}
		}
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		for(int i = 0; i < n; i++) {
			String input = br.readLine();
			st = new StringTokenizer(input);
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			for(int j = a; j < a+10; j++) {
				for(int m = b; m <b+10; m++) {
					nums[j][m] = 1;
				}
			}
		}
		int result = 0;
		for(int[] i : nums) {
			for(int j : i) {
				if(j == 1) {
					result++;
				}
			}
		}
		System.out.println(result);
		
	}
}

