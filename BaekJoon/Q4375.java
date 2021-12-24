package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q4375 {    // 1
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String string = null;
        while ((string = br.readLine()) != null) {
            int n = Integer.parseInt(string);
            int temp = 1;
            int cnt = 1;
            while (true) {
                if (temp % n == 0) break;

                cnt++;
                temp = (temp * 10 + 1) % n;
            }
            System.out.println(cnt);
        }
    }
}
