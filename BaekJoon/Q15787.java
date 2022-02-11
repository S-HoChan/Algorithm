package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q15787 {   // 기차가 어둠을 헤치고 은하수를
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        boolean[][] isExist = new boolean[n][20];
        int m = Integer.parseInt(st.nextToken());
        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int order = Integer.parseInt(st.nextToken());
            int train = Integer.parseInt(st.nextToken()) - 1;
            if (order == 1 || order == 2) {
                int x = Integer.parseInt(st.nextToken()) - 1;
                isExist[train][x] = order == 1;
            } else if (order == 3) {
                for (int i = 19; i > 1; i--) {
                    isExist[train][i] = isExist[train][i - 1];
                }
                isExist[train][0] = false;
            } else if (order == 4) {
                for (int i = 0; i < 19; i++) {
                    isExist[train][i] = isExist[train][i + 1];
                }
                isExist[train][19] = false;
            }
        }

        Set<String> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            String temp = "";
            for (int j = 0; j < 20; j++) {
                if (isExist[i][j]) temp += '1';
                else temp += '0';
            }
            set.add(temp);
        }
        System.out.println(set.size());
    }
}
