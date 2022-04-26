package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Q11003 {   // 최솟값 찾기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        Deque<int[]> deque = new ArrayDeque<>();    // value, index
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int now = Integer.parseInt(st.nextToken());
            while (!deque.isEmpty() && deque.peekLast()[0] > now) {
                deque.pollLast();
            }

            deque.offer(new int[]{now, i});
            if (deque.peek()[1] < i - l + 1) deque.poll();
            sb.append(deque.peek()[0]).append(' ');
        }
        System.out.println(sb);
    }
}
