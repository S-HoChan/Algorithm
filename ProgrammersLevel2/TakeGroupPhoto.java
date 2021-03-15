package ProgrammersLevel2;

import java.util.HashMap;

public class TakeGroupPhoto {
    static int[] position;
    static boolean[] visited;
    static HashMap<Character, Integer> kakao;
    static int cnt = 0;

    public int solution(int n, String[] data) {
        int answer = 0;
        position = new int[8];
        visited = new boolean[8];
        kakao = new HashMap<>();
        kakao.put('A', 0);
        kakao.put('C', 1);
        kakao.put('F', 2);
        kakao.put('J', 3);
        kakao.put('M', 4);
        kakao.put('N', 5);
        kakao.put('R', 6);
        kakao.put('T', 7);

        perm(0, data);
        answer = cnt;
        return answer;
    }

    public static void perm(int idx, String[] data) {
        if (idx == 8) { // 기저조건
            if (isOk(data)) cnt++;
            return;
        }

        for (int i = 0; i < 8; i++) {  // permutation
            if (!visited[i]) {    // 사용하지 않았다면
                visited[i] = true;
                position[idx] = i;
                perm(idx + 1, data);
                visited[i] = false;
            }
        }
    }

    public static boolean isOk(String[] data) {
        for (int i = 0; i < data.length; i++) { // 입력받은 데이터 접근
            int c1 = kakao.get(data[i].charAt(0));
            int c2 = kakao.get(data[i].charAt(2));
            char operator = data[i].charAt(3);
            int diff = data[i].charAt(4) - '0';
            int pos1 = position[c1];
            int pos2 = position[c2];

            if (operator == '=') {
                if (Math.abs(pos1 - pos2) - 1 != diff) return false;
            } else if (operator == '>') {
                if (Math.abs(pos1 - pos2) - 1 <= diff) return false;
            } else {   // operator '<'
                if (Math.abs(pos1 - pos2) - 1 >= diff) return false;
            }
        }
        return true;
    }
}
