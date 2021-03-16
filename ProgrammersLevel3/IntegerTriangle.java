package ProgrammersLevel3;

public class IntegerTriangle {
    public int solution(int[][] triangle) {
        int answer = 0;
        int n = triangle.length;
        int[][] tri = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < triangle[i].length; j++) {
                tri[i][j] = triangle[i][j];
                if (i == 0) continue;
                int num;
                if (j == 0) num = tri[i - 1][j];
                else num = Math.max(tri[i - 1][j - 1], tri[i - 1][j]);
                tri[i][j] += num;
            }
        }

        for (int i = 0; i < n; i++) {
            answer = Math.max(answer, tri[n - 1][i]);
        }

        return answer;
    }
}
