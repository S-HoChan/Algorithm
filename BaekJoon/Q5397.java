package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Q5397 {    // 키로거
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            char[] arr = br.readLine().toCharArray();
            Stack<Character> preCursor = new Stack<>();
            Stack<Character> postCursor = new Stack<>();
            for (char c : arr) {
                if (c == '-') {
                    if (!preCursor.isEmpty()) {
                        preCursor.pop();
                    }
                } else if (c == '<') {
                    if (!preCursor.isEmpty()) {
                        postCursor.push(preCursor.pop());
                    }
                } else if (c == '>') {
                    if (!postCursor.isEmpty()) {
                        preCursor.push(postCursor.pop());
                    }
                } else {
                    preCursor.push(c);
                }
            }

            for (Character character : preCursor) {
                sb.append(character);
            }
            while (!postCursor.isEmpty()) {
                sb.append(postCursor.pop());
            }
            sb.append('\n');
        }

        System.out.println(sb);
    }
}
