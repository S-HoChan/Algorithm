package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Q2960 {    // 에라토스테네스의 체
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int count = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 2; i <= n; i++) {
            pq.add(i);
        }
        while (!pq.isEmpty()) {
            int p = pq.peek();
            for (int i = 1; p * i <= n; i++) {
                if (!pq.contains(p * i)) continue;
                if (++count == k) {
                    System.out.println(p * i);
                    return;
                }

                pq.remove(p * i);
            }
        }
    }
}
