import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		String input = br.readLine();
		st = new StringTokenizer(input);
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		int min = 1000;
		if(min > x) {
			min = x;
		}
		if(min > y) {
			min = y;
		}
		if(min > w-x) {
			min = w-x;
		}
		if(min > h-y) {
			min = h-y;
		}
		System.out.println(min);
	}
}
