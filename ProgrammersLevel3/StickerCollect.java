package ProgrammersLevel3;

public class StickerCollect {
    public int solution(int sticker[]) {
        if (sticker.length <= 3) {
            int answer = 0;
            for (int stic : sticker) answer = Math.max(answer, stic);
            return answer;
        }

        int[] dp1 = new int[sticker.length];    // start at first sticker
        int[] dp2 = new int[sticker.length];    // start at second sticker

        dp1[0] = sticker[0];
        dp1[1] = sticker[0];
        dp2[0] = 0;
        dp2[1] = sticker[1];
        for (int i = 2; i < sticker.length; i++) {
            if (i == sticker.length - 1) dp1[i] = Math.max(dp1[i - 2], dp1[i - 1]);
            else dp1[i] = Math.max(dp1[i - 2] + sticker[i], dp1[i - 1]);
            dp2[i] = Math.max(dp2[i - 2] + sticker[i], dp2[i - 1]);
        }

        return Math.max(dp1[sticker.length - 1], dp2[sticker.length - 1]);
    }
}
