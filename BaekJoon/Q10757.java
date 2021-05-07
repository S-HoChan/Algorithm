package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q10757 {   // 큰 수 A+B
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        StringBuilder a = new StringBuilder(st.nextToken());
        StringBuilder b = new StringBuilder(st.nextToken());

        while (a.length() != b.length()) {
            if (a.length() < b.length()) {
                a.insert(0, "0");
            } else {
                b.insert(0, "0");
            }
        }

        StringBuilder ans = new StringBuilder();
        int s = 0;
        for (int i = a.length() - 1; i >= 0; i--) {
            int value = (int) a.toString().charAt(i) - '0' + (int) b.toString().charAt(i) - '0' + s;
            s = value >= 10 ? 1 : 0;
            ans.insert(0, value % 10);
        }
        if (s == 1) ans.insert(0, s);

        System.out.println(ans);
    }
}
