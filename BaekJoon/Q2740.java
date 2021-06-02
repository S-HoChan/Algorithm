package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2740 {    // 행렬 곱셈
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] arrA = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arrA[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] arrB = new int[m][k];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < k; j++) {
                arrB[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k; j++) {
                int now = 0;
                for (int o = 0; o < m; o++) {
                    now += arrA[i][o] * arrB[o][j];
                }
                sb.append(now).append(' ');
            }
            sb.append('\n');
        }

        System.out.println(sb);
    }
}
