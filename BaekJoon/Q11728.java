package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q11728 {   // 배열 합치기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] mat1 = new int[n];
        int m = Integer.parseInt(st.nextToken());
        int[] mat2 = new int[m];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            mat1[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            mat2[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(mat1);
        Arrays.sort(mat2);
        int idx1 = 0, idx2 = 0;
        while (idx1 < n && idx2 < m) {
            if (mat1[idx1] < mat2[idx2]) {
                sb.append(mat1[idx1++]).append(' ');
            } else {
                sb.append(mat2[idx2++]).append(' ');
            }
        }
        while (idx1 < n) {
            sb.append(mat1[idx1++]).append(' ');
        }
        while (idx2 < m) {
            sb.append(mat2[idx2++]).append(' ');
        }

        System.out.println(sb);
    }
}
