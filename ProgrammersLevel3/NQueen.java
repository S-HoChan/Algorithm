package ProgrammersLevel3;

public class NQueen {
    int[] col;
    int answer;

    public int solution(int n) {
        answer = 0;
        for (int i = 0; i < n; i++) {
            col = new int[n];
            col[0] = i; // i 번째에 queen이 배치
            backtracking(n, 1);
        }

        return answer;
    }

    public void backtracking(int max, int row) {
        if (row == max) { // 정답 출력
            answer++;
            col[row - 1] = 0;
        } else {    // queen 배치
            for (int i = 0; i < max; i++) {
                col[row] = i;
                if (isPossible(row)) backtracking(max, row + 1);
                else col[row] = 0;
            }
            col[row] = 0;
        }
    }

    public boolean isPossible(int row) {
        for (int i = 0; i < row; i++) { // 같은 열에 배치되거나 대각선
            if (col[i] == col[row] ||
                    Math.abs(row - i) == Math.abs(col[row] - col[i])) return false;
        }
        return true;
    }
}
