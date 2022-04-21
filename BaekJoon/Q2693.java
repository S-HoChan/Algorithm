package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Q2693 {    // N번째 큰 수
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 10; i++)
                pq.add(Integer.parseInt(st.nextToken()));
            pq.poll();
            pq.poll();
            sb.append(pq.poll()).append('\n');
        }
        System.out.println(sb);
    }
}
