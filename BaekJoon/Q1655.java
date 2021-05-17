package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q1655 {    // 가운데를 말해요
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            minHeap.add(Integer.parseInt(br.readLine()));

            if (minHeap.size() > maxHeap.size() + 1) {
                maxHeap.add(minHeap.poll());
            } else if(!minHeap.isEmpty() && !maxHeap.isEmpty()){
                if (minHeap.peek() > maxHeap.peek()) {
                    int temp = minHeap.poll();
                    minHeap.add(maxHeap.poll());
                    maxHeap.add(temp);
                }
            }

            sb.append(minHeap.peek()).append('\n');
        }

        System.out.println(sb);
    }
}
