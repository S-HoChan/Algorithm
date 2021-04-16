package ProgrammersLevel3;

import java.util.PriorityQueue;

public class ShuttleBus {
    public String solution(int n, int t, int m, String[] timetable) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (String table : timetable) {
            int hour = Integer.parseInt(table.substring(0, 2));
            int min = Integer.parseInt(table.substring(3));
            pq.add(hour * 60 + min);    // String to Integer
        }

        int result;
        int now = 0;
        boolean check = false;  // 자리가 모자른 경우 확인
        for (int i = 0; i < n; i++) {   // (i + 1)번째 셔틀
            int time = 540 + t * i;     // 셔틀 도착시간
            for (int j = 0; j < m && !pq.isEmpty(); j++) {   // m명 탑승
                now = pq.peek();
                if (now <= time) {  // 미리 와서 줄 서있으면
                    pq.poll();      // 탑승
                } else break;
                if (i == n - 1 && j == m - 1) {
                    check = true;   // 마지막 버스가 가득 찬 상황
                }
            }
        }

        if (check) result = now - 1;   // 마지막으로 탈 수 있는 사람보다 1분 일찍 오기
        else result = 540 + t * (n - 1);    // 자리가 남으므로 마지막으로 출발하는 셔틀 타기

        String answer = String.format("%02d:%02d", result / 60, result % 60);
        return answer;
    }
}
