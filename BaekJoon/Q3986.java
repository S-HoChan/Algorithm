package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Q3986 {    // 좋은 단어
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int answer = 0;
        while (n-- > 0) {
            char[] arr = br.readLine().toCharArray();
            if (isOk(arr)) answer++;
        }
        System.out.println(answer);
    }

    static boolean isOk(char[] arr) {
        Stack<Character> stack = new Stack<>();
        for (char c : arr) {
            if (!stack.isEmpty()) {
                if (c == stack.peek()) {
                    stack.pop();
                    continue;
                }
            }
            stack.push(c);
        }

        return stack.isEmpty();
    }
}
