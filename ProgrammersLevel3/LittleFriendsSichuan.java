package ProgrammersLevel3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class LittleFriendsSichuan {

    // todo. 다른 방법 찾을 것 (시간 초과)
    int[] dy = {1, -1, 0, 0};
    int[] dx = {0, 0, 1, -1};
    char[] dir = {'D', 'U', 'R', 'L'};

    public String solution(int m, int n, String[] board) {
        String answer = "";
        char[][] map = new char[m][n];
        for (int i = 0; i < m; i++) {
            map[i] = board[i].toCharArray();
        }
        ArrayList<Character> al = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] != '.' && map[i][j] != '*' && !al.contains(map[i][j])) {
                    al.add(map[i][j]);
                }
            }
        }   // 새로운 문자 list에 추가
        Collections.sort(al);

        for (int idx = 0; idx < al.size(); idx++) {
            char c = al.get(idx);
            loop:
            for (int y = 0; y < m; y++) {
                for (int x = 0; x < n; x++) {
                    if (map[y][x] == c) {   // 같을 경우 찾기
                        Queue<Block> queue = new LinkedList<>();
                        queue.add(new Block(y, x, 'U', -1));   // 위에서 부터 탐색하여 위로 가는 경우는 없다.

                        while (!queue.isEmpty()) {  // BFS로 블럭 찾기
                            Block now = queue.poll();
                            for (int i = 0; i < 4; i++) {   // 4방향 탐색
                                int _y = y + dy[i];
                                int _x = x + dx[i];
                                if (_y < 0 || _y >= m || _x < 0 || _x >= n || map[_y][_x] == '*') continue; // 못가는 경우

                                char d = dir[i];
                                if (map[_y][_x] == c) { // 같은 블럭인 경우
                                    map[y][x] = '.';
                                    map[_y][_x] = '.';  // 블럭 지우기
                                    answer += c;   // 결과 추가
                                    al.remove(idx);
                                    idx = -1;
                                    break loop; // 반복문 다시 동작
                                } else if (map[_y][_x] == '.') {    // 빈 공간인 경우
                                    if (now.direction == d) { // 같은 방향인 경우
                                        queue.add(new Block(_y, _x, d, now.cnt));
                                    } else if (now.cnt <= 1) {  // 꺾어야 하는 경우
                                        queue.add(new Block(_y, _x, d, now.cnt + 1));
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        if (al.size() == 0) return "IMPOSSIBLE";
        else return answer;
    }

    public class Block {
        int y;
        int x;
        char direction; // L U R D
        int cnt;    // 꺾은 횟수

        Block(int y, int x, char c, int cnt) {
            this.y = y;
            this.x = x;
            this.direction = c;
            this.cnt = cnt;
        }
    }
}
