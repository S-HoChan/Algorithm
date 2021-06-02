package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q11444 {   // 피보나치 수 6
    private static final int MOD = 1000000007;
    private static long[][] init = {{1, 1}, {1, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());

        System.out.println(sol(init, n - 1)[0][0]);
    }

    private static long[][] sol(long[][] arr, long n) {
        if (n == 1 || n == 0) return init;

        long[][] temp = sol(arr, n / 2);
        temp = product(temp, temp);
        if (n % 2 == 1) temp = product(temp, init);
        return temp;
    }

    private static long[][] product(long[][] arr1, long[][] arr2) {
        long[][] temp = new long[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 2; k++) {
                    temp[i][j] += arr1[i][k] * arr2[k][j];
                    temp[i][j] %= MOD;
                }
            }
        }
        return temp;
    }
}
