package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1990 {    // 소수인팰린드롬
    public static void main(String[] args) throws IOException {
        boolean[] isNotPrime = new boolean[100_000_001];
        for (int i = 2; i * i <= 100_000_000; i++) {
            if (isNotPrime[i]) continue;
            for (int j = i * i; j <= 100_000_000; j += i) {
                isNotPrime[j] = true;
            }
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        for (int num = a; num <= b; num++) {
            if (!isNotPrime[num] && isPalin(num))
                sb.append(num).append('\n');
        }
        sb.append(-1);
        System.out.println(sb);
    }

    static boolean isPalin(int num) {
        char[] arr = String.valueOf(num).toCharArray();
        for (int i = 0; i < arr.length / 2; i++) {
            if (arr[i] != arr[arr.length - 1 - i]) return false;
        }
        return true;
    }
}
