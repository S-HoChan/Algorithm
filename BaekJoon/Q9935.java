package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Q9935 {    // 문자열 폭발
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String string = br.readLine();
        String boom = br.readLine();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < string.length(); i++) {
            stack.push(string.charAt(i));

            if (stack.size() >= boom.length()) {
                boolean flag = true;
                for (int j = 0; j < boom.length(); j++) {
                    if (stack.get(stack.size() - boom.length() + j) != boom.charAt(j)) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    for (int j = 0; j < boom.length(); j++) {
                        stack.pop();
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (char c : stack) {
            sb.append(c);
        }

        System.out.println(sb.length() > 0 ? sb : "FRULA");
    }
}
