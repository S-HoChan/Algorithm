package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Q14247 {   // 나무 자르기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[][] tree = new int[n][2];  // 나무의 길이, 자라는 길이
        for (int i = 0; i < n; i++) {
            tree[i][0] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            tree[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(tree, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        long answer = 0;
        for (int i = 0; i < n; i++) {
            answer += tree[i][0] + (long) tree[i][1] * i;
        }

        System.out.println(answer);
    }
}
