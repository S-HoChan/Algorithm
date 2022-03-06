package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q19539 {   // 사과나무
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int total = 0;
        int oddCount = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        while (n-- > 0) {
            int now = Integer.parseInt(st.nextToken());
            total += now;
            if (now % 2 == 1) oddCount++;
        }

        System.out.println(total % 3 == 0 && oddCount <= total / 3 ? "YES" : "NO");
    }
}
