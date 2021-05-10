package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1436 {    // 영화감독 숌
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        int num = 666;
        int count = 1;
        while (count != n) {
            num++;
            if (String.valueOf(num).contains("666")) count++;
        }

        System.out.println(num);
    }
}
