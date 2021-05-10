package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q11729 {   // 하노이 탑 이동 순서
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        sb.append((int) (Math.pow(2, n) - 1)).append('\n'); // an = 2^n - 1

        hanoi(n, 1, 2, 3);
        System.out.println(sb);
    }

    public static void hanoi(int n, int start, int mid, int to) {
        if (n == 1) {
            sb.append(start + " " + to + "\n");
            return;
        }

        hanoi(n - 1, start, to, mid);   // n - 1 개를 A에서 B로 이동
        sb.append(start + " " + to + "\n"); // 1 개를 A에서 C로 이동
        hanoi(n - 1, mid, start, to);    // n - 1 개를 B에서 C로 이동
    }
}
