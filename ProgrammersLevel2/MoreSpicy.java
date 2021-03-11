package ProgrammersLevel2;

import java.util.*;

public class MoreSpicy {
    public static void main(String[] args) {

    }

    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for(int scov : scoville){
            queue.add(scov);
        }

        while(queue.peek() < K){
            if(queue.size() < 2) return -1;

            answer++;
            int first = queue.poll();
            int second = queue.poll();
            int mixed = first + 2 * second;
            queue.add(mixed);
        }

        return answer;
    }
}
