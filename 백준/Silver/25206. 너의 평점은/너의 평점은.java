import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		double sum = 0;
		int count = 0;
		StringTokenizer st = null;
		for(int i = 0; i < 20; i++) {
			String input = br.readLine();
			st = new StringTokenizer(input);
			String trash = st.nextToken();
			double score = Double.parseDouble(st.nextToken());
			String s = st.nextToken();
			if(s.equals("A+")) {
				sum += score*4.5;
			}
			else if(s.equals("A0")) {
				sum += score*4.0;
			}
			else if(s.equals("B+")) {
				sum += score*3.5;
			}
			else if(s.equals("B0")) {
				sum += score*3.0;
			}
			else if(s.equals("C+")) {
				sum += score*2.5;
			}
			else if(s.equals("C0")) {
				sum += score*2.0;
			}
			else if(s.equals("D+")) {
				sum += score*1.5;
			}
			else if(s.equals("D0")) {
				sum += score*1.0;
			}
			if(s.equals("P")) continue;
			count += score;
		}
		System.out.println(sum/count);
		
	}
}

