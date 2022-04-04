package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Q17619 {   // 개구리 점프
    static int[] parent;
    static int[] size;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        parent = new int[n];
        size = new int[n];
        int[][] arr = new int[n][3];    // x1, x2, idx
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = i;
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            arr[i][2] = i;
        }

        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i][1] >= arr[j][0])
                    union(arr[i][2], arr[j][2]);
                else break;
            }
        }

        StringBuilder sb = new StringBuilder();
        while (q-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken()) - 1;
            int n2 = Integer.parseInt(st.nextToken()) - 1;

            if (find(n1) == find(n2)) sb.append(1);
            else sb.append(0);
            sb.append('\n');
        }
        System.out.println(sb);
    }

    static void union(int a, int b) {
        int n1 = find(a);
        int n2 = find(b);
        if (size[a] > size[b]) {
            int temp = n1;
            n1 = n2;
            n2 = temp;  // swap
        }

        parent[n1] = n2;
        size[n2] += size[n1];
    }

    static int find(int a) {
        return a == parent[a] ? a : (parent[a] = find(parent[a]));
    }
}
