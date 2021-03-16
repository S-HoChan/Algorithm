package ProgrammersLevel2;

public class ExpectedMatchTable {
    public int solution(int n, int a, int b)
    {
        int answer = 0;
        int small = a < b ? a : b;
        int large = a > b ? a : b;

        while (true) {
            answer++;
            if (large - small == 1 && small % 2 == 1) break;
            large = large / 2 + large % 2;
            small = small / 2 + small % 2;
        }

        return answer;
    }
}
