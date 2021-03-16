package ProgrammersLevel3;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class DualPriorityQueue {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (String operation : operations) {
            String[] op = operation.split(" ");
            String operator = op[0];
            int number = Integer.parseInt(op[1]);

            if (operator.equals("I")) {
                pq.add(number);
            } else if (operator.equals("D")) {
                if (pq.isEmpty()) continue;
                if (number == -1) {
                    pq.poll();
                } else {
                    Queue<Integer> temp = new LinkedList<>();
                    while (!pq.isEmpty()) {
                        temp.offer(pq.poll());
                    }
                    while (!temp.isEmpty()) {
                        if (temp.size() == 1) temp.poll();
                        else pq.add(temp.poll());
                    }
                }
            }
        }

        if (!pq.isEmpty()) {
            int num = 0;
            answer[1] = pq.poll();
            while (!pq.isEmpty()) {
                num = pq.poll();
            }
            answer[0] = num;
        }
        return answer;
    }
}
