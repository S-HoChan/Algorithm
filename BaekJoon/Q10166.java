package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q10166 {   // 관중석
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        boolean[][] visited = new boolean[2001][2001];
        int d1 = Integer.parseInt(st.nextToken());
        int d2 = Integer.parseInt(st.nextToken());
        int answer = 0;
        for (int i = d1; i <= d2; i++) {
            for (int j = 1; j <= i; j++) {
                int gcd = gcd(i, j);
                if (!visited[i / gcd][j / gcd]) {
                    visited[i / gcd][j / gcd] = true;
                    answer++;
                }
            }
        }
        System.out.println(answer);
    }

    static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}
