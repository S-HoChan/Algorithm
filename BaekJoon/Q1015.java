package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q1015 {    // 수열 정렬
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] arrA = new int[n][2];
        int[] arrB = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arrA[i][0] = i;
            arrA[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arrA, (o1, o2) -> {
            if (o1[1] > o2[1]) return 1;
            else if (o1[1] < o2[1]) return -1;
            else {
                if (o1[0] > o2[0]) return 1;
                else return -1;
            }
        });

        for (int i = 0; i < n; i++) {
            arrB[arrA[i][0]] = i;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(arrB[i]).append(' ');
        }
        System.out.println(sb);
    }
}
