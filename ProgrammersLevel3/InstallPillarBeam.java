package ProgrammersLevel3;

import java.util.ArrayList;

public class InstallPillarBeam {
    // [ x, y, a, b ] : (x, y)에 설치, a(0 기둥, 1 보), b(0 삭제, 1 설치)
    boolean[][][] build;

    public int[][] solution(int n, int[][] build_frame) {
        build = new boolean[n + 1][n + 1][2];

        for (int i = 0; i < build_frame.length; i++) {
            int x = build_frame[i][0];
            int y = build_frame[i][1];
            int structure = build_frame[i][2];
            int isInstall = build_frame[i][3];

            if (structure == 0) { // 기둥
                if (isInstall == 1) { // 설치
                    build[x][y][0] = confirmPillar(x, y);
                } else { // 삭제
                    build[x][y][0] = false;
                    if ((isPillar(x, y + 1) && !confirmPillar(x, y + 1))           // 위에 기둥 검사
                            || (isBeam(x, y + 1) && !confirmBeam(x, y + 1))           // 위에 보 검사
                            || (isBeam(x - 1, y + 1) && !confirmBeam(x - 1, y + 1))) {     // 왼쪽 위의 보 검사
                        build[x][y][0] = true;  // 삭제가 무시되는 경우
                    }
                }
            } else {    // 보
                if (isInstall == 1) {
                    build[x][y][1] = confirmBeam(x, y);
                } else {
                    build[x][y][1] = false;
                    if ((isPillar(x, y) && !confirmPillar(x, y))               // 보 왼쪽 기둥
                            || (isPillar(x + 1, y) && !confirmPillar(x + 1, y))        // 보 오른쪽 기둥
                            || (isBeam(x + 1, y) && !confirmBeam(x + 1, y))           // 오른쪽 보
                            || (isBeam(x - 1, y) && !confirmBeam(x - 1, y))) {         // 왼쪽 보
                        build[x][y][1] = true;
                    }
                }
            }
        }

        ArrayList<Constructor> list = new ArrayList<>();
        for (int i = 0; i < build.length; i++) {
            for (int j = 0; j < build.length; j++) {
                if (build[i][j][0]) list.add(new Constructor(i, j, 0));
                if (build[i][j][1]) list.add(new Constructor(i, j, 1)); // 정렬 기준으로 삽입
            }
        }

        int[][] answer = new int[list.size()][3];
        for (int i = 0; i < list.size(); i++) {
            answer[i][0] = list.get(i).x;
            answer[i][1] = list.get(i).y;
            answer[i][2] = list.get(i).type;
        }

        return answer;
    }

    boolean isPillar(int x, int y) {
        if (x < 0 || y < 0 || x > build.length || y > build.length) {
            return false;
        }
        return build[x][y][0];
    }

    boolean isBeam(int x, int y) {
        if (x < 0 || y < 0 || x > build.length || y > build.length) {
            return false;
        }
        return build[x][y][1];
    }

    boolean confirmPillar(int x, int y) { // 바닥 위, 기둥 위, 보의 한 쪽 위
        return y == 0 || isPillar(x, y - 1) || isBeam(x, y) || isBeam(x - 1, y);
    }

    boolean confirmBeam(int x, int y) { // 아래 기둥이 있는지, 양 옆에 보가 있는지 확인
        return isPillar(x, y - 1) || isPillar(x + 1, y - 1) || (isBeam(x - 1, y) && isBeam(x + 1, y));
    }

    static class Constructor {
        int x;
        int y;
        int type;

        Constructor(int x, int y, int type) {
            this.x = x;
            this.y = y;
            this.type = type;
        }
    }
}
