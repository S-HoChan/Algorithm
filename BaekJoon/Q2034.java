package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2034 {    // 반음
    // A(2)B(1)C(2)D(2)E(1)F(2)G(2)A
    static int[] location = new int[]{0, 2, 3, 5, 7, 8, 10};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < location.length; i++) {
            int now = location[i];
            boolean isOk = true;
            for (int j = 0; j < arr.length; j++) {
                now = (now + arr[j] + 24) % 12;  // 0 ~ 11 의 값을 가진다.
                if (!isWhite(now)) {
                    isOk = false;
                    break;
                }
            }
            if (isOk) {
                char start = (char) ('A' + i);
                char end = '-';
                for (int j = 0; j < location.length; j++) {
                    if (now == location[j]) {
                        end = (char) ('A' + j);
                        break;
                    }
                }
                sb.append(start).append(' ').append(end).append('\n');
            }
        }

        System.out.println(sb);
    }

    static boolean isWhite(int now) {
        for (int i = 0; i < location.length; i++) {
            if (now == location[i]) return true;
        }
        return false;
    }
}
