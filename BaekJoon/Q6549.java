package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Q6549 {    // 히스토그램에서 가장 큰 직사각형
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            if (n == 0) break;

            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            Stack<Integer> stack = new Stack<>();   // index stack
            long max = 0;
            for (int i = 0; i < n; i++) {
                while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {  // 나보다 큰 높이 탐색
                    int now = stack.pop();
                    int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                    max = Math.max(max, (long) width * arr[now]);
                }
                stack.push(i);
            }

            // 남은 값 계산
            while (!stack.isEmpty()) {
                int now = stack.pop();
                int width = stack.isEmpty() ? n : n - stack.peek() - 1;
                max = Math.max(max, (long) width * arr[now]);
            }

            sb.append(max).append('\n');
        }

        System.out.println(sb);
    }
}
