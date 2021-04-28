package ProgrammersLevel4;

import java.util.*;

public class SteppingStone {
    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        Arrays.sort(rocks);

        int left = 1, right = distance;    // binarySearch
        int mid = 0;    // 최소값
        while (left <= right) {
            int cnt = 0;
            int prev = 0;
            mid = (left + right) / 2;

            for (int i = 0; i < rocks.length; i++) {
                if (rocks[i] - prev < mid) cnt++;    // mid보다 작은 값이 존재하므로 해당 돌을 제거한다.
                else prev = rocks[i];   // mid보다 크거나 같은 값이 존재하므로 prev를 현재 돌로 초기화한다.
            }
            if(distance - prev < mid) cnt++;    // 마지막 돌과 도착점의 거리 확인

            if(cnt <= n){   // 최소값을 만들 수 있다.
                answer = Math.max(answer, mid);
                left = mid + 1;
            } else right = mid - 1;
        }

        return answer;
    }
}
