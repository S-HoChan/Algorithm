package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Q1662 {    // 압축
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = br.readLine().toCharArray();
        Stack<int[]> stack = new Stack<>();   // value, length
        for (char now : arr) {
            if (now == '(') {
                stack.add(new int[]{-1, 1});    // -1 : (
            } else if (now == ')') {
                int total = 0;
                while (stack.peek()[0] != -1) {
                    total += stack.pop()[1];
                }
                stack.pop();    // ( 제거
                int repeat = stack.pop()[0];
                stack.add(new int[]{-2, repeat * total});   // -2 : 압축해제한 결과물
            } else {
                stack.add(new int[]{now - '0', 1});
            }
        }

        int answer = 0;
        while (!stack.isEmpty()) {
            answer += stack.pop()[1];
        }
        System.out.println(answer);
    }
}
