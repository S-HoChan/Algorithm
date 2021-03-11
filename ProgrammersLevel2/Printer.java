package ProgrammersLevel2;

public class Printer {
    public static void main(String[] args) {

    }

    public int solution(int[] priorities, int location) {
        int answer = 0;
        int maxIndex = 0, lastIndex;
        while (true) {
            if (maxIndex >= priorities.length) maxIndex = 0;
            lastIndex = maxIndex;
            for (int i = 0; i < priorities.length; i++) {
                int poi = lastIndex + i;
                if (poi >= priorities.length) poi -= priorities.length;
                maxIndex = priorities[poi] > priorities[maxIndex] ? poi : maxIndex;
            }
            if (maxIndex == location) return answer + 1;
            priorities[maxIndex++] = 0;
            answer++;
        }
    }
}
