package ProgrammersLevel2;

public class BiggestSquareSearch {
    public int solution(int[][] board) {
        int answer = 0;

        if (board.length <= 1 || board[0].length <= 1) return 1;
        for (int i = 1; i < board.length; i++) {
            for (int j = 1; j < board[0].length; j++) {
                if (board[i][j] != 1) continue;
                int up = board[i - 1][j];
                int left = board[i][j - 1];
                int upperLeft = board[i - 1][j - 1];
                int min = Math.min(up, left);
                min = Math.min(min, upperLeft);
                board[i][j] = ++min;
                answer = answer > min ? answer : min;
            }
        }

        return answer * answer;
    }
}
