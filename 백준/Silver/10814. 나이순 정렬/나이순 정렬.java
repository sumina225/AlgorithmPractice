import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		int n = Integer.parseInt(br.readLine());
		String[][] info = new String[n][3];
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			info[i][0] = st.nextToken();
			info[i][1] = st.nextToken();
			info[i][2] = Integer.toString(i);
		}
		Arrays.sort(info,new Comparator<String[]>() {
			public int compare(String[] s1, String[] s2) {
				if(s1[0].equals(s2[0])) {
					return Integer.parseInt(s1[2])-Integer.parseInt(s2[2]);
				}
				return Integer.parseInt(s1[0])-Integer.parseInt(s2[0]);
			}
		});
		for(int i = 0; i < n; i++) {
			bw.write(info[i][0] + " " + info[i][1] + "\n");
		}
		
		
		
		br.close();
		bw.flush();
		bw.close();
	}
}
