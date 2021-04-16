package ProgrammersLevel3;

import java.util.Arrays;

public class NumberGame {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        Arrays.sort(A);
        Arrays.sort(B);

        int idxB = B.length - 1;    // 뒤에서부터 A를 이길 수 있는 B 찾기
        for (int idxA = A.length - 1; idxA >= 0; idxA--) {
            if (B[idxB] > A[idxA]) {    // 이기는 패
                answer++;
                idxB--;
            }
        }

        return answer;
    }
}
