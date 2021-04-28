package ProgrammersLevel4;

import java.util.*;

public class RyansWorry {
    // todo. 틀린 답안이므로 고칠 것
    public int solution(int n, int m, int[][] timetable) {
        int maxNum = 0;
        Time[] times = new Time[timetable.length];
        for (int i = 0; i < timetable.length; i++) {
            times[i] = new Time(timetable[i][0], timetable[i][1]);
        }
        Arrays.sort(times, new Comparator<Time>() {
            @Override
            public int compare(Time o1, Time o2) {
                if (o1.start > o2.start) return 1;
                else if (o1.start == o2.start) {
                    if (o1.end > o2.end) return 1;
                    else return -1;
                } else return -1;
            }
        });

        for (int i = 0; i < times.length; i++) {
            int time = times[i].start;
            int nowNum = 0;
            for (int j = 0; j < times.length; j++) {
                if (times[j].start <= time && times[j].end >= time) nowNum++;
            }
            maxNum = Math.max(maxNum, nowNum);
        }

        if (maxNum == 1) return 0;
        else {
            int answer = ((n - 1) * 4 - maxNum) / maxNum;
            if ((n - 1) * 4 - maxNum % maxNum != 0) answer++;
            return answer;
        }
    }

    class Time {
        int start;
        int end;

        Time(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
