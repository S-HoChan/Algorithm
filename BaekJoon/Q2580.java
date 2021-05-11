package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2580 {    // 스도쿠
    private static int[][] map = new int[9][9];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        for (int i = 0; i < 9; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        sol(0, 0);
    }

    private static void sol(int row, int col) {
        if (col == 9) {   // 행이 다 채워질 경우 다음 행으로 이동
            sol(row + 1, 0);
            return;
        }

        if (row == 9) {  // 행과 열이 모두 채워진 경우 출력 후 종료
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) sb.append(map[i][j]).append(' ');
                sb.append('\n');
            }
            System.out.println(sb);
            System.exit(0);
        }

        if (map[row][col] == 0) { // 가능한 수 탐색
            for (int num = 1; num <= 9; num++) {  // 1 ~ 9까지 검사
                if (isOk(row, col, num)) {
                    map[row][col] = num;
                    sol(row, col + 1);
                }
            }
            map[row][col] = 0;
            return;
        }

        sol(row, col + 1);
    }

    private static boolean isOk(int row, int col, int value) {
        for (int i = 0; i < 9; i++) { // 같은 행, 열에 겹치는 숫자가 있는지 검사
            if (map[row][i] == value || map[i][col] == value) return false;
        }

        int rowSet = (row / 3) * 3;
        int colSet = (col / 3) * 3; // 속한 3*3의 첫 위치 설정
        for (int i = rowSet; i < rowSet + 3; i++) {
            for (int j = colSet; j < colSet + 3; j++) {
                if (map[i][j] == value) return false;   // 3*3 내의 중복값 검사
            }
        }
        return true;
    }
}
