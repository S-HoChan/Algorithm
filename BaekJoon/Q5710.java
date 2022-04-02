package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q5710 {    // 전기 요금
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (a == 0 && b == 0) break;

            int totalWatt = calWatt(a);
            int left = 0, right = totalWatt / 2;
            while (left <= right) {
                int mid = (left + right) / 2;

                int diff = calPrice(totalWatt - mid) - calPrice(mid);
                if (diff < b) right = mid - 1;
                else if (diff > b) left = mid + 1;
                else {
                    sb.append(calPrice(mid)).append('\n');
                    break;
                }
            }
        }
        System.out.println(sb);
    }

    static int calWatt(int a) {
        if (a <= 200) return a / 2;    // 2 * 100
        else if (a <= 29900) return (a - 200) / 3 + 100;   // 3 * 9900 + 200
        else if (a <= 4979900) return (a - 29900) / 5 + 10000;   // 5 * 990000 + 29900
        else return (a - 4979900) / 7 + 1000000;
    }

    static int calPrice(int w) {
        if (w <= 100) return 2 * w;
        else if (w <= 10000) return 3 * (w - 100) + 200;
        else if (w <= 1000000) return 5 * (w - 10000) + 29900;
        else return (w - 1000000) * 7 + 4979900;
    }
}
