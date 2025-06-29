class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String[] videoLenParts = video_len.split(":");
        int videoLenSec = Integer.parseInt(videoLenParts[0]) * 60 + Integer.parseInt(videoLenParts[1]);

        String[] posParts = pos.split(":");
        int currentPosSec = Integer.parseInt(posParts[0]) * 60 + Integer.parseInt(posParts[1]);

        String[] opStartParts = op_start.split(":");
        int opStartSec = Integer.parseInt(opStartParts[0]) * 60 + Integer.parseInt(opStartParts[1]);

        String[] opEndParts = op_end.split(":");
        int opEndSec = Integer.parseInt(opEndParts[0]) * 60 + Integer.parseInt(opEndParts[1]);
        
        if (currentPosSec >= opStartSec && currentPosSec <= opEndSec) {
            currentPosSec = opEndSec;
        }

        for (String command : commands) {
            if (command.equals("prev")) {
                currentPosSec -= 10;
                if (currentPosSec < 0) {
                    currentPosSec = 0;
                }
            } else if (command.equals("next")) {
                currentPosSec += 10;
                if (currentPosSec > videoLenSec) {
                    currentPosSec = videoLenSec;
                }
            }

            if (currentPosSec >= opStartSec && currentPosSec <= opEndSec) {
                currentPosSec = opEndSec;
            }
        }

        int finalMinutes = currentPosSec / 60;
        int finalSeconds = currentPosSec % 60;
        
        return String.format("%02d:%02d", finalMinutes, finalSeconds);
    }
}