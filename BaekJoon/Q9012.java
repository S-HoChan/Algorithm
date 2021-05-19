package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Q9012 {    // 괄호
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < t; i++) {
            String str = br.readLine();
            if (sol(str)) sb.append("YES\n");
            else sb.append("NO\n");
        }

        System.out.println(sb);
    }

    private static boolean sol(String str) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                stack.add('(');
            } else {
                if (stack.isEmpty()) return false;
                else stack.pop();
            }
        }
        if (stack.isEmpty()) return true;
        else return false;
    }
}
