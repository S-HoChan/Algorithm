package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Q17503 {   // 맥주 축제
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] arr = new int[k][2];    // 선호도, 도수
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr, Comparator.comparingInt(o -> o[1])); // 도수 ASC

        PriorityQueue<Integer> pq = new PriorityQueue<>(); // 선호도 저장
        int sum = 0;    // 누적 선호도
        for (int i = 0; i < k; i++) {
            pq.add(arr[i][0]);
            sum += arr[i][0];

            if (pq.size() > n) sum -= pq.poll();
            if (pq.size() == n && sum >= m) {
                System.out.println(arr[i][1]);
                return;
            }
        }
        System.out.println(-1);
    }
}
