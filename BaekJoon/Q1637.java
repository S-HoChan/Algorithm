package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1637 {    // 날카로운 눈
    static int n;
    static int[] a, b, c;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        a = new int[n];
        c = new int[n];
        b = new int[n];
        long left = Long.MAX_VALUE, right = 0;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            a[i] = Integer.parseInt(st.nextToken());
            c[i] = Integer.parseInt(st.nextToken());
            b[i] = Integer.parseInt(st.nextToken());
            left = Math.min(left, a[i]);
            right = Math.max(right, c[i]);
        }
        long max = ++right;

        while (left < right) {    // binary search
            long mid = (left + right) / 2;
            long cnt = getCnt(mid);
            if (cnt % 2 == 0) left = mid + 1;
            else right = mid;
        }

        if (left == max) System.out.println("NOTHING");
        else System.out.println(left + " " + (getCnt(left) - getCnt(left - 1)));
    }

    static long getCnt(long m) {
        long cnt = 0;
        for (int i = 0; i < n; i++)
            if (m >= a[i])
                cnt += (Math.min(m, c[i]) - a[i]) / b[i] + 1;
        return cnt;
    }
}
