package ProgrammersLevel3;

public class BalloonPopping {
    public int solution(int[] a) {
        if (a.length == 1) return 1;
        int answer = 2;
        int[] leftMin = new int[a.length];
        int[] rightMin = new int[a.length];

        int temp = Integer.MAX_VALUE;
        for (int i = 0; i < a.length; i++) {
            temp = temp < a[i] ? temp : a[i];
            leftMin[i] = temp;
        }

        temp = Integer.MAX_VALUE;
        for (int i = a.length - 1; i >= 0; i--) {
            temp = temp < a[i] ? temp : a[i];
            rightMin[i] = temp;
        }

        for (int i = 1; i < a.length - 1; i++) {
            if (leftMin[i] >= a[i] || rightMin[i] >= a[i]) answer++;
        }

        return answer;
    }
}
