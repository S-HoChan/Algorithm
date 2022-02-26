package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Q2812 {    // 크게 만들기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        char[] num = br.readLine().toCharArray();

        Stack<Character> stack = new Stack<>();
        int popCount = 0;
        for (int i = 0; i < n; i++) {
            char now = num[i];
            if (!stack.isEmpty()) {
                while (popCount < k && !stack.isEmpty() && stack.peek() < now) {
                    stack.pop();
                    popCount++;
                }
            }
            stack.add(now);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n - k; i++) {
            sb.append(stack.get(i));
        }
        System.out.println(sb);
    }
}
