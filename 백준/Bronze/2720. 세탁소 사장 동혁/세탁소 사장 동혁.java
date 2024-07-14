import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test_case = Integer.parseInt(br.readLine());
		for(int t = 0; t < test_case; t++) {
			int coin = Integer.parseInt(br.readLine());
			int[] result = {0,0,0,0};
			if(coin / 25 > 0) {
				result[0] += coin/25;
				coin = coin%25;
			}
			if(coin / 10 > 0) {
				result[1] += coin/10;
				coin = coin%10;
			}
			if(coin / 5 > 0) {
				result[2] += coin/5;
				coin = coin%5;
			}
			result[3] += coin;
			for(int i = 0; i < 4; i++) {
				System.out.print(result[i] + " ");
			}
			System.out.println();
		}
	}
}
