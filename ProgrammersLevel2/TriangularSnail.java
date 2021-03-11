package ProgrammersLevel2;

public class TriangularSnail {
    public static void main(String[] args) {

    }

    public int[] solution(int n) {
        int arraySize = n * (n + 1) / 2;
        int[] answer = new int[arraySize];

        int[][] arr = new int[n][n];
        int i = 0, j = 0, k = 1;
        arr[i][j] = k;

        while (k < arraySize) {
            while (i + 1 < n && arr[i + 1][j] < 1 && k < arraySize) {
                arr[++i][j] = ++k;
            }   // 하단
            while (j + 1 < n && arr[i][j + 1] < 1 && k < arraySize) {
                arr[i][++j] = ++k;
            }   // 우측
            while (i - 1 > 0 && j - 1 > 0 && arr[i - 1][j - 1] < 1 && k < arraySize) { // 대각선
                arr[--i][--j] = ++k;
            }
        }

        k = 0;
        for (i = 0; i < n; i++) {
            for (j = 0; j <= i; j++) {
                answer[k++] = arr[i][j];
            }
        }

        return answer;
    }
}
