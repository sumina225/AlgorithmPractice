import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		String input;
		int minx = 10000;
		int miny = 10000;
		int maxx = -10000;
		int maxy = -10000;
		for(int i = 0; i < n; i++) {
			input = br.readLine();
			st = new StringTokenizer(input);
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			if(x < minx) {
				minx = x;
			}
			if(x > maxx) {
				maxx = x;
			}
			if(y < miny) {
				miny = y;
			}
			if(y > maxy) {
				maxy = y;
			}
		}
		System.out.println((maxx-minx)*(maxy-miny));
	}
}
