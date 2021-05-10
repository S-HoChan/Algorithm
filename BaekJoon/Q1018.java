package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1018 {    // 체스판 다시 칠하기
    public static boolean[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        board = new boolean[n][m];  // W일 경우 true, B일 경우 false
        for (int i = 0; i < n; i++) {
            String pattern = br.readLine();
            for (int j = 0; j < m; j++) {
                if (pattern.charAt(j) == 'W') board[i][j] = true;
            }
        }

        int ans = 64 + 1;
        for (int y = 0; y + 7 < n; y++) {
            for (int x = 0; x + 7 < m; x++) {
                int cnt = 0;
                boolean white = board[y][x];
                for (int i = 0; i < 8; i++) {
                    for (int j = 0; j < 8; j++) {
                        if (white) {
                            if ((i + j) % 2 == 0 && !board[y + i][x + j]) cnt++;
                            if ((i + j) % 2 == 1 && board[y + i][x + j]) cnt++;
                        } else {
                            if ((i + j) % 2 == 0 && board[y + i][x + j]) cnt++;
                            if ((i + j) % 2 == 1 && !board[y + i][x + j]) cnt++;
                        }
                    }
                }
                ans = Math.min(ans, Math.min(cnt, 64 - cnt));   // 64 - cnt : 반대로 칠하는 경우
            }
        }
        System.out.println(ans);
    }
}