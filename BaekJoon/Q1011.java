package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1011 {    // Fly me to the Alpha Centauri
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int t = Integer.parseInt(st.nextToken());
        for (int tt = 0; tt < t; tt++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            int dist = y - x;
            int ans = (int) Math.sqrt(dist);    // 소수점 버림

            if (ans == Math.sqrt(dist)) System.out.println(ans * 2 - 1);
            else if (dist <= ans * ans + ans) System.out.println(ans * 2);
            else System.out.println(ans * 2 + 1);
        }
    }
}
