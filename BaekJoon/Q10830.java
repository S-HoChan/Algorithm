package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q10830 {   // 행렬 제곱
    private static int n;
    private final static int MOD = 1000;
    public static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken()) % MOD;
            }
        }

        int[][] result = solution(arr, b);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(result[i][j]).append(' ');
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

    public static int[][] solution(int[][] a, long en) {
        if (en == 1L) {
            return a;
        }

        int[][] temp = solution(a, en / 2);
        temp = product(temp, temp);
        if (en % 2 != 0) temp = product(temp, arr);
        return temp;
    }

    public static int[][] product(int[][] arr1, int[][] arr2) {
        int[][] temp = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    temp[i][j] += arr1[i][k] * arr2[k][j];
                    temp[i][j] %= MOD;
                }
            }
        }
        return temp;
    }
}
