package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Q1461 {    // 도서관
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        PriorityQueue<Integer> postive = new PriorityQueue<>((o1, o2) -> o2 - o1);
        PriorityQueue<Integer> negative = new PriorityQueue<>((o1, o2) -> o2 - o1);
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int temp = Integer.parseInt(st.nextToken());
            if (temp > 0) postive.add(temp);
            else negative.add(Math.abs(temp));
        }

        int maxDist = 0;
        if (postive.isEmpty()) maxDist = negative.peek();
        else if (negative.isEmpty()) maxDist = postive.peek();
        else maxDist = Math.max(postive.peek(), negative.peek());

        int answer = 0;
        while (!postive.isEmpty()) {
            int temp = postive.poll();
            for (int i = 0; i < m - 1; i++) {
                if (postive.isEmpty()) break;
                postive.poll();
            }
            answer += temp * 2;
        }
        while (!negative.isEmpty()) {
            int temp = negative.poll();
            for (int i = 0; i < m - 1; i++) {
                if (negative.isEmpty()) break;
                negative.poll();
            }
            answer += temp * 2;
        }

        System.out.println(answer - maxDist);
    }
}
