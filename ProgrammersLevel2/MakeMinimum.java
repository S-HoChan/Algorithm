package ProgrammersLevel2;

import java.util.Arrays;

public class MakeMinimum {
    public int solution(int []A, int []B)
    {
        int answer = 0;
        Arrays.sort(A);
        Arrays.sort(B);
        int n = A.length - 1;

        for(int i = 0; i <= n; i++){
            answer += A[i] * B[n-i];
        }

        return answer;
    }
}
