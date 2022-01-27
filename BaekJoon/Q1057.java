package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1057 {    // 토너먼트
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int kim = Integer.parseInt(st.nextToken());
        int lim = Integer.parseInt(st.nextToken());
        int answer = 0;
        while (true) {
            answer++;
            kim = kim / 2 + kim % 2;
            lim = lim / 2 + lim % 2;
            if (kim == lim) break;
        }
        System.out.println(answer);
    }
}
