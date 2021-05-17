package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q13305 {   // 주유소
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int[] distances = new int[n - 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n - 1; i++){
            distances[i] = Integer.parseInt(st.nextToken());
        }

        int[] costs = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            costs[i] = Integer.parseInt(st.nextToken());

        int minCost = costs[0];
        long ans = 0;
        for (int i = 0; i < n - 1; i++) {
            minCost = Math.min(minCost, costs[i]);
            ans += (long) distances[i] * minCost;
        }

        System.out.println(ans);
    }
}
