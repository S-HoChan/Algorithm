package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Q1406 {    // 에디터
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        Stack<Character> left = new Stack<>();
        Stack<Character> right = new Stack<>();
        for (int i = 0; i < input.length(); i++)
            left.add(input.charAt(i));
        int m = Integer.parseInt(br.readLine());
        while (m-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char order = st.nextToken().charAt(0);
            if (order == 'L') {
                if (!left.isEmpty()) right.push(left.pop());
            } else if (order == 'D') {
                if (!right.isEmpty()) left.push(right.pop());
            } else if (order == 'B') {
                if (!left.isEmpty()) left.pop();
            } else {
                char alphabet = st.nextToken().charAt(0);
                left.push(alphabet);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!left.isEmpty()) right.push(left.pop());
        while (!right.isEmpty()) sb.append(right.pop());
        System.out.println(sb);
    }
}
