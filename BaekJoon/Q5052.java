package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q5052 {    // 전화번호 목록
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            String[] phoneArr = new String[n];
            for (int i = 0; i < n; i++) {
                phoneArr[i] = br.readLine();
            }
            Arrays.sort(phoneArr);

            sb.append(isOk(n, phoneArr) ? "YES" : "NO").append('\n');
        }
        System.out.println(sb);
    }

    static boolean isOk(int n, String[] phoneArr) {
        for (int i = 0; i < n - 1; i++) {
            if (phoneArr[i + 1].startsWith(phoneArr[i])) return false;
        }
        return true;
    }
}
