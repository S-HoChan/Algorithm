package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1182 {    // 부분수열의 합
    static int answer = 0;
    static int[] arr;
    static int n, s;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        sol(0, 0, 0);
        System.out.println(answer);
    }

    static void sol(int depth, int sum, int length) {
        if (depth == n) {
            if (sum == s && length > 0) answer++;
            return;
        }

        sol(depth + 1, sum + arr[depth], length + 1);
        sol(depth + 1, sum, length);
    }
}
