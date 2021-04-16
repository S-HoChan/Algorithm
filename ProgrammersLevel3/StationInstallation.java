package ProgrammersLevel3;

public class StationInstallation {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int left, right;    // 기지국 외의 값
        int baseL, baseR = 0;   // 기지국 내의 값

        for (int station : stations) {
            left = baseR;

            baseL = Math.max(0, station - w);
            baseR = Math.min(n, station + w);

            right = baseL - 1;
            if (right < 0 || left >= right) continue;    // 이미 포함됨
            answer += (right - left) / (2 * w + 1);  // 필요한 기지국 계산
            if ((right - left) % (2 * w + 1) != 0) answer++;
        }

        if (baseR < n) {  // 우측에 남은 경우
            answer += (n - baseR) / (2 * w + 1);
            if ((n - baseR) % (2 * w + 1) != 0) answer++;
        }

        return answer;
    }
}
