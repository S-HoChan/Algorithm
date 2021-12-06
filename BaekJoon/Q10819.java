package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q10819 {   // 차이를 최대로
    static int n, answer = 0;
    static int[] arr, tempArr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        visited = new boolean[n];
        tempArr = new int[n];
        sol(0);
        System.out.println(answer);
    }

    static void sol(int depth) {
        if (depth == n) {
            int sum = 0;
            for (int i = 0; i < n - 1; i++) {
                sum += Math.abs(tempArr[i] - tempArr[i + 1]);
            }
            answer = Math.max(answer, sum);
        } else {
            for (int i = 0; i < n; i++) {
                if (visited[i]) continue;

                visited[i] = true;
                tempArr[depth] = arr[i];
                sol(depth + 1);
                visited[i] = false;
            }
        }
    }
}
