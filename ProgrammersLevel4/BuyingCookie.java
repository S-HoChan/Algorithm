package ProgrammersLevel4;

public class BuyingCookie {
    public int solution(int[] cookie) {
        int answer = 0;
        for (int m = 0; m < cookie.length - 1; m++) {
            int left = m, right = m + 1;
            int child1 = cookie[m], child2 = cookie[m + 1];
            while (true) {
                if (child1 == child2 && answer < child1) answer = child1;
                else if (child1 > child2 && right + 1 < cookie.length)
                    child2 += cookie[++right];
                else if (child1 <= child2 && left > 0)
                    child1 += cookie[--left];
                else break;
            }
        }

        return answer;
    }
}
