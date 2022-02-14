package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1292 {    // 쉽게 푸는 문제
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int answer = 0;
        int num = 1;
        for (int i = a; i <= b; i++) {
            while (i > num * (num + 1) / 2) {
                num++;
            }
            answer += num;
        }
        System.out.println(answer);
    }
}
