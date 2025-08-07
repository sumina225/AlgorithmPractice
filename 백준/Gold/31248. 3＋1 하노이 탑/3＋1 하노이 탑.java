import java.io.*;
public class Main {
    static StringBuilder sb = new StringBuilder();
    static int M = 0;
    static void move(char from, char to) {
        sb.append(from).append(' ').append(to).append('\n'); M++;
    }
    static void hanoi(int N, char from, char to, char aux) {
        if (N == 1) { move(from, to); return; }
        hanoi(N-1, from, aux, to);
        move(from, to);
        hanoi(N-1, aux, to, from);
    }
    static void dHanoi(int N, char from, char to, char r1, char r2) {
        if (N == 1) {
            move(from, to);
        } else if (N == 2) {
            move(from, r2); move(from, to); move(r2, to);
        } else {
            hanoi(N-2, from, r1, r2);
            move(from, r2); move(from, to); move(r2, to);
            dHanoi(N-2, r1, to, from, r2);
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        dHanoi(N, 'A', 'D', 'B', 'C');
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(M + "\n");
        bw.write(sb.toString());
        bw.flush();
    }
}
