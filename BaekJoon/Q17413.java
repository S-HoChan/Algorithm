package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Q17413 {   // 단어 뒤집기 2
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char now = s.charAt(i);
            if (now == '<') {
                while (!stack.isEmpty()) {
                    sb.append(stack.pop());
                }
                sb.append(now);
                for (int next = i + 1; next < s.length(); next++) {
                    sb.append(s.charAt(next));
                    if (s.charAt(next) == '>') {
                        i = next;
                        break;
                    }
                }
            } else if (now == ' ') {
                while (!stack.isEmpty()) {
                    sb.append(stack.pop());
                }
                sb.append(now);
            } else {
                stack.add(now);
            }
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        System.out.println(sb);
    }
}
