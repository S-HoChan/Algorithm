package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Q1744 {    // 수 묶기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int answer = 0;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((o1, o2) -> o1 - o2);
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
        boolean haveZero = false;
        for (int i = 0; i < n; i++) {
            int now = Integer.parseInt(br.readLine());
            if (now < 0) minHeap.add(now);
            else if (now > 1) maxHeap.add(now);
            else if (now == 1) answer += 1;
            else haveZero = true;
        }

        while (minHeap.size() >= 2) {
            int first = minHeap.poll();
            int second = minHeap.poll();
            answer += first * second;
        }
        if (!minHeap.isEmpty() && !haveZero) answer += minHeap.poll();
        while (maxHeap.size() >= 2) {
            int first = maxHeap.poll();
            int second = maxHeap.poll();
            answer += first * second;
        }
        if (!maxHeap.isEmpty()) answer += maxHeap.poll();
        System.out.println(answer);
    }
}
