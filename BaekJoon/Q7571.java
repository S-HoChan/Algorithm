package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q7571 {    // 점 모으기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arrY = new int[m];
        int[] arrX = new int[m];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            arrY[i] = Integer.parseInt(st.nextToken()) - 1;
            arrX[i] = Integer.parseInt(st.nextToken()) - 1;
        }
        Arrays.sort(arrY);
        Arrays.sort(arrX);
        int midY = arrY[m / 2];
        int midX = arrX[m / 2];

        int answer = 0;
        for (int i = 0; i < m; i++) {
            answer += Math.abs(midY - arrY[i]) + Math.abs(midX - arrX[i]);
        }
        System.out.println(answer);
    }
}
