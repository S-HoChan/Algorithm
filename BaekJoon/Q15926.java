package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Q15926 {   // 현욱은 괄호왕이야!!
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[] arr = br.readLine().toCharArray();
        Stack<Integer> stack = new Stack<>();
        stack.add(-1);  // 맨 처음이 '('일 경우 거리 계산을 위한 인자
        int answer = 0;

        for (int i = 0; i < n; i++) {
            char now = arr[i];
            if (now == '(') {
                stack.add(i);
            } else {    // now == ')'
                if (!stack.isEmpty()) stack.pop();  // ')'만 있는 경우 예외처리
                if (stack.isEmpty()) {  // 여기까지는 올바르지 않은 괄호
                    stack.add(i);
                } else {
                    answer = Math.max(answer, i - stack.peek());
                }
            }
        }

        System.out.println(answer);
    }
}
