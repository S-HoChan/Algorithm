package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1072 {    // 게임
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int z = getPer(x, y);

        int answer = -1;
        int left = 0;
        int right = 1_000_000_000;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (getPer(x + mid, y + mid) != z) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        System.out.println(answer);
    }

    static int getPer(int x, int y) {
        return (int) ((long) y * 100 / x);
    }
}
