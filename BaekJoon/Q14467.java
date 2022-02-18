package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q14467 {   // 소가 길을 건너간 이유 1
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] cow = new int[10];
        Arrays.fill(cow, -1);
        int answer = 0;
        while (n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int cowNum = Integer.parseInt(st.nextToken()) - 1;
            int locate = Integer.parseInt(st.nextToken());
            if (cow[cowNum] != locate && cow[cowNum] != -1) answer++;
            cow[cowNum] = locate;
        }
        System.out.println(answer);
    }
}
