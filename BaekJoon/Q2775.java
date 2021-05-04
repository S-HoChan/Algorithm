package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2775 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int t = Integer.parseInt(st.nextToken());
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int level = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());

            int[][] apartment = new int[level + 1][n];
            for (int j = 0; j <= level; j++) {    // 층
                for (int k = 0; k < n; k++) {    // 호
                    if (j == 0) {
                        apartment[j][k] = k + 1;
                    } else {
                        for (int m = 0; m <= k; m++) {
                            apartment[j][k] += apartment[j-1][m];
                        }
                    }
                }
            }
            System.out.println(apartment[level][n-1]);
        }
    }
}
