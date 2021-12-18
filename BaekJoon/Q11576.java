package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Q11576 {   // Base Conversion
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        int decimal = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = m - 1; i >= 0; i--) {
            int x = Integer.parseInt(st.nextToken());
            decimal += x * Math.pow(a, i);
        }

        Stack<Integer> stack = new Stack<>();
        while (decimal != 0) {
            int now = decimal % b;
            decimal /= b;
            stack.push(now);
        }

        int size = stack.size();
        for (int i = 0; i < size; i++) {
            if (i == size - 1) {
                sb.append(stack.pop());
            } else {
                sb.append(stack.pop()).append(' ');
            }
        }

        System.out.println(sb);
    }
}
