package ProgrammersLevel2;

public class MatrixMultiple {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length];

        int n = arr1[0].length;

        for (int y = 0; y < arr1.length; y++) {
            for (int x = 0; x < arr2[0].length; x++) {
                for(int i = 0; i < n; i++){
                    answer[y][x] += arr1[y][i] * arr2[i][x];
                }
            }
        }

        return answer;
    }
}
