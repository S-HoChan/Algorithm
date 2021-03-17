package ProgrammersLevel2;

public class LengthOfVisit {
    public static int solution(String dirs) {
        int answer = 0;
        boolean[][] col = new boolean[11][11];  // 세로 선분의 시작점
        boolean[][] row = new boolean[11][11];  // 가로 선분의 시작점
        int y = 5, x = 5;

        for (int i = 0; i < dirs.length(); i++) {
            char now = dirs.charAt(i);
            if (now == 'U') {
                if (y > 0) {
                    if (!col[--y][x]) {
                        col[y][x] = true;
                        answer++;
                    }
                }
            } else if (now == 'D') {
                if (y < 10) {
                    if (!col[y][x]) {
                        col[y++][x] = true;
                        answer++;
                    } else {
                        y++;
                    }
                }
            } else if (now == 'L') {
                if (x > 0) {
                    if (!row[y][--x]) {
                        row[y][x] = true;
                        answer++;
                    }
                }
            } else {    // now == 'R'
                if (x < 10) {
                    if (!row[y][x]){
                        row[y][x++] = true;
                        answer++;
                    } else {
                        x++;
                    }
                }
            }
        }

        return answer;
    }
}
