package ProgrammersLevel3;

import java.util.Collections;
import java.util.PriorityQueue;

public class Overtime {
    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for (int work : works) queue.add(work);

        for (int i = 0; i < n; i++) {
            int max = queue.poll();
            if (max <= 0) break;
            queue.add(max - 1);
        }

        while(!queue.isEmpty()){
            int now = queue.poll();
            answer += now * now;
        }
        return answer;
    }
}
