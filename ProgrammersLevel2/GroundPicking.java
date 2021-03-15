package ProgrammersLevel2;

public class GroundPicking {
    int solution(int[][] land) {
        int answer = 0;

        for (int y = 1; y < land.length; y++) {
            for (int x = 0; x < land[0].length; x++) {
                int max = 0;
                for(int k = 0; k < land[0].length; k++){
                    if (k == x) continue;
                    max = Math.max(max, land[y-1][k]);
                }
                land[y][x] += max;
            }
        }

        for(int i = 0; i < land[0].length; i++){
            answer = Math.max(answer, land[land.length-1][i]);
        }

        return answer;
    }
}
