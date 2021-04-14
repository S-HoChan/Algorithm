package ProgrammersLevel3;

import java.util.ArrayList;

public class HanoiTower {
    ArrayList<int[]> list;

    public int[][] solution(int n) {
        list = new ArrayList<>();

        hanoi(n, 1, 3, 2);

        int[][] answer = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            answer[i][0] = list.get(i)[0];
            answer[i][1] = list.get(i)[1];
        }

        return answer;
    }

    public void hanoi(int n, int start, int dest, int via) {   // 개수, 출발, 도착, 경유
        int[] move = {start, dest};

        if (n == 1) list.add(move);
        else {
            hanoi(n - 1, start, via, dest);
            list.add(move);
            hanoi(n - 1, via, dest, start);
        }
    }
}
