import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int[] x = new int[3];
		int[] y = new int[3];
		for(int i = 0; i < 3; i++) {
			String input = br.readLine();
			st = new StringTokenizer(input);
			x[i] = Integer.parseInt(st.nextToken());
			y[i] = Integer.parseInt(st.nextToken());
		}
		int ansx = 0;
		int ansy = 0;
		for(int i = 0; i < 3; i++) {
			int countx = 0;
			int county = 0;
			for(int j = 0; j < 3; j++) {
				if(x[i] == x[j]) {
					countx++;
				}
				if(y[i] == y[j]) {
					county++;
				}
			}
			if(countx == 1) {
				ansx = x[i];
			}
			if(county == 1) {
				ansy = y[i];
			}
		}
		System.out.println(ansx + " " + ansy);
		
		
	}
}
