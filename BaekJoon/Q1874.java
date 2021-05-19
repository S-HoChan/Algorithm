package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Q1874 {    // 스택 수열
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        boolean isOk = true;
        int num = 1;
        for (int i = 0; i < n; i++) {
            int now = Integer.parseInt(br.readLine());

            if (isOk) {
                while (num <= now) {
                    stack.add(num++);
                    sb.append("+\n");
                }
                if (stack.isEmpty()) isOk = false;
                else {
                    while (!stack.isEmpty() && stack.peek() >= now) {
                        stack.pop();
                        sb.append("-\n");
                    }
                }
            }
        }
        if (isOk) System.out.println(sb);
        else System.out.println("NO");
    }
}
