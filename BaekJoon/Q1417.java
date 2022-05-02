package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Q1417 {    // 국회의원 선거
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int first = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int i = 0; i < n - 1; i++)
            pq.add(Integer.parseInt(br.readLine()));
        int answer = 0;
        while (!pq.isEmpty() && first <= pq.peek()) {
            pq.add(pq.poll() - 1);
            first++;
            answer++;
        }
        System.out.println(answer);
    }
}
