package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1612 {    // 가지고 노는 1
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        if (n % 2 == 0 || n % 5 == 0) {
            System.out.println(-1);
            return;
        }

        for (int i = 1, j = 0; ; i++) {
            j = (10 * j + 1) % n;
            if (j % n == 0) {
                System.out.println(i);
                break;
            }
        }
    }
}
