import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        Map<String, Integer> inTimeMap = new HashMap<>();
        Map<String, Integer> totalParkingTimeMap = new HashMap<>();

        for (String record : records) {
            String[] parts = record.split(" ");
            String timeStr = parts[0];
            String carNumber = parts[1];
            String type = parts[2];

            int currentTime = Integer.parseInt(timeStr.substring(0, 2)) * 60 + Integer.parseInt(timeStr.substring(3, 5));

            if (type.equals("IN")) {
                inTimeMap.put(carNumber, currentTime);
            } else {
                int inTime = inTimeMap.remove(carNumber);
                totalParkingTimeMap.put(carNumber, totalParkingTimeMap.getOrDefault(carNumber, 0) + (currentTime - inTime));
            }
        }

        for (Map.Entry<String, Integer> entry : inTimeMap.entrySet()) {
            String carNumber = entry.getKey();
            int inTime = entry.getValue();
            int endTime = 23 * 60 + 59;

            totalParkingTimeMap.put(carNumber, totalParkingTimeMap.getOrDefault(carNumber, 0) + (endTime - inTime));
        }

        List<String> sortedCarNumbers = new ArrayList<>(totalParkingTimeMap.keySet());
        Collections.sort(sortedCarNumbers);

        int baseTime = fees[0];
        int baseFee = fees[1];
        int unitTime = fees[2];
        int unitFee = fees[3];

        int[] answer = new int[sortedCarNumbers.size()];
        for (int i = 0; i < sortedCarNumbers.size(); i++) {
            String carNumber = sortedCarNumbers.get(i);
            int totalMinutes = totalParkingTimeMap.get(carNumber);

            int calculatedFee = baseFee;

            if (totalMinutes > baseTime) {
                int excessMinutes = totalMinutes - baseTime;
                calculatedFee += (int) Math.ceil((double) excessMinutes / unitTime) * unitFee;
            }
            answer[i] = calculatedFee;
        }

        return answer;
    }
}