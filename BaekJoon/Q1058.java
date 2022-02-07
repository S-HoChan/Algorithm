package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1058 {    // 친구
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[][] map = new char[n][n];
        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            int temp = 0;
            for (int j = 0; j < n; j++) {
                if (i == j) continue;

                if (map[i][j] == 'Y') temp++;
                else {
                    for (int k = 0; k < n; k++) {
                        if (map[i][k] == 'Y' && map[k][j] == 'Y') {
                            temp++;
                            break;
                        }
                    }
                }
            }
            answer = Math.max(answer, temp);
        }
        System.out.println(answer);
    }
}
