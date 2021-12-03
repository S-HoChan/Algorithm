package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1080 {    // 행렬
    static char[][] matA;
    static char[][] matB;
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        matA = new char[n][m];
        for (int i = 0; i < n; i++) {
            char[] temp = br.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                matA[i][j] = temp[j];
            }
        }
        matB = new char[n][m];
        for (int i = 0; i < n; i++) {
            char[] temp = br.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                matB[i][j] = temp[j];
            }
        }

        int ans = 0;
        if (n >= 3 && m >= 3) {
            for (int i = 0; i < n - 2; i++) {
                for (int j = 0; j < m - 2; j++) {
                    if (matA[i][j] != matB[i][j]) {
                        action(i, j);
                        ans++;
                    }
                }
            }
        }

        if (!isSame()) ans = -1;
        System.out.println(ans);
    }

    static void action(int y, int x) {
        for (int i = y; i < y + 3; i++) {
            for (int j = x; j < x + 3; j++) {
                if (matA[i][j] == '0') matA[i][j] = '1';
                else matA[i][j] = '0';
            }
        }
    }

    static boolean isSame() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matA[i][j] != matB[i][j]) return false;
            }
        }
        return true;
    }
}
