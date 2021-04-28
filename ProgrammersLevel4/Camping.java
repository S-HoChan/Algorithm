package ProgrammersLevel4;

import java.util.*;

public class Camping {
    public int solution(int n, int[][] data) {
        // 좌표 압축
        ArrayList<Integer> xList = new ArrayList<>();
        ArrayList<Integer> yList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            xList.add(data[i][0]);
            yList.add(data[i][1]);
        }

        ArrayList<Integer> uniqueX = new ArrayList<>(new HashSet<>(xList));
        ArrayList<Integer> uniqueY = new ArrayList<>(new HashSet<>(yList));
        Collections.sort(uniqueX);
        Collections.sort(uniqueY);

        int[][] S = new int[n][n];  // 구간 합 배열
        for (int i = 0; i < n; i++) {
            int x = uniqueX.indexOf(new Integer(data[i][0]));
            int y = uniqueY.indexOf(new Integer(data[i][1]));

            // 좌표 압축 적용
            data[i][0] = x;
            data[i][1] = y;

            S[x][y] = 1;    // 구간합 배열 초기값
        }

        for (int i = 0; i < n; i++) { // N^2 구간 합
            for (int j = 0; j < n; j++) {
                S[i][j] += (i - 1 >= 0 ? S[i - 1][j] : 0)
                        + (j - 1 >= 0 ? S[i][j - 1] : 0)
                        - (i - 1 >= 0 && j - 1 >= 0 ? S[i - 1][j - 1] : 0);
            }
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {   // 모든 쐐기 조합에 대해서 검사
            for (int j = i + 1; j < n; j++) {
                if (data[i][0] == data[j][0] || data[i][1] == data[j][1]) continue; // 넓이가 0인 경우

                int startX = Math.min(data[i][0], data[j][0]);
                int startY = Math.min(data[i][1], data[j][1]);
                int endX = Math.max(data[i][0], data[j][0]);
                int endY = Math.max(data[i][1], data[j][1]);

                int cnt;    // 직사각형 내부에 쐐기가 존재하는지 확인
                if (startX + 1 > endX - 1 || startY + 1 > endY - 1) cnt = 0;
                else cnt = S[endX - 1][endY - 1] - S[endX - 1][startY] - S[startX][endY - 1] + S[startX][startY];

                if (cnt == 0) answer++;
            }
        }

        return answer;
    }
}
