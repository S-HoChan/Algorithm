package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Q17298 {   // 오큰수
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) {   // stack 내의 숫자는 index를 의미함
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                arr[stack.pop()] = arr[i];
            }

            stack.add(i);
        }

        while (!stack.isEmpty()) arr[stack.pop()] = -1;  // 오큰수가 없는 경우

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) sb.append(arr[i]).append(' ');

        System.out.println(sb);
    }
}
