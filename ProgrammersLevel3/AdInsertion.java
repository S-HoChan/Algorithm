package ProgrammersLevel3;

import java.util.Arrays;

public class AdInsertion {
    public String solution(String play_time, String adv_time, String[] logs) {
        int playTime = timeToSecond(play_time), advTime = timeToSecond(adv_time);

        long[] playCnt = new long[playTime + 1];
        for (String log : logs) {
            String[] split = log.split("-");
            playCnt[timeToSecond(split[0])]++;
            playCnt[timeToSecond(split[1])]--;
        }

        for (int i = 1; i <= playTime; i++) playCnt[i] += playCnt[i - 1];
        for (int i = 1; i <= playTime; i++) playCnt[i] += playCnt[i - 1];

        long maxTime = playCnt[advTime - 1], maxStartTime = 0;
        for (int i = 0; i + advTime <= playTime; i++) {
            long tmp = playCnt[i + advTime] - playCnt[i];

            if (tmp > maxTime) {
                maxTime = tmp;
                maxStartTime = i + 1;
            }
        }

        return String.format("%02d:%02d:%02d", maxStartTime / (60 * 60), (maxStartTime / 60) % 60, maxStartTime % 60);
    }

    int timeToSecond(String str) {
        int[] parse = Arrays.stream(str.split(":")).mapToInt(Integer::parseInt).toArray();
        return parse[0] * 60 * 60 + parse[1] * 60 + parse[2];
    }


//    public String solution(String play_time, String adv_time, String[] logs) {
//        int ans = 100 * 3600;
//        int longest = 0;
//
//        int playLength = Integer.parseInt(play_time.substring(0, 2)) * 3600 +
//                Integer.parseInt(play_time.substring(3, 5)) * 60 +
//                Integer.parseInt(play_time.substring(6));
//        int advLength = Integer.parseInt(adv_time.substring(0, 2)) * 3600 +
//                Integer.parseInt(adv_time.substring(3, 5)) * 60 +
//                Integer.parseInt(adv_time.substring(6));
//
//        int[] startTime = new int[logs.length];
//        int[] endTime = new int[logs.length];
//        for (int i = 0; i < logs.length; i++) {
//            int startHour = Integer.parseInt(logs[i].substring(0, 2));
//            int startMinute = Integer.parseInt(logs[i].substring(3, 5));
//            int startSecond = Integer.parseInt(logs[i].substring(6, 8));
//            startTime[i] = startHour * 3600 + startMinute * 60 + startSecond;
//
//            int endHour = Integer.parseInt(logs[i].substring(9, 11));
//            int endMinute = Integer.parseInt(logs[i].substring(12, 14));
//            int endSecond = Integer.parseInt(logs[i].substring(15));
//            endTime[i] = endHour * 3600 + endMinute * 60 + endSecond;
//        }
//
//        for (int i = 0; i < startTime.length; i++) { // 앞부분 기준
//            int tot = 0;
//            int advStart = startTime[i];
//            int advEnd = startTime[i] + advLength;
//            if (advEnd > playLength) continue;
//
//            for (int j = 0; j < startTime.length; j++) {
//                if (endTime[j] < advStart || startTime[j] > advEnd) continue;
//
//                if (advStart < startTime[j]) {
//                    if (advEnd > endTime[j]) {
//                        tot += endTime[j] - startTime[j];
//                    } else {
//                        tot += advEnd - startTime[j];
//                    }
//                } else {    // advStart >= startTime[j]
//                    if (advEnd < endTime[j]) {
//                        tot += advLength;
//                    } else {
//                        tot += endTime[j] - advStart;
//                    }
//                }
//            }
//
//            if (tot > longest) {
//                ans = advStart;
//                longest = tot;
//            } else if (tot == longest) ans = Math.min(ans, advStart);
//        }
//
//        for (int i = 0; i < startTime.length; i++) { // 뒷부분 기준
//            int tot = 0;
//            int advStart = endTime[i] - advLength;
//            int advEnd = endTime[i];
//            if (advStart < 0) continue;
//
//            for (int j = 0; j < startTime.length; j++) {
//                if (endTime[j] < advStart || startTime[j] > advEnd) continue;
//
//                if (advStart < startTime[j]) {
//                    if (advEnd > endTime[j]) {
//                        tot += endTime[j] - startTime[j];
//                    } else {
//                        tot += advEnd - startTime[j];
//                    }
//                } else {    // advStart >= startTime[j]
//                    if (advEnd < endTime[j]) {
//                        tot += advLength;
//                    } else {
//                        tot += endTime[j] - advStart;
//                    }
//                }
//            }
//
//            if (tot > longest) {
//                ans = advStart;
//                longest = tot;
//            } else if (tot == longest) ans = Math.min(ans, advStart);
//        }
//
//        if (ans == 100 * 3600) return "00:00:00";
//        return String.format("%02d:%02d:%02d", ans / 3600, (ans / 60) % 60, ans % 60);
//    }
}
