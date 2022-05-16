package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1614 {    // 영식이의 손가락
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int hurt = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        if (hurt == 1) System.out.println((n * 8L));
        else if (hurt == 2) System.out.println((1 + (n / 2) * 8L + (n % 2) * 6));
        else if (hurt == 3) System.out.println((2 + (n / 2) * 8L + (n % 2) * 4));
        else if (hurt == 4) System.out.println((3 + (n / 2) * 8L + (n % 2) * 2));
        else System.out.println((4 + n * 8L));
    }
}
