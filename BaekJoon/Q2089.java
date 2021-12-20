package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2089 {    // -2진수
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        if (n == 0) System.out.println(0);
        else {
            StringBuilder sb = new StringBuilder();
            while (n != 1) {
                sb.append(Math.abs(n % -2));
                n = (int) Math.ceil((double) n / (-2));
            }
            sb.append(n);
            System.out.println(sb.reverse());
        }
    }
}
