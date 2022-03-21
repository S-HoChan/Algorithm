package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Q16637 {   // 괄호 추가하기
    static int answer = Integer.MIN_VALUE;
    static List<Integer> num = new ArrayList<>();
    static List<Character> operator = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[] arr = br.readLine().toCharArray();
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) num.add(arr[i] - '0');
            else operator.add(arr[i]);
        }

        dfs(0, num.get(0));
        System.out.println(answer);
    }

    static void dfs(int idx, int sum) {
        if (idx >= operator.size()) {
            answer = Math.max(answer, sum);
            return;
        }

        dfs(idx + 1, cal(idx, sum, num.get(idx + 1)));    // 괄호없이
        if (idx + 1 < operator.size()) {
            int next = cal(idx + 1, num.get(idx + 1), num.get(idx + 2));
            dfs(idx + 2, cal(idx, sum, next));
        }
    }

    static int cal(int idx, int a, int b) {
        char ope = operator.get(idx);
        if (ope == '+')
            return a + b;
        else if (ope == '-')
            return a - b;
        else    // ope == '*'
            return a * b;
    }
}
