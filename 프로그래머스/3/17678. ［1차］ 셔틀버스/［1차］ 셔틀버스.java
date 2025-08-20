import java.util.*;

class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        int temp = 0;
        StringBuilder sb = new StringBuilder();

        int[] time = new int[timetable.length];
        for (int i = 0; i < timetable.length; i++) {
            String[] s = timetable[i].split(":");
            int num = 60 * Integer.parseInt(s[0]) + Integer.parseInt(s[1]);
            time[i] = num;
        }
        Arrays.sort(time);

        int low = 0;
        int high = 23 * 60 + 59;

        int[] bus = new int[n];
        for (int i = 0; i < n; i++) {
            bus[i] = 9 * 60 + t * i;
        }
        int bLen = bus.length;
        int tLen = time.length;

        // ===== 이분 탐색 =====
        while (low <= high) {
            int mid = (low + high) / 2;

           // [변경된 판정부 - 버스 1대 처리]
            int index = 0;
            boolean usedCon = false;

            for (int i = 0; i < bLen; i++) {
                int boarded = 0;

                // 1) mid보다 먼저 온 승객
                while (index < tLen && time[index] <= bus[i] && time[index] < mid && boarded < m) {
                    boarded++; index++;
                }

                // 2) mid에 온 승객(동시 도착 → 승객 우선)
                while (index < tLen && time[index] <= bus[i] && time[index] == mid && boarded < m) {
                    boarded++; index++;
                }

                // 3) Con 탑승 시도(아직 자리 있고 mid ≤ 버스)
                if (!usedCon && boarded < m && mid <= bus[i]) {
                    usedCon = true; boarded++;
                }

                // 4) mid 이후~버스 도착 전 승객
                while (index < tLen && time[index] <= bus[i] && boarded < m) {
                    boarded++; index++;
                }
            }

            if (usedCon) { temp = mid; low = mid + 1; }
            else { high = mid - 1; }

        }

        // 출력 포맷
        if (temp / 60 < 10) sb.append(0);
        sb.append(temp / 60).append(":");
        if (temp % 60 < 10) sb.append(0);
        sb.append(temp % 60);

        return sb.toString();
    }
}
