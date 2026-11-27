
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ,:");

        String month = st.nextToken();
        int day = Integer.parseInt(st.nextToken());
        int year = Integer.parseInt(st.nextToken());
        int hour = Integer.parseInt(st.nextToken());
        int minute = Integer.parseInt(st.nextToken());

        String[] months = {
                "January", "February", "March", "April",
                "May", "June", "July", "August",
                "September", "October", "November", "December"
        };

        int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        boolean leap = year % 400 == 0 || (year % 4 == 0 && year % 100 != 0);

        if (leap) {
            days[1] = 29;
        }

        int passedDays = day - 1;

        for (int i = 0; i < 12; i++) {
            if (months[i].equals(month)) {
                break;
            }
            passedDays += days[i];
        }

        int passedMinutes = passedDays * 1440 + hour * 60 + minute;
        int totalMinutes = (leap ? 366 : 365) * 1440;

        System.out.println(passedMinutes * 100.0 / totalMinutes);
    }
}
