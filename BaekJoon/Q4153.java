package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q4153 {    // 직각 삼각형
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (a == 0 && b == 0 && c == 0) break;

            int max = Math.max(a, Math.max(b, c));
            int other = 0;
            if (a != max) other += a * a;
            if (b != max) other += b * b;
            if (c != max) other += c * c;

            if (other == max * max) System.out.println("right");
            else System.out.println("wrong");
        }
    }
}
