package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q9663 {    // N-Queen
    private static int[] row;
    private static int ans = 0;
    private static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        row = new int[n];   // queen이 위치한 행을 저장

        sol(0);
        System.out.println(ans);
    }

    private static void sol(int depth) {
        if (depth == n) {
            ans++;
            return;
        }

        for (int i = 0; i < n; i++) {
            row[depth] = i;
            if (isOk(depth)) sol(depth + 1);
        }
    }

    private static boolean isOk(int col) {
        for (int i = 0; i < col; i++) {
            if (row[i] == row[col]) return false;   // 같은 행에 존재
            else if (Math.abs(col - i) == Math.abs(row[col] - row[i])) return false;    // 대각선에 존재
        }

        return true;
    }
}
