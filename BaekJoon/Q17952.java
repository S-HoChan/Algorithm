package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Q17952 {   // 과제는 끝나지 않아!
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int answer = 0;
        Stack<int[]> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int flag = Integer.parseInt(st.nextToken());
            if (flag == 1) {
                int a = Integer.parseInt(st.nextToken());
                int t = Integer.parseInt(st.nextToken()) - 1;
                if (t == 0) {
                    answer += a;
                } else {
                    stack.add(new int[]{a, t});
                }
            } else {
                if (!stack.isEmpty()) {
                    int[] now = stack.pop();
                    int a = now[0];
                    int t = --now[1];
                    if (t == 0) {
                        answer += a;
                    } else {
                        stack.add(new int[]{a, t});
                    }
                }
            }
        }
        System.out.println(answer);
    }
}
